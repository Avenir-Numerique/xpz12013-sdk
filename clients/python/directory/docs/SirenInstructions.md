# SirenInstructions

Instructions regarding the SIREN

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**is_sales_prospecting_forbidden** | **bool** | Indicates whether the information is forbidden from being used for sales prospecting purposes. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.siren_instructions import SirenInstructions

# TODO update the JSON string below
json = "{}"
# create an instance of SirenInstructions from a JSON string
siren_instructions_instance = SirenInstructions.from_json(json)
# print the JSON string representation of the object
print(SirenInstructions.to_json())

# convert the object into a dict
siren_instructions_dict = siren_instructions_instance.to_dict()
# create an instance of SirenInstructions from a dict
siren_instructions_from_dict = SirenInstructions.from_dict(siren_instructions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


