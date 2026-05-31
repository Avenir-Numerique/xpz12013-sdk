# `/clients` — Clients générés multi-langues

Clients **Java**, **TypeScript** et **Python** générés depuis les contrats OpenAPI officiels de la
norme (dans [`/spec`](../spec)) via [OpenAPI Generator](https://openapi-generator.tech). Le **SDK C#**
([`/dotnet`](../dotnet)) reste l'implémentation de référence faite main ; ces clients couvrent le
reste de l'écosystème e-invoicing.

> **Statut : généré.** Les clients sont produits depuis les swaggers v1.2.0 de `/spec` et committés.
> La CI régénère et vérifie l'absence de dérive à chaque modification de `/spec` ou de la config.

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

## Publication

Le workflow [`publish-clients.yml`](../.github/workflows/publish-clients.yml) publie les clients
(déclenchement manuel `workflow_dispatch` ou tag `clients-v*`) :

| Cible | Job | Secret requis | Pré-requis |
|-------|-----|---------------|-----------|
| **npm** | `npm` | `NPM_TOKEN` | org/scope `@neotimo` sur npmjs, jeton avec droit publish |
| **PyPI** | `pypi` | `PYPI_API_TOKEN` | projets `neotimo-xpz12013-*` disponibles, jeton scopé |
| **Maven** | `maven` | *(aucun — `GITHUB_TOKEN` intégré)* | publie vers **GitHub Packages** |

> **Maven** : la cible est **GitHub Packages** (immédiat, sans compte tiers ni signature GPG).
> Pour une diffusion publique sans authentification côté consommateur, viser **Maven Central**
> (Sonatype) ultérieurement — cela demande la propriété du namespace `fr.neotimo` et une clé GPG.
