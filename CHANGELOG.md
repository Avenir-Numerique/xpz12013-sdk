# Changelog

Les versions du SDK sont **alignées sur la version de la norme AFNOR XP Z12-013** couverte.

## 1.3.0 — Norme AFNOR XP Z12-013 v1.3.0

Couvre la norme **XP Z12-013 v1.3.0** (publiée le 30/06/2026). ⚠️ Cette version introduit des
**ruptures d'API** malgré l'incrément mineur : le numéro suit la norme, pas le SemVer de l'API
(cf. `docs/PUBLISHING.md`).

### Ruptures (breaking changes)

- **Webhooks — payload aplati.** `WebhookParams` expose désormais directement
  `CallbackUrl`, `FlowTypes` (liste), `FlowDirection`, `AckStatus`. Les types `CallbackParameters`,
  `CallbackHeader`, `CallbackAuthentication`, `CallbackSignature`, `WebhookMetadata`,
  `WebhookPatchPayload`, `SignatureAlgorithm` et `CallbackAuthType` sont supprimés.
  - *Migration* : remplacer `new WebhookParams { Callback = new() { Url = … }, Metadata = new() { FlowType = … } }`
    par `new WebhookParams { CallbackUrl = …, FlowTypes = [ … ], FlowDirection = … }`.
- **Webhooks — opérations retirées.** `GetWebhookAsync` et `UpdateWebhookAsync` sont supprimées
  (les endpoints `GET`/`PATCH /v1/webhooks/{id}` n'existent plus dans la norme). Un webhook se
  supprime (`DeleteWebhookAsync`) puis se recrée.
- **Webhooks — réponses.** La création retourne `WebhookIdParam { WebhookId, SigningKey, CreatedAt }`.
  `ListWebhooksAsync` retourne `WebhookListResponse { Count, Webhooks }` (au lieu d'une liste d'ids).
- **`FlowType`** : la valeur `StateInvoice` est supprimée.

### Ajouts

- **`FlowType`** : `StateCustomerInvoice`, `StateSupplierInvoice`, `StateTransactionReport`,
  `StateTransactionReportLC`, `StatePaymentReport`, `StatePaymentReportLC`, `Undefined`.
- **`ProcessingRule`** et **`FlowProfile`** : valeur `Undefined` (états Pending/Error).
- **Pagination par curseur** sur la recherche de flux : `SearchFlowParams.Cursor` /
  `SearchFlowContent.NextCursor` (le filtre par date `UpdatedAfter` reste disponible).
- **Directory** : `SearchDirectoryLine.Include` (`siren`/`siret`/`routingCode`) ;
  `FacilityPayload.Instructions` pour les établissements imbriqués (le champ racine
  `SiretInstructions` est conservé).
- Identifiants `FlowId` / `TrackingId` : longueur maximale portée de 36 à **64** caractères.
- Le healthcheck du Directory Service peut exiger le scope OAuth2 `health.read`
  (à renseigner via `XpZ12013ClientOptions.Scopes`).

### Clients multi-langues

Les clients Java, TypeScript et Python (`clients/`) sont régénérés depuis les specs v1.3.0.

## 1.2.x — Norme AFNOR XP Z12-013 v1.2.0

Version initiale du SDK.
