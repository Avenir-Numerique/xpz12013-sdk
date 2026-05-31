# Contribuer

Merci de votre intérêt pour le SDK XP Z12-013 ! Ce projet est une **implémentation de référence**
ouverte de la norme AFNOR XP Z12-013 ; les contributions de la communauté e-invoicing sont bienvenues.

## Prérequis

- .NET SDK 9.0 (ou supérieur)

## Cycle de développement

```bash
dotnet build XpZ12013.Sdk.slnx -c Release
dotnet test tests/XpZ12013.Sdk.Tests/XpZ12013.Sdk.Tests.csproj -c Release
```

Les **tests d'intégration** (`tests/XpZ12013.Sdk.IntegrationTests`) ne s'exécutent que si les
variables d'environnement du sandbox sont définies (`XPZ_FLOW_URL`, `XPZ_DIRECTORY_URL`,
`XPZ_CLIENT_ID`, `XPZ_CLIENT_SECRET`, `XPZ_TOKEN_URL`) ; sinon ils sont ignorés.

## Règles

- **Conventional Commits** (`feat:`, `fix:`, `test:`, `docs:`, `refactor:`, `chore:`).
- Toute modification de comportement doit être couverte par un test unitaire.
- Le **SDK cœur** (`dotnet/XpZ12013.Sdk`) ne doit dépendre que de la BCL .NET — aucune dépendance
  NuGet externe. Les intégrations (DI, etc.) vont dans des paquets séparés.
- Restez fidèle au texte normatif AFNOR ; documentez tout écart.

## Pull requests

1. Forkez et créez une branche depuis `main`.
2. Vérifiez que `dotnet build` et les tests unitaires passent.
3. Ouvrez la PR en décrivant le changement et son lien avec la norme.

## Licence

En contribuant, vous acceptez que votre contribution soit publiée sous licence [MIT](./LICENSE).
