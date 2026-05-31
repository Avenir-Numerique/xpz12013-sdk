# SiretSearchPost200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**search** | [**SearchSiret**](SearchSiret.md) |  | [optional] 
**total_number_of_results** | **int** | The total number of results | [optional] 
**results** | [**List[FacilityPayloadHistory]**](FacilityPayloadHistory.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.siret_search_post200_response import SiretSearchPost200Response

# TODO update the JSON string below
json = "{}"
# create an instance of SiretSearchPost200Response from a JSON string
siret_search_post200_response_instance = SiretSearchPost200Response.from_json(json)
# print the JSON string representation of the object
print(SiretSearchPost200Response.to_json())

# convert the object into a dict
siret_search_post200_response_dict = siret_search_post200_response_instance.to_dict()
# create an instance of SiretSearchPost200Response from a dict
siret_search_post200_response_from_dict = SiretSearchPost200Response.from_dict(siret_search_post200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


