# DirectoryLineSearchPost200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**search** | [**SearchDirectoryLine**](SearchDirectoryLine.md) |  | [optional] 
**total_number_of_results** | **int** | The total number of results, if -1 is returned then this value is not managed due to performance issue | [optional] [default to -1]
**results** | [**List[DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode]**](DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.directory_line_search_post200_response import DirectoryLineSearchPost200Response

# TODO update the JSON string below
json = "{}"
# create an instance of DirectoryLineSearchPost200Response from a JSON string
directory_line_search_post200_response_instance = DirectoryLineSearchPost200Response.from_json(json)
# print the JSON string representation of the object
print(DirectoryLineSearchPost200Response.to_json())

# convert the object into a dict
directory_line_search_post200_response_dict = directory_line_search_post200_response_instance.to_dict()
# create an instance of DirectoryLineSearchPost200Response from a dict
directory_line_search_post200_response_from_dict = DirectoryLineSearchPost200Response.from_dict(directory_line_search_post200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


