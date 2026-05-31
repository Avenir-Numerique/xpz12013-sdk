using System.Net;
using System.Net.Http.Headers;
using System.Text;

namespace XpZ12013.Sdk;

// Standalone HTTP core — replaces the platform `ApiClientBase`. BCL only: per-request bearer
// auth, exponential backoff with jitter on transient failures, JSON (de)serialization, multipart
// upload and binary download.
public sealed partial class XpZ12013Client
{
    // -------------------------------------------------------------------------------
    // Typed verb helpers
    // -------------------------------------------------------------------------------

    private async Task<ApiResult<T>> GetAsync<T>(
        string url, IReadOnlyDictionary<string, string>? query,
        IReadOnlyDictionary<string, string>? headers, CancellationToken ct)
    {
        var fullUrl = AppendQuery(url, query);
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Get, fullUrl), headers, ct).ConfigureAwait(false);
        return await ReadResultAsync<T>(response, ct).ConfigureAwait(false);
    }

    private async Task<ApiResult<TResp>> PostAsync<TReq, TResp>(
        string url, TReq body, IReadOnlyDictionary<string, string>? headers, CancellationToken ct)
    {
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Post, url) { Content = JsonContent(body) },
            headers, ct).ConfigureAwait(false);
        return await ReadResultAsync<TResp>(response, ct).ConfigureAwait(false);
    }

    private async Task<ApiResult> PatchAsync<TReq>(
        string url, TReq body, IReadOnlyDictionary<string, string>? headers, CancellationToken ct)
    {
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Patch, url) { Content = JsonContent(body) },
            headers, ct).ConfigureAwait(false);
        return await ReadResultAsync(response, ct).ConfigureAwait(false);
    }

    private async Task<ApiResult> DeleteAsync(
        string url, IReadOnlyDictionary<string, string>? headers, CancellationToken ct)
    {
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Delete, url), headers, ct).ConfigureAwait(false);
        return await ReadResultAsync(response, ct).ConfigureAwait(false);
    }

    private async Task<ApiResult> SendHealthAsync(string url, CancellationToken ct)
    {
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Get, url), BuildHeaders(), ct).ConfigureAwait(false);
        return await ReadResultAsync(response, ct).ConfigureAwait(false);
    }

    private async Task<ApiResult<Stream>> GetStreamAsync(
        string url, IReadOnlyDictionary<string, string>? query,
        IReadOnlyDictionary<string, string>? headers, CancellationToken ct)
    {
        var fullUrl = AppendQuery(url, query);
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Get, fullUrl), headers, ct).ConfigureAwait(false);

        var status = (int)response.StatusCode;
        if (!response.IsSuccessStatusCode)
            return ApiResult<Stream>.Fail(status, await SafeReadStringAsync(response, ct).ConfigureAwait(false));

        // Buffer to memory so the stream outlives the response. For very large downloads a
        // production build should expose a streaming overload instead.
        var buffer = new MemoryStream();
        await response.Content.CopyToAsync(buffer, ct).ConfigureAwait(false);
        buffer.Position = 0;
        return ApiResult<Stream>.Ok(buffer, status);
    }

    private async Task<ApiResult<TResp>> PostMultipartAsync<TResp>(
        string url, Stream file, string fileName, string fileContentType,
        IReadOnlyDictionary<string, string> formFields, string fileFieldName,
        IReadOnlyDictionary<string, string>? additionalHeaders, CancellationToken ct)
    {
        var content = new MultipartFormDataContent();
        foreach (var (key, value) in formFields)
            content.Add(new StringContent(value), key);

        var fileContent = new StreamContent(file);
        fileContent.Headers.ContentType = new MediaTypeHeaderValue(fileContentType);
        content.Add(fileContent, fileFieldName, fileName);

        // Non-idempotent + a single-use request body (the stream) → do not retry.
        using var response = await SendAsync(
            () => new HttpRequestMessage(HttpMethod.Post, url) { Content = content },
            additionalHeaders, ct, allowRetry: false).ConfigureAwait(false);
        return await ReadResultAsync<TResp>(response, ct).ConfigureAwait(false);
    }

    // -------------------------------------------------------------------------------
    // Core send: per-request auth + transient retry with exponential backoff + jitter
    // -------------------------------------------------------------------------------

    private async Task<HttpResponseMessage> SendAsync(
        Func<HttpRequestMessage> requestFactory,
        IReadOnlyDictionary<string, string>? headers,
        CancellationToken ct,
        bool allowRetry = true)
    {
        var maxAttempts = allowRetry ? Math.Max(1, _options.MaxRetries + 1) : 1;
        HttpResponseMessage? response = null;

        for (var attempt = 1; attempt <= maxAttempts; attempt++)
        {
            var request = requestFactory();

            var token = await _authenticator.GetAccessTokenAsync(ct).ConfigureAwait(false);
            if (!string.IsNullOrEmpty(token))
                request.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token);

            if (headers is not null)
                foreach (var (key, value) in headers)
                    request.Headers.TryAddWithoutValidation(key, value);

            response?.Dispose();
            response = await _http
                .SendAsync(request, HttpCompletionOption.ResponseHeadersRead, ct)
                .ConfigureAwait(false);
            request.Dispose();

            if (attempt == maxAttempts || !IsTransient(response.StatusCode))
                return response;

            await Task.Delay(BackoffDelay(attempt), ct).ConfigureAwait(false);
        }

        return response!;
    }

    private static bool IsTransient(HttpStatusCode code) =>
        (int)code >= 500 || code == HttpStatusCode.RequestTimeout || (int)code == 429;

    private TimeSpan BackoffDelay(int attempt)
    {
        var baseMs = _options.RetryBaseDelayMs * Math.Pow(2, attempt - 1);
        var jitterMs = Random.Shared.Next(0, 250);
        return TimeSpan.FromMilliseconds(baseMs + jitterMs);
    }

    // -------------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------------

    private static StringContent JsonContent<T>(T body) =>
        new(JsonSerializer.Serialize(body, JsonOptions), Encoding.UTF8, "application/json");

    private static async Task<ApiResult<T>> ReadResultAsync<T>(HttpResponseMessage response, CancellationToken ct)
    {
        var status = (int)response.StatusCode;
        if (!response.IsSuccessStatusCode)
            return ApiResult<T>.Fail(status, await SafeReadStringAsync(response, ct).ConfigureAwait(false));

        if (status == (int)HttpStatusCode.NoContent || response.Content.Headers.ContentLength == 0)
            return ApiResult<T>.Ok(default, status);

        await using var stream = await response.Content.ReadAsStreamAsync(ct).ConfigureAwait(false);
        var data = await JsonSerializer.DeserializeAsync<T>(stream, JsonOptions, ct).ConfigureAwait(false);
        return ApiResult<T>.Ok(data, status);
    }

    private static async Task<ApiResult> ReadResultAsync(HttpResponseMessage response, CancellationToken ct)
    {
        var status = (int)response.StatusCode;
        return response.IsSuccessStatusCode
            ? ApiResult.Ok(status)
            : ApiResult.Fail(status, await SafeReadStringAsync(response, ct).ConfigureAwait(false));
    }

    private static async Task<string?> SafeReadStringAsync(HttpResponseMessage response, CancellationToken ct)
    {
        try { return await response.Content.ReadAsStringAsync(ct).ConfigureAwait(false); }
        catch { return response.ReasonPhrase; }
    }

    private static string AppendQuery(string url, IReadOnlyDictionary<string, string>? query)
    {
        if (query is null || query.Count == 0)
            return url;

        var sb = new StringBuilder(url);
        sb.Append(url.Contains('?') ? '&' : '?');
        var first = true;
        foreach (var (key, value) in query)
        {
            if (!first) sb.Append('&');
            sb.Append(Uri.EscapeDataString(key)).Append('=').Append(Uri.EscapeDataString(value));
            first = false;
        }
        return sb.ToString();
    }
}
