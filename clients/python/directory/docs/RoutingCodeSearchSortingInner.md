# RoutingCodeSearchSortingInner

A sort criteria composed of a field and an order (ascending or descending).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_field** | [**RoutingCodeField**](RoutingCodeField.md) |  | [optional] 
**order** | [**SortingOrder**](SortingOrder.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_search_sorting_inner import RoutingCodeSearchSortingInner

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodeSearchSortingInner from a JSON string
routing_code_search_sorting_inner_instance = RoutingCodeSearchSortingInner.from_json(json)
# print the JSON string representation of the object
print(RoutingCodeSearchSortingInner.to_json())

# convert the object into a dict
routing_code_search_sorting_inner_dict = routing_code_search_sorting_inner_instance.to_dict()
# create an instance of RoutingCodeSearchSortingInner from a dict
routing_code_search_sorting_inner_from_dict = RoutingCodeSearchSortingInner.from_dict(routing_code_search_sorting_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


