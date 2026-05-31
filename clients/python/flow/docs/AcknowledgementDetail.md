# AcknowledgementDetail


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**level** | **str** |  | 
**item** | **str** | Item on which the error refers | 
**reason_code** | [**ReasonCode**](ReasonCode.md) |  | 
**reason_message** | **str** |  | 

## Example

```python
from neotimo_xpz12013_flow.models.acknowledgement_detail import AcknowledgementDetail

# TODO update the JSON string below
json = "{}"
# create an instance of AcknowledgementDetail from a JSON string
acknowledgement_detail_instance = AcknowledgementDetail.from_json(json)
# print the JSON string representation of the object
print(AcknowledgementDetail.to_json())

# convert the object into a dict
acknowledgement_detail_dict = acknowledgement_detail_instance.to_dict()
# create an instance of AcknowledgementDetail from a dict
acknowledgement_detail_from_dict = AcknowledgementDetail.from_dict(acknowledgement_detail_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


