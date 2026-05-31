# Error

Error code

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**error_code** | **str** | Short numerical or alphanumerical code that identifies precisely a unique error. | 
**error_message** | **str** | Contains information on the error. Not intended to be displayed to an end user. For security reasons, a tradeoff between clarity &amp; security shall be found. | [optional] 
**type** | **str** |  | [optional] [default to 'about:blank']
**details** | **str** |  | [optional] 
**instance** | **str** |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.error import Error

# TODO update the JSON string below
json = "{}"
# create an instance of Error from a JSON string
error_instance = Error.from_json(json)
# print the JSON string representation of the object
print(Error.to_json())

# convert the object into a dict
error_dict = error_instance.to_dict()
# create an instance of Error from a dict
error_from_dict = Error.from_dict(error_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


