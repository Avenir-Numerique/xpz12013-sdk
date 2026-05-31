# FacilityPayloadHistoryUleB2gAdditionalData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**pm** | **bool** | Indicates whether the public structure acts as project manager for work invoices in addition to receiving simple invoices. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 
**pm_only** | **bool** | Indicates whether the public structure only acts as a project manager; if so, it can only receive invoices for work. This attribute is only returned if the directory line is defined for a public structure at the SIREN/SIRET or SIREN/SIRET/Routing code level. | [optional] 
**manages_payment_status** | **bool** | Indicates whether the public structure manages the payment status of invoices. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 
**manages_legal_commitment_code** | **bool** | Indicates whether the public structure requires a legal commitment number. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 
**manages_legal_commitment_or_service_code** | **bool** | Indicates whether the public structure requires a service code or a commitment code in its exchanges. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 
**service_code_status** | **bool** | Indicates whether the structure requires a service code. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.facility_payload_history_ule_b2g_additional_data import FacilityPayloadHistoryUleB2gAdditionalData

# TODO update the JSON string below
json = "{}"
# create an instance of FacilityPayloadHistoryUleB2gAdditionalData from a JSON string
facility_payload_history_ule_b2g_additional_data_instance = FacilityPayloadHistoryUleB2gAdditionalData.from_json(json)
# print the JSON string representation of the object
print(FacilityPayloadHistoryUleB2gAdditionalData.to_json())

# convert the object into a dict
facility_payload_history_ule_b2g_additional_data_dict = facility_payload_history_ule_b2g_additional_data_instance.to_dict()
# create an instance of FacilityPayloadHistoryUleB2gAdditionalData from a dict
facility_payload_history_ule_b2g_additional_data_from_dict = FacilityPayloadHistoryUleB2gAdditionalData.from_dict(facility_payload_history_ule_b2g_additional_data_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


