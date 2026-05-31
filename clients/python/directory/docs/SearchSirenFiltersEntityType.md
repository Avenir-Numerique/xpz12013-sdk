# SearchSirenFiltersEntityType


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | [**EntityType**](EntityType.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren_filters_entity_type import SearchSirenFiltersEntityType

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSirenFiltersEntityType from a JSON string
search_siren_filters_entity_type_instance = SearchSirenFiltersEntityType.from_json(json)
# print the JSON string representation of the object
print(SearchSirenFiltersEntityType.to_json())

# convert the object into a dict
search_siren_filters_entity_type_dict = search_siren_filters_entity_type_instance.to_dict()
# create an instance of SearchSirenFiltersEntityType from a dict
search_siren_filters_entity_type_from_dict = SearchSirenFiltersEntityType.from_dict(search_siren_filters_entity_type_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


