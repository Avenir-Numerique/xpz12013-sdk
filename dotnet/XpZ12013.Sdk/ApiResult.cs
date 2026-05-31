namespace XpZ12013.Sdk;

/// <summary>
/// Outcome of an API call without a body (delete, update, healthcheck).
/// </summary>
public class ApiResult
{
    /// <summary>Whether the HTTP call returned a success status code.</summary>
    public bool IsSuccess { get; protected init; }

    /// <summary>The HTTP status code returned by the API.</summary>
    public int StatusCode { get; protected init; }

    /// <summary>The raw error payload (or reason phrase) when the call failed; otherwise <c>null</c>.</summary>
    public string? ErrorMessage { get; protected init; }

    /// <summary>Creates a successful result.</summary>
    public static ApiResult Ok(int statusCode) => new() { IsSuccess = true, StatusCode = statusCode };

    /// <summary>Creates a failed result.</summary>
    public static ApiResult Fail(int statusCode, string? errorMessage) =>
        new() { IsSuccess = false, StatusCode = statusCode, ErrorMessage = errorMessage };
}

/// <summary>
/// Outcome of an API call carrying a deserialized payload of type <typeparamref name="T"/>.
/// </summary>
public sealed class ApiResult<T> : ApiResult
{
    /// <summary>The deserialized response payload when <see cref="ApiResult.IsSuccess"/> is <c>true</c>.</summary>
    public T? Data { get; private init; }

    /// <summary>Creates a successful result carrying <paramref name="data"/>.</summary>
    public static ApiResult<T> Ok(T? data, int statusCode) =>
        new() { IsSuccess = true, StatusCode = statusCode, Data = data };

    /// <summary>Creates a failed result.</summary>
    public static new ApiResult<T> Fail(int statusCode, string? errorMessage) =>
        new() { IsSuccess = false, StatusCode = statusCode, ErrorMessage = errorMessage };
}
