# SearchSirenFiltersSiren


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | **str** | SIREN number to search for. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren_filters_siren import SearchSirenFiltersSiren

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSirenFiltersSiren from a JSON string
search_siren_filters_siren_instance = SearchSirenFiltersSiren.from_json(json)
# print the JSON string representation of the object
print(SearchSirenFiltersSiren.to_json())

# convert the object into a dict
search_siren_filters_siren_dict = search_siren_filters_siren_instance.to_dict()
# create an instance of SearchSirenFiltersSiren from a dict
search_siren_filters_siren_from_dict = SearchSirenFiltersSiren.from_dict(search_siren_filters_siren_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


