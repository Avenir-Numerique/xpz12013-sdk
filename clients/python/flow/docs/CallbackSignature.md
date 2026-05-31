# CallbackSignature


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**algo** | [**Algorithm**](Algorithm.md) |  | 
**key** | **bytearray** | Base 64 encoded string | 

## Example

```python
from neotimo_xpz12013_flow.models.callback_signature import CallbackSignature

# TODO update the JSON string below
json = "{}"
# create an instance of CallbackSignature from a JSON string
callback_signature_instance = CallbackSignature.from_json(json)
# print the JSON string representation of the object
print(CallbackSignature.to_json())

# convert the object into a dict
callback_signature_dict = callback_signature_instance.to_dict()
# create an instance of CallbackSignature from a dict
callback_signature_from_dict = CallbackSignature.from_dict(callback_signature_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


