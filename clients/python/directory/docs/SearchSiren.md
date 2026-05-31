# SearchSiren


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**SearchSirenFilters**](SearchSirenFilters.md) |  | [optional] 
**sorting** | [**List[SearchSirenSortingInner]**](SearchSirenSortingInner.md) | Sorting criteria on a field and an order (ascending or descending). | [optional] 
**fields** | [**List[SirenField]**](SirenField.md) | Allows you to filter the desired fields in the response. | [optional] 
**limit** | **int** | Maximum number of results | [optional] 
**ignore** | **int** | Number of results to skip | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siren import SearchSiren

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiren from a JSON string
search_siren_instance = SearchSiren.from_json(json)
# print the JSON string representation of the object
print(SearchSiren.to_json())

# convert the object into a dict
search_siren_dict = search_siren_instance.to_dict()
# create an instance of SearchSiren from a dict
search_siren_from_dict = SearchSiren.from_dict(search_siren_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


