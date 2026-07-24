# WebhookIdParam


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**webhook_id** | **str** |  | [optional] 
**signing_key** | **bytearray** |  | [optional] 
**created_at** | **datetime** |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.webhook_id_param import WebhookIdParam

# TODO update the JSON string below
json = "{}"
# create an instance of WebhookIdParam from a JSON string
webhook_id_param_instance = WebhookIdParam.from_json(json)
# print the JSON string representation of the object
print(WebhookIdParam.to_json())

# convert the object into a dict
webhook_id_param_dict = webhook_id_param_instance.to_dict()
# create an instance of WebhookIdParam from a dict
webhook_id_param_from_dict = WebhookIdParam.from_dict(webhook_id_param_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


