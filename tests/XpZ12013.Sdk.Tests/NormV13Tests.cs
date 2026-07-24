using System.Text.Json;
using XpZ12013.Sdk.Models;

namespace XpZ12013.Sdk.Tests;

/// <summary>
/// Conformance tests for the AFNOR XP Z12-013 v1.3.0 schema changes:
/// flat webhook payloads, new enum values, cursor pagination, 64-char identifiers.
/// </summary>
public class NormV13Tests
{
    // Webhooks --------------------------------------------------------------------

    [Fact]
    public void WebhookParams_SerializesFlat()
    {
        var json = JsonSerializer.Serialize(new WebhookParams
        {
            CallbackUrl = "https://cb.example.com/hooks",
            FlowTypes = [FlowType.CustomerInvoice, FlowType.CustomerInvoiceLC],
            FlowDirection = FlowDirection.In,
            AckStatus = FlowAckStatus.Ok
        });

        Assert.Contains("\"callbackUrl\":\"https://cb.example.com/hooks\"", json);
        Assert.Contains("\"flowTypes\":[\"CustomerInvoice\",\"CustomerInvoiceLC\"]", json);
        Assert.Contains("\"flowDirection\":\"In\"", json);
        Assert.DoesNotContain("callback\":{", json);
        Assert.DoesNotContain("metadata", json);
    }

    [Fact]
    public void WebhookParams_OmitsNullFilters()
    {
        var json = JsonSerializer.Serialize(new WebhookParams { CallbackUrl = "https://cb.example.com" });
        Assert.DoesNotContain("flowTypes", json);
        Assert.DoesNotContain("flowDirection", json);
        Assert.DoesNotContain("ackStatus", json);
    }

    [Fact]
    public void WebhookIdParam_DeserializesSigningKeyAndCreatedAt()
    {
        const string json = """
            { "webhookId": "9e107d9d-372b-4e05-9d2b-16b1c4f0e2aa",
              "signingKey": "c2lnbmluZy1rZXk=", "createdAt": "2026-07-01T08:30:00Z" }
            """;

        var created = JsonSerializer.Deserialize<WebhookIdParam>(json)!;

        Assert.Equal("9e107d9d-372b-4e05-9d2b-16b1c4f0e2aa", created.WebhookId);
        Assert.Equal("c2lnbmluZy1rZXk=", created.SigningKey);
        Assert.Equal(DateTimeOffset.Parse("2026-07-01T08:30:00Z"), created.CreatedAt);
    }

    [Fact]
    public void WebhookListResponse_DeserializesCountAndWebhooks()
    {
        const string json = """
            { "count": 1,
              "webhooks": [ { "webhookId": "a", "callbackUrl": "https://cb/a", "flowTypes": ["CustomerInvoice"] } ] }
            """;

        var list = JsonSerializer.Deserialize<WebhookListResponse>(json)!;

        Assert.Equal(1, list.Count);
        var only = Assert.Single(list.Webhooks);
        Assert.Equal("https://cb/a", only.CallbackUrl);
        Assert.Equal(FlowType.CustomerInvoice, Assert.Single(only.FlowTypes!));
    }

    // Enums -----------------------------------------------------------------------

    [Theory]
    [InlineData(FlowType.StateCustomerInvoice, "StateCustomerInvoice")]
    [InlineData(FlowType.StateSupplierInvoice, "StateSupplierInvoice")]
    [InlineData(FlowType.StateTransactionReport, "StateTransactionReport")]
    [InlineData(FlowType.StateTransactionReportLC, "StateTransactionReportLC")]
    [InlineData(FlowType.StatePaymentReport, "StatePaymentReport")]
    [InlineData(FlowType.StatePaymentReportLC, "StatePaymentReportLC")]
    [InlineData(FlowType.Undefined, "Undefined")]
    public void FlowType_NewValues_RoundTrip(FlowType value, string wire)
    {
        Assert.Equal($"\"{wire}\"", JsonSerializer.Serialize(value));
        Assert.Equal(value, JsonSerializer.Deserialize<FlowType>($"\"{wire}\""));
    }

    [Fact]
    public void FlowType_StateInvoice_Removed()
        => Assert.DoesNotContain("StateInvoice", Enum.GetNames<FlowType>());

    [Fact]
    public void ProcessingRule_And_FlowProfile_SupportUndefined()
    {
        Assert.Equal(ProcessingRule.Undefined, JsonSerializer.Deserialize<ProcessingRule>("\"Undefined\""));
        Assert.Equal(FlowProfile.Undefined, JsonSerializer.Deserialize<FlowProfile>("\"Undefined\""));
    }

    // Cursor pagination -----------------------------------------------------------

    [Fact]
    public void SearchFlowParams_SerializesCursor()
    {
        var json = JsonSerializer.Serialize(new SearchFlowParams
        {
            Cursor = "eyJpZCI6MTIzNH0=",
            Where = new SearchFlowFilters { AckStatus = FlowAckStatus.Ok }
        });
        Assert.Contains("\"cursor\":\"eyJpZCI6MTIzNH0=\"", json);
    }

    [Fact]
    public void SearchFlowParams_OmitsNullCursor()
        => Assert.DoesNotContain("cursor", JsonSerializer.Serialize(new SearchFlowParams { Where = new SearchFlowFilters() }));

    [Fact]
    public void SearchFlowContent_DeserializesNextCursor()
    {
        var content = JsonSerializer.Deserialize<SearchFlowContent>("""{ "nextCursor": "bmV4dA==", "results": [] }""")!;
        Assert.Equal("bmV4dA==", content.NextCursor);
        Assert.Empty(content.Results);
    }

    // Identifiers 64 chars --------------------------------------------------------

    [Fact]
    public void FlowId_Accepts64Chars()
        => Assert.Equal(new string('a', 64), new FlowId(new string('a', 64)).Value);

    [Fact]
    public void FlowId_Rejects65Chars()
        => Assert.Throws<ArgumentException>(() => new FlowId(new string('a', 65)));

    [Fact]
    public void TrackingId_Accepts64Chars()
        => Assert.Equal(new string('t', 64), new TrackingId(new string('t', 64)).Value);

    [Fact]
    public void TrackingId_Rejects65Chars()
        => Assert.Throws<ArgumentException>(() => new TrackingId(new string('t', 65)));

    // Directory -------------------------------------------------------------------

    [Fact]
    public void SearchDirectoryLine_SerializesInclude()
    {
        var json = JsonSerializer.Serialize(new SearchDirectoryLine { Include = ["siren", "siret", "routingCode"] });
        Assert.Contains("\"include\":[\"siren\",\"siret\",\"routingCode\"]", json);
    }

    [Fact]
    public void NestedFacility_DeserializesInstructions()
    {
        const string json = """{ "siret": "70204275500240", "instructions": { "isSalesProspectingForbidden": true } }""";
        var facility = JsonSerializer.Deserialize<FacilityPayload>(json)!;

        Assert.NotNull(facility.Instructions);
        Assert.True(facility.Instructions!.IsSalesProspectingForbidden);
        Assert.Null(facility.SiretInstructions);
    }
}
