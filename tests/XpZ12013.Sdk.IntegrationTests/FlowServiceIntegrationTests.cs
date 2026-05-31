using Xunit;

namespace XpZ12013.Sdk.IntegrationTests;

/// <summary>Read-only Flow Service integration checks (no flow submitted).</summary>
[Trait("Category", "Integration")]
public sealed class FlowServiceIntegrationTests(SandboxFixture fixture) : IClassFixture<SandboxFixture>
{
    [SandboxFact]
    public async Task FlowHealthcheck_IsHealthy()
    {
        var result = await fixture.Client!.CheckFlowHealthAsync();
        Assert.True(result.IsSuccess, $"HTTP {result.StatusCode}: {result.ErrorMessage}");
    }

    [SandboxFact]
    public async Task ListWebhooks_ReturnsOk()
    {
        var result = await fixture.Client!.ListWebhooksAsync();
        Assert.True(result.IsSuccess, $"HTTP {result.StatusCode}: {result.ErrorMessage}");
    }
}
