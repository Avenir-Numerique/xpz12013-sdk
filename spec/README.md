# `/spec` — Contrats OpenAPI AFNOR XP Z12-013

Ce dossier accueille les contrats **OpenAPI 3.0.3 v1.2.0** de la norme, source de génération
des clients multi-langues (phase 3). Déposez les annexes AFNOR ici en les renommant ainsi
(noms attendus par les scripts de génération) :

| Fichier attendu | Source AFNOR |
|-----------------|--------------|
| `flow-service.json` | `ANNEXE A - XP Z12-013 - Flow_Service-1.2.0-swagger-resolved.json` |
| `directory-service.json` | `ANNEXE B - XP Z12-013 - Directory_Service-1.2.0-swagger-resolved.json` |

> ⚠️ **Les fichiers ne sont volontairement pas encore committés.**
> La redistribution des annexes AFNOR (copyright AFNOR) dans un dépôt public MIT doit être
> tranchée juridiquement — voir **NEOTIMO-1417** (phase 0). Deux options :
> 1. accord explicite d'AFNOR pour redistribuer les annexes ;
> 2. téléchargement de la spec au moment du build (script) plutôt qu'un commit.

Tant que ce point n'est pas levé, la génération multi-langue (phase 3) reste locale.
