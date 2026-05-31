# CallbackAuthentication

The authentication mode required for the callback call

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**auth_type** | **str** |  | 
**user_id** | **str** |  | 
**user_password** | **str** |  | 
**token_url** | **str** |  | 
**client_id** | **str** |  | 
**client_secret** | **str** |  | 

## Example

```python
from neotimo_xpz12013_flow.models.callback_authentication import CallbackAuthentication

# TODO update the JSON string below
json = "{}"
# create an instance of CallbackAuthentication from a JSON string
callback_authentication_instance = CallbackAuthentication.from_json(json)
# print the JSON string representation of the object
print(CallbackAuthentication.to_json())

# convert the object into a dict
callback_authentication_dict = callback_authentication_instance.to_dict()
# create an instance of CallbackAuthentication from a dict
callback_authentication_from_dict = CallbackAuthentication.from_dict(callback_authentication_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


