namespace XpZ12013.Sdk.Tests;

public class OptionsTests
{
    private static XpZ12013ClientOptions ValidOAuth() => new()
    {
        FlowServiceBaseUrl = "https://flow.test/flow-service",
        DirectoryServiceBaseUrl = "https://dir.test/directory-service",
        UseOAuth2 = true,
        ClientId = "id",
        ClientSecret = "secret",
        TokenUrl = "https://auth.test/token"
    };

    [Fact]
    public void Validate_ValidOAuth_DoesNotThrow()
        => ValidOAuth().Validate(); // no exception

    [Fact]
    public void Validate_MissingFlowUrl_Throws()
    {
        var options = ValidOAuth();
        options.FlowServiceBaseUrl = "";
        Assert.Throws<InvalidOperationException>(options.Validate);
    }

    [Fact]
    public void Validate_MissingDirectoryUrl_Throws()
    {
        var options = ValidOAuth();
        options.DirectoryServiceBaseUrl = "";
        Assert.Throws<InvalidOperationException>(options.Validate);
    }

    [Fact]
    public void Validate_OAuthMissingClientId_Throws()
    {
        var options = ValidOAuth();
        options.ClientId = "";
        Assert.Throws<InvalidOperationException>(options.Validate);
    }

    [Fact]
    public void Validate_BearerMode_MissingToken_Throws()
    {
        var options = ValidOAuth();
        options.UseOAuth2 = false;
        options.BearerToken = "";
        Assert.Throws<InvalidOperationException>(options.Validate);
    }

    [Fact]
    public void Validate_BearerMode_WithToken_DoesNotThrow()
    {
        var options = ValidOAuth();
        options.UseOAuth2 = false;
        options.BearerToken = "jwt";
        options.Validate(); // no exception
    }
}
