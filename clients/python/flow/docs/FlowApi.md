# neotimo_xpz12013_flow.FlowApi

All URIs are relative to *https://api.flow.company.com/flow-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_flow**](FlowApi.md#create_flow) | **POST** /v1/flows | Submit a new flow
[**get_flow**](FlowApi.md#get_flow) | **GET** /v1/flows/{flowId} | Download the file of a flow
[**search_flows**](FlowApi.md#search_flows) | **POST** /v1/flows/search | Select flows upon criteria


# **create_flow**
> FullFlowInfo create_flow(flow_info, file, request_id=request_id, organization_id=organization_id)

Submit a new flow

Submit a flow. A flow is a single-invoice file, with :   - an XML/PDF file with the data of the invoice  The flow is created with a `flowInfo` object, allowing to qualify the flow.    A flow can be :   - an invoice (CII, UBL, Factur-X,...)    - a lifecycle (CDAR)    - or a e-reporting file 

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.models.flow_info import FlowInfo
from neotimo_xpz12013_flow.models.full_flow_info import FullFlowInfo
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
    api_instance = neotimo_xpz12013_flow.FlowApi(api_client)
    flow_info = neotimo_xpz12013_flow.FlowInfo() # FlowInfo | 
    file = None # bytearray | Flow file: Max size = 100 MB
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)

    try:
        # Submit a new flow
        api_response = api_instance.create_flow(flow_info, file, request_id=request_id, organization_id=organization_id)
        print("The response of FlowApi->create_flow:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowApi->create_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **flow_info** | [**FlowInfo**](FlowInfo.md)|  | 
 **file** | **bytearray**| Flow file: Max size &#x3D; 100 MB | 
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 

### Return type

[**FullFlowInfo**](FullFlowInfo.md)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**202** | OK - Response message once the flow has been uploaded.  |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**413** | Error 413 : Payload Too Large. |  -  |
**422** | Error 422 : Unprocessable entity. |  -  |
**429** | Error 429 : Too many requests. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_flow**
> get_flow(flow_id, request_id=request_id, organization_id=organization_id, doc_type=doc_type)

Download the file of a flow

Download a file related to a given flow:   - an invoice   - a life cycle   - an e-reporting 

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
    api_instance = neotimo_xpz12013_flow.FlowApi(api_client)
    flow_id = 'flow_id_example' # str | Flow identifier
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)
    doc_type = Metadata # str | This parameter allows to provide the type of file to be downloaded, can be either one:   - Metadata [Default]: provides the flow metadata as a JSON payload, no download   - Original: the document that has been initially sent/provided by the emitter   - Converted: the document that has been optionally converted by the system   - ReadableView: the document that has been optionally generated as the readable file  (optional) (default to Metadata)

    try:
        # Download the file of a flow
        api_instance.get_flow(flow_id, request_id=request_id, organization_id=organization_id, doc_type=doc_type)
    except Exception as e:
        print("Exception when calling FlowApi->get_flow: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **flow_id** | **str**| Flow identifier | 
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 
 **doc_type** | **str**| This parameter allows to provide the type of file to be downloaded, can be either one:   - Metadata [Default]: provides the flow metadata as a JSON payload, no download   - Original: the document that has been initially sent/provided by the emitter   - Converted: the document that has been optionally converted by the system   - ReadableView: the document that has been optionally generated as the readable file  | [optional] [default to Metadata]

### Return type

void (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK - Response message once the flow has been downloaded. |  * Content-Disposition - Header specifying attached file name <br>  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**404** | Error 404 : Resource Not Found. |  -  |
**429** | Error 429 : Too many requests. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **search_flows**
> SearchFlowContent search_flows(request_id=request_id, organization_id=organization_id, search_flow_params=search_flow_params)

Select flows upon criteria

Retrieves a set of flows matching the provided search criteria:   - Need at least one criterion to be specified   - Assuming a logical AND when combining criteria   - Assuming a logical OR for criteria allowing a list of values  Pagination works with the updatedAfter property The comparison with current date is strict : updatedAt > updatedAfter 

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.models.search_flow_content import SearchFlowContent
from neotimo_xpz12013_flow.models.search_flow_params import SearchFlowParams
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
    api_instance = neotimo_xpz12013_flow.FlowApi(api_client)
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)
    search_flow_params = neotimo_xpz12013_flow.SearchFlowParams() # SearchFlowParams |  (optional)

    try:
        # Select flows upon criteria
        api_response = api_instance.search_flows(request_id=request_id, organization_id=organization_id, search_flow_params=search_flow_params)
        print("The response of FlowApi->search_flows:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling FlowApi->search_flows: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 
 **search_flow_params** | [**SearchFlowParams**](SearchFlowParams.md)|  | [optional] 

### Return type

[**SearchFlowContent**](SearchFlowContent.md)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK - Response message when returning the results of a search request.  |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**429** | Error 429 : Too many requests. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

