# LegalUnitPayloadHistory


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**siren** | **str** | SIREN number | [optional] 
**business_name** | **str** | Business name | [optional] 
**entity_type** | [**EntityType**](EntityType.md) |  | [optional] 
**administrative_status** | [**LegalUnitAdministrativeStatus**](LegalUnitAdministrativeStatus.md) |  | [optional] 
**instructions** | [**SirenInstructions**](SirenInstructions.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.legal_unit_payload_history import LegalUnitPayloadHistory

# TODO update the JSON string below
json = "{}"
# create an instance of LegalUnitPayloadHistory from a JSON string
legal_unit_payload_history_instance = LegalUnitPayloadHistory.from_json(json)
# print the JSON string representation of the object
print(LegalUnitPayloadHistory.to_json())

# convert the object into a dict
legal_unit_payload_history_dict = legal_unit_payload_history_instance.to_dict()
# create an instance of LegalUnitPayloadHistory from a dict
legal_unit_payload_history_from_dict = LegalUnitPayloadHistory.from_dict(legal_unit_payload_history_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


