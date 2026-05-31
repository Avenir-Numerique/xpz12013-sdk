# RoutingCodeSearch


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**RoutingCodeSearchFilters**](RoutingCodeSearchFilters.md) |  | [optional] 
**sorting** | [**List[RoutingCodeSearchSortingInner]**](RoutingCodeSearchSortingInner.md) | Sorting criteria on a field and an order (ascending or descending). | [optional] 
**fields** | [**List[RoutingCodeField]**](RoutingCodeField.md) | Allows you to filter the desired fields in the response. | [optional] 
**include** | **List[str]** |  | [optional] 
**limit** | **int** | Maximum number of results | [optional] 
**ignore** | **int** | Number of results to skip | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_search import RoutingCodeSearch

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodeSearch from a JSON string
routing_code_search_instance = RoutingCodeSearch.from_json(json)
# print the JSON string representation of the object
print(RoutingCodeSearch.to_json())

# convert the object into a dict
routing_code_search_dict = routing_code_search_instance.to_dict()
# create an instance of RoutingCodeSearch from a dict
routing_code_search_from_dict = RoutingCodeSearch.from_dict(routing_code_search_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


