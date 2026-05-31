# SearchDirectoryLineFiltersAddressingIdentifier


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**ContainsOrStrictOperator**](ContainsOrStrictOperator.md) |  | [optional] 
**value** | **str** | Addressing identifier of the directory line. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_directory_line_filters_addressing_identifier import SearchDirectoryLineFiltersAddressingIdentifier

# TODO update the JSON string below
json = "{}"
# create an instance of SearchDirectoryLineFiltersAddressingIdentifier from a JSON string
search_directory_line_filters_addressing_identifier_instance = SearchDirectoryLineFiltersAddressingIdentifier.from_json(json)
# print the JSON string representation of the object
print(SearchDirectoryLineFiltersAddressingIdentifier.to_json())

# convert the object into a dict
search_directory_line_filters_addressing_identifier_dict = search_directory_line_filters_addressing_identifier_instance.to_dict()
# create an instance of SearchDirectoryLineFiltersAddressingIdentifier from a dict
search_directory_line_filters_addressing_identifier_from_dict = SearchDirectoryLineFiltersAddressingIdentifier.from_dict(search_directory_line_filters_addressing_identifier_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


