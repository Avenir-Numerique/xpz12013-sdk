

# RoutingCodePayloadHistoryLegalUnitFacility


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**routingIdentifier** | **String** | Routing identifier od a routing code. |  [optional] |
|**siret** | **String** | SIRET Number |  [optional] |
|**routingIdentifierType** | **String** | Routing Identifier type. |  [optional] |
|**routingCodeName** | **String** | Name of the directory line routing code. This attribute is only returned if the directory line is defined at the SIREN / SIRET / Routing code mesh. |  [optional] |
|**managesLegalCommitmentCode** | **Boolean** | Indicates whether the public structure requires a legal commitment number. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. |  [optional] |
|**administrativeStatus** | **RoutingCodeAdministrativeStatus** |  |  [optional] |
|**address** | [**AddressRead**](AddressRead.md) |  |  [optional] |
|**legalUnit** | [**LegalUnitPayloadIncluded**](LegalUnitPayloadIncluded.md) |  |  [optional] |
|**facility** | [**FacilityPayloadIncluded**](FacilityPayloadIncluded.md) |  |  [optional] |



