# RoutingCodeSearchFiltersRoutingIdentifier


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOperator**](ContainsOrStrictOperator.md) |  | [optional] 
**value** | **str** | Routing identifier for a routing code. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_search_filters_routing_identifier import RoutingCodeSearchFiltersRoutingIdentifier

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodeSearchFiltersRoutingIdentifier from a JSON string
routing_code_search_filters_routing_identifier_instance = RoutingCodeSearchFiltersRoutingIdentifier.from_json(json)
# print the JSON string representation of the object
print(RoutingCodeSearchFiltersRoutingIdentifier.to_json())

# convert the object into a dict
routing_code_search_filters_routing_identifier_dict = routing_code_search_filters_routing_identifier_instance.to_dict()
# create an instance of RoutingCodeSearchFiltersRoutingIdentifier from a dict
routing_code_search_filters_routing_identifier_from_dict = RoutingCodeSearchFiltersRoutingIdentifier.from_dict(routing_code_search_filters_routing_identifier_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


