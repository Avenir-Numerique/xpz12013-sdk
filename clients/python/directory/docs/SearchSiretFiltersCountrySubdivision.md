# SearchSiretFiltersCountrySubdivision


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | **str** | Subdivision of the country | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_country_subdivision import SearchSiretFiltersCountrySubdivision

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersCountrySubdivision from a JSON string
search_siret_filters_country_subdivision_instance = SearchSiretFiltersCountrySubdivision.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersCountrySubdivision.to_json())

# convert the object into a dict
search_siret_filters_country_subdivision_dict = search_siret_filters_country_subdivision_instance.to_dict()
# create an instance of SearchSiretFiltersCountrySubdivision from a dict
search_siret_filters_country_subdivision_from_dict = SearchSiretFiltersCountrySubdivision.from_dict(search_siret_filters_country_subdivision_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


