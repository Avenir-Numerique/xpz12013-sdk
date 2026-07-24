# neotimo_xpz12013_directory.SirenApi

All URIs are relative to *https://api.directory.company.com/directory-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_company_by_siren**](SirenApi.md#get_company_by_siren) | **GET** /v1/siren/code-insee:{siren} | Consult a siren (legal unit) by SIREN number
[**search_company_by_siren**](SirenApi.md#search_company_by_siren) | **POST** /v1/siren/search | SIREN search (or legal unit)


# **get_company_by_siren**
> LegalUnitPayloadHistory get_company_by_siren(siren, fields=fields)

Consult a siren (legal unit) by SIREN number

Returns the details of a company (legal unit) identified by the SIREN number passed as a parameter.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.legal_unit_payload_history import LegalUnitPayloadHistory
from neotimo_xpz12013_directory.models.siren_field import SirenField
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
    api_instance = neotimo_xpz12013_directory.SirenApi(api_client)
    siren = '702042755' # str | Corresponds to the SIREN number of a legal unit.
    fields = [neotimo_xpz12013_directory.SirenField()] # List[SirenField] | Fields of the SIREN resource. (optional)

    try:
        # Consult a siren (legal unit) by SIREN number
        api_response = api_instance.get_company_by_siren(siren, fields=fields)
        print("The response of SirenApi->get_company_by_siren:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SirenApi->get_company_by_siren: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siren** | **str**| Corresponds to the SIREN number of a legal unit. | 
 **fields** | [**List[SirenField]**](SirenField.md)| Fields of the SIREN resource. | [optional] 

### Return type

[**LegalUnitPayloadHistory**](LegalUnitPayloadHistory.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a company. |  -  |
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

# **search_company_by_siren**
> SirenSearchPost200Response search_company_by_siren(search_siren=search_siren)

SIREN search (or legal unit)

Multi-criteria company search.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.search_siren import SearchSiren
from neotimo_xpz12013_directory.models.siren_search_post200_response import SirenSearchPost200Response
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
    api_instance = neotimo_xpz12013_directory.SirenApi(api_client)
    search_siren = neotimo_xpz12013_directory.SearchSiren() # SearchSiren |  (optional)

    try:
        # SIREN search (or legal unit)
        api_response = api_instance.search_company_by_siren(search_siren=search_siren)
        print("The response of SirenApi->search_company_by_siren:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SirenApi->search_company_by_siren: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search_siren** | [**SearchSiren**](SearchSiren.md)|  | [optional] 

### Return type

[**SirenSearchPost200Response**](SirenSearchPost200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns one or more companies. |  -  |
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

