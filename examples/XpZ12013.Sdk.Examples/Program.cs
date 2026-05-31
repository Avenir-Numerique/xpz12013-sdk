using XpZ12013.Sdk;
using XpZ12013.Sdk.Models;

// Minimal runnable tour of the NeoTimo XP Z12-013 SDK.
//
// Provide credentials via environment variables to hit a real (sandbox) PDP, otherwise the
// program just prints how it would be called:
//   XPZ_FLOW_URL, XPZ_DIRECTORY_URL, XPZ_CLIENT_ID, XPZ_CLIENT_SECRET, XPZ_TOKEN_URL

var flowUrl = Environment.GetEnvironmentVariable("XPZ_FLOW_URL");
var directoryUrl = Environment.GetEnvironmentVariable("XPZ_DIRECTORY_URL");
var clientId = Environment.GetEnvironmentVariable("XPZ_CLIENT_ID");
var clientSecret = Environment.GetEnvironmentVariable("XPZ_CLIENT_SECRET");
var tokenUrl = Environment.GetEnvironmentVariable("XPZ_TOKEN_URL");

if (string.IsNullOrWhiteSpace(flowUrl) || string.IsNullOrWhiteSpace(directoryUrl) ||
    string.IsNullOrWhiteSpace(clientId) || string.IsNullOrWhiteSpace(clientSecret) ||
    string.IsNullOrWhiteSpace(tokenUrl))
{
    Console.WriteLine("""
        NeoTimo XP Z12-013 SDK — exemples
        =================================
        Définissez ces variables d'environnement pour exécuter contre un PDP (sandbox) :
          XPZ_FLOW_URL, XPZ_DIRECTORY_URL, XPZ_CLIENT_ID, XPZ_CLIENT_SECRET, XPZ_TOKEN_URL

        Aperçu de l'API (voir le code de ce fichier) :
          • client.GetCompanyAsync("702042755")           → entreprise par SIREN
          • client.SearchFlowsAsync(...)                  → recherche de flux
          • client.CreateFlowAsync(flowInfo, stream, ...)  → dépôt de facture
        """);
    return;
}

using var client = new XpZ12013Client(new XpZ12013ClientOptions
{
    FlowServiceBaseUrl = flowUrl,
    DirectoryServiceBaseUrl = directoryUrl,
    UseOAuth2 = true,
    ClientId = clientId,
    ClientSecret = clientSecret,
    TokenUrl = tokenUrl
});

// 1) Santé des deux services.
var flowHealth = await client.CheckFlowHealthAsync();
var dirHealth = await client.CheckDirectoryHealthAsync();
Console.WriteLine($"Flow health     : {flowHealth.StatusCode} ({(flowHealth.IsSuccess ? "OK" : "KO")})");
Console.WriteLine($"Directory health: {dirHealth.StatusCode} ({(dirHealth.IsSuccess ? "OK" : "KO")})");

// 2) Consulter une entreprise par SIREN (conversion implicite depuis string).
var company = await client.GetCompanyAsync("702042755");
if (company.IsSuccess)
    Console.WriteLine($"Entreprise : {company.Data?.BusinessName}");
else
    Console.WriteLine($"Erreur SIREN : {company.StatusCode} {company.ErrorMessage}");

// 3) Rechercher les flux entrants récents.
var flows = await client.SearchFlowsAsync(new SearchFlowParams
{
    Limit = 50,
    Where = new SearchFlowFilters
    {
        UpdatedAfter = DateTimeOffset.UtcNow.AddDays(-1),
        FlowDirection = [FlowDirection.In],
        AckStatus = FlowAckStatus.Ok
    }
});
if (flows.IsSuccess)
    Console.WriteLine($"Flux entrants (24 h) : {flows.Data?.Results.Count ?? 0}");

// 4) Déposer une facture (décommenter avec un vrai fichier).
// await using var file = File.OpenRead("facture.xml");
// var deposit = await client.CreateFlowAsync(
//     new FlowInfo { Name = "facture.xml", FlowSyntax = FlowSyntax.FacturX, FlowProfile = FlowProfile.ExtendedCtcFr },
//     file, fileName: "facture.xml", fileContentType: "application/xml");
// Console.WriteLine(deposit.IsSuccess ? $"Flux déposé : {deposit.Data?.FlowId}" : $"Échec : {deposit.ErrorMessage}");
