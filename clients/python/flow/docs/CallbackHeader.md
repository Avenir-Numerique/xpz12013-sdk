# CallbackHeader


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**header_name** | **str** |  | 
**header_value** | **str** |  | 

## Example

```python
from neotimo_xpz12013_flow.models.callback_header import CallbackHeader

# TODO update the JSON string below
json = "{}"
# create an instance of CallbackHeader from a JSON string
callback_header_instance = CallbackHeader.from_json(json)
# print the JSON string representation of the object
print(CallbackHeader.to_json())

# convert the object into a dict
callback_header_dict = callback_header_instance.to_dict()
# create an instance of CallbackHeader from a dict
callback_header_from_dict = CallbackHeader.from_dict(callback_header_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


