# `/clients` — Clients générés multi-langues

Clients **Java**, **TypeScript** et **Python** générés depuis les contrats OpenAPI officiels de la
norme (dans [`/spec`](../spec)) via [OpenAPI Generator](https://openapi-generator.tech). Le **SDK C#**
([`/dotnet`](../dotnet)) reste l'implémentation de référence faite main ; ces clients couvrent le
reste de l'écosystème e-invoicing.

> ⚠️ **Statut : tuyauterie prête, génération en attente.** Les clients ne sont pas encore committés :
> ils seront générés dès que les swaggers AFNOR seront déposés dans `/spec` (cf. **NEOTIMO-1417**,
> point juridique). Tant que `/spec` est vide, le script et la CI sont des _no-op_.

## Générer en local

Prérequis : **Node.js** (pour `npx`) et un **JRE** (OpenAPI Generator tourne sur la JVM).

```bash
# Linux / macOS / WSL
bash scripts/generate-clients.sh 1.2.0
```

```powershell
# Windows
pwsh scripts/generate-clients.ps1 -Version 1.2.0
```

La version d'OpenAPI Generator est épinglée dans [`openapitools.json`](../openapitools.json) pour une
sortie déterministe (indispensable au contrôle de dérive en CI).

## Arborescence générée

```
clients/
  generator-config/   typescript.json · python.json · java.json   (options communes)
  typescript/flow  ·  typescript/directory     (typescript-fetch, sans dépendance runtime)
  python/flow      ·  python/directory         (urllib3)
  java/flow        ·  java/directory           (java.net.http, sans dépendance runtime)
```

Un client est généré **par service** (Flow / Directory), car la norme expose deux API sur des hôtes
distincts.

## Noms de paquets

| Langage | Flow Service | Directory Service |
|---------|--------------|-------------------|
| npm | `@neotimo/xpz12013-flow` | `@neotimo/xpz12013-directory` |
| PyPI | `neotimo-xpz12013-flow` | `neotimo-xpz12013-directory` |
| Maven | `fr.neotimo:xpz12013-flow` | `fr.neotimo:xpz12013-directory` |

## Base URL

Les `servers` des swaggers sont des URL à trous (`{sub-domain}.{domain}`) : comme pour le SDK C#,
l'utilisateur du client généré doit **fournir explicitement la base URL** du service à l'exécution.

## CI — contrôle de dérive

Le workflow [`generate-clients.yml`](../.github/workflows/generate-clients.yml) régénère les clients
et **échoue si le code commité diverge de la spec** : la source de vérité reste `/spec`.

## Publication (à activer en même temps que la génération)

Une fois les clients générés et committés, la publication se fera par langage :
`npm publish` (npm), `twine upload` (PyPI), `mvn deploy` (Maven Central). Workflow dédié à ajouter
lorsque les paquets seront prêts.
