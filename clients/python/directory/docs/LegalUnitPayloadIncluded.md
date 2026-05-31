# LegalUnitPayloadIncluded


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**siren** | **str** | SIREN number | [optional] 
**business_name** | **str** | Business name | [optional] 
**entity_type** | [**EntityType**](EntityType.md) |  | [optional] 
**administrative_status** | [**LegalUnitAdministrativeStatus**](LegalUnitAdministrativeStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.legal_unit_payload_included import LegalUnitPayloadIncluded

# TODO update the JSON string below
json = "{}"
# create an instance of LegalUnitPayloadIncluded from a JSON string
legal_unit_payload_included_instance = LegalUnitPayloadIncluded.from_json(json)
# print the JSON string representation of the object
print(LegalUnitPayloadIncluded.to_json())

# convert the object into a dict
legal_unit_payload_included_dict = legal_unit_payload_included_instance.to_dict()
# create an instance of LegalUnitPayloadIncluded from a dict
legal_unit_payload_included_from_dict = LegalUnitPayloadIncluded.from_dict(legal_unit_payload_included_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


