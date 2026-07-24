# SirenSearchPost200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**search** | [**SearchSiren**](SearchSiren.md) |  | [optional] 
**total_number_of_results** | **int** | The total number of results, if -1 is returned then this value is not managed due to performance issue | [optional] [default to -1]
**results** | [**List[LegalUnitPayloadHistory]**](LegalUnitPayloadHistory.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.siren_search_post200_response import SirenSearchPost200Response

# TODO update the JSON string below
json = "{}"
# create an instance of SirenSearchPost200Response from a JSON string
siren_search_post200_response_instance = SirenSearchPost200Response.from_json(json)
# print the JSON string representation of the object
print(SirenSearchPost200Response.to_json())

# convert the object into a dict
siren_search_post200_response_dict = siren_search_post200_response_instance.to_dict()
# create an instance of SirenSearchPost200Response from a dict
siren_search_post200_response_from_dict = SirenSearchPost200Response.from_dict(siren_search_post200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


