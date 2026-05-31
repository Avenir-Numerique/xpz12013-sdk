// Flow Service models (Annexe A).
namespace XpZ12013.Sdk.Models;

// -----------------------------------------------------------------------------------
// ENUMS
// -----------------------------------------------------------------------------------

/// <summary>Syntax of the original file belonging to a flow.</summary>
[JsonConverter(typeof(StringEnumConverter<FlowSyntax>))]
public enum FlowSyntax
{
    CII,
    UBL,

    [JsonEnumValue("Factur-X")]
    FacturX,
    CDAR,
    FRR
}

/// <summary>Profile of a flow.</summary>
[JsonConverter(typeof(StringEnumConverter<FlowProfile>))]
public enum FlowProfile
{
    Basic,
    CIUS,

    [JsonEnumValue("Extended-CTC-FR")]
    ExtendedCtcFr
}

/// <summary>Type of a flow (invoice, lifecycle, e-reporting...).</summary>
[JsonConverter(typeof(JsonStringEnumConverter<FlowType>))]
public enum FlowType
{
    CustomerInvoice,
    SupplierInvoice,
    StateInvoice,
    CustomerInvoiceLC,
    SupplierInvoiceLC,
    StateCustomerInvoiceLC,
    StateSupplierInvoiceLC,
    AggregatedCustomerTransactionReport,
    UnitaryCustomerTransactionReport,
    AggregatedCustomerPaymentReport,
    UnitaryCustomerPaymentReport,
    UnitarySupplierTransactionReport,
    MultiFlowReport
}

/// <summary>Direction of a flow: In (PDP → OD) or Out (OD → PDP).</summary>
[JsonConverter(typeof(JsonStringEnumConverter<FlowDirection>))]
public enum FlowDirection
{
    In,
    Out
}

/// <summary>Acknowledgement status of a flow.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<FlowAckStatus>))]
public enum FlowAckStatus
{
    Pending,
    Ok,
    Error
}

/// <summary>Regulatory processing rule applied to a flow.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<ProcessingRule>))]
public enum ProcessingRule
{
    B2B,
    B2BInt,
    B2C,
    B2G,
    B2GInt,
    OutOfScope,
    B2GOutOfScope,
    ArchiveOnly,
    NotApplicable
}

/// <summary>File flavor to download for a flow.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<FlowDocType>))]
public enum FlowDocType
{
    /// <summary>Flow metadata as JSON (no binary download).</summary>
    Metadata,

    /// <summary>The document initially sent by the emitter.</summary>
    Original,

    /// <summary>The optionally converted document.</summary>
    Converted,

    /// <summary>The optionally generated readable file.</summary>
    ReadableView
}

/// <summary>Acknowledgement detail severity.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<AcknowledgementLevel>))]
public enum AcknowledgementLevel
{
    Error,
    Warning
}

// -----------------------------------------------------------------------------------
// FLOW INFO (signalling)
// -----------------------------------------------------------------------------------

/// <summary>
/// Signalling of a flow, used to qualify a flow at submission (multipart "flowInfo" field).
/// </summary>
public class FlowInfo
{
    /// <summary>Name of the file (required, max 255 chars).</summary>
    [JsonPropertyName("name")]
    public required string Name { get; set; }

    /// <summary>Syntax of the original file (required).</summary>
    [JsonPropertyName("flowSyntax")]
    public required FlowSyntax FlowSyntax { get; set; }

