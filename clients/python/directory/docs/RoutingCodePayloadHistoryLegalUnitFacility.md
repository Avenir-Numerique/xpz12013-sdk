# RoutingCodePayloadHistoryLegalUnitFacility


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**routing_identifier** | **str** | Routing identifier od a routing code. | [optional] 
**siret** | **str** | SIRET Number | [optional] 
**routing_identifier_type** | **str** | Routing Identifier type. | [optional] 
**routing_code_name** | **str** | Name of the directory line routing code. This attribute is only returned if the directory line is defined at the SIREN / SIRET / Routing code mesh. | [optional] 
**manages_legal_commitment_code** | **bool** | Indicates whether the public structure requires a legal commitment number. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 
**administrative_status** | [**RoutingCodeAdministrativeStatus**](RoutingCodeAdministrativeStatus.md) |  | [optional] 
**address** | [**AddressRead**](AddressRead.md) |  | [optional] 
**legal_unit** | [**LegalUnitPayloadIncluded**](LegalUnitPayloadIncluded.md) |  | [optional] 
**facility** | [**FacilityPayloadIncluded**](FacilityPayloadIncluded.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_payload_history_legal_unit_facility import RoutingCodePayloadHistoryLegalUnitFacility

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodePayloadHistoryLegalUnitFacility from a JSON string
routing_code_payload_history_legal_unit_facility_instance = RoutingCodePayloadHistoryLegalUnitFacility.from_json(json)
# print the JSON string representation of the object
print(RoutingCodePayloadHistoryLegalUnitFacility.to_json())

# convert the object into a dict
routing_code_payload_history_legal_unit_facility_dict = routing_code_payload_history_legal_unit_facility_instance.to_dict()
# create an instance of RoutingCodePayloadHistoryLegalUnitFacility from a dict
routing_code_payload_history_legal_unit_facility_from_dict = RoutingCodePayloadHistoryLegalUnitFacility.from_dict(routing_code_payload_history_legal_unit_facility_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


