// Directory Service models (Annexe B).
namespace XpZ12013.Sdk.Models;

// -----------------------------------------------------------------------------------
// ENUMS
// -----------------------------------------------------------------------------------

/// <summary>Legal structure type.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<EntityType>))]
public enum EntityType
{
    Public,
    PrivateVatRegistered
}

/// <summary>Administrative status: A - Active, C - Closed.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<AdministrativeStatus>))]
public enum AdministrativeStatus
{
    A,
    C
}

/// <summary>Facility type: P - Main facility, S - Secondary facility.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<FacilityType>))]
public enum FacilityType
{
    P,
    S
}

/// <summary>Reception platform type (UNCL 3035): WK - value added network (PA), DFH - government service (PPF).</summary>
[JsonConverter(typeof(JsonStringEnumConverter<PlatformType>))]
public enum PlatformType
{
    WK,
    DFH
}

/// <summary>Directory line status.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<DirectoryLineStatus>))]
public enum DirectoryLineStatus
{
    Enabled,
    Disabled,
    Upcoming
}

/// <summary>Sorting order.</summary>
[JsonConverter(typeof(StringEnumConverter<SortingOrder>))]
public enum SortingOrder
{
    [JsonEnumValue("ascending")]
    Ascending,

    [JsonEnumValue("descending")]
    Descending
}

// -----------------------------------------------------------------------------------
// COMMON SEARCH BUILDING BLOCKS
// -----------------------------------------------------------------------------------

/// <summary>A single filter criterion: a comparison operator and a value.</summary>
public class FilterCriterion
{
    /// <summary>Comparison operator: "contains", "strict" or "startWith" depending on the field.</summary>
    [JsonPropertyName("op")]
    public required string Op { get; set; }

    [JsonPropertyName("value")]
    public required string Value { get; set; }
}

/// <summary>A sorting criterion: a field name and an order.</summary>
public class SortingItem
{
    [JsonPropertyName("field")]
    public required string Field { get; set; }

    [JsonPropertyName("sortingOrder")]
    public SortingOrder SortingOrder { get; set; } = SortingOrder.Ascending;
}

// -----------------------------------------------------------------------------------
// SHARED PAYLOAD PIECES
// -----------------------------------------------------------------------------------

/// <summary>Postal address wrapper.</summary>
public class AddressRead
{
    [JsonPropertyName("addressLine1")]
    public string? AddressLine1 { get; set; }

    [JsonPropertyName("addressLine2")]
    public string? AddressLine2 { get; set; }

    [JsonPropertyName("addressLine3")]
    public string? AddressLine3 { get; set; }

    [JsonPropertyName("postalCode")]
    public string? PostalCode { get; set; }

    [JsonPropertyName("countrySubdivision")]
    public string? CountrySubdivision { get; set; }

    [JsonPropertyName("locality")]
    public string? Locality { get; set; }

    [JsonPropertyName("countryCode")]
    public string? CountryCode { get; set; }

    [JsonPropertyName("countryName")]
    public string? CountryName { get; set; }
}

/// <summary>Directory instructions (sales prospecting).</summary>
public class DirectoryInstructions
{
    [JsonPropertyName("isSalesProspectingForbidden")]
    public bool? IsSalesProspectingForbidden { get; set; }
}

/// <summary>Additional B2G data for a public facility.</summary>
public class B2gAdditionalData
{
    [JsonPropertyName("pm")]
    public bool? Pm { get; set; }

    [JsonPropertyName("pmOnly")]
    public bool? PmOnly { get; set; }

    [JsonPropertyName("managesPaymentStatus")]
    public bool? ManagesPaymentStatus { get; set; }

    [JsonPropertyName("managesLegalCommitmentCode")]
    public bool? ManagesLegalCommitmentCode { get; set; }

    [JsonPropertyName("managesLegalCommitmentOrServiceCode")]
    public bool? ManagesLegalCommitmentOrServiceCode { get; set; }

    [JsonPropertyName("serviceCodeStatus")]
    public bool? ServiceCodeStatus { get; set; }
}

// -----------------------------------------------------------------------------------
// RESOURCE PAYLOADS
// -----------------------------------------------------------------------------------

/// <summary>Legal unit (SIREN) payload.</summary>
public class LegalUnitPayload
{
    [JsonPropertyName("siren")]
    public string? Siren { get; set; }

    [JsonPropertyName("businessName")]
    public string? BusinessName { get; set; }

    [JsonPropertyName("entityType")]
    public EntityType? EntityType { get; set; }

    [JsonPropertyName("administrativeStatus")]
    public AdministrativeStatus? AdministrativeStatus { get; set; }

    [JsonPropertyName("instructions")]
    public DirectoryInstructions? Instructions { get; set; }
}

/// <summary>Facility (SIRET) payload.</summary>
public class FacilityPayload
{
    [JsonPropertyName("siret")]
    public string? Siret { get; set; }

