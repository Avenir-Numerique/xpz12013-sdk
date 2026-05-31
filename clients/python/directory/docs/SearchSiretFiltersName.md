# SearchSiretFiltersName


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOperator**](ContainsOrStrictOperator.md) |  | [optional] 
**value** | **str** | business name | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_name import SearchSiretFiltersName

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersName from a JSON string
search_siret_filters_name_instance = SearchSiretFiltersName.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersName.to_json())

# convert the object into a dict
search_siret_filters_name_dict = search_siret_filters_name_instance.to_dict()
# create an instance of SearchSiretFiltersName from a dict
search_siret_filters_name_from_dict = SearchSiretFiltersName.from_dict(search_siret_filters_name_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


