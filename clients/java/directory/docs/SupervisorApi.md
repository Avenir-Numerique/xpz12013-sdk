# SupervisorApi

All URIs are relative to *https://api.directory.company.com/directory-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getHealth**](SupervisorApi.md#getHealth) | **GET** /v1/healthcheck | Checks if the API connection is operational. |
| [**getHealthWithHttpInfo**](SupervisorApi.md#getHealthWithHttpInfo) | **GET** /v1/healthcheck | Checks if the API connection is operational. |



## getHealth

> void getHealth()

Checks if the API connection is operational.

Checks if the API connection is operational.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SupervisorApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.directory.company.com/directory-service");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SupervisorApi apiInstance = new SupervisorApi(defaultClient);
        try {
            apiInstance.getHealth();
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

This endpoint does not need any parameter.

### Return type


null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The connection to the API is functional. |  -  |
| **500** | Internal Server Error. |  -  |
| **503** | Service unavailable. |  -  |

## getHealthWithHttpInfo

> ApiResponse<Void> getHealth getHealthWithHttpInfo()

Checks if the API connection is operational.

Checks if the API connection is operational.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SupervisorApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.directory.company.com/directory-service");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SupervisorApi apiInstance = new SupervisorApi(defaultClient);
        try {
            ApiResponse<Void> response = apiInstance.getHealthWithHttpInfo();
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

This endpoint does not need any parameter.

### Return type


ApiResponse<Void>

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The connection to the API is functional. |  -  |
| **500** | Internal Server Error. |  -  |
| **503** | Service unavailable. |  -  |

