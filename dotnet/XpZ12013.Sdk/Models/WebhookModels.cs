// Webhook models (Flow Service, Annexe A).
namespace XpZ12013.Sdk.Models;

/// <summary>
/// Parameters used to create a webhook subscription (flat structure, norm v1.3.0).
/// The optional properties act as filters: a flow triggers the callback only if it
/// matches every provided criterion.
/// </summary>
public class WebhookParams
{
    /// <summary>Callback URL invoked by the platform (required).</summary>
    [JsonPropertyName("callbackUrl")]
    public required string CallbackUrl { get; set; }

    /// <summary>Flow types that trigger the webhook (OR within the list).</summary>
    [JsonPropertyName("flowTypes")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public List<FlowType>? FlowTypes { get; set; }

    [JsonPropertyName("flowDirection")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FlowDirection? FlowDirection { get; set; }

    [JsonPropertyName("ackStatus")]
    [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingNull)]
    public FlowAckStatus? AckStatus { get; set; }
}

/// <summary>
/// Identification of a webhook as returned at creation: id, signing key and creation time.
/// The signing key (base64) is used to verify the signature of incoming callback requests.
/// </summary>
public class WebhookIdParam
{
    [JsonPropertyName("webhookId")]
    public string WebhookId { get; set; } = string.Empty;

    /// <summary>Base64-encoded key used by the platform to sign callback requests.</summary>
    [JsonPropertyName("signingKey")]
    public string? SigningKey { get; set; }

    [JsonPropertyName("createdAt")]
    public DateTimeOffset? CreatedAt { get; set; }
}

/// <summary>A webhook subscription (id + signing info + params), as returned by GET /v1/webhooks.</summary>
public class Webhook
{
    [JsonPropertyName("webhookId")]
    public string WebhookId { get; set; } = string.Empty;

    /// <summary>Base64-encoded key used by the platform to sign callback requests.</summary>
    [JsonPropertyName("signingKey")]
    public string? SigningKey { get; set; }

    [JsonPropertyName("createdAt")]
    public DateTimeOffset? CreatedAt { get; set; }

    [JsonPropertyName("callbackUrl")]
    public string CallbackUrl { get; set; } = string.Empty;

    [JsonPropertyName("flowTypes")]
    public List<FlowType>? FlowTypes { get; set; }

    [JsonPropertyName("flowDirection")]
    public FlowDirection? FlowDirection { get; set; }

    [JsonPropertyName("ackStatus")]
    public FlowAckStatus? AckStatus { get; set; }
}

/// <summary>Response listing the webhook subscriptions owned by the token holder.</summary>
public class WebhookListResponse
{
    [JsonPropertyName("count")]
    public int Count { get; set; }

    [JsonPropertyName("webhooks")]
    public List<Webhook> Webhooks { get; set; } = [];
}
