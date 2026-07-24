# RoutingCodeApi

All URIs are relative to *https://api.directory.company.com/directory-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getRoutingCodeBySiretAndId**](RoutingCodeApi.md#getRoutingCodeBySiretAndId) | **GET** /v1/routing-code/siret:{siret}/code:{routing-identifier} | Get a routing code by SIRET and routing identifier |
| [**getRoutingCodeBySiretAndIdWithHttpInfo**](RoutingCodeApi.md#getRoutingCodeBySiretAndIdWithHttpInfo) | **GET** /v1/routing-code/siret:{siret}/code:{routing-identifier} | Get a routing code by SIRET and routing identifier |
| [**searchRoutingCode**](RoutingCodeApi.md#searchRoutingCode) | **POST** /v1/routing-code/search | Search for a routing code |
| [**searchRoutingCodeWithHttpInfo**](RoutingCodeApi.md#searchRoutingCodeWithHttpInfo) | **POST** /v1/routing-code/search | Search for a routing code |



## getRoutingCodeBySiretAndId

> RoutingCodePayloadHistoryLegalUnitFacility getRoutingCodeBySiretAndId(siret, routingIdentifier, include, fields)

Get a routing code by SIRET and routing identifier

Retrieve the Routing Code data corresponding to the identifier passed in parameters.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.RoutingCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.directory.company.com/directory-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoutingCodeApi apiInstance = new RoutingCodeApi(defaultClient);
        String siret = "70204275500240"; // String | SIRET number of a facility.
        String routingIdentifier = "702042755"; // String | Routing Identifier of a routing code
        List<String> include = Arrays.asList(); // List<String> | Relations to include in the response.
        List<RoutingCodeField> fields = Arrays.asList(); // List<RoutingCodeField> | Fields of the Routing Code resource
        try {
            RoutingCodePayloadHistoryLegalUnitFacility result = apiInstance.getRoutingCodeBySiretAndId(siret, routingIdentifier, include, fields);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingCodeApi#getRoutingCodeBySiretAndId");
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
| **siret** | **String**| SIRET number of a facility. | |
| **routingIdentifier** | **String**| Routing Identifier of a routing code | |
| **include** | [**List&lt;String&gt;**](String.md)| Relations to include in the response. | [optional] [enum: siren, siret] |
| **fields** | [**List&lt;RoutingCodeField&gt;**](RoutingCodeField.md)| Fields of the Routing Code resource | [optional] |

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
| **200** | Returns a routing code. |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **408** | Error 408 : Request Timeout Exceeded. |  -  |
| **422** | Error 422 : Unprocessable entity. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **501** | Error 501 : Not Implemented. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |
| **0** | An error has occurred - See the status code and json response for more information. |  -  |

## getRoutingCodeBySiretAndIdWithHttpInfo

> ApiResponse<RoutingCodePayloadHistoryLegalUnitFacility> getRoutingCodeBySiretAndId getRoutingCodeBySiretAndIdWithHttpInfo(siret, routingIdentifier, include, fields)

Get a routing code by SIRET and routing identifier

Retrieve the Routing Code data corresponding to the identifier passed in parameters.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.RoutingCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.directory.company.com/directory-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoutingCodeApi apiInstance = new RoutingCodeApi(defaultClient);
        String siret = "70204275500240"; // String | SIRET number of a facility.
        String routingIdentifier = "702042755"; // String | Routing Identifier of a routing code
        List<String> include = Arrays.asList(); // List<String> | Relations to include in the response.
        List<RoutingCodeField> fields = Arrays.asList(); // List<RoutingCodeField> | Fields of the Routing Code resource
        try {
            ApiResponse<RoutingCodePayloadHistoryLegalUnitFacility> response = apiInstance.getRoutingCodeBySiretAndIdWithHttpInfo(siret, routingIdentifier, include, fields);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingCodeApi#getRoutingCodeBySiretAndId");
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
| **siret** | **String**| SIRET number of a facility. | |
| **routingIdentifier** | **String**| Routing Identifier of a routing code | |
| **include** | [**List&lt;String&gt;**](String.md)| Relations to include in the response. | [optional] [enum: siren, siret] |
| **fields** | [**List&lt;RoutingCodeField&gt;**](RoutingCodeField.md)| Fields of the Routing Code resource | [optional] |

### Return type

ApiResponse<[**RoutingCodePayloadHistoryLegalUnitFacility**](RoutingCodePayloadHistoryLegalUnitFacility.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns a routing code. |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **408** | Error 408 : Request Timeout Exceeded. |  -  |
| **422** | Error 422 : Unprocessable entity. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **501** | Error 501 : Not Implemented. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |
| **0** | An error has occurred - See the status code and json response for more information. |  -  |


## searchRoutingCode

> RoutingCodeSearchPost200Response searchRoutingCode(routingCodeSearch)

Search for a routing code

Search for routing codes that meet all the criteria passed as parameters and return the routing codes in the desired format.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.RoutingCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.directory.company.com/directory-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoutingCodeApi apiInstance = new RoutingCodeApi(defaultClient);
        RoutingCodeSearch routingCodeSearch = new RoutingCodeSearch(); // RoutingCodeSearch | 
        try {
            RoutingCodeSearchPost200Response result = apiInstance.searchRoutingCode(routingCodeSearch);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingCodeApi#searchRoutingCode");
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
| **routingCodeSearch** | [**RoutingCodeSearch**](RoutingCodeSearch.md)|  | |

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
| **200** | Returns the routing code(s) matching the search criteria. |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **408** | Error 408 : Request Timeout Exceeded. |  -  |
| **422** | Error 422 : Unprocessable entity. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **501** | Error 501 : Not Implemented. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |
| **0** | An error has occurred - See the status code and json response for more information. |  -  |

## searchRoutingCodeWithHttpInfo

> ApiResponse<RoutingCodeSearchPost200Response> searchRoutingCode searchRoutingCodeWithHttpInfo(routingCodeSearch)

Search for a routing code

Search for routing codes that meet all the criteria passed as parameters and return the routing codes in the desired format.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.RoutingCodeApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.directory.company.com/directory-service");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoutingCodeApi apiInstance = new RoutingCodeApi(defaultClient);
        RoutingCodeSearch routingCodeSearch = new RoutingCodeSearch(); // RoutingCodeSearch | 
        try {
            ApiResponse<RoutingCodeSearchPost200Response> response = apiInstance.searchRoutingCodeWithHttpInfo(routingCodeSearch);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling RoutingCodeApi#searchRoutingCode");
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
| **routingCodeSearch** | [**RoutingCodeSearch**](RoutingCodeSearch.md)|  | |

### Return type

ApiResponse<[**RoutingCodeSearchPost200Response**](RoutingCodeSearchPost200Response.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns the routing code(s) matching the search criteria. |  -  |
| **400** | Error 400 : Bad request. |  -  |
| **401** | Error 401 : Authentication error. |  -  |
| **403** | Error 403 : Forbidden. |  -  |
| **404** | Error 404 : Resource Not Found. |  -  |
| **408** | Error 408 : Request Timeout Exceeded. |  -  |
| **422** | Error 422 : Unprocessable entity. |  -  |
| **429** | Error 429 : Too many requests. |  -  |
| **500** | Error 500 : Server Internal Error. |  -  |
| **501** | Error 501 : Not Implemented. |  -  |
| **503** | Error 503 : Unavailable Resource. |  -  |
| **0** | An error has occurred - See the status code and json response for more information. |  -  |

