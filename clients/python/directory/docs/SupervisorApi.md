# neotimo_xpz12013_directory.SupervisorApi

All URIs are relative to *https://api.directory.company.com/directory-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_health**](SupervisorApi.md#get_health) | **GET** /v1/healthcheck | Checks if the API connection is operational.


# **get_health**
> get_health()

Checks if the API connection is operational.

Checks if the API connection is operational.

### Example

* Bearer (JWT) Authentication (bearerAuth):

```python
import neotimo_xpz12013_directory
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

# Configure Bearer authorization (JWT): bearerAuth
configuration = neotimo_xpz12013_directory.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_directory.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_directory.SupervisorApi(api_client)

    try:
        # Checks if the API connection is operational.
        api_instance.get_health()
    except Exception as e:
        print("Exception when calling SupervisorApi->get_health: %s\n" % e)
```



### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | The connection to the API is functional. |  -  |
**500** | Internal Server Error. |  -  |
**503** | Service unavailable. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

