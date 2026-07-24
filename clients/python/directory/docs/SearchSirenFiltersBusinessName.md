# SearchSirenFiltersBusinessName


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOrStartWithOperator**](ContainsOrStrictOrStartWithOperator.md) |  | [optional] 
**value** | **str** | Business name | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren_filters_business_name import SearchSirenFiltersBusinessName

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSirenFiltersBusinessName from a JSON string
search_siren_filters_business_name_instance = SearchSirenFiltersBusinessName.from_json(json)
# print the JSON string representation of the object
print(SearchSirenFiltersBusinessName.to_json())

# convert the object into a dict
search_siren_filters_business_name_dict = search_siren_filters_business_name_instance.to_dict()
# create an instance of SearchSirenFiltersBusinessName from a dict
search_siren_filters_business_name_from_dict = SearchSirenFiltersBusinessName.from_dict(search_siren_filters_business_name_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


