# neotimo_xpz12013_directory.SiretApi

All URIs are relative to *https://api.directory.company.com/directory-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_facility_by_siret**](SiretApi.md#get_facility_by_siret) | **GET** /v1/siret/code-insee:{siret} | Gets a siret (facility) by SIRET number
[**search_facility_by_siret**](SiretApi.md#search_facility_by_siret) | **POST** /v1/siret/search | Search for a SIRET (facility)


# **get_facility_by_siret**
> FacilityPayloadHistory get_facility_by_siret(siret, fields=fields, include=include)

Gets a siret (facility) by SIRET number

Returns the details of a facility associated to a SIRET.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.facility_payload_history import FacilityPayloadHistory
from neotimo_xpz12013_directory.models.siret_field import SiretField
from neotimo_xpz12013_directory.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.directory.company.com/directory-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_directory.Configuration(
    host = "https://api.directory.company.com/directory-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): bearerAuth
configuration = neotimo_xpz12013_directory.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_directory.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_directory.SiretApi(api_client)
    siret = '70204275500240' # str | SIRET number of a facility.
    fields = [neotimo_xpz12013_directory.SiretField()] # List[SiretField] | Fields of the SIRET resource. (optional)
    include = ['[\"siren\"]'] # List[str] | Relations to include in the response. (optional)

    try:
        # Gets a siret (facility) by SIRET number
        api_response = api_instance.get_facility_by_siret(siret, fields=fields, include=include)
        print("The response of SiretApi->get_facility_by_siret:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SiretApi->get_facility_by_siret: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siret** | **str**| SIRET number of a facility. | 
 **fields** | [**List[SiretField]**](SiretField.md)| Fields of the SIRET resource. | [optional] 
 **include** | [**List[str]**](str.md)| Relations to include in the response. | [optional] 

### Return type

[**FacilityPayloadHistory**](FacilityPayloadHistory.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a facility. |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**404** | Error 404 : Resource Not Found. |  -  |
**408** | Error 408 : Request Timeout Exceeded. |  -  |
**422** | Error 422 : Unprocessable entity. |  -  |
**429** | Error 429 : Too many requests. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**501** | Error 501 : Not Implemented. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |
**0** | An error has occurred - See the status code and json response for more information. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_facility_by_siret**
> SiretSearchPost200Response search_facility_by_siret(search_siret=search_siret)

Search for a SIRET (facility)

Multi-criteria search for facilities.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.search_siret import SearchSiret
from neotimo_xpz12013_directory.models.siret_search_post200_response import SiretSearchPost200Response
from neotimo_xpz12013_directory.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.directory.company.com/directory-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_directory.Configuration(
    host = "https://api.directory.company.com/directory-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): bearerAuth
configuration = neotimo_xpz12013_directory.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_directory.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_directory.SiretApi(api_client)
    search_siret = neotimo_xpz12013_directory.SearchSiret() # SearchSiret |  (optional)

    try:
        # Search for a SIRET (facility)
        api_response = api_instance.search_facility_by_siret(search_siret=search_siret)
        print("The response of SiretApi->search_facility_by_siret:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SiretApi->search_facility_by_siret: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search_siret** | [**SearchSiret**](SearchSiret.md)|  | [optional] 

### Return type

[**SiretSearchPost200Response**](SiretSearchPost200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns an establishment as defined on a given observation date or as defined on the current date if the observation date is not specified. |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**404** | Error 404 : Resource Not Found. |  -  |
**408** | Error 408 : Request Timeout Exceeded. |  -  |
**422** | Error 422 : Unprocessable entity. |  -  |
**429** | Error 429 : Too many requests. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**501** | Error 501 : Not Implemented. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |
**0** | An error has occurred - See the status code and json response for more information. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