    /// <summary>External tracking identifier set by the sender.</summary>
    [JsonPropertyName("trackingId")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? TrackingId { get; set; }

    /// <summary>Regulatory processing rule (optional, may be computed by the system).</summary>
    [JsonPropertyName("processingRule")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public ProcessingRule? ProcessingRule { get; set; }

    /// <summary>Profile of the flow.</summary>
    [JsonPropertyName("flowProfile")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FlowProfile? FlowProfile { get; set; }

    /// <summary>SHA-256 fingerprint of the attached file (hex), for integrity checks.</summary>
    [JsonPropertyName("sha256")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? Sha256 { get; set; }
}

/// <summary>
/// Identified flow info returned after submission: flow info + id + submission timestamp.
/// </summary>
public class FullFlowInfo : FlowInfo
{
    /// <summary>Flow identifier assigned by the system.</summary>
    [JsonPropertyName("flowId")]
    public string FlowId { get; set; } = string.Empty;

    /// <summary>Submission date/time (server time reference).</summary>
    [JsonPropertyName("submittedAt")]
    public DateTimeOffset? SubmittedAt { get; set; }
}

// -----------------------------------------------------------------------------------
// FLOW (full resource)
// -----------------------------------------------------------------------------------

/// <summary>A Flow resource as returned by search, metadata get and webhook callbacks.</summary>
public class Flow
{
    [JsonPropertyName("flowId")]
    public string FlowId { get; set; } = string.Empty;

    [JsonPropertyName("name")]
    public string Name { get; set; } = string.Empty;

    [JsonPropertyName("trackingId")]
    public string? TrackingId { get; set; }

    [JsonPropertyName("flowSyntax")]
    public FlowSyntax? FlowSyntax { get; set; }

    [JsonPropertyName("flowProfile")]
    public FlowProfile? FlowProfile { get; set; }

    [JsonPropertyName("flowType")]
    public FlowType? FlowType { get; set; }

    [JsonPropertyName("flowDirection")]
    public FlowDirection? FlowDirection { get; set; }

    [JsonPropertyName("processingRule")]
    public ProcessingRule? ProcessingRule { get; set; }

    /// <summary>Whether the processing rule was an input or was computed.</summary>
    [JsonPropertyName("processingRuleSource")]
    public string? ProcessingRuleSource { get; set; }

    [JsonPropertyName("submittedAt")]
    public DateTimeOffset? SubmittedAt { get; set; }

    [JsonPropertyName("updatedAt")]
    public DateTimeOffset? UpdatedAt { get; set; }

    [JsonPropertyName("acknowledgement")]
    public Acknowledgement? Acknowledgement { get; set; }
}

/// <summary>Acknowledgement of a flow (anti-virus, integrity, rules, unicity checks).</summary>
public class Acknowledgement
{
    [JsonPropertyName("status")]
    public FlowAckStatus Status { get; set; }

    [JsonPropertyName("details")]
    public List<AcknowledgementDetail> Details { get; set; } = [];
}

/// <summary>A single acknowledgement detail (level, item, reason).</summary>
public class AcknowledgementDetail
{
    [JsonPropertyName("level")]
    public AcknowledgementLevel Level { get; set; }

    [JsonPropertyName("item")]
    public string Item { get; set; } = string.Empty;

    [JsonPropertyName("reasonCode")]
    public string ReasonCode { get; set; } = string.Empty;

    [JsonPropertyName("reasonMessage")]
    public string ReasonMessage { get; set; } = string.Empty;
}

// -----------------------------------------------------------------------------------
// SEARCH
// -----------------------------------------------------------------------------------

/// <summary>Parameters of a flow search (POST /v1/flows/search).</summary>
public class SearchFlowParams
{
    /// <summary>Maximum number of results to return (default 25, max 100).</summary>
    [JsonPropertyName("limit")]
    public int Limit { get; set; } = 25;

    /// <summary>Filtering criteria; at least one is required.</summary>
    [JsonPropertyName("where")]
    public required SearchFlowFilters Where { get; set; }
}

/// <summary>Flow search filters (logical AND across criteria, OR within a list).</summary>
public class SearchFlowFilters
{
    /// <summary>Strict comparison: updatedAt &gt; updatedAfter (also used for pagination).</summary>
    [JsonPropertyName("updatedAfter")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public DateTimeOffset? UpdatedAfter { get; set; }

    [JsonPropertyName("updatedBefore")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public DateTimeOffset? UpdatedBefore { get; set; }

    [JsonPropertyName("processingRule")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<ProcessingRule>? ProcessingRule { get; set; }

    [JsonPropertyName("flowType")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<FlowType>? FlowType { get; set; }

    [JsonPropertyName("flowDirection")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<FlowDirection>? FlowDirection { get; set; }

    [JsonPropertyName("trackingId")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? TrackingId { get; set; }

    [JsonPropertyName("ackStatus")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FlowAckStatus? AckStatus { get; set; }
}

/// <summary>A set of flows matching the provided criteria.</summary>
public class SearchFlowContent
{
    [JsonPropertyName("limit")]
    public int? Limit { get; set; }

    [JsonPropertyName("filters")]
    public SearchFlowFilters? Filters { get; set; }

    [JsonPropertyName("results")]
    public List<Flow> Results { get; set; } = [];
}
