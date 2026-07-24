namespace XpZ12013.Sdk;

// Flow Service operations (Annexe A).
public sealed partial class XpZ12013Client
{
    /// <summary>
    /// Submits a new flow (single-invoice file) with its signalling information.
    /// </summary>
    /// <param name="flowInfo">Signalling of the flow (name, syntax, profile, processing rule...).</param>
    /// <param name="file">The flow file content (XML/PDF, max 100 MB).</param>
    /// <param name="fileName">File name surfaced in the multipart Content-Disposition.</param>
    /// <param name="fileContentType">MIME type of the file: "application/xml" or "application/pdf".</param>
    /// <param name="cancellationToken">Cancellation token.</param>
    public async Task<ApiResult<FullFlowInfo>> CreateFlowAsync(
        FlowInfo flowInfo,
        Stream file,
        string fileName,
        string fileContentType = "application/xml",
        CancellationToken cancellationToken = default)
    {
        var formFields = new Dictionary<string, string>
        {
            ["flowInfo"] = JsonSerializer.Serialize(flowInfo, JsonOptions)
        };

        return await PostMultipartAsync<FullFlowInfo>(
            FlowUrl("/v1/flows"),
            file,
            fileName,
            fileContentType,
            formFields,
            fileFieldName: "file",
            additionalHeaders: BuildHeaders(),
            ct: cancellationToken);
    }

    /// <summary>
    /// Searches flows matching the provided criteria. Pagination is cursor-based: while the
    /// response carries a <c>nextCursor</c>, pass it back as <see cref="Models.SearchFlowParams.Cursor"/>
    /// to fetch the next page; its absence signals the end.
    /// </summary>
    public async Task<ApiResult<SearchFlowContent>> SearchFlowsAsync(
        SearchFlowParams search,
        CancellationToken cancellationToken = default)
    {
        return await PostAsync<SearchFlowParams, SearchFlowContent>(
            FlowUrl("/v1/flows/search"),
            search,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>
    /// Gets the metadata of a flow as a JSON payload (no binary download).
    /// </summary>
    public async Task<ApiResult<Flow>> GetFlowMetadataAsync(
        FlowId flowId,
        CancellationToken cancellationToken = default)
    {
        var query = new Dictionary<string, string>
        {
            ["docType"] = FlowDocType.Metadata.ToString()
        };

        return await GetAsync<Flow>(
            FlowUrl($"/v1/flows/{flowId.Value}"),
            query,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>
    /// Downloads the file of a flow (original, converted or readable view).
    /// </summary>
    /// <param name="flowId">The flow identifier.</param>
    /// <param name="docType">Which document flavor to download (defaults to the original document).</param>
    /// <param name="cancellationToken">Cancellation token.</param>
    public async Task<ApiResult<Stream>> DownloadFlowAsync(
        FlowId flowId,
        FlowDocType docType = FlowDocType.Original,
        CancellationToken cancellationToken = default)
    {
        var query = new Dictionary<string, string>
        {
            ["docType"] = docType.ToString()
        };

        return await GetStreamAsync(
            FlowUrl($"/v1/flows/{flowId.Value}"),
            query,
            BuildHeaders(),
            cancellationToken);
    }
}
