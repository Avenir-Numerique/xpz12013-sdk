# SearchDirectoryLineFiltersAddressingSuffix


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOperator**](ContainsOrStrictOperator.md) |  | [optional] 
**value** | **str** | suffix of the directory line which defines an address mesh not attached to a facility | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_directory_line_filters_addressing_suffix import SearchDirectoryLineFiltersAddressingSuffix

# TODO update the JSON string below
json = "{}"
# create an instance of SearchDirectoryLineFiltersAddressingSuffix from a JSON string
search_directory_line_filters_addressing_suffix_instance = SearchDirectoryLineFiltersAddressingSuffix.from_json(json)
# print the JSON string representation of the object
print(SearchDirectoryLineFiltersAddressingSuffix.to_json())

# convert the object into a dict
search_directory_line_filters_addressing_suffix_dict = search_directory_line_filters_addressing_suffix_instance.to_dict()
# create an instance of SearchDirectoryLineFiltersAddressingSuffix from a dict
search_directory_line_filters_addressing_suffix_from_dict = SearchDirectoryLineFiltersAddressingSuffix.from_dict(search_directory_line_filters_addressing_suffix_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


