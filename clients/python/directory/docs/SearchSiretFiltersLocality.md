# SearchSiretFiltersLocality


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOrStartWithOperator**](ContainsOrStrictOrStartWithOperator.md) |  | [optional] 
**value** | **str** | Municipality of the recipient structure having defined the directory line(s). | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_locality import SearchSiretFiltersLocality

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersLocality from a JSON string
search_siret_filters_locality_instance = SearchSiretFiltersLocality.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersLocality.to_json())

# convert the object into a dict
search_siret_filters_locality_dict = search_siret_filters_locality_instance.to_dict()
# create an instance of SearchSiretFiltersLocality from a dict
search_siret_filters_locality_from_dict = SearchSiretFiltersLocality.from_dict(search_siret_filters_locality_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


