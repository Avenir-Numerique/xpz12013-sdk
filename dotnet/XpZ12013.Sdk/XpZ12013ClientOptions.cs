namespace XpZ12013.Sdk;

/// <summary>
/// Configuration for <see cref="XpZ12013Client"/>. The AFNOR XP Z12-013 standard exposes two
/// HTTP services on distinct hosts (Flow Service — Annexe A, Directory Service — Annexe B); both
/// are driven from a single client, each via its own base URL.
/// </summary>
public sealed class XpZ12013ClientOptions
{
    // -------------------------------------------------------------------------------
    // Service base URLs
    // -------------------------------------------------------------------------------

    /// <summary>
    /// Base URL of the Flow Service (Annexe A), e.g. "https://api.flow.mon-pdp.fr/flow-service".
    /// The OpenAPI <c>servers</c> entry is templated (<c>{sub-domain}.{domain}</c>), so this must be
    /// provided explicitly by the integrator.
    /// </summary>
    public string FlowServiceBaseUrl { get; set; } = string.Empty;

    /// <summary>
    /// Base URL of the Directory Service (Annexe B), e.g. "https://api.directory.mon-pdp.fr/directory-service".
    /// </summary>
    public string DirectoryServiceBaseUrl { get; set; } = string.Empty;

    // -------------------------------------------------------------------------------
    // Authentication — Bearer JWT or OAuth2 Client Credentials
    // -------------------------------------------------------------------------------

    /// <summary>
    /// When <c>true</c> (default) the client uses the OAuth2 Client Credentials flow with automatic
    /// token refresh. When <c>false</c> the static <see cref="BearerToken"/> is used.
    /// </summary>
    public bool UseOAuth2 { get; set; } = true;

    /// <summary>OAuth2 client identifier (Client Credentials flow).</summary>
    public string ClientId { get; set; } = string.Empty;

    /// <summary>OAuth2 client secret (Client Credentials flow).</summary>
    public string ClientSecret { get; set; } = string.Empty;

    /// <summary>OAuth2 token endpoint, e.g. "https://auth.mon-pdp.fr/auth-service/{custId}/token".</summary>
    public string TokenUrl { get; set; } = string.Empty;

    /// <summary>
    /// Optional OAuth2 scope(s), space-separated. The AFNOR specs declare no scopes by default,
    /// except the Directory Service healthcheck which requires "health.read" (norm v1.3.0);
    /// include it here if the target platform enforces that scope.
    /// </summary>
    public string? Scopes { get; set; }

    /// <summary>Static Bearer JWT, used when <see cref="UseOAuth2"/> is <c>false</c>.</summary>
    public string BearerToken { get; set; } = string.Empty;

    // -------------------------------------------------------------------------------
    // Delegation / multi-tenancy
    // -------------------------------------------------------------------------------

    /// <summary>
    /// Optional value sent in the "Organization-Id" header on every request (delegation / multi-tenancy).
    /// </summary>
    public string? OrganizationId { get; set; }

    // -------------------------------------------------------------------------------
    // Transport / resilience
    // -------------------------------------------------------------------------------

    /// <summary>Request timeout, in seconds (default 30).</summary>
    public int TimeoutSeconds { get; set; } = 30;

    /// <summary>Maximum number of automatic retries on transient failures (5xx, 408, 429). Default 3.</summary>
    public int MaxRetries { get; set; } = 3;

    /// <summary>Base delay (ms) for the exponential backoff between retries. Default 200.</summary>
    public int RetryBaseDelayMs { get; set; } = 200;

    /// <summary>Throws <see cref="InvalidOperationException"/> when the configuration is incomplete.</summary>
    public void Validate()
    {
        if (string.IsNullOrWhiteSpace(FlowServiceBaseUrl))
            throw new InvalidOperationException($"{nameof(FlowServiceBaseUrl)} is required.");
        if (string.IsNullOrWhiteSpace(DirectoryServiceBaseUrl))
            throw new InvalidOperationException($"{nameof(DirectoryServiceBaseUrl)} is required.");

        if (UseOAuth2)
        {
            if (string.IsNullOrWhiteSpace(ClientId)) throw new InvalidOperationException($"{nameof(ClientId)} is required in OAuth2 mode.");
            if (string.IsNullOrWhiteSpace(ClientSecret)) throw new InvalidOperationException($"{nameof(ClientSecret)} is required in OAuth2 mode.");
            if (string.IsNullOrWhiteSpace(TokenUrl)) throw new InvalidOperationException($"{nameof(TokenUrl)} is required in OAuth2 mode.");
        }
        else if (string.IsNullOrWhiteSpace(BearerToken))
        {
            throw new InvalidOperationException($"{nameof(BearerToken)} is required when {nameof(UseOAuth2)} is false.");
        }
    }
}
