# RoutingCodeSearchFilters


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**routing_identifier** | [**RoutingCodeSearchFiltersRoutingIdentifier**](RoutingCodeSearchFiltersRoutingIdentifier.md) |  | [optional] 
**siret** | [**SearchSiretFiltersSiret**](SearchSiretFiltersSiret.md) |  | [optional] 
**routing_code_name** | [**RoutingCodeSearchFiltersRoutingCodeName**](RoutingCodeSearchFiltersRoutingCodeName.md) |  | [optional] 
**administrative_status** | [**RoutingCodeSearchFiltersAdministrativeStatus**](RoutingCodeSearchFiltersAdministrativeStatus.md) |  | [optional] 
**address_lines** | [**SearchSiretFiltersAddressLines**](SearchSiretFiltersAddressLines.md) |  | [optional] 
**postal_code** | [**SearchSiretFiltersPostalCode**](SearchSiretFiltersPostalCode.md) |  | [optional] 
**locality** | [**SearchSiretFiltersLocality**](SearchSiretFiltersLocality.md) |  | [optional] 

## Example

```python
from neotimo_xpz12013_directory.models.routing_code_search_filters import RoutingCodeSearchFilters

# TODO update the JSON string below
json = "{}"
# create an instance of RoutingCodeSearchFilters from a JSON string
routing_code_search_filters_instance = RoutingCodeSearchFilters.from_json(json)
# print the JSON string representation of the object
print(RoutingCodeSearchFilters.to_json())

# convert the object into a dict
routing_code_search_filters_dict = routing_code_search_filters_instance.to_dict()
# create an instance of RoutingCodeSearchFilters from a dict
routing_code_search_filters_from_dict = RoutingCodeSearchFilters.from_dict(routing_code_search_filters_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


