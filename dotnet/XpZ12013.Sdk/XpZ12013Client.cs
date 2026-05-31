using XpZ12013.Sdk.Authentication;

namespace XpZ12013.Sdk;

/// <summary>
/// Standalone .NET client for the AFNOR XP Z12-013 standard (French e-invoicing interoperability,
/// PDP/PA). Implementation of reference covering both services of the norm:
/// the <b>Flow Service</b> (Annexe A — submit/search/download flows, manage webhooks) and the
/// <b>Directory Service</b> (Annexe B — SIREN, SIRET, routing codes, directory lines).
/// </summary>
/// <remarks>
/// The two services are hosted on distinct base URLs. Both are driven from this single client:
/// every operation builds an absolute URL for its target service. The client has no dependency
/// other than the .NET base class library.
/// </remarks>
public sealed partial class XpZ12013Client : IDisposable
{
    private readonly XpZ12013ClientOptions _options;
    private readonly HttpClient _http;
    private readonly bool _ownsHttpClient;
    private readonly IXpZ12013Authenticator _authenticator;

    internal static readonly JsonSerializerOptions JsonOptions = new()
    {
        DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,
        PropertyNameCaseInsensitive = true
    };

    /// <summary>
    /// Creates a new client. Pass a custom <paramref name="httpClient"/> to control the transport
    /// (proxy, handlers, pooling); otherwise an internal one is created and disposed with the client.
    /// </summary>
    public XpZ12013Client(XpZ12013ClientOptions options, HttpClient? httpClient = null)
    {
        ArgumentNullException.ThrowIfNull(options);
        options.Validate();

        _options = options;
        _ownsHttpClient = httpClient is null;
        _http = httpClient ?? new HttpClient();
        _http.Timeout = TimeSpan.FromSeconds(options.TimeoutSeconds);

        _authenticator = options.UseOAuth2
            ? new OAuth2ClientCredentialsAuthenticator(_http, options)
            : new StaticBearerAuthenticator(options.BearerToken);
    }

    /// <summary>Builds an absolute URL on the Flow Service for the given relative path.</summary>
    private string FlowUrl(string path) =>
        $"{_options.FlowServiceBaseUrl.TrimEnd('/')}/{path.TrimStart('/')}";

    /// <summary>Builds an absolute URL on the Directory Service for the given relative path.</summary>
    private string DirectoryUrl(string path) =>
        $"{_options.DirectoryServiceBaseUrl.TrimEnd('/')}/{path.TrimStart('/')}";

    /// <summary>
    /// Builds the per-request headers: a fresh correlation header (Request-Id) and, when configured,
    /// the delegation header (Organization-Id).
    /// </summary>
    private Dictionary<string, string> BuildHeaders()
    {
        var headers = new Dictionary<string, string>
        {
            ["Request-Id"] = Guid.NewGuid().ToString()
        };
        if (!string.IsNullOrWhiteSpace(_options.OrganizationId))
            headers["Organization-Id"] = _options.OrganizationId!;
        return headers;
    }

    /// <inheritdoc />
    public void Dispose()
    {
        (_authenticator as IDisposable)?.Dispose();
        if (_ownsHttpClient)
            _http.Dispose();
    }
}
