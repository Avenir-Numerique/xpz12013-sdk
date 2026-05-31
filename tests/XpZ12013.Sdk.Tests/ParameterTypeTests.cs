namespace XpZ12013.Sdk.Tests;

public class ParameterTypeTests
{
    [Theory]
    [InlineData("702042755")]
    [InlineData("000000000")]
    public void Siren_Valid_IsAccepted(string value)
    {
        var siren = new Siren(value);
        Assert.Equal(value, siren.Value);
        Assert.Equal(value, (string)siren); // implicit conversion to string
    }

    [Theory]
    [InlineData("12345678")]    // 8 digits
    [InlineData("1234567890")]  // 10 digits
    [InlineData("70204275A")]   // contains a letter
    [InlineData("")]
    public void Siren_Invalid_Throws(string value)
        => Assert.Throws<ArgumentException>(() => new Siren(value));

    [Fact]
    public void Siren_ImplicitFromString_Works()
    {
        Siren siren = "702042755";
        Assert.Equal("702042755", siren.Value);
    }

    [Theory]
    [InlineData("70204275500240")]
    public void Siret_Valid_IsAccepted(string value)
        => Assert.Equal(value, new Siret(value).Value);

    [Theory]
    [InlineData("7020427550024")]   // 13 digits
    [InlineData("702042755002400")] // 15 digits
    public void Siret_Invalid_Throws(string value)
        => Assert.Throws<ArgumentException>(() => new Siret(value));

    [Fact]
    public void WebhookId_Valid_Uuid_IsAccepted()
    {
        const string uuid = "3fa85f64-5717-4562-b3fc-2c963f66afa6";
        Assert.Equal(uuid, new WebhookId(uuid).Value);
    }

    [Theory]
    [InlineData("not-a-uuid")]
    [InlineData("3fa85f64")]
    public void WebhookId_Invalid_Throws(string value)
        => Assert.Throws<ArgumentException>(() => new WebhookId(value));

    [Fact]
    public void Siren_ValueEquality_Holds()
        => Assert.Equal(new Siren("702042755"), new Siren("702042755"));
}
