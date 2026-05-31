# FullFlowInfoExtension

Extension schema to build FFullFlowInfo, Flow schemas

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flow_id** | **str** | Unique identifier supporting UUID but not only, for flexibility purpose | 
**submitted_at** | **datetime** | The flow submission date and time (the date and time when the flow was created on the system) This property should be used by the API consumer as a time reference to avoid clock synchronization issues  | 

## Example

```python
from neotimo_xpz12013_flow.models.full_flow_info_extension import FullFlowInfoExtension

# TODO update the JSON string below
json = "{}"
# create an instance of FullFlowInfoExtension from a JSON string
full_flow_info_extension_instance = FullFlowInfoExtension.from_json(json)
# print the JSON string representation of the object
print(FullFlowInfoExtension.to_json())

# convert the object into a dict
full_flow_info_extension_dict = full_flow_info_extension_instance.to_dict()
# create an instance of FullFlowInfoExtension from a dict
full_flow_info_extension_from_dict = FullFlowInfoExtension.from_dict(full_flow_info_extension_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


