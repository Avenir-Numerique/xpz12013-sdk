# neotimo_xpz12013_flow.SupervisorApi

All URIs are relative to *https://api.flow.company.com/flow-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_health**](SupervisorApi.md#get_health) | **GET** /v1/healthcheck | Check whether the API service is up and running.


# **get_health**
> get_health(request_id=request_id, organization_id=organization_id)

Check whether the API service is up and running.

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.flow.company.com/flow-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_flow.Configuration(
    host = "https://api.flow.company.com/flow-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): BearerAuth
configuration = neotimo_xpz12013_flow.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_flow.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_flow.SupervisorApi(api_client)
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)

    try:
        # Check whether the API service is up and running.
        api_instance.get_health(request_id=request_id, organization_id=organization_id)
    except Exception as e:
        print("Exception when calling SupervisorApi->get_health: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 

### Return type

void (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK - Operation succeeded |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

