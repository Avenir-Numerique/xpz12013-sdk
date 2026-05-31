using XpZ12013.Sdk.Models;
using Xunit;

namespace XpZ12013.Sdk.IntegrationTests;

/// <summary>
/// Read-only integration tests against a live AFNOR/PDP sandbox. Safe (no mutation): healthchecks
/// and directory searches only. Skipped automatically when the sandbox is not configured.
/// </summary>
[Trait("Category", "Integration")]
public sealed class DirectoryServiceIntegrationTests(SandboxFixture fixture) : IClassFixture<SandboxFixture>
{
    [SandboxFact]
    public async Task DirectoryHealthcheck_IsHealthy()
    {
        var result = await fixture.Client!.CheckDirectoryHealthAsync();
        Assert.True(result.IsSuccess, $"HTTP {result.StatusCode}: {result.ErrorMessage}");
    }

    [SandboxFact]
    public async Task SearchCompanies_ByBusinessName_ReturnsOk()
    {
        var result = await fixture.Client!.SearchCompaniesAsync(new SearchSiren
        {
            Limit = 5,
            Filters = new SearchSirenFilters
            {
                BusinessName = new FilterCriterion { Op = "contains", Value = "a" }
            }
        });

        Assert.True(result.IsSuccess, $"HTTP {result.StatusCode}: {result.ErrorMessage}");
        Assert.NotNull(result.Data);
    }
}
