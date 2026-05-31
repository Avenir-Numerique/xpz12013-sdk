# SearchSiretFiltersSiret


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | **str** | SIRET number to search for. | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_siret import SearchSiretFiltersSiret

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersSiret from a JSON string
search_siret_filters_siret_instance = SearchSiretFiltersSiret.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersSiret.to_json())

# convert the object into a dict
search_siret_filters_siret_dict = search_siret_filters_siret_instance.to_dict()
# create an instance of SearchSiretFiltersSiret from a dict
search_siret_filters_siret_from_dict = SearchSiretFiltersSiret.from_dict(search_siret_filters_siret_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


