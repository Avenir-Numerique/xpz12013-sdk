# RoutingCodeSearchPost200Response


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**search** | [**RoutingCodeSearch**](RoutingCodeSearch.md) |  | [optional] 
**total_number_of_results** | **int** | The total number of results | [optional] 
**results** | [**List[RoutingCodePayloadHistoryLegalUnitFacility]**](RoutingCodePayloadHistoryLegalUnitFacility.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_search_post200_response import RoutingCodeSearchPost200Response

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodeSearchPost200Response from a JSON string
routing_code_search_post200_response_instance = RoutingCodeSearchPost200Response.from_json(json)
# print the JSON string representation of the object
print(RoutingCodeSearchPost200Response.to_json())

# convert the object into a dict
routing_code_search_post200_response_dict = routing_code_search_post200_response_instance.to_dict()
# create an instance of RoutingCodeSearchPost200Response from a dict
routing_code_search_post200_response_from_dict = RoutingCodeSearchPost200Response.from_dict(routing_code_search_post200_response_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


