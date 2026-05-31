# SearchSirenFilters


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**siren** | [**SearchSirenFiltersSiren**](SearchSirenFiltersSiren.md) |  | [optional] 
**business_name** | [**SearchSirenFiltersBusinessName**](SearchSirenFiltersBusinessName.md) |  | [optional] 
**entity_type** | [**SearchSirenFiltersEntityType**](SearchSirenFiltersEntityType.md) |  | [optional] 
**administrative_status** | [**SearchSirenFiltersAdministrativeStatus**](SearchSirenFiltersAdministrativeStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren_filters import SearchSirenFilters

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSirenFilters from a JSON string
search_siren_filters_instance = SearchSirenFilters.from_json(json)
# print the JSON string representation of the object
print(SearchSirenFilters.to_json())

# convert the object into a dict
search_siren_filters_dict = search_siren_filters_instance.to_dict()
# create an instance of SearchSirenFilters from a dict
search_siren_filters_from_dict = SearchSirenFilters.from_dict(search_siren_filters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


