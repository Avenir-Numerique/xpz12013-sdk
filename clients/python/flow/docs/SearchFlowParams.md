# SearchFlowParams


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**limit** | **int** | Pagination, Maximum number of results that may be returned | [optional] [default to 25]
**cursor** | **str** | If cursor is provided, then start search starting from that cursor | [optional] 
**where** | [**SearchFlowFilters**](SearchFlowFilters.md) |  | 

## Example

```python
from neotimo_xpz12013_flow.models.search_flow_params import SearchFlowParams

# TODO update the JSON string below
json = "{}"
# create an instance of SearchFlowParams from a JSON string
search_flow_params_instance = SearchFlowParams.from_json(json)
# print the JSON string representation of the object
print(SearchFlowParams.to_json())

# convert the object into a dict
search_flow_params_dict = search_flow_params_instance.to_dict()
# create an instance of SearchFlowParams from a dict
search_flow_params_from_dict = SearchFlowParams.from_dict(search_flow_params_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


