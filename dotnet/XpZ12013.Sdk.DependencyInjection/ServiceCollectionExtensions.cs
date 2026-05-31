using Microsoft.Extensions.DependencyInjection;

namespace XpZ12013.Sdk;

/// <summary>
/// Dependency-injection helpers for registering <see cref="XpZ12013Client"/>.
/// </summary>
public static class ServiceCollectionExtensions
{
    /// <summary>
    /// Registers a singleton <see cref="XpZ12013Client"/> configured via <paramref name="configure"/>.
    /// </summary>
    public static IServiceCollection AddXpZ12013Client(
        this IServiceCollection services,
        Action<XpZ12013ClientOptions> configure)
    {
        ArgumentNullException.ThrowIfNull(services);
        ArgumentNullException.ThrowIfNull(configure);

        var options = new XpZ12013ClientOptions();
        configure(options);
        return services.AddXpZ12013Client(options);
    }

    /// <summary>
    /// Registers a singleton <see cref="XpZ12013Client"/> with pre-built <paramref name="options"/>.
    /// </summary>
    public static IServiceCollection AddXpZ12013Client(
        this IServiceCollection services,
        XpZ12013ClientOptions options)
    {
        ArgumentNullException.ThrowIfNull(services);
        ArgumentNullException.ThrowIfNull(options);
        options.Validate();

        // The HTTP client is stateless → register as a singleton (matches the SDK design).
        services.AddSingleton(options);
        services.AddSingleton<XpZ12013Client>(sp => new XpZ12013Client(sp.GetRequiredService<XpZ12013ClientOptions>()));
        return services;
    }
}
