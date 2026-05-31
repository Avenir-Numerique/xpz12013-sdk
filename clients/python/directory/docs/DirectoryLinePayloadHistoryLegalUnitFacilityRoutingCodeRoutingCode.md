# DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**routing_identifier** | **str** | Routing identifier od a routing code. | [optional] 
**routing_identifier_type** | **str** | Routing Identifier type. | [optional] 
**routing_code_name** | **str** | Name of the directory line routing code. This attribute is only returned if the directory line is defined at the SIREN / SIRET / Routing code mesh. | [optional] 
**manages_legal_commitment** | **bool** | Indicates whether the public structure requires a legal commitment number. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 
**administrative_status** | [**RoutingCodeAdministrativeStatus**](RoutingCodeAdministrativeStatus.md) |  | [optional] 
**address** | [**AddressRead**](AddressRead.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.directory_line_payload_history_legal_unit_facility_routing_code_routing_code import DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode

# TODO update the JSON string below
json = "{}"
# create an instance of DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode from a JSON string
directory_line_payload_history_legal_unit_facility_routing_code_routing_code_instance = DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.from_json(json)
# print the JSON string representation of the object
print(DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.to_json())

# convert the object into a dict
directory_line_payload_history_legal_unit_facility_routing_code_routing_code_dict = directory_line_payload_history_legal_unit_facility_routing_code_routing_code_instance.to_dict()
# create an instance of DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode from a dict
directory_line_payload_history_legal_unit_facility_routing_code_routing_code_from_dict = DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.from_dict(directory_line_payload_history_legal_unit_facility_routing_code_routing_code_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


