namespace XpZ12013.Sdk;

// Supervisor operations (healthchecks).
public sealed partial class XpZ12013Client
{
    /// <summary>Checks whether the Flow Service is up and running.</summary>
    public Task<ApiResult> CheckFlowHealthAsync(CancellationToken cancellationToken = default)
        => SendHealthAsync(FlowUrl("/v1/healthcheck"), cancellationToken);

    /// <summary>Checks whether the Directory Service is up and running.</summary>
    public Task<ApiResult> CheckDirectoryHealthAsync(CancellationToken cancellationToken = default)
        => SendHealthAsync(DirectoryUrl("/v1/healthcheck"), cancellationToken);
}
