# CoreFlowInfo

Core schema to build FlowInfo, FullFlowInfo, Flow schemas

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tracking_id** | **str** | The tracking id is an external identifier and is used to track the flow by the sender | [optional] 
**name** | **str** | Name of the file | 
**processing_rule** | [**ProcessingRule**](ProcessingRule.md) |  | [optional] 
**flow_syntax** | [**FlowSyntax**](FlowSyntax.md) |  | 
**flow_profile** | [**FlowProfile**](FlowProfile.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.core_flow_info import CoreFlowInfo

# TODO update the JSON string below
json = "{}"
# create an instance of CoreFlowInfo from a JSON string
core_flow_info_instance = CoreFlowInfo.from_json(json)
# print the JSON string representation of the object
print(CoreFlowInfo.to_json())

# convert the object into a dict
core_flow_info_dict = core_flow_info_instance.to_dict()
# create an instance of CoreFlowInfo from a dict
core_flow_info_from_dict = CoreFlowInfo.from_dict(core_flow_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


