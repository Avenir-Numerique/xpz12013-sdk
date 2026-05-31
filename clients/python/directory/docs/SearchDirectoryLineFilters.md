# SearchDirectoryLineFilters


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressing_identifier** | [**SearchDirectoryLineFiltersAddressingIdentifier**](SearchDirectoryLineFiltersAddressingIdentifier.md) |  | [optional] 
**siren** | [**SearchSirenFiltersSiren**](SearchSirenFiltersSiren.md) |  | [optional] 
**siret** | [**SearchSiretFiltersSiret**](SearchSiretFiltersSiret.md) |  | [optional] 
**routing_identifier** | [**RoutingCodeSearchFiltersRoutingIdentifier**](RoutingCodeSearchFiltersRoutingIdentifier.md) |  | [optional] 
**addressing_suffix** | [**SearchDirectoryLineFiltersAddressingSuffix**](SearchDirectoryLineFiltersAddressingSuffix.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_directory_line_filters import SearchDirectoryLineFilters

# TODO update the JSON string below
json = "{}"
# create an instance of SearchDirectoryLineFilters from a JSON string
search_directory_line_filters_instance = SearchDirectoryLineFilters.from_json(json)
# print the JSON string representation of the object
print(SearchDirectoryLineFilters.to_json())

# convert the object into a dict
search_directory_line_filters_dict = search_directory_line_filters_instance.to_dict()
# create an instance of SearchDirectoryLineFilters from a dict
search_directory_line_filters_from_dict = SearchDirectoryLineFilters.from_dict(search_directory_line_filters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


