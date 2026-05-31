using System.Net;
using System.Net.Http;
using XpZ12013.Sdk.Models;

namespace XpZ12013.Sdk.Tests;

public class ClientTests
{
    private static (XpZ12013Client client, StubHttpHandler handler) CreateBearerClient(
        Func<HttpRequestMessage, int, HttpResponseMessage> responder,
        Action<XpZ12013ClientOptions>? configure = null)
    {
        var handler = new StubHttpHandler(responder);
        var options = new XpZ12013ClientOptions
        {
            FlowServiceBaseUrl = "https://flow.test/flow-service",
            DirectoryServiceBaseUrl = "https://dir.test/directory-service",
            UseOAuth2 = false,
            BearerToken = "test-token",
            MaxRetries = 2,
            RetryBaseDelayMs = 1
        };
        configure?.Invoke(options);
        return (new XpZ12013Client(options, new HttpClient(handler)), handler);
    }

    [Fact]
    public async Task GetCompanyAsync_BuildsDirectoryUrl_AndAuthAndCorrelationHeaders()
    {
        var (client, handler) = CreateBearerClient(
            (_, _) => StubHttpHandler.Json(HttpStatusCode.OK, """{"siren":"702042755","businessName":"ACME"}"""));

        var result = await client.GetCompanyAsync("702042755");

        Assert.True(result.IsSuccess);
        Assert.Equal("ACME", result.Data!.BusinessName);

        var request = handler.Requests[0];
        Assert.Equal(HttpMethod.Get, request.Method);
        Assert.StartsWith("https://dir.test/directory-service/v1/siren/", request.RequestUri!.AbsoluteUri);
        Assert.Contains("code-insee:702042755", request.RequestUri!.AbsoluteUri);
        Assert.Equal("Bearer", request.Headers.Authorization!.Scheme);
        Assert.Equal("test-token", request.Headers.Authorization!.Parameter);
        Assert.True(request.Headers.Contains("Request-Id"));
        Assert.False(request.Headers.Contains("Organization-Id"));
    }

    [Fact]
    public async Task SearchFlowsAsync_PostsJson_WithStringEnumMemberNames()
    {
        var (client, handler) = CreateBearerClient(
            (_, _) => StubHttpHandler.Json(HttpStatusCode.OK, """{"results":[]}"""));

        var result = await client.SearchFlowsAsync(new SearchFlowParams
        {
            Limit = 10,
            Where = new SearchFlowFilters
            {
                FlowDirection = [FlowDirection.In],
                AckStatus = FlowAckStatus.Ok
            }
        });

        Assert.True(result.IsSuccess);

        var request = handler.Requests[0];
        Assert.Equal(HttpMethod.Post, request.Method);
        Assert.Contains("/v1/flows/search", request.RequestUri!.AbsoluteUri);

        var body = handler.Bodies[0]!;
        Assert.Contains("\"flowDirection\":[\"In\"]", body);
        Assert.Contains("\"ackStatus\":\"Ok\"", body);
    }

    [Fact]
    public async Task FailedResponse_SurfacesStatusAndError()
    {
        var (client, _) = CreateBearerClient(
            (_, _) => StubHttpHandler.Json(HttpStatusCode.NotFound, """{"error":"not found"}"""));

        var result = await client.GetCompanyAsync("702042755");

        Assert.False(result.IsSuccess);
        Assert.Equal(404, result.StatusCode);
        Assert.Contains("not found", result.ErrorMessage);
    }

    [Fact]
    public async Task TransientFailure_IsRetried_ThenSucceeds()
    {
        var (client, handler) = CreateBearerClient(
            (_, attempt) => attempt == 0
                ? new HttpResponseMessage(HttpStatusCode.ServiceUnavailable)
                : StubHttpHandler.Json(HttpStatusCode.OK, """{"businessName":"ACME"}"""));

        var result = await client.GetCompanyAsync("702042755");

        Assert.True(result.IsSuccess);
        Assert.Equal(2, handler.Requests.Count); // one failed + one retry
    }

    [Fact]
    public async Task OrganizationId_IsSent_WhenConfigured()
    {
        var (client, handler) = CreateBearerClient(
            (_, _) => StubHttpHandler.Json(HttpStatusCode.OK, "{}"),
            o => o.OrganizationId = "70204275500240");

        await client.GetCompanyAsync("702042755");

        var request = handler.Requests[0];
        Assert.True(request.Headers.Contains("Organization-Id"));
        Assert.Equal("70204275500240", request.Headers.GetValues("Organization-Id").Single());
    }

    [Fact]
    public async Task OAuth2_FetchesTokenOnce_ThenReusesItOnSubsequentCalls()
    {
        var tokenHits = 0;
        var handler = new StubHttpHandler((request, _) =>
        {
            if (request.RequestUri!.AbsoluteUri.StartsWith("https://auth.test/token"))
            {
                tokenHits++;
                return StubHttpHandler.Json(HttpStatusCode.OK, """{"access_token":"abc","expires_in":3600}""");
            }
            return StubHttpHandler.Json(HttpStatusCode.OK, """{"businessName":"ACME"}""");
        });

        using var client = new XpZ12013Client(new XpZ12013ClientOptions
        {
            FlowServiceBaseUrl = "https://flow.test/flow-service",
            DirectoryServiceBaseUrl = "https://dir.test/directory-service",
            UseOAuth2 = true,
            ClientId = "id",
            ClientSecret = "secret",
            TokenUrl = "https://auth.test/token"
        }, new HttpClient(handler));

        await client.GetCompanyAsync("702042755");
        await client.GetCompanyAsync("702042755");

        Assert.Equal(1, tokenHits); // token cached across calls

        var apiRequests = handler.Requests
            .Where(r => r.RequestUri!.AbsoluteUri.Contains("directory-service"))
            .ToList();
        Assert.Equal(2, apiRequests.Count);
        Assert.All(apiRequests, r => Assert.Equal("abc", r.Headers.Authorization!.Parameter));
    }
}
