# WebhookApi

All URIs are relative to *https://api.flow.company.com/flow-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createWebhook**](WebhookApi.md#createWebhook) | **POST** /v1/webhooks | Subscribe to a webhook |
| [**createWebhookWithHttpInfo**](WebhookApi.md#createWebhookWithHttpInfo) | **POST** /v1/webhooks | Subscribe to a webhook |
| [**deleteWebhook**](WebhookApi.md#deleteWebhook) | **DELETE** /v1/webhooks/{webhookUid} | Unsubscribe to a webhook |
| [**deleteWebhookWithHttpInfo**](WebhookApi.md#deleteWebhookWithHttpInfo) | **DELETE** /v1/webhooks/{webhookUid} | Unsubscribe to a webhook |
| [**listWebhooks**](WebhookApi.md#listWebhooks) | **GET** /v1/webhooks | Retrieve the list of webhooks created by the owner of the token |
| [**listWebhooksWithHttpInfo**](WebhookApi.md#listWebhooksWithHttpInfo) | **GET** /v1/webhooks | Retrieve the list of webhooks created by the owner of the token |



## createWebhook

> WebhookIdParam createWebhook(requestId, organizationId, webhookParams)

Subscribe to a webhook

This operation creates and configures a new webhook, providing: - The callback URL - The metadata to filter on subsets of events  The webhook belongs to the owner of the token and cannot be seen from others: - It returns an id and a signing key (256 or 512 bits) that should be kept - The signing key allows to validate the signature of each received event.  How the signature is managed: - At webhook creation a signing Key is randomly generated in a secure way   - 256 bits are enough if the random generator is secure    - 512 bits are necessary if the generator is not secure - Each time an event is sent:   - a SHA-256 fingerprint is generated based on the concatenation of:     - the JSON payload of the response (as is, no canonical format)     - a separator : @     - the current epoch time in seconds   - a HMAC signature is computed over the fingerprint with the callback signing key   - the signature is base64 encoded for the transport    The signature and the timestamp are returned in the following headers of the callback:   - Afnor-Signature is the signature (base64)   - Afnor-Signature-Timestamp is the epoch timestamp in seconds 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.WebhookApi;

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

        WebhookApi apiInstance = new WebhookApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        WebhookParams webhookParams = new WebhookParams(); // WebhookParams | Create a webhook
        try {
            WebhookIdParam result = apiInstance.createWebhook(requestId, organizationId, webhookParams);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhookApi#createWebhook");
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
| **webhookParams** | [**WebhookParams**](WebhookParams.md)| Create a webhook | [optional] |

### Return type

[**WebhookIdParam**](WebhookIdParam.md)


### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK - Webhook Created |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## createWebhookWithHttpInfo

> ApiResponse<WebhookIdParam> createWebhook createWebhookWithHttpInfo(requestId, organizationId, webhookParams)

Subscribe to a webhook

This operation creates and configures a new webhook, providing: - The callback URL - The metadata to filter on subsets of events  The webhook belongs to the owner of the token and cannot be seen from others: - It returns an id and a signing key (256 or 512 bits) that should be kept - The signing key allows to validate the signature of each received event.  How the signature is managed: - At webhook creation a signing Key is randomly generated in a secure way   - 256 bits are enough if the random generator is secure    - 512 bits are necessary if the generator is not secure - Each time an event is sent:   - a SHA-256 fingerprint is generated based on the concatenation of:     - the JSON payload of the response (as is, no canonical format)     - a separator : @     - the current epoch time in seconds   - a HMAC signature is computed over the fingerprint with the callback signing key   - the signature is base64 encoded for the transport    The signature and the timestamp are returned in the following headers of the callback:   - Afnor-Signature is the signature (base64)   - Afnor-Signature-Timestamp is the epoch timestamp in seconds 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.WebhookApi;

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

        WebhookApi apiInstance = new WebhookApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        WebhookParams webhookParams = new WebhookParams(); // WebhookParams | Create a webhook
        try {
            ApiResponse<WebhookIdParam> response = apiInstance.createWebhookWithHttpInfo(requestId, organizationId, webhookParams);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhookApi#createWebhook");
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
| **webhookParams** | [**WebhookParams**](WebhookParams.md)| Create a webhook | [optional] |

### Return type

ApiResponse<[**WebhookIdParam**](WebhookIdParam.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | OK - Webhook Created |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |


## deleteWebhook

> void deleteWebhook(webhookUid, requestId, organizationId)

Unsubscribe to a webhook

- Delete a subscription owned by the owner of the token - The operation is allowed only buy the owner of the token 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.WebhookApi;

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

        WebhookApi apiInstance = new WebhookApi(defaultClient);
        UUID webhookUid = UUID.randomUUID(); // UUID | The webhook unique ID
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            apiInstance.deleteWebhook(webhookUid, requestId, organizationId);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhookApi#deleteWebhook");
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
| **webhookUid** | **UUID**| The webhook unique ID | |
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
| **204** | No Content - No content expected |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## deleteWebhookWithHttpInfo

> ApiResponse<Void> deleteWebhook deleteWebhookWithHttpInfo(webhookUid, requestId, organizationId)

Unsubscribe to a webhook

- Delete a subscription owned by the owner of the token - The operation is allowed only buy the owner of the token 

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.WebhookApi;

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

        WebhookApi apiInstance = new WebhookApi(defaultClient);
        UUID webhookUid = UUID.randomUUID(); // UUID | The webhook unique ID
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            ApiResponse<Void> response = apiInstance.deleteWebhookWithHttpInfo(webhookUid, requestId, organizationId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhookApi#deleteWebhook");
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
| **webhookUid** | **UUID**| The webhook unique ID | |
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
| **204** | No Content - No content expected |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |


## listWebhooks

> ListWebhooks200Response listWebhooks(requestId, organizationId)

Retrieve the list of webhooks created by the owner of the token

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.WebhookApi;

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

        WebhookApi apiInstance = new WebhookApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            ListWebhooks200Response result = apiInstance.listWebhooks(requestId, organizationId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhookApi#listWebhooks");
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

[**ListWebhooks200Response**](ListWebhooks200Response.md)


### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Webhook List Response |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

## listWebhooksWithHttpInfo

> ApiResponse<ListWebhooks200Response> listWebhooks listWebhooksWithHttpInfo(requestId, organizationId)

Retrieve the list of webhooks created by the owner of the token

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.flow.ApiClient;
import fr.neotimo.xpz12013.flow.ApiException;
import fr.neotimo.xpz12013.flow.ApiResponse;
import fr.neotimo.xpz12013.flow.Configuration;
import fr.neotimo.xpz12013.flow.auth.*;
import fr.neotimo.xpz12013.flow.models.*;
import fr.neotimo.xpz12013.flow.api.WebhookApi;

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

        WebhookApi apiInstance = new WebhookApi(defaultClient);
        UUID requestId = UUID.randomUUID(); // UUID | Header parameter used to correlate logs from several components
        String organizationId = "organizationId_example"; // String | The organization that is aimed in a multi tenancy context
        try {
            ApiResponse<ListWebhooks200Response> response = apiInstance.listWebhooksWithHttpInfo(requestId, organizationId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling WebhookApi#listWebhooks");
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

ApiResponse<[**ListWebhooks200Response**](ListWebhooks200Response.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK - Webhook List Response |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |

