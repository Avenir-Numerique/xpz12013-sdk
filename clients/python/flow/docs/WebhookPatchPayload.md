# WebhookPatchPayload


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**headers** | [**List[CallbackHeader]**](CallbackHeader.md) |  | [optional] 
**authentication** | [**CallbackAuthentication**](CallbackAuthentication.md) |  | [optional] 
**signature** | [**CallbackSignature**](CallbackSignature.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.webhook_patch_payload import WebhookPatchPayload

# TODO update the JSON string below
json = "{}"
# create an instance of WebhookPatchPayload from a JSON string
webhook_patch_payload_instance = WebhookPatchPayload.from_json(json)
# print the JSON string representation of the object
print(WebhookPatchPayload.to_json())

# convert the object into a dict
webhook_patch_payload_dict = webhook_patch_payload_instance.to_dict()
# create an instance of WebhookPatchPayload from a dict
webhook_patch_payload_from_dict = WebhookPatchPayload.from_dict(webhook_patch_payload_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


