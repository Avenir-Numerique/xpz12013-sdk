# SearchSiretSortingInner

A sorting criteria composed of a field and an order (ascending or descending).

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**var_field** | [**SiretField**](SiretField.md) |  | [optional] 
**order** | [**SortingOrder**](SortingOrder.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_sorting_inner import SearchSiretSortingInner

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretSortingInner from a JSON string
search_siret_sorting_inner_instance = SearchSiretSortingInner.from_json(json)
# print the JSON string representation of the object
print(SearchSiretSortingInner.to_json())

# convert the object into a dict
search_siret_sorting_inner_dict = search_siret_sorting_inner_instance.to_dict()
# create an instance of SearchSiretSortingInner from a dict
search_siret_sorting_inner_from_dict = SearchSiretSortingInner.from_dict(search_siret_sorting_inner_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


