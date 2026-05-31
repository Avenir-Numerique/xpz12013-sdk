using System.Reflection;

namespace XpZ12013.Sdk.Models;

/// <summary>
/// Declares the JSON wire value of an enum member when it differs from the member name
/// (e.g. <c>Factur-X</c>). Replacement for the .NET 9-only <c>[JsonStringEnumMemberName]</c>,
/// so the SDK can multi-target net8.0 and net9.0.
/// </summary>
[AttributeUsage(AttributeTargets.Field)]
internal sealed class JsonEnumValueAttribute(string value) : Attribute
{
    public string Value { get; } = value;
}

/// <summary>
/// String enum converter honoring <see cref="JsonEnumValueAttribute"/> (falling back to the
/// member name). Behaves identically on net8.0 and net9.0.
/// </summary>
internal sealed class StringEnumConverter<TEnum> : JsonConverter<TEnum> where TEnum : struct, Enum
{
    private static readonly Dictionary<TEnum, string> ToWire = Build();
    private static readonly Dictionary<string, TEnum> FromWire =
        ToWire.ToDictionary(kv => kv.Value, kv => kv.Key, StringComparer.Ordinal);

    private static Dictionary<TEnum, string> Build()
    {
        var map = new Dictionary<TEnum, string>();
        foreach (var field in typeof(TEnum).GetFields(BindingFlags.Public | BindingFlags.Static))
        {
            var value = (TEnum)field.GetValue(null)!;
            map[value] = field.GetCustomAttribute<JsonEnumValueAttribute>()?.Value ?? field.Name;
        }
        return map;
    }

    public override TEnum Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
    {
        var raw = reader.GetString();
        if (raw is not null && FromWire.TryGetValue(raw, out var value))
            return value;
        throw new JsonException($"Unknown {typeof(TEnum).Name} value: '{raw}'.");
    }

    public override void Write(Utf8JsonWriter writer, TEnum value, JsonSerializerOptions options)
        => writer.WriteStringValue(ToWire.TryGetValue(value, out var wire) ? wire : value.ToString());
}
