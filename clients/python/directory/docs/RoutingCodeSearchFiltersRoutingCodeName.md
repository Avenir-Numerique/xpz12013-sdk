# RoutingCodeSearchFiltersRoutingCodeName


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOperator**](ContainsOrStrictOperator.md) |  | [optional] 
**value** | **str** | Name of the routing code. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_search_filters_routing_code_name import RoutingCodeSearchFiltersRoutingCodeName

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodeSearchFiltersRoutingCodeName from a JSON string
routing_code_search_filters_routing_code_name_instance = RoutingCodeSearchFiltersRoutingCodeName.from_json(json)
# print the JSON string representation of the object
print(RoutingCodeSearchFiltersRoutingCodeName.to_json())

# convert the object into a dict
routing_code_search_filters_routing_code_name_dict = routing_code_search_filters_routing_code_name_instance.to_dict()
# create an instance of RoutingCodeSearchFiltersRoutingCodeName from a dict
routing_code_search_filters_routing_code_name_from_dict = RoutingCodeSearchFiltersRoutingCodeName.from_dict(routing_code_search_filters_routing_code_name_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


