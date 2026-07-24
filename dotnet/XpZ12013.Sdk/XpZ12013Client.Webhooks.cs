namespace XpZ12013.Sdk;

// Webhook operations (Flow Service, Annexe A).
public sealed partial class XpZ12013Client
{
    /// <summary>Retrieves the webhook subscriptions owned by the token holder.</summary>
    public async Task<ApiResult<WebhookListResponse>> ListWebhooksAsync(
        CancellationToken cancellationToken = default)
    {
        return await GetAsync<WebhookListResponse>(
            FlowUrl("/v1/webhooks"),
            null,
            BuildHeaders(),
            cancellationToken);
    }

    /// <summary>
    /// Subscribes to a webhook (callback URL + flow filter). The response carries the
    /// signing key used by the platform to sign callback requests.
    /// </summary>
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
