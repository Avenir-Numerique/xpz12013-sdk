using XpZ12013.Sdk;

namespace XpZ12013.Sdk.IntegrationTests;

/// <summary>
/// Builds a single <see cref="XpZ12013Client"/> from the sandbox environment, shared across a
/// test class. When the sandbox is not configured, <see cref="Client"/> is null and the
/// <see cref="SandboxFactAttribute"/> skips the tests before they touch it.
/// </summary>
public sealed class SandboxFixture : IDisposable
{
    public XpZ12013Client? Client { get; }

    public SandboxFixture()
    {
        if (!SandboxConfig.IsConfigured)
            return;

        Client = new XpZ12013Client(new XpZ12013ClientOptions
        {
            FlowServiceBaseUrl = SandboxConfig.FlowUrl!,
            DirectoryServiceBaseUrl = SandboxConfig.DirectoryUrl!,
            UseOAuth2 = true,
            ClientId = SandboxConfig.ClientId!,
            ClientSecret = SandboxConfig.ClientSecret!,
            TokenUrl = SandboxConfig.TokenUrl!
        });
    }

    public void Dispose() => Client?.Dispose();
}
