# SearchFlowContent

A set of flows matching criterias, provided into the request

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**limit** | **int** |  | [optional] 
**filters** | [**SearchFlowFilters**](SearchFlowFilters.md) |  | [optional] 
**results** | [**List[Flow]**](Flow.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.search_flow_content import SearchFlowContent

# TODO update the JSON string below
json = "{}"
# create an instance of SearchFlowContent from a JSON string
search_flow_content_instance = SearchFlowContent.from_json(json)
# print the JSON string representation of the object
print(SearchFlowContent.to_json())

# convert the object into a dict
search_flow_content_dict = search_flow_content_instance.to_dict()
# create an instance of SearchFlowContent from a dict
search_flow_content_from_dict = SearchFlowContent.from_dict(search_flow_content_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


