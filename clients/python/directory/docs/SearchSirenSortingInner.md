# SearchSirenSortingInner

A sorting criteria composed of a field and an order (ascending or descending).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_field** | [**SirenField**](SirenField.md) |  | [optional] 
**order** | [**SortingOrder**](SortingOrder.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren_sorting_inner import SearchSirenSortingInner

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSirenSortingInner from a JSON string
search_siren_sorting_inner_instance = SearchSirenSortingInner.from_json(json)
# print the JSON string representation of the object
print(SearchSirenSortingInner.to_json())

# convert the object into a dict
search_siren_sorting_inner_dict = search_siren_sorting_inner_instance.to_dict()
# create an instance of SearchSirenSortingInner from a dict
search_siren_sorting_inner_from_dict = SearchSirenSortingInner.from_dict(search_siren_sorting_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


