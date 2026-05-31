# FlowInfo

Signaling of the flow

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tracking_id** | **str** | The tracking id is an external identifier and is used to track the flow by the sender | [optional] 
**name** | **str** | Name of the file | 
**processing_rule** | [**ProcessingRule**](ProcessingRule.md) |  | [optional] 
**flow_syntax** | [**FlowSyntax**](FlowSyntax.md) |  | 
**flow_profile** | [**FlowProfile**](FlowProfile.md) |  | [optional] 
**sha256** | **bytearray** | The sha256 is the fingerprint of the attached file: - if provided in the request: it should be checked once received - if not provided in the request: it may be computed and returned in the response  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.flow_info import FlowInfo

# TODO update the JSON string below
json = "{}"
# create an instance of FlowInfo from a JSON string
flow_info_instance = FlowInfo.from_json(json)
# print the JSON string representation of the object
print(FlowInfo.to_json())

# convert the object into a dict
flow_info_dict = flow_info_instance.to_dict()
# create an instance of FlowInfo from a dict
flow_info_from_dict = FlowInfo.from_dict(flow_info_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


