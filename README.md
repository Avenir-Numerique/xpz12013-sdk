# XP Z12-013 SDK &nbsp;·&nbsp; by NeoTimo

> Implémentation de référence **.NET** — bientôt **Java / TypeScript / Python** — de la norme
> **AFNOR XP Z12-013 v1.2.0**, l'API standardisée d'interopérabilité de la **facturation
> électronique française** (échanges entre systèmes d'information et Plateformes de
> Dématérialisation Partenaires).
>
> Offert gratuitement par **[NeoTimo](https://neotimo.fr)** / Avenir Numérique pour accélérer
> l'intégration de la réforme par les éditeurs et intégrateurs. Licence **MIT**.

```xml
<PackageReference Include="NeoTimo.XpZ12013.Sdk" />
```

La norme couvre deux services, tous deux pilotés depuis un seul client :

| Service | Annexe | Rôle |
|---------|--------|------|
| **Flow Service** | A | Dépôt de flux (factures, cycles de vie, e-reporting), recherche, téléchargement, webhooks |
| **Directory Service** | B | Annuaire : SIREN, SIRET, codes routage, lignes annuaire |

## Démarrage rapide

```csharp
using XpZ12013.Sdk;

using var client = new XpZ12013Client(new XpZ12013ClientOptions
{
    FlowServiceBaseUrl      = "https://api.flow.mon-pdp.fr/flow-service",
    DirectoryServiceBaseUrl = "https://api.directory.mon-pdp.fr/directory-service",

    // OAuth2 Client Credentials (refresh automatique)
    ClientId     = "...",
    ClientSecret = "...",
    TokenUrl     = "https://auth.mon-pdp.fr/auth-service/{custId}/token",
});

// Déposer une facture
await using var file = File.OpenRead("facture.xml");
var result = await client.CreateFlowAsync(
    new FlowInfo
    {
        Name        = "facture.xml",
        FlowSyntax  = FlowSyntax.FacturX,
        FlowProfile = FlowProfile.ExtendedCtcFr,
        TrackingId  = "CMD-2026-001",
    },
    file, fileName: "facture.xml", fileContentType: "application/xml");

if (result.IsSuccess)
    Console.WriteLine($"Flux déposé : {result.Data!.FlowId}");
```

## Pourquoi ce SDK plutôt que des appels HTTP bruts

- **Typage fort de bout en bout** — modèles, enums et réponses de la norme, sérialisation gérée.
- **Identifiants validés** — `Siren` (9 chiffres), `Siret` (14 chiffres), `FlowId`, `WebhookId`…
  avec conversions implicites depuis/vers `string`.
- **OAuth2 Client Credentials** avec refresh automatique du token (ou Bearer statique).
- **Résilience intégrée** — retries avec backoff exponentiel + jitter sur les erreurs transitoires.
- **Cœur sans dépendance** — uniquement la BCL .NET (`HttpClient` + `System.Text.Json`).
  L'intégration `Microsoft.Extensions.DependencyInjection` est fournie dans un paquet séparé et
  optionnel (`NeoTimo.XpZ12013.Sdk.DependencyInjection`).

## Authentification

| Mode | Configuration |
|------|---------------|
| **OAuth2 Client Credentials** (défaut) | `ClientId`, `ClientSecret`, `TokenUrl`, `Scopes` (optionnel) |
| **Bearer JWT statique** | `UseOAuth2 = false` + `BearerToken` |

> La délégation multi-tenant est gérée via `OrganizationId` (en-tête `Organization-Id`).
> Chaque requête porte un `Request-Id` de corrélation.

## Injection de dépendances (optionnel)

```xml
<PackageReference Include="NeoTimo.XpZ12013.Sdk.DependencyInjection" />
```

```csharp
services.AddXpZ12013Client(options =>
{
    options.FlowServiceBaseUrl      = "https://api.flow.mon-pdp.fr/flow-service";
    options.DirectoryServiceBaseUrl = "https://api.directory.mon-pdp.fr/directory-service";
    options.ClientId     = "...";
    options.ClientSecret = "...";
    options.TokenUrl     = "https://auth.mon-pdp.fr/auth-service/{custId}/token";
});
```

`XpZ12013Client` est enregistré en **Singleton** (le client HTTP est sans état).

## Surface couverte

**Flow Service** — `CreateFlowAsync`, `SearchFlowsAsync`, `GetFlowMetadataAsync`, `DownloadFlowAsync`,
`ListWebhooksAsync`, `GetWebhookAsync`, `CreateWebhookAsync`, `UpdateWebhookAsync`, `DeleteWebhookAsync`.

**Directory Service** — `SearchCompaniesAsync` / `GetCompanyAsync` (SIREN),
`SearchFacilitiesAsync` / `GetFacilityAsync` (SIRET), `SearchRoutingCodesAsync` / `GetRoutingCodeAsync`,
`SearchDirectoryLinesAsync` / `GetDirectoryLineAsync`.

**Supervision** — `CheckFlowHealthAsync`, `CheckDirectoryHealthAsync`.

> Pagination des flux : itérez en réutilisant `UpdatedAfter` avec l'`updatedAt` du dernier flux reçu
> (comparaison stricte `updatedAt > updatedAfter`).

## Multi-langue

Les clients **Java / TypeScript / Python** sont générés depuis les contrats OpenAPI 3.0.3 officiels de
la norme (dossier [`/spec`](./spec)). Voir la feuille de route.

## Structure du dépôt

```
spec/        Contrats OpenAPI AFNOR (source de génération multi-langue)
dotnet/      SDK C# fait main : XpZ12013.Sdk (cœur) + XpZ12013.Sdk.DependencyInjection
examples/    Exemples exécutables
tests/       Tests unitaires (xUnit)
clients/     Clients générés (Java / TS / Python) — à venir
```

## Avertissement

Ce SDK est une **implémentation de référence indépendante** de la norme XP Z12-013. AFNOR® est une
marque de l'Association française de normalisation. Reportez-vous toujours au texte normatif officiel
de l'AFNOR comme source faisant foi.

## Licence

[MIT](./LICENSE) © 2026 Avenir Numérique (NeoTimo).
