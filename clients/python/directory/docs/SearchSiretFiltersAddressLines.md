# SearchSiretFiltersAddressLines


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStartWithOperator**](ContainsOrStartWithOperator.md) |  | [optional] 
**value** | **str** | address lines of the recipient structure having defined the directory line(s). | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_address_lines import SearchSiretFiltersAddressLines

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersAddressLines from a JSON string
search_siret_filters_address_lines_instance = SearchSiretFiltersAddressLines.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersAddressLines.to_json())

# convert the object into a dict
search_siret_filters_address_lines_dict = search_siret_filters_address_lines_instance.to_dict()
# create an instance of SearchSiretFiltersAddressLines from a dict
search_siret_filters_address_lines_from_dict = SearchSiretFiltersAddressLines.from_dict(search_siret_filters_address_lines_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


