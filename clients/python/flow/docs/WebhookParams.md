# WebhookParams


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**callback** | [**CallbackParameters**](CallbackParameters.md) |  | 
**metadata** | [**WebhookMetadata**](WebhookMetadata.md) |  | 

## Example

```python
from neotimo_xpz12013_flow.models.webhook_params import WebhookParams

# TODO update the JSON string below
json = "{}"
# create an instance of WebhookParams from a JSON string
webhook_params_instance = WebhookParams.from_json(json)
# print the JSON string representation of the object
print(WebhookParams.to_json())

# convert the object into a dict
webhook_params_dict = webhook_params_instance.to_dict()
# create an instance of WebhookParams from a dict
webhook_params_from_dict = WebhookParams.from_dict(webhook_params_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


