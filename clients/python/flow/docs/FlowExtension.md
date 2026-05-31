# FlowExtension

Extension schema to build Flow schema

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**updated_at** | **datetime** | The last update date and time of the flow. When the flow is submitted updatedAt is equal to submittedAt. When the flow acknowledgment status is changed updatedAt date and time is updated.  | 
**flow_type** | [**FlowType**](FlowType.md) |  | 
**processing_rule_source** | **str** | Says whether the processing rule has been computed or the processing rule was an input parameter | 
**flow_direction** | [**FlowDirection**](FlowDirection.md) |  | 
**acknowledgement** | [**Acknowledgement**](Acknowledgement.md) |  | 

## Example

```python
from neotimo_xpz12013_flow.models.flow_extension import FlowExtension

# TODO update the JSON string below
json = "{}"
# create an instance of FlowExtension from a JSON string
flow_extension_instance = FlowExtension.from_json(json)
# print the JSON string representation of the object
print(FlowExtension.to_json())

# convert the object into a dict
flow_extension_dict = flow_extension_instance.to_dict()
# create an instance of FlowExtension from a dict
flow_extension_from_dict = FlowExtension.from_dict(flow_extension_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


