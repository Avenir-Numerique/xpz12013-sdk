# SearchSiretFiltersFacilityType


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**StrictOperator**](StrictOperator.md) |  | [optional] 
**value** | [**FacilityType**](FacilityType.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters_facility_type import SearchSiretFiltersFacilityType

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFiltersFacilityType from a JSON string
search_siret_filters_facility_type_instance = SearchSiretFiltersFacilityType.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFiltersFacilityType.to_json())

# convert the object into a dict
search_siret_filters_facility_type_dict = search_siret_filters_facility_type_instance.to_dict()
# create an instance of SearchSiretFiltersFacilityType from a dict
search_siret_filters_facility_type_from_dict = SearchSiretFiltersFacilityType.from_dict(search_siret_filters_facility_type_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


