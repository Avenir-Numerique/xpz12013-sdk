# SearchSiretFilters


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**siret** | [**SearchSiretFiltersSiret**](SearchSiretFiltersSiret.md) |  | [optional] 
**siren** | [**SearchSirenFiltersSiren**](SearchSirenFiltersSiren.md) |  | [optional] 
**facility_type** | [**SearchSiretFiltersFacilityType**](SearchSiretFiltersFacilityType.md) |  | [optional] 
**name** | [**SearchSiretFiltersName**](SearchSiretFiltersName.md) |  | [optional] 
**address_lines** | [**SearchSiretFiltersAddressLines**](SearchSiretFiltersAddressLines.md) |  | [optional] 
**postal_code** | [**SearchSiretFiltersPostalCode**](SearchSiretFiltersPostalCode.md) |  | [optional] 
**country_subdivision** | [**SearchSiretFiltersCountrySubdivision**](SearchSiretFiltersCountrySubdivision.md) |  | [optional] 
**locality** | [**SearchSiretFiltersLocality**](SearchSiretFiltersLocality.md) |  | [optional] 
**administrative_status** | [**SearchSiretFiltersAdministrativeStatus**](SearchSiretFiltersAdministrativeStatus.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.search_siret_filters import SearchSiretFilters

# TODO update the JSON string below
json = "{}"
# create an instance of SearchSiretFilters from a JSON string
search_siret_filters_instance = SearchSiretFilters.from_json(json)
# print the JSON string representation of the object
print(SearchSiretFilters.to_json())

# convert the object into a dict
search_siret_filters_dict = search_siret_filters_instance.to_dict()
# create an instance of SearchSiretFilters from a dict
search_siret_filters_from_dict = SearchSiretFilters.from_dict(search_siret_filters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


