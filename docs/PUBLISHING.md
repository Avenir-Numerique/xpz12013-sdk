# Mise en ligne — `neotimo/xpz12013-sdk`

Marche à suivre pour publier le dépôt sur GitHub, brancher la CI et publier les paquets.
Le dépôt local est prêt : branche **`main`**, 5 commits, build vert, tests verts, clients générés.

---

## 1. Créer le dépôt GitHub public

### Option A — avec GitHub CLI (le plus rapide)

`gh` n'est pas installé sur le poste. Installer puis s'authentifier (commandes **interactives** :
les lancer dans le terminal, par ex. via le préfixe `!` de Claude Code) :

```powershell
winget install --id GitHub.cli -e
gh auth login          # interactif : choisir GitHub.com + HTTPS + navigateur
```

Puis, depuis la racine du dépôt :

```powershell
gh repo create neotimo/xpz12013-sdk --public --source . --remote origin `
  --description "SDK & implémentation de référence de la norme AFNOR XP Z12-013 (facturation électronique FR). Par NeoTimo." `
  --push
```

> Remplacer `neotimo` par le nom exact de l'organisation GitHub cible si différent.

### Option B — sans gh (interface web + git)

1. Sur GitHub : **New repository** → propriétaire `neotimo`, nom `xpz12013-sdk`, **Public**,
   sans README/licence/gitignore (le dépôt en a déjà).
2. Lier et pousser :

```powershell
cd C:\Users\manu.HVB\source\repos\xpz12013-sdk
git remote add origin https://github.com/neotimo/xpz12013-sdk.git
git push -u origin main
```

Au push, les workflows **CI** et **Generate clients** se déclenchent.

---

## 2. Secrets & environnement

### a) Environnement `sandbox` (tests d'intégration)

GitHub → **Settings → Environments → New environment** : `sandbox`.
Y ajouter les secrets (credentials du PDP de test) :

| Secret | Valeur |
|--------|--------|
| `XPZ_FLOW_URL` | URL du Flow Service sandbox |
| `XPZ_DIRECTORY_URL` | URL du Directory Service sandbox |
| `XPZ_CLIENT_ID` | client_id OAuth2 sandbox |
| `XPZ_CLIENT_SECRET` | client_secret OAuth2 sandbox |
| `XPZ_TOKEN_URL` | endpoint token OAuth2 sandbox |

Tant qu'ils sont absents, le job d'intégration s'exécute mais les tests sont **skippés** (pas d'échec).

### b) Secret `NUGET_API_KEY` (publication NuGet)

1. Sur [nuget.org](https://www.nuget.org) → **API Keys** → créer une clé (scope push, globs
   `NeoTimo.XpZ12013.*`).
2. GitHub → **Settings → Secrets and variables → Actions → New repository secret** :
   `NUGET_API_KEY` = la clé.

Avec gh :

```powershell
gh secret set NUGET_API_KEY --body "<clé>"
gh secret set XPZ_FLOW_URL --env sandbox --body "<url>"   # idem pour les autres XPZ_*
```

---

## 3. Première publication NuGet (sur tag)

Le workflow `release.yml` se déclenche sur un tag `v*` et publie les deux paquets
(`NeoTimo.XpZ12013.Sdk` et `…​.DependencyInjection`) avec la version dérivée du tag.

```powershell
git tag v1.2.0          # version alignée sur la norme XP Z12-013
git push origin v1.2.0
```

> Convention suggérée : versionner le SDK sur la version de norme couverte (1.2.0).

---

## 4. Vérifications post-déploiement

- [ ] Onglet **Actions** : CI verte (build + tests unitaires), Generate clients verte (pas de dérive).
- [ ] Job **Sandbox integration tests** : vert (si secrets posés) ou tests skippés (sinon).
- [ ] [nuget.org](https://www.nuget.org/packages/NeoTimo.XpZ12013.Sdk) : paquets en ligne.
- [ ] Badges du README au vert.
- [ ] (Optionnel) **Settings → Branches** : protéger `main` (PR obligatoire + CI requise avant merge).

---

## 5. Publication des clients multi-langues (étape ultérieure)

Les clients générés (`/clients`) sont présents mais pas encore publiés sur npm / PyPI / Maven.
À faire quand on décide de les diffuser : ajouter un workflow par registre
(`npm publish`, `twine upload`, `mvn deploy`) avec les secrets correspondants
(`NPM_TOKEN`, `PYPI_TOKEN`, identifiants Sonatype).
