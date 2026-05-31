using Microsoft.Extensions.DependencyInjection;

namespace XpZ12013.Sdk.Tests;

public class DependencyInjectionTests
{
    [Fact]
    public void AddXpZ12013Client_RegistersClientAsSingleton()
    {
        var services = new ServiceCollection();
        services.AddXpZ12013Client(o =>
        {
            o.FlowServiceBaseUrl = "https://flow.test/flow-service";
            o.DirectoryServiceBaseUrl = "https://dir.test/directory-service";
            o.UseOAuth2 = false;
            o.BearerToken = "jwt";
        });

        using var provider = services.BuildServiceProvider();

        var first = provider.GetService<XpZ12013Client>();
        var second = provider.GetRequiredService<XpZ12013Client>();

        Assert.NotNull(first);
        Assert.Same(first, second); // singleton lifetime
    }

    [Fact]
    public void AddXpZ12013Client_InvalidOptions_ThrowsAtRegistration()
    {
        var services = new ServiceCollection();
        Assert.Throws<InvalidOperationException>(() =>
            services.AddXpZ12013Client(o =>
            {
                // Missing service URLs / credentials → Validate() must throw.
                o.UseOAuth2 = false;
            }));
    }
}
