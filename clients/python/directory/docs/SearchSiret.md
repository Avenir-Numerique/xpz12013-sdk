# SearchSiret


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**SearchSiretFilters**](SearchSiretFilters.md) |  | [optional] 
**sorting** | [**List[SearchSiretSortingInner]**](SearchSiretSortingInner.md) | Sorting criteria on a field and an order (ascending or descending). | [optional] 
**fields** | [**List[SiretField]**](SiretField.md) | Allows you to filter the desired fields in the response. | [optional] 
**include** | **List[str]** |  | [optional] 
**limit** | **int** | Maximum number of results | [optional] 
**ignore** | **int** | Number of results to skip | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret import SearchSiret

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiret from a JSON string
search_siret_instance = SearchSiret.from_json(json)
# print the JSON string representation of the object
print(SearchSiret.to_json())

# convert the object into a dict
search_siret_dict = search_siret_instance.to_dict()
# create an instance of SearchSiret from a dict
search_siret_from_dict = SearchSiret.from_dict(search_siret_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


