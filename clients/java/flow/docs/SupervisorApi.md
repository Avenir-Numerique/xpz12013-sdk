# SupervisorApi

All URIs are relative to *https://api.flow.company.com/flow-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getHealth**](SupervisorApi.md#getHealth) | **GET** /v1/healthcheck | Check whether the API service is up and running. |
| [**getHealthWithHttpInfo**](SupervisorApi.md#getHealthWithHttpInfo) | **GET** /v1/healthcheck | Check whether the API service is up and running. |



## getHealth

> void getHealth(requestId, organizationId)

Check whether the API service is up and running.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.SupervisorApi;

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

        SupervisorApi apiInstance = new SupervisorApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            apiInstance.getHealth(requestId, organizationId);
        } catch (ApiException e) {
            System.err.println("Exception when calling SupervisorApi#getHealth");
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

### Return type


null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Operation succeeded |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## getHealthWithHttpInfo

> ApiResponse<Void> getHealth getHealthWithHttpInfo(requestId, organizationId)

Check whether the API service is up and running.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.SupervisorApi;

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

        SupervisorApi apiInstance = new SupervisorApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            ApiResponse<Void> response = apiInstance.getHealthWithHttpInfo(requestId, organizationId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling SupervisorApi#getHealth");
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

### Return type


ApiResponse<Void>

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Operation succeeded |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

