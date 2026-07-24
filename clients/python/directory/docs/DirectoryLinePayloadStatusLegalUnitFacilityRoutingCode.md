# DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressing_identifier** | **str** | Addressing identifier of the directory line. | [optional] 
**platform_type** | [**RecipientPlatformType**](RecipientPlatformType.md) |  | [optional] 
**directory_line_status** | [**DirectoryLineStatus**](DirectoryLineStatus.md) |  | [optional] 
**siren** | **str** | SIREN number | [optional] 
**siret** | **str** | SIRET Number | [optional] 
**routing_identifier** | **str** | Routing identifier od a routing code. | [optional] 
**addressing_suffix** | **str** | suffix of the directory line which defines an address mesh not attached to a facility | [optional] 
**routing_code** | [**DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode**](DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.md) |  | [optional] 
**legal_unit** | [**LegalUnitPayloadIncluded**](LegalUnitPayloadIncluded.md) |  | [optional] 
**facility** | [**FacilityPayloadIncluded**](FacilityPayloadIncluded.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.directory_line_payload_status_legal_unit_facility_routing_code import DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode

# TODO update the JSON string below
json = "{}"
# create an instance of DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode from a JSON string
directory_line_payload_status_legal_unit_facility_routing_code_instance = DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode.from_json(json)
# print the JSON string representation of the object
print(DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode.to_json())

# convert the object into a dict
directory_line_payload_status_legal_unit_facility_routing_code_dict = directory_line_payload_status_legal_unit_facility_routing_code_instance.to_dict()
# create an instance of DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode from a dict
directory_line_payload_status_legal_unit_facility_routing_code_from_dict = DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode.from_dict(directory_line_payload_status_legal_unit_facility_routing_code_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


