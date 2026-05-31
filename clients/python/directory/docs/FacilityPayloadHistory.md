# FacilityPayloadHistory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**siret** | **str** | SIRET Number | [optional] 
**siren** | **str** | SIREN number | [optional] 
**name** | **str** | business name | [optional] 
**facility_type** | [**FacilityType**](FacilityType.md) |  | [optional] 
**administrative_status** | [**FacilityAdministrativeStatus**](FacilityAdministrativeStatus.md) |  | [optional] 
**siret_instructions** | [**SiretInstructions**](SiretInstructions.md) |  | [optional] 
**address** | [**AddressRead**](AddressRead.md) |  | [optional] 
**b2g_additional_data** | [**FacilityPayloadHistoryUleB2gAdditionalData**](FacilityPayloadHistoryUleB2gAdditionalData.md) |  | [optional] 
**legal_unit** | [**LegalUnitPayloadIncluded**](LegalUnitPayloadIncluded.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.facility_payload_history import FacilityPayloadHistory

# TODO update the JSON string below
json = "{}"
# create an instance of FacilityPayloadHistory from a JSON string
facility_payload_history_instance = FacilityPayloadHistory.from_json(json)
# print the JSON string representation of the object
print(FacilityPayloadHistory.to_json())

# convert the object into a dict
facility_payload_history_dict = facility_payload_history_instance.to_dict()
# create an instance of FacilityPayloadHistory from a dict
facility_payload_history_from_dict = FacilityPayloadHistory.from_dict(facility_payload_history_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


