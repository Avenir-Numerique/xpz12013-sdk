# neotimo_xpz12013_directory.RoutingCodeApi

All URIs are relative to *https://api.directory.company.com/directory-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_routing_code_by_siret_and_id**](RoutingCodeApi.md#get_routing_code_by_siret_and_id) | **GET** /v1/routing-code/siret:{siret}/code:{routing-identifier} | Get a routing code by SIRET and routing identifier
[**search_routing_code**](RoutingCodeApi.md#search_routing_code) | **POST** /v1/routing-code/search | Search for a routing code


# **get_routing_code_by_siret_and_id**
> RoutingCodePayloadHistoryLegalUnitFacility get_routing_code_by_siret_and_id(siret, routing_identifier, include=include, fields=fields)

Get a routing code by SIRET and routing identifier

Retrieve the Routing Code data corresponding to the identifier passed in parameters.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.routing_code_field import RoutingCodeField
from neotimo_xpz12013_directory.models.routing_code_payload_history_legal_unit_facility import RoutingCodePayloadHistoryLegalUnitFacility
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
    api_instance = neotimo_xpz12013_directory.RoutingCodeApi(api_client)
    siret = '70204275500240' # str | SIRET number of a facility.
    routing_identifier = '702042755' # str | Routing Identifier of a routing code
    include = ['[\"siren\",\"siret\"]'] # List[str] | Relations to include in the response. (optional)
    fields = [neotimo_xpz12013_directory.RoutingCodeField()] # List[RoutingCodeField] | Fields of the Routing Code resource (optional)

    try:
        # Get a routing code by SIRET and routing identifier
        api_response = api_instance.get_routing_code_by_siret_and_id(siret, routing_identifier, include=include, fields=fields)
        print("The response of RoutingCodeApi->get_routing_code_by_siret_and_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RoutingCodeApi->get_routing_code_by_siret_and_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **siret** | **str**| SIRET number of a facility. | 
 **routing_identifier** | **str**| Routing Identifier of a routing code | 
 **include** | [**List[str]**](str.md)| Relations to include in the response. | [optional] 
 **fields** | [**List[RoutingCodeField]**](RoutingCodeField.md)| Fields of the Routing Code resource | [optional] 

### Return type

[**RoutingCodePayloadHistoryLegalUnitFacility**](RoutingCodePayloadHistoryLegalUnitFacility.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns a routing code. |  -  |
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

# **search_routing_code**
> RoutingCodeSearchPost200Response search_routing_code(routing_code_search)

Search for a routing code

Search for routing codes that meet all the criteria passed as parameters and return the routing codes in the desired format.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.routing_code_search import RoutingCodeSearch
from neotimo_xpz12013_directory.models.routing_code_search_post200_response import RoutingCodeSearchPost200Response
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
    api_instance = neotimo_xpz12013_directory.RoutingCodeApi(api_client)
    routing_code_search = neotimo_xpz12013_directory.RoutingCodeSearch() # RoutingCodeSearch | 

    try:
        # Search for a routing code
        api_response = api_instance.search_routing_code(routing_code_search)
        print("The response of RoutingCodeApi->search_routing_code:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling RoutingCodeApi->search_routing_code: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **routing_code_search** | [**RoutingCodeSearch**](RoutingCodeSearch.md)|  | 

### Return type

[**RoutingCodeSearchPost200Response**](RoutingCodeSearchPost200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Returns the routing code(s) matching the search criteria. |  -  |
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

