# SiretInstructions

Instructions regarding the SIRET

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**is_sales_prospecting_forbidden** | **bool** | Indicates whether the information is forbidden from being used for sales prospecting purposes. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.siret_instructions import SiretInstructions

# TODO update the JSON string below
json = "{}"
# create an instance of SiretInstructions from a JSON string
siret_instructions_instance = SiretInstructions.from_json(json)
# print the JSON string representation of the object
print(SiretInstructions.to_json())

# convert the object into a dict
siret_instructions_dict = siret_instructions_instance.to_dict()
# create an instance of SiretInstructions from a dict
siret_instructions_from_dict = SiretInstructions.from_dict(siret_instructions_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


