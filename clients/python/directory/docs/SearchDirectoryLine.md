# SearchDirectoryLine


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filters** | [**SearchDirectoryLineFilters**](SearchDirectoryLineFilters.md) |  | [optional] 
**sorting** | [**List[SearchDirectoryLineSortingInner]**](SearchDirectoryLineSortingInner.md) | Sorting criteria on a field and an order (ascending or descending). | [optional] 
**fields** | [**List[DirectoryLineField]**](DirectoryLineField.md) | Allows you to filter the desired fields in the response. | [optional] 
**limit** | **int** | Maximum number of results | [optional] 
**ignore** | **int** | Number of results to skip | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_directory_line import SearchDirectoryLine

# TODO update the JSON string below
json = "{}"
# create an instance of SearchDirectoryLine from a JSON string
search_directory_line_instance = SearchDirectoryLine.from_json(json)
# print the JSON string representation of the object
print(SearchDirectoryLine.to_json())

# convert the object into a dict
search_directory_line_dict = search_directory_line_instance.to_dict()
# create an instance of SearchDirectoryLine from a dict
search_directory_line_from_dict = SearchDirectoryLine.from_dict(search_directory_line_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


