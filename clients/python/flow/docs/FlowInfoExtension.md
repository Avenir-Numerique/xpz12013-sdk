# FlowInfoExtension

Extension to build the FlowInfo

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sha256** | **bytearray** | The sha256 is the fingerprint of the attached file: - if provided in the request: it should be checked once received - if not provided in the request: it may be computed and returned in the response  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.flow_info_extension import FlowInfoExtension

# TODO update the JSON string below
json = "{}"
# create an instance of FlowInfoExtension from a JSON string
flow_info_extension_instance = FlowInfoExtension.from_json(json)
# print the JSON string representation of the object
print(FlowInfoExtension.to_json())

# convert the object into a dict
flow_info_extension_dict = flow_info_extension_instance.to_dict()
# create an instance of FlowInfoExtension from a dict
flow_info_extension_from_dict = FlowInfoExtension.from_dict(flow_info_extension_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


