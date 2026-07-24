# FacilityPayloadIncluded


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**siret** | **str** | SIRET Number | [optional] 
**siren** | **str** | SIREN number | [optional] 
**name** | **str** | business name | [optional] 
**facility_type** | [**FacilityType**](FacilityType.md) |  | [optional] 
**administrative_status** | [**FacilityAdministrativeStatus**](FacilityAdministrativeStatus.md) |  | [optional] 
**instructions** | [**SiretInstructions**](SiretInstructions.md) |  | [optional] 
**address** | [**AddressRead**](AddressRead.md) |  | [optional] 
**b2g_additional_data** | [**FacilityPayloadHistoryUleB2gAdditionalData**](FacilityPayloadHistoryUleB2gAdditionalData.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.facility_payload_included import FacilityPayloadIncluded

# TODO update the JSON string below
json = "{}"
# create an instance of FacilityPayloadIncluded from a JSON string
facility_payload_included_instance = FacilityPayloadIncluded.from_json(json)
# print the JSON string representation of the object
print(FacilityPayloadIncluded.to_json())

# convert the object into a dict
facility_payload_included_dict = facility_payload_included_instance.to_dict()
# create an instance of FacilityPayloadIncluded from a dict
facility_payload_included_from_dict = FacilityPayloadIncluded.from_dict(facility_payload_included_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


