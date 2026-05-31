namespace XpZ12013.Sdk;

// Webhook operations (Flow Service, Annexe A).
public sealed partial class XpZ12013Client
{
    /// <summary>Retrieves the list of webhook ids owned by the token holder.</summary>
    public async Task<ApiResult<WebhookListResponse>> ListWebhooksAsync(
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<WebhookListResponse>(
            FlowUrl("/v1/webhooks"),
            null,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Gets the full content of a webhook subscription.</summary>
    public async Task<ApiResult<Webhook>> GetWebhookAsync(
        WebhookId webhookUid,
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<Webhook>(
            FlowUrl($"/v1/webhooks/{webhookUid.Value}"),
            null,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Subscribes to a webhook (technical &amp; security parameters + metadata filter).</summary>
    public async Task<ApiResult<WebhookIdParam>> CreateWebhookAsync(
        WebhookParams parameters,
        CancellationToken cancellationToken = default)
    {
        return await PostAsync<WebhookParams, WebhookIdParam>(
            FlowUrl("/v1/webhooks"),
            parameters,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Updates the technical configuration of a webhook, keeping the same metadata.</summary>
    public async Task<ApiResult> UpdateWebhookAsync(
        WebhookId webhookUid,
        WebhookPatchPayload payload,
        CancellationToken cancellationToken = default)
    {
        return await PatchAsync(
            FlowUrl($"/v1/webhooks/{webhookUid.Value}"),
            payload,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>Unsubscribes from a webhook.</summary>
    public async Task<ApiResult> DeleteWebhookAsync(
        WebhookId webhookUid,
        CancellationToken cancellationToken = default)
    {
        return await DeleteAsync(
            FlowUrl($"/v1/webhooks/{webhookUid.Value}"),
            BuildHeaders(),
            cancellationToken);
    }
}
