# SearchSirenFiltersAdministrativeStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | [**LegalUnitAdministrativeStatus**](LegalUnitAdministrativeStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren_filters_administrative_status import SearchSirenFiltersAdministrativeStatus

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSirenFiltersAdministrativeStatus from a JSON string
search_siren_filters_administrative_status_instance = SearchSirenFiltersAdministrativeStatus.from_json(json)
# print the JSON string representation of the object
print(SearchSirenFiltersAdministrativeStatus.to_json())

# convert the object into a dict
search_siren_filters_administrative_status_dict = search_siren_filters_administrative_status_instance.to_dict()
# create an instance of SearchSirenFiltersAdministrativeStatus from a dict
search_siren_filters_administrative_status_from_dict = SearchSirenFiltersAdministrativeStatus.from_dict(search_siren_filters_administrative_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


