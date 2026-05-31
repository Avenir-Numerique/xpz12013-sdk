// Webhook models (Flow Service, Annexe A).
namespace XpZ12013.Sdk.Models;

/// <summary>Signature algorithm used for webhook callbacks.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<SignatureAlgorithm>))]
public enum SignatureAlgorithm
{
    RS256,
    HS256,
    ECDSA,
    EDDSA_25519,
    RSA_PSS,
    EDDSA_448
}

/// <summary>Authentication mode required to call back the subscriber's endpoint.</summary>
[JsonConverter(typeof(JsonStringEnumConverter<CallbackAuthType>))]
public enum CallbackAuthType
{
    BASIC,
    OAUTH2
}

/// <summary>Parameters used to create or describe a webhook subscription.</summary>
public class WebhookParams
{
    [JsonPropertyName("callback")]
    public required CallbackParameters Callback { get; set; }

    [JsonPropertyName("metadata")]
    public required WebhookMetadata Metadata { get; set; }
}

/// <summary>Technical parameters of the callback endpoint.</summary>
public class CallbackParameters
{
    /// <summary>Callback URL invoked by the platform (required).</summary>
    [JsonPropertyName("url")]
    public required string Url { get; set; }

    [JsonPropertyName("headers")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<CallbackHeader>? Headers { get; set; }

    [JsonPropertyName("authentication")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public CallbackAuthentication? Authentication { get; set; }

    [JsonPropertyName("signature")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public CallbackSignature? Signature { get; set; }
}

/// <summary>A custom header added to the callback request.</summary>
public class CallbackHeader
{
    [JsonPropertyName("headerName")]
    public required string HeaderName { get; set; }

    [JsonPropertyName("headerValue")]
    public required string HeaderValue { get; set; }
}

/// <summary>
/// Authentication block for the callback. Depending on <see cref="AuthType"/>, fill either the
/// Basic credentials (userId/userPassword) or the OAuth2 credentials (tokenUrl/clientId/clientSecret).
/// </summary>
public class CallbackAuthentication
{
    [JsonPropertyName("authType")]
    public required CallbackAuthType AuthType { get; set; }

    // Basic
    [JsonPropertyName("userId")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? UserId { get; set; }

    [JsonPropertyName("userPassword")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? UserPassword { get; set; }

    // OAuth2
    [JsonPropertyName("tokenUrl")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? TokenUrl { get; set; }

    [JsonPropertyName("clientId")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? ClientId { get; set; }

    [JsonPropertyName("clientSecret")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public string? ClientSecret { get; set; }
}

/// <summary>Signature configuration for callbacks.</summary>
public class CallbackSignature
{
    [JsonPropertyName("algo")]
    public SignatureAlgorithm Algo { get; set; }

    /// <summary>Base64-encoded signing key.</summary>
    [JsonPropertyName("key")]
    public required string Key { get; set; }
}

/// <summary>Metadata used to filter the subset of flows that trigger the webhook.</summary>
public class WebhookMetadata
{
    [JsonPropertyName("flowType")]
    public required FlowType FlowType { get; set; }

    [JsonPropertyName("flowDirection")]
    public required FlowDirection FlowDirection { get; set; }

    [JsonPropertyName("processingRule")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public ProcessingRule? ProcessingRule { get; set; }

    [JsonPropertyName("ackStatus")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FlowAckStatus? AckStatus { get; set; }
}

/// <summary>A webhook subscription (id + params), as returned by GET /v1/webhooks/{id}.</summary>
public class Webhook : WebhookParams
{
    [JsonPropertyName("webhookId")]
    public string WebhookId { get; set; } = string.Empty;
}

/// <summary>Lightweight response holding only the webhook id (creation response).</summary>
public class WebhookIdParam
{
    [JsonPropertyName("webhookId")]
    public string WebhookId { get; set; } = string.Empty;
}

/// <summary>Response listing the webhook ids owned by the token holder.</summary>
public class WebhookListResponse
{
    [JsonPropertyName("webhookIds")]
    public List<string> WebhookIds { get; set; } = [];
}

/// <summary>Payload to update a webhook's technical parameters (metadata is kept unchanged).</summary>
public class WebhookPatchPayload
{
    [JsonPropertyName("headers")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<CallbackHeader>? Headers { get; set; }

    [JsonPropertyName("authentication")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public CallbackAuthentication? Authentication { get; set; }

    [JsonPropertyName("signature")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public CallbackSignature? Signature { get; set; }
}