    [JsonPropertyName("siren")]
    public string? Siren { get; set; }

    [JsonPropertyName("name")]
    public string? Name { get; set; }

    [JsonPropertyName("facilityType")]
    public FacilityType? FacilityType { get; set; }

    [JsonPropertyName("administrativeStatus")]
    public AdministrativeStatus? AdministrativeStatus { get; set; }

    [JsonPropertyName("siretInstructions")]
    public DirectoryInstructions? SiretInstructions { get; set; }

    [JsonPropertyName("address")]
    public AddressRead? Address { get; set; }

    [JsonPropertyName("b2gAdditionalData")]
    public B2gAdditionalData? B2gAdditionalData { get; set; }

    [JsonPropertyName("legalUnit")]
    public LegalUnitPayload? LegalUnit { get; set; }
}

/// <summary>Routing code payload.</summary>
public class RoutingCodePayload
{
    [JsonPropertyName("routingIdentifier")]
    public string? RoutingIdentifier { get; set; }

    [JsonPropertyName("siret")]
    public string? Siret { get; set; }

    [JsonPropertyName("routingIdentifierType")]
    public string? RoutingIdentifierType { get; set; }

    [JsonPropertyName("routingCodeName")]
    public string? RoutingCodeName { get; set; }

    [JsonPropertyName("managesLegalCommitmentCode")]
    public bool? ManagesLegalCommitmentCode { get; set; }

    [JsonPropertyName("administrativeStatus")]
    public AdministrativeStatus? AdministrativeStatus { get; set; }

    [JsonPropertyName("address")]
    public AddressRead? Address { get; set; }

    [JsonPropertyName("legalUnit")]
    public LegalUnitPayload? LegalUnit { get; set; }

    [JsonPropertyName("facility")]
    public FacilityPayload? Facility { get; set; }
}

/// <summary>Embedded routing code inside a directory line.</summary>
public class DirectoryLineRoutingCode
{
    [JsonPropertyName("routingIdentifier")]
    public string? RoutingIdentifier { get; set; }

    [JsonPropertyName("routingIdentifierType")]
    public string? RoutingIdentifierType { get; set; }

    [JsonPropertyName("routingCodeName")]
    public string? RoutingCodeName { get; set; }

    [JsonPropertyName("managesLegalCommitment")]
    public bool? ManagesLegalCommitment { get; set; }

    [JsonPropertyName("administrativeStatus")]
    public AdministrativeStatus? AdministrativeStatus { get; set; }

    [JsonPropertyName("address")]
    public AddressRead? Address { get; set; }
}

/// <summary>Directory line payload.</summary>
public class DirectoryLinePayload
{
    [JsonPropertyName("addressingIdentifier")]
    public string? AddressingIdentifier { get; set; }

    [JsonPropertyName("platformType")]
    public PlatformType? PlatformType { get; set; }

    [JsonPropertyName("directoryLineStatus")]
    public DirectoryLineStatus? DirectoryLineStatus { get; set; }

    [JsonPropertyName("siren")]
    public string? Siren { get; set; }

    [JsonPropertyName("siret")]
    public string? Siret { get; set; }

    [JsonPropertyName("addressingSuffix")]
    public string? AddressingSuffix { get; set; }

    [JsonPropertyName("routingCode")]
    public DirectoryLineRoutingCode? RoutingCode { get; set; }

    [JsonPropertyName("legalUnit")]
    public LegalUnitPayload? LegalUnit { get; set; }

    [JsonPropertyName("facility")]
    public FacilityPayload? Facility { get; set; }
}

// -----------------------------------------------------------------------------------
// SEARCH REQUESTS
// -----------------------------------------------------------------------------------

