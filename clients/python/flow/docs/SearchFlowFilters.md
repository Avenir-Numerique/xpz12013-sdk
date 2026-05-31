# SearchFlowFilters

Filtering criteria, at least one is required

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updated_after** | **datetime** | The comparison with current date is strict : updatedAt &gt; updatedAfter | [optional] 
**updated_before** | **datetime** |  | [optional] 
**processing_rule** | [**List[ProcessingRule]**](ProcessingRule.md) |  | [optional] 
**flow_type** | [**List[FlowType]**](FlowType.md) |  | [optional] 
**flow_direction** | [**List[FlowDirection]**](FlowDirection.md) |  | [optional] 
**tracking_id** | **str** | Unique identifier supporting UUID but not only, for flexibility purpose | [optional] 
**ack_status** | [**FlowAckStatus**](FlowAckStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.search_flow_filters import SearchFlowFilters

# TODO update the JSON string below
json = "{}"
# create an instance of SearchFlowFilters from a JSON string
search_flow_filters_instance = SearchFlowFilters.from_json(json)
# print the JSON string representation of the object
print(SearchFlowFilters.to_json())

# convert the object into a dict
search_flow_filters_dict = search_flow_filters_instance.to_dict()
# create an instance of SearchFlowFilters from a dict
search_flow_filters_from_dict = SearchFlowFilters.from_dict(search_flow_filters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


