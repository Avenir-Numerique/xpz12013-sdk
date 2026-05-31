using System.Text.RegularExpressions;

namespace XpZ12013.Sdk;

// Strongly-typed, self-validating identifiers for the AFNOR XP Z12-013 API.
// Implemented as readonly record structs (value semantics) with implicit string conversions,
// so callers can pass a raw string or a typed value interchangeably:
//     client.GetCompanyAsync("702042755");
//     client.GetCompanyAsync(new Siren("702042755"));

/// <summary>SIREN number of a legal unit (9 digits).</summary>
public readonly partial record struct Siren
{
    [GeneratedRegex(@"^[0-9]{9}$")]
    private static partial Regex Pattern();

    /// <summary>The raw 9-digit SIREN value.</summary>
    public string Value { get; }

    public Siren(string value)
    {
        if (string.IsNullOrWhiteSpace(value) || !Pattern().IsMatch(value))
            throw new ArgumentException($"SIREN must be 9 digits: '{value}'.", nameof(value));
        Value = value;
    }

    public static implicit operator string(Siren id) => id.Value;
    public static implicit operator Siren(string value) => new(value);
    public override string ToString() => Value;
}

/// <summary>SIRET number of a facility (14 digits).</summary>
public readonly partial record struct Siret
{
    [GeneratedRegex(@"^[0-9]{14}$")]
    private static partial Regex Pattern();

    /// <summary>The raw 14-digit SIRET value.</summary>
    public string Value { get; }

    public Siret(string value)
    {
        if (string.IsNullOrWhiteSpace(value) || !Pattern().IsMatch(value))
            throw new ArgumentException($"SIRET must be 14 digits: '{value}'.", nameof(value));
        Value = value;
    }

    public static implicit operator string(Siret id) => id.Value;
    public static implicit operator Siret(string value) => new(value);
    public override string ToString() => Value;
}

/// <summary>Flow identifier (UUID or any string up to 36 chars).</summary>
public readonly record struct FlowId
{
    /// <summary>The raw flow identifier value.</summary>
    public string Value { get; }

    public FlowId(string value)
    {
        if (string.IsNullOrWhiteSpace(value)) throw new ArgumentException("Flow ID is required.", nameof(value));
        if (value.Length > 36) throw new ArgumentException("Flow ID must be 36 characters or less.", nameof(value));
        Value = value;
    }

    public static implicit operator string(FlowId id) => id.Value;
    public static implicit operator FlowId(string value) => new(value);
    public override string ToString() => Value;
}

/// <summary>External tracking identifier set by the sender (max 36 chars).</summary>
public readonly record struct TrackingId
{
    /// <summary>The raw tracking identifier value.</summary>
    public string Value { get; }

    public TrackingId(string value)
    {
        if (string.IsNullOrWhiteSpace(value)) throw new ArgumentException("Tracking ID is required.", nameof(value));
        if (value.Length > 36) throw new ArgumentException("Tracking ID must be 36 characters or less.", nameof(value));
        Value = value;
    }

    public static implicit operator string(TrackingId id) => id.Value;
    public static implicit operator TrackingId(string value) => new(value);
    public override string ToString() => Value;
}

/// <summary>Webhook subscription identifier (UUID).</summary>
public readonly partial record struct WebhookId
{
    [GeneratedRegex(@"^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")]
    private static partial Regex Pattern();

    /// <summary>The raw UUID value.</summary>
    public string Value { get; }

    public WebhookId(string value)
    {
        if (string.IsNullOrWhiteSpace(value) || !Pattern().IsMatch(value))
            throw new ArgumentException($"Webhook ID must be a UUID: '{value}'.", nameof(value));
        Value = value;
    }

    public static implicit operator string(WebhookId id) => id.Value;
    public static implicit operator WebhookId(string value) => new(value);
    public override string ToString() => Value;
}

/// <summary>Routing identifier of a routing code (max 100 chars).</summary>
public readonly record struct RoutingIdentifier
{
    /// <summary>The raw routing identifier value.</summary>
    public string Value { get; }

    public RoutingIdentifier(string value)
    {
        if (string.IsNullOrWhiteSpace(value)) throw new ArgumentException("Routing identifier is required.", nameof(value));
        if (value.Length > 100) throw new ArgumentException("Routing identifier must be 100 characters or less.", nameof(value));
        Value = value;
    }

    public static implicit operator string(RoutingIdentifier id) => id.Value;
    public static implicit operator RoutingIdentifier(string value) => new(value);
    public override string ToString() => Value;
}

/// <summary>Addressing identifier of a directory line (max 125 chars).</summary>
public readonly record struct AddressingIdentifier
{
    /// <summary>The raw addressing identifier value.</summary>
    public string Value { get; }

    public AddressingIdentifier(string value)
    {
        if (string.IsNullOrWhiteSpace(value)) throw new ArgumentException("Addressing identifier is required.", nameof(value));
        if (value.Length > 125) throw new ArgumentException("Addressing identifier must be 125 characters or less.", nameof(value));
        Value = value;
    }

    public static implicit operator string(AddressingIdentifier id) => id.Value;
    public static implicit operator AddressingIdentifier(string value) => new(value);
    public override string ToString() => Value;
}