/// <summary>SIREN search request (POST /v1/siren/search).</summary>
public class SearchSiren
{
    [JsonPropertyName("filters")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public SearchSirenFilters? Filters { get; set; }

    [JsonPropertyName("sorting")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<SortingItem>? Sorting { get; set; }

    [JsonPropertyName("fields")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<string>? Fields { get; set; }

    [JsonPropertyName("limit")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Limit { get; set; }

    [JsonPropertyName("ignore")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Ignore { get; set; }
}

/// <summary>SIREN search filters.</summary>
public class SearchSirenFilters
{
    [JsonPropertyName("siren")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Siren { get; set; }

    [JsonPropertyName("businessName")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? BusinessName { get; set; }

    [JsonPropertyName("entityType")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? EntityType { get; set; }

    [JsonPropertyName("administrativeStatus")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AdministrativeStatus { get; set; }
}

/// <summary>SIRET search request (POST /v1/siret/search).</summary>
public class SearchSiret
{
    [JsonPropertyName("filters")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public SearchSiretFilters? Filters { get; set; }

    [JsonPropertyName("sorting")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<SortingItem>? Sorting { get; set; }

    [JsonPropertyName("fields")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<string>? Fields { get; set; }

    [JsonPropertyName("include")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<string>? Include { get; set; }

    [JsonPropertyName("limit")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Limit { get; set; }

    [JsonPropertyName("ignore")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Ignore { get; set; }
}

/// <summary>SIRET search filters.</summary>
public class SearchSiretFilters
{
    [JsonPropertyName("siret")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Siret { get; set; }

    [JsonPropertyName("siren")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Siren { get; set; }

    [JsonPropertyName("facilityType")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? FacilityType { get; set; }

    [JsonPropertyName("name")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Name { get; set; }

    [JsonPropertyName("addressLines")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AddressLines { get; set; }

    [JsonPropertyName("postalCode")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? PostalCode { get; set; }

    [JsonPropertyName("countrySubdivision")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? CountrySubdivision { get; set; }

    [JsonPropertyName("locality")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Locality { get; set; }

    [JsonPropertyName("administrativeStatus")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AdministrativeStatus { get; set; }
}

/// <summary>Routing code search request (POST /v1/routing-code/search).</summary>
public class RoutingCodeSearch
{
    [JsonPropertyName("filters")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public RoutingCodeSearchFilters? Filters { get; set; }

    [JsonPropertyName("sorting")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<SortingItem>? Sorting { get; set; }

    [JsonPropertyName("fields")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<string>? Fields { get; set; }

    [JsonPropertyName("include")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<string>? Include { get; set; }

    [JsonPropertyName("limit")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Limit { get; set; }

    [JsonPropertyName("ignore")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Ignore { get; set; }
}

/// <summary>Routing code search filters.</summary>
public class RoutingCodeSearchFilters
{
    [JsonPropertyName("routingIdentifier")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? RoutingIdentifier { get; set; }

    [JsonPropertyName("siret")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Siret { get; set; }

    [JsonPropertyName("routingCodeName")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? RoutingCodeName { get; set; }

    [JsonPropertyName("administrativeStatus")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AdministrativeStatus { get; set; }

    [JsonPropertyName("addressLines")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AddressLines { get; set; }

    [JsonPropertyName("postalCode")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? PostalCode { get; set; }

    [JsonPropertyName("locality")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Locality { get; set; }
}

/// <summary>Directory line search request (POST /v1/directory-line/search).</summary>
public class SearchDirectoryLine
{
    [JsonPropertyName("filters")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public SearchDirectoryLineFilters? Filters { get; set; }

    [JsonPropertyName("sorting")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<SortingItem>? Sorting { get; set; }

    [JsonPropertyName("fields")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<string>? Fields { get; set; }

    [JsonPropertyName("limit")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Limit { get; set; }

    [JsonPropertyName("ignore")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public int? Ignore { get; set; }
}

/// <summary>Directory line search filters.</summary>
public class SearchDirectoryLineFilters
{
    [JsonPropertyName("addressingIdentifier")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AddressingIdentifier { get; set; }

    [JsonPropertyName("siren")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Siren { get; set; }

    [JsonPropertyName("siret")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? Siret { get; set; }

    [JsonPropertyName("routingIdentifier")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? RoutingIdentifier { get; set; }

    [JsonPropertyName("addressingSuffix")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FilterCriterion? AddressingSuffix { get; set; }
}

// -----------------------------------------------------------------------------------
// SEARCH RESPONSES
// -----------------------------------------------------------------------------------

/// <summary>SIREN search response.</summary>
public class SirenSearchResponse
{
    [JsonPropertyName("search")]
    public SearchSiren? Search { get; set; }

    [JsonPropertyName("totalNumberOfResults")]
    public int TotalNumberOfResults { get; set; }

    [JsonPropertyName("results")]
    public List<LegalUnitPayload> Results { get; set; } = [];
}

/// <summary>SIRET search response.</summary>
public class SiretSearchResponse
{
    [JsonPropertyName("search")]
    public SearchSiret? Search { get; set; }

    [JsonPropertyName("totalNumberOfResults")]
    public int TotalNumberOfResults { get; set; }

    [JsonPropertyName("results")]
    public List<FacilityPayload> Results { get; set; } = [];
}

/// <summary>Routing code search response.</summary>
public class RoutingCodeSearchResponse
{
    [JsonPropertyName("search")]
    public RoutingCodeSearch? Search { get; set; }

    [JsonPropertyName("totalNumberOfResults")]
    public int TotalNumberOfResults { get; set; }

    [JsonPropertyName("results")]
    public List<RoutingCodePayload> Results { get; set; } = [];
}

/// <summary>Directory line search response.</summary>
public class DirectoryLineSearchResponse
{
    [JsonPropertyName("search")]
    public SearchDirectoryLine? Search { get; set; }

    [JsonPropertyName("totalNumberOfResults")]
    public int TotalNumberOfResults { get; set; }

    [JsonPropertyName("results")]
    public List<DirectoryLinePayload> Results { get; set; } = [];
}
