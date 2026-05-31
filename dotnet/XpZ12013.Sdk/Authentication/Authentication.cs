using System.Net.Http.Json;

namespace XpZ12013.Sdk.Authentication;

/// <summary>
/// Supplies a bearer access token for outgoing requests. Implement this to plug a custom
/// authentication scheme into <see cref="XpZ12013Client"/>.
/// </summary>
public interface IXpZ12013Authenticator
{
    /// <summary>Returns a valid access token (refreshing it if necessary).</summary>
    ValueTask<string> GetAccessTokenAsync(CancellationToken cancellationToken = default);
}

/// <summary>Authenticator that always returns the same static bearer token.</summary>
internal sealed class StaticBearerAuthenticator(string token) : IXpZ12013Authenticator
{
    public ValueTask<string> GetAccessTokenAsync(CancellationToken cancellationToken = default)
        => ValueTask.FromResult(token);
}

/// <summary>
/// OAuth2 Client Credentials authenticator with in-memory token caching and automatic refresh
/// (renews ~30s before expiry). Thread-safe.
/// </summary>
internal sealed class OAuth2ClientCredentialsAuthenticator(HttpClient httpClient, XpZ12013ClientOptions options)
    : IXpZ12013Authenticator, IDisposable
{
    private readonly SemaphoreSlim _lock = new(1, 1);
    private string? _token;
    private DateTimeOffset _expiresAt = DateTimeOffset.MinValue;

    public async ValueTask<string> GetAccessTokenAsync(CancellationToken cancellationToken = default)
    {
        if (_token is not null && DateTimeOffset.UtcNow < _expiresAt)
            return _token;

        await _lock.WaitAsync(cancellationToken).ConfigureAwait(false);
        try
        {
            if (_token is not null && DateTimeOffset.UtcNow < _expiresAt)
                return _token;

            var form = new Dictionary<string, string>
            {
                ["grant_type"] = "client_credentials",
                ["client_id"] = options.ClientId,
                ["client_secret"] = options.ClientSecret
            };
            if (!string.IsNullOrWhiteSpace(options.Scopes))
                form["scope"] = options.Scopes!;

            using var request = new HttpRequestMessage(HttpMethod.Post, options.TokenUrl)
            {
                Content = new FormUrlEncodedContent(form)
            };
            using var response = await httpClient.SendAsync(request, cancellationToken).ConfigureAwait(false);
            response.EnsureSuccessStatusCode();

            var token = await response.Content
                .ReadFromJsonAsync<TokenResponse>(cancellationToken)
                .ConfigureAwait(false)
                ?? throw new InvalidOperationException("Empty OAuth2 token response.");

            _token = token.AccessToken;
            var lifetime = Math.Max(30, token.ExpiresIn);
            _expiresAt = DateTimeOffset.UtcNow.AddSeconds(lifetime - 30);
            return _token;
        }
        finally
        {
            _lock.Release();
        }
    }

    public void Dispose() => _lock.Dispose();

    private sealed class TokenResponse
    {
        [JsonPropertyName("access_token")] public string AccessToken { get; set; } = string.Empty;
        [JsonPropertyName("expires_in")] public int ExpiresIn { get; set; } = 3600;
        [JsonPropertyName("token_type")] public string? TokenType { get; set; }
    }
}
