# CallbackParameters


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**url** | **str** |  | 
**headers** | [**List[CallbackHeader]**](CallbackHeader.md) |  | [optional] 
**authentication** | [**CallbackAuthentication**](CallbackAuthentication.md) |  | [optional] 
**signature** | [**CallbackSignature**](CallbackSignature.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.callback_parameters import CallbackParameters

# TODO update the JSON string below
json = "{}"
# create an instance of CallbackParameters from a JSON string
callback_parameters_instance = CallbackParameters.from_json(json)
# print the JSON string representation of the object
print(CallbackParameters.to_json())

# convert the object into a dict
callback_parameters_dict = callback_parameters_instance.to_dict()
# create an instance of CallbackParameters from a dict
callback_parameters_from_dict = CallbackParameters.from_dict(callback_parameters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


