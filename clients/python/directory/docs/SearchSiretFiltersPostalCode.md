# SearchSiretFiltersPostalCode


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOrStartWithOperator**](StrictOrStartWithOperator.md) |  | [optional] 
**value** | **str** | Service postal code | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_postal_code import SearchSiretFiltersPostalCode

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersPostalCode from a JSON string
search_siret_filters_postal_code_instance = SearchSiretFiltersPostalCode.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersPostalCode.to_json())

# convert the object into a dict
search_siret_filters_postal_code_dict = search_siret_filters_postal_code_instance.to_dict()
# create an instance of SearchSiretFiltersPostalCode from a dict
search_siret_filters_postal_code_from_dict = SearchSiretFiltersPostalCode.from_dict(search_siret_filters_postal_code_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


