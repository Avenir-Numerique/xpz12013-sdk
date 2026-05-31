using System.Text.Json;
using XpZ12013.Sdk.Models;

namespace XpZ12013.Sdk.Tests;

public class SerializationTests
{
    [Fact]
    public void FlowSyntax_FacturX_SerializesWithNormMemberName()
        => Assert.Equal("\"Factur-X\"", JsonSerializer.Serialize(FlowSyntax.FacturX));

    [Fact]
    public void FlowProfile_ExtendedCtcFr_SerializesWithNormMemberName()
        => Assert.Equal("\"Extended-CTC-FR\"", JsonSerializer.Serialize(FlowProfile.ExtendedCtcFr));

    [Fact]
    public void SortingOrder_SerializesLowercase()
        => Assert.Equal("\"ascending\"", JsonSerializer.Serialize(SortingOrder.Ascending));

    [Fact]
    public void FlowInfo_RoundTrips()
    {
        var original = new FlowInfo
        {
            Name = "facture.xml",
            FlowSyntax = FlowSyntax.FacturX,
            FlowProfile = FlowProfile.ExtendedCtcFr,
            TrackingId = "CMD-1"
        };

        var json = JsonSerializer.Serialize(original);
        Assert.Contains("\"flowSyntax\":\"Factur-X\"", json);

        var back = JsonSerializer.Deserialize<FlowInfo>(json)!;
        Assert.Equal(FlowSyntax.FacturX, back.FlowSyntax);
        Assert.Equal("CMD-1", back.TrackingId);
    }

    [Fact]
    public void FlowInfo_OmitsNullOptionalFields()
    {
        var json = JsonSerializer.Serialize(new FlowInfo { Name = "f.xml", FlowSyntax = FlowSyntax.UBL });
        Assert.DoesNotContain("trackingId", json);
        Assert.DoesNotContain("processingRule", json);
    }
}
