namespace XpZ12013.Sdk;

// Directory Service operations (Annexe B).
public sealed partial class XpZ12013Client
{
    // -------------------------------------------------------------------------------
    // SIREN (legal units)
    // -------------------------------------------------------------------------------

    /// <summary>Multi-criteria search for companies (legal units) by SIREN.</summary>
    public async Task<ApiResult<SirenSearchResponse>> SearchCompaniesAsync(
        SearchSiren search,
        CancellationToken cancellationToken = default)
    {
        return await PostAsync<SearchSiren, SirenSearchResponse>(
            DirectoryUrl("/v1/siren/search"),
            search,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Gets a company (legal unit) by its SIREN number.</summary>
    public async Task<ApiResult<LegalUnitPayload>> GetCompanyAsync(
        Siren siren,
        IEnumerable<string>? fields = null,
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<LegalUnitPayload>(
            DirectoryUrl($"/v1/siren/code-insee:{siren.Value}"),
            BuildArrayQuery(("fields", fields)),
            BuildHeaders(),
            cancellationToken);
    }

    // -------------------------------------------------------------------------------
    // SIRET (facilities)
    // -------------------------------------------------------------------------------

    /// <summary>Multi-criteria search for facilities by SIRET.</summary>
    public async Task<ApiResult<SiretSearchResponse>> SearchFacilitiesAsync(
        SearchSiret search,
        CancellationToken cancellationToken = default)
    {
        return await PostAsync<SearchSiret, SiretSearchResponse>(
            DirectoryUrl("/v1/siret/search"),
            search,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Gets a facility by its SIRET number.</summary>
    public async Task<ApiResult<FacilityPayload>> GetFacilityAsync(
        Siret siret,
        IEnumerable<string>? fields = null,
        IEnumerable<string>? include = null,
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<FacilityPayload>(
            DirectoryUrl($"/v1/siret/code-insee:{siret.Value}"),
            BuildArrayQuery(("fields", fields), ("include", include)),
            BuildHeaders(),
            cancellationToken);
    }

    // -------------------------------------------------------------------------------
    // ROUTING CODES
    // -------------------------------------------------------------------------------

    /// <summary>Multi-criteria search for routing codes.</summary>
    public async Task<ApiResult<RoutingCodeSearchResponse>> SearchRoutingCodesAsync(
        RoutingCodeSearch search,
        CancellationToken cancellationToken = default)
    {
        return await PostAsync<RoutingCodeSearch, RoutingCodeSearchResponse>(
            DirectoryUrl("/v1/routing-code/search"),
            search,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Gets a routing code by SIRET and routing identifier.</summary>
    public async Task<ApiResult<RoutingCodePayload>> GetRoutingCodeAsync(
        Siret siret,
        RoutingIdentifier routingIdentifier,
        IEnumerable<string>? fields = null,
        IEnumerable<string>? include = null,
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<RoutingCodePayload>(
            DirectoryUrl($"/v1/routing-code/siret:{siret.Value}/code:{routingIdentifier.Value}"),
            BuildArrayQuery(("fields", fields), ("include", include)),
            BuildHeaders(),
            cancellationToken);
    }

    // -------------------------------------------------------------------------------
    // DIRECTORY LINES
    // -------------------------------------------------------------------------------

    /// <summary>Multi-criteria search for directory lines.</summary>
    public async Task<ApiResult<DirectoryLineSearchResponse>> SearchDirectoryLinesAsync(
        SearchDirectoryLine search,
        CancellationToken cancellationToken = default)
    {
        return await PostAsync<SearchDirectoryLine, DirectoryLineSearchResponse>(
            DirectoryUrl("/v1/directory-line/search"),
            search,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Gets a directory line by its addressing identifier.</summary>
    public async Task<ApiResult<DirectoryLinePayload>> GetDirectoryLineAsync(
        AddressingIdentifier addressingIdentifier,
        IEnumerable<string>? fields = null,
        IEnumerable<string>? include = null,
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<DirectoryLinePayload>(
            DirectoryUrl($"/v1/directory-line/code:{addressingIdentifier.Value}"),
            BuildArrayQuery(("fields", fields), ("include", include)),
            BuildHeaders(),
            cancellationToken);
    }

    // -------------------------------------------------------------------------------
    // HELPERS
    // -------------------------------------------------------------------------------

    /// <summary>
    /// Builds a query-parameter dictionary for the directory "array" parameters (fields, include),
    /// serialized comma-separated (explode=false). Returns null when no parameter has a value.
    /// </summary>
    private static Dictionary<string, string>? BuildArrayQuery(
        params (string Name, IEnumerable<string>? Values)[] arrays)
    {
        Dictionary<string, string>? query = null;
        foreach (var (name, values) in arrays)
        {
            var list = values?.Where(v => !string.IsNullOrWhiteSpace(v)).ToList();
            if (list is { Count: > 0 })
            {
                query ??= [];
                query[name] = string.Join(",", list);
            }
        }
        return query;
    }
}
