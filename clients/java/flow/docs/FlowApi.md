# FlowApi

All URIs are relative to *https://api.flow.company.com/flow-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createFlow**](FlowApi.md#createFlow) | **POST** /v1/flows | Submit a new flow |
| [**createFlowWithHttpInfo**](FlowApi.md#createFlowWithHttpInfo) | **POST** /v1/flows | Submit a new flow |
| [**getFlow**](FlowApi.md#getFlow) | **GET** /v1/flows/{flowId} | Download the file of a flow |
| [**getFlowWithHttpInfo**](FlowApi.md#getFlowWithHttpInfo) | **GET** /v1/flows/{flowId} | Download the file of a flow |
| [**searchFlows**](FlowApi.md#searchFlows) | **POST** /v1/flows/search | Select flows upon criteria |
| [**searchFlowsWithHttpInfo**](FlowApi.md#searchFlowsWithHttpInfo) | **POST** /v1/flows/search | Select flows upon criteria |



## createFlow

> FullFlowInfo createFlow(flowInfo, _file, requestId, organizationId)

Submit a new flow

Submit a flow. A flow is a single-invoice file, with :   - an XML/PDF file with the data of the invoice  The flow is created with a &#x60;flowInfo&#x60; object, allowing to qualify the flow.    A flow can be :   - an invoice (CII, UBL, Factur-X,...)    - a lifecycle (CDAR)    - or a e-reporting file 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.FlowApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flow.company.com/flow-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        FlowApi apiInstance = new FlowApi(defaultClient);
        FlowInfo flowInfo = new FlowInfo(); // FlowInfo | 
        File _file = new File("/path/to/file"); // File | Flow file: Max size = 100 MB
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            FullFlowInfo result = apiInstance.createFlow(flowInfo, _file, requestId, organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowApi#createFlow");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **flowInfo** | [**FlowInfo**](FlowInfo.md)|  | |
| **_file** | **File**| Flow file: Max size &#x3D; 100 MB | |
| **requestId** | **UUID**| Header parameter used to correlate logs from several components | [optional] |
| **organizationId** | **String**| The organization that is aimed in a multi tenancy context | [optional] |

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
| **202** | OK - Response message once the flow has been uploaded.  |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **413** | Error 413 : Payload Too Large. |  -  |
| **422** | Error 422 : Unprocessable entity. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## createFlowWithHttpInfo

> ApiResponse<FullFlowInfo> createFlow createFlowWithHttpInfo(flowInfo, _file, requestId, organizationId)

Submit a new flow

Submit a flow. A flow is a single-invoice file, with :   - an XML/PDF file with the data of the invoice  The flow is created with a &#x60;flowInfo&#x60; object, allowing to qualify the flow.    A flow can be :   - an invoice (CII, UBL, Factur-X,...)    - a lifecycle (CDAR)    - or a e-reporting file 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.FlowApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flow.company.com/flow-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        FlowApi apiInstance = new FlowApi(defaultClient);
        FlowInfo flowInfo = new FlowInfo(); // FlowInfo | 
        File _file = new File("/path/to/file"); // File | Flow file: Max size = 100 MB
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            ApiResponse<FullFlowInfo> response = apiInstance.createFlowWithHttpInfo(flowInfo, _file, requestId, organizationId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowApi#createFlow");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **flowInfo** | [**FlowInfo**](FlowInfo.md)|  | |
| **_file** | **File**| Flow file: Max size &#x3D; 100 MB | |
| **requestId** | **UUID**| Header parameter used to correlate logs from several components | [optional] |
| **organizationId** | **String**| The organization that is aimed in a multi tenancy context | [optional] |

### Return type

ApiResponse<[**FullFlowInfo**](FullFlowInfo.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | OK - Response message once the flow has been uploaded.  |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **413** | Error 413 : Payload Too Large. |  -  |
| **422** | Error 422 : Unprocessable entity. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |


## getFlow

> void getFlow(flowId, requestId, organizationId, docType)

Download the file of a flow

Download a file related to a given flow:   - an invoice   - a life cycle   - an e-reporting 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.FlowApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flow.company.com/flow-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        FlowApi apiInstance = new FlowApi(defaultClient);
        String flowId = "flowId_example"; // String | Flow identifier
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        String docType = "Metadata"; // String | This parameter allows to provide the type of file to be downloaded, can be either one:   - Metadata [Default]: provides the flow metadata as a JSON payload, no download   - Original: the document that has been initially sent/provided by the emitter   - Converted: the document that has been optionally converted by the system   - ReadableView: the document that has been optionally generated as the readable file 
        try {
            apiInstance.getFlow(flowId, requestId, organizationId, docType);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowApi#getFlow");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **flowId** | **String**| Flow identifier | |
| **requestId** | **UUID**| Header parameter used to correlate logs from several components | [optional] |
| **organizationId** | **String**| The organization that is aimed in a multi tenancy context | [optional] |
| **docType** | **String**| This parameter allows to provide the type of file to be downloaded, can be either one:   - Metadata [Default]: provides the flow metadata as a JSON payload, no download   - Original: the document that has been initially sent/provided by the emitter   - Converted: the document that has been optionally converted by the system   - ReadableView: the document that has been optionally generated as the readable file  | [optional] [default to Metadata] [enum: Metadata, Original, Converted, ReadableView] |

### Return type


null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Response message once the flow has been downloaded. |  * Content-Disposition - Header specifying attached file name <br>  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## getFlowWithHttpInfo

> ApiResponse<Void> getFlow getFlowWithHttpInfo(flowId, requestId, organizationId, docType)

Download the file of a flow

Download a file related to a given flow:   - an invoice   - a life cycle   - an e-reporting 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.FlowApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flow.company.com/flow-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        FlowApi apiInstance = new FlowApi(defaultClient);
        String flowId = "flowId_example"; // String | Flow identifier
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        String docType = "Metadata"; // String | This parameter allows to provide the type of file to be downloaded, can be either one:   - Metadata [Default]: provides the flow metadata as a JSON payload, no download   - Original: the document that has been initially sent/provided by the emitter   - Converted: the document that has been optionally converted by the system   - ReadableView: the document that has been optionally generated as the readable file 
        try {
            ApiResponse<Void> response = apiInstance.getFlowWithHttpInfo(flowId, requestId, organizationId, docType);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowApi#getFlow");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **flowId** | **String**| Flow identifier | |
| **requestId** | **UUID**| Header parameter used to correlate logs from several components | [optional] |
| **organizationId** | **String**| The organization that is aimed in a multi tenancy context | [optional] |
| **docType** | **String**| This parameter allows to provide the type of file to be downloaded, can be either one:   - Metadata [Default]: provides the flow metadata as a JSON payload, no download   - Original: the document that has been initially sent/provided by the emitter   - Converted: the document that has been optionally converted by the system   - ReadableView: the document that has been optionally generated as the readable file  | [optional] [default to Metadata] [enum: Metadata, Original, Converted, ReadableView] |

### Return type


ApiResponse<Void>

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Response message once the flow has been downloaded. |  * Content-Disposition - Header specifying attached file name <br>  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |


## searchFlows

> SearchFlowContent searchFlows(requestId, organizationId, searchFlowParams)

Select flows upon criteria

Retrieves a set of flows matching the provided search criteria:   - Need at least one criterion to be specified   - Assuming a logical AND when combining criteria   - Assuming a logical OR for criteria allowing a list of values  Pagination works with the updatedAfter property The comparison with current date is strict : updatedAt &gt; updatedAfter 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.FlowApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flow.company.com/flow-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        FlowApi apiInstance = new FlowApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        SearchFlowParams searchFlowParams = new SearchFlowParams(); // SearchFlowParams | 
        try {
            SearchFlowContent result = apiInstance.searchFlows(requestId, organizationId, searchFlowParams);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowApi#searchFlows");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **requestId** | **UUID**| Header parameter used to correlate logs from several components | [optional] |
| **organizationId** | **String**| The organization that is aimed in a multi tenancy context | [optional] |
| **searchFlowParams** | [**SearchFlowParams**](SearchFlowParams.md)|  | [optional] |

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
| **200** | OK - Response message when returning the results of a search request.  |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## searchFlowsWithHttpInfo

> ApiResponse<SearchFlowContent> searchFlows searchFlowsWithHttpInfo(requestId, organizationId, searchFlowParams)

Select flows upon criteria

Retrieves a set of flows matching the provided search criteria:   - Need at least one criterion to be specified   - Assuming a logical AND when combining criteria   - Assuming a logical OR for criteria allowing a list of values  Pagination works with the updatedAfter property The comparison with current date is strict : updatedAt &gt; updatedAfter 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.FlowApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.flow.company.com/flow-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        FlowApi apiInstance = new FlowApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        SearchFlowParams searchFlowParams = new SearchFlowParams(); // SearchFlowParams | 
        try {
            ApiResponse<SearchFlowContent> response = apiInstance.searchFlowsWithHttpInfo(requestId, organizationId, searchFlowParams);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling FlowApi#searchFlows");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **requestId** | **UUID**| Header parameter used to correlate logs from several components | [optional] |
| **organizationId** | **String**| The organization that is aimed in a multi tenancy context | [optional] |
| **searchFlowParams** | [**SearchFlowParams**](SearchFlowParams.md)|  | [optional] |

### Return type

ApiResponse<[**SearchFlowContent**](SearchFlowContent.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Response message when returning the results of a search request.  |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

