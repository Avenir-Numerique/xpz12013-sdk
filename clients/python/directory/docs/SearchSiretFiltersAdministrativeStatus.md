# SearchSiretFiltersAdministrativeStatus


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | [**FacilityAdministrativeStatus**](FacilityAdministrativeStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_administrative_status import SearchSiretFiltersAdministrativeStatus

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersAdministrativeStatus from a JSON string
search_siret_filters_administrative_status_instance = SearchSiretFiltersAdministrativeStatus.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersAdministrativeStatus.to_json())

# convert the object into a dict
search_siret_filters_administrative_status_dict = search_siret_filters_administrative_status_instance.to_dict()
# create an instance of SearchSiretFiltersAdministrativeStatus from a dict
search_siret_filters_administrative_status_from_dict = SearchSiretFiltersAdministrativeStatus.from_dict(search_siret_filters_administrative_status_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


