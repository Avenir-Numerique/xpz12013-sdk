# WebhookMetadata


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**processing_rule** | [**ProcessingRule**](ProcessingRule.md) |  | [optional] 
**flow_type** | [**FlowType**](FlowType.md) |  | 
**flow_direction** | [**FlowDirection**](FlowDirection.md) |  | 
**ack_status** | [**FlowAckStatus**](FlowAckStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_flow.models.webhook_metadata import WebhookMetadata

# TODO update the JSON string below
json = "{}"
# create an instance of WebhookMetadata from a JSON string
webhook_metadata_instance = WebhookMetadata.from_json(json)
# print the JSON string representation of the object
print(WebhookMetadata.to_json())

# convert the object into a dict
webhook_metadata_dict = webhook_metadata_instance.to_dict()
# create an instance of WebhookMetadata from a dict
webhook_metadata_from_dict = WebhookMetadata.from_dict(webhook_metadata_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


