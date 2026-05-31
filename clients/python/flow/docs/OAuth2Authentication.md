# OAuth2Authentication


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**token_url** | **str** |  | 
**client_id** | **str** |  | 
**client_secret** | **str** |  | 

## Example

```python
from neotimo_xpz12013_flow.models.o_auth2_authentication import OAuth2Authentication

# TODO update the JSON string below
json = "{}"
# create an instance of OAuth2Authentication from a JSON string
o_auth2_authentication_instance = OAuth2Authentication.from_json(json)
# print the JSON string representation of the object
print(OAuth2Authentication.to_json())

# convert the object into a dict
o_auth2_authentication_dict = o_auth2_authentication_instance.to_dict()
# create an instance of OAuth2Authentication from a dict
o_auth2_authentication_from_dict = OAuth2Authentication.from_dict(o_auth2_authentication_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


