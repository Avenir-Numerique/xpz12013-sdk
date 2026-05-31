# FullFlowInfo

Identified Flow info: flow info + id + timestamp

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flow_id** | **str** | Unique identifier supporting UUID but not only, for flexibility purpose | 
**submitted_at** | **datetime** | The flow submission date and time (the date and time when the flow was created on the system) This property should be used by the API consumer as a time reference to avoid clock synchronization issues  | 
**tracking_id** | **str** | The tracking id is an external identifier and is used to track the flow by the sender | [optional] 
**name** | **str** | Name of the file | 
**processing_rule** | [**ProcessingRule**](ProcessingRule.md) |  | [optional] 
**flow_syntax** | [**FlowSyntax**](FlowSyntax.md) |  | 
**flow_profile** | [**FlowProfile**](FlowProfile.md) |  | [optional] 
**sha256** | **bytearray** | The sha256 is the fingerprint of the attached file: - if provided in the request: it should be checked once received - if not provided in the request: it may be computed and returned in the response  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.full_flow_info import FullFlowInfo

# TODO update the JSON string below
json = "{}"
# create an instance of FullFlowInfo from a JSON string
full_flow_info_instance = FullFlowInfo.from_json(json)
# print the JSON string representation of the object
print(FullFlowInfo.to_json())

# convert the object into a dict
full_flow_info_dict = full_flow_info_instance.to_dict()
# create an instance of FullFlowInfo from a dict
full_flow_info_from_dict = FullFlowInfo.from_dict(full_flow_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


