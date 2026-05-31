using Xunit;

namespace XpZ12013.Sdk.IntegrationTests;

/// <summary>
/// A <see cref="FactAttribute"/> that auto-skips when the sandbox environment variables are
/// not configured. Integration tests therefore run in CI (secrets provided) and are skipped
/// locally / on forks without leaking credentials.
/// </summary>
public sealed class SandboxFactAttribute : FactAttribute
{
    public SandboxFactAttribute()
    {
        if (!SandboxConfig.IsConfigured)
            Skip = "Sandbox non configuré — définir XPZ_FLOW_URL, XPZ_DIRECTORY_URL, XPZ_CLIENT_ID, XPZ_CLIENT_SECRET, XPZ_TOKEN_URL.";
    }
}

/// <summary>Reads the sandbox connection settings from environment variables.</summary>
public static class SandboxConfig
{
    public static string? FlowUrl => Environment.GetEnvironmentVariable("XPZ_FLOW_URL");
    public static string? DirectoryUrl => Environment.GetEnvironmentVariable("XPZ_DIRECTORY_URL");
    public static string? ClientId => Environment.GetEnvironmentVariable("XPZ_CLIENT_ID");
    public static string? ClientSecret => Environment.GetEnvironmentVariable("XPZ_CLIENT_SECRET");
    public static string? TokenUrl => Environment.GetEnvironmentVariable("XPZ_TOKEN_URL");

    public static bool IsConfigured =>
        !string.IsNullOrWhiteSpace(FlowUrl) &&
        !string.IsNullOrWhiteSpace(DirectoryUrl) &&
        !string.IsNullOrWhiteSpace(ClientId) &&
        !string.IsNullOrWhiteSpace(ClientSecret) &&
        !string.IsNullOrWhiteSpace(TokenUrl);
}
