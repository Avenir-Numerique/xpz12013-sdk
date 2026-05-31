# neotimo_xpz12013_directory.DirectoryLineApi

All URIs are relative to *https://api.directory.company.com/directory-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_directory_line_by_id**](DirectoryLineApi.md#get_directory_line_by_id) | **GET** /v1/directory-line/code:{addressing-identifier} | Get a directory line.
[**search_directory_line**](DirectoryLineApi.md#search_directory_line) | **POST** /v1/directory-line/search | Search for a directory line


# **get_directory_line_by_id**
> DirectoryLinePayloadLegalUnitFacilityRoutingCode get_directory_line_by_id(addressing_identifier, include=include, fields=fields)

Get a directory line.

Retrieve the data from the directory line corresponding to the identifier passed in parameters.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.directory_line_field import DirectoryLineField
from neotimo_xpz12013_directory.models.directory_line_payload_legal_unit_facility_routing_code import DirectoryLinePayloadLegalUnitFacilityRoutingCode
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
    api_instance = neotimo_xpz12013_directory.DirectoryLineApi(api_client)
    addressing_identifier = 'dcsc456sdcsdcs556' # str | Addressing identifier of the directory line
    include = ['[\"siren\",\"siret\",\"routingCode\"]'] # List[str] | Relations to include in the response.. (optional)
    fields = [neotimo_xpz12013_directory.DirectoryLineField()] # List[DirectoryLineField] | Fields of the Directory Line resource (optional)

    try:
        # Get a directory line.
        api_response = api_instance.get_directory_line_by_id(addressing_identifier, include=include, fields=fields)
        print("The response of DirectoryLineApi->get_directory_line_by_id:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DirectoryLineApi->get_directory_line_by_id: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **addressing_identifier** | **str**| Addressing identifier of the directory line | 
 **include** | [**List[str]**](str.md)| Relations to include in the response.. | [optional] 
 **fields** | [**List[DirectoryLineField]**](DirectoryLineField.md)| Fields of the Directory Line resource | [optional] 

### Return type

[**DirectoryLinePayloadLegalUnitFacilityRoutingCode**](DirectoryLinePayloadLegalUnitFacilityRoutingCode.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Retourns a directory line. |  -  |
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

# **search_directory_line**
> DirectoryLineSearchPost200Response search_directory_line(search_directory_line=search_directory_line)

Search for a directory line

Search for directory lines that meet all the criteria passed as parameters and return the results in the desired format.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.models.directory_line_search_post200_response import DirectoryLineSearchPost200Response
from neotimo_xpz12013_directory.models.search_directory_line import SearchDirectoryLine
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
    api_instance = neotimo_xpz12013_directory.DirectoryLineApi(api_client)
    search_directory_line = neotimo_xpz12013_directory.SearchDirectoryLine() # SearchDirectoryLine |  (optional)

    try:
        # Search for a directory line
        api_response = api_instance.search_directory_line(search_directory_line=search_directory_line)
        print("The response of DirectoryLineApi->search_directory_line:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling DirectoryLineApi->search_directory_line: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **search_directory_line** | [**SearchDirectoryLine**](SearchDirectoryLine.md)|  | [optional] 

### Return type

[**DirectoryLineSearchPost200Response**](DirectoryLineSearchPost200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/problem+json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | returns the directory line(s) matching the search criteria. |  -  |
**204** | No Content - No content expected |  -  |
**206** | Request processed without error, but the volume of information returned has been reduced. |  -  |
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

