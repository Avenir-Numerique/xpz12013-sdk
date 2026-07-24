# SirenApi

All URIs are relative to *https://api.directory.company.com/directory-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCompanyBySiren**](SirenApi.md#getCompanyBySiren) | **GET** /v1/siren/code-insee:{siren} | Consult a siren (legal unit) by SIREN number |
| [**getCompanyBySirenWithHttpInfo**](SirenApi.md#getCompanyBySirenWithHttpInfo) | **GET** /v1/siren/code-insee:{siren} | Consult a siren (legal unit) by SIREN number |
| [**searchCompanyBySiren**](SirenApi.md#searchCompanyBySiren) | **POST** /v1/siren/search | SIREN search (or legal unit) |
| [**searchCompanyBySirenWithHttpInfo**](SirenApi.md#searchCompanyBySirenWithHttpInfo) | **POST** /v1/siren/search | SIREN search (or legal unit) |



## getCompanyBySiren

> LegalUnitPayloadHistory getCompanyBySiren(siren, fields)

Consult a siren (legal unit) by SIREN number

Returns the details of a company (legal unit) identified by the SIREN number passed as a parameter.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SirenApi;

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

        SirenApi apiInstance = new SirenApi(defaultClient);
        String siren = "702042755"; // String | Corresponds to the SIREN number of a legal unit.
        List<SirenField> fields = Arrays.asList(); // List<SirenField> | Fields of the SIREN resource.
        try {
            LegalUnitPayloadHistory result = apiInstance.getCompanyBySiren(siren, fields);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SirenApi#getCompanyBySiren");
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
| **siren** | **String**| Corresponds to the SIREN number of a legal unit. | |
| **fields** | [**List&lt;SirenField&gt;**](SirenField.md)| Fields of the SIREN resource. | [optional] |

### Return type

[**LegalUnitPayloadHistory**](LegalUnitPayloadHistory.md)


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns a company. |  -  |
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

## getCompanyBySirenWithHttpInfo

> ApiResponse<LegalUnitPayloadHistory> getCompanyBySiren getCompanyBySirenWithHttpInfo(siren, fields)

Consult a siren (legal unit) by SIREN number

Returns the details of a company (legal unit) identified by the SIREN number passed as a parameter.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SirenApi;

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

        SirenApi apiInstance = new SirenApi(defaultClient);
        String siren = "702042755"; // String | Corresponds to the SIREN number of a legal unit.
        List<SirenField> fields = Arrays.asList(); // List<SirenField> | Fields of the SIREN resource.
        try {
            ApiResponse<LegalUnitPayloadHistory> response = apiInstance.getCompanyBySirenWithHttpInfo(siren, fields);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SirenApi#getCompanyBySiren");
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
| **siren** | **String**| Corresponds to the SIREN number of a legal unit. | |
| **fields** | [**List&lt;SirenField&gt;**](SirenField.md)| Fields of the SIREN resource. | [optional] |

### Return type

ApiResponse<[**LegalUnitPayloadHistory**](LegalUnitPayloadHistory.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns a company. |  -  |
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


## searchCompanyBySiren

> SirenSearchPost200Response searchCompanyBySiren(searchSiren)

SIREN search (or legal unit)

Multi-criteria company search.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SirenApi;

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

        SirenApi apiInstance = new SirenApi(defaultClient);
        SearchSiren searchSiren = new SearchSiren(); // SearchSiren | 
        try {
            SirenSearchPost200Response result = apiInstance.searchCompanyBySiren(searchSiren);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SirenApi#searchCompanyBySiren");
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
| **searchSiren** | [**SearchSiren**](SearchSiren.md)|  | [optional] |

### Return type

[**SirenSearchPost200Response**](SirenSearchPost200Response.md)


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns one or more companies. |  -  |
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

## searchCompanyBySirenWithHttpInfo

> ApiResponse<SirenSearchPost200Response> searchCompanyBySiren searchCompanyBySirenWithHttpInfo(searchSiren)

SIREN search (or legal unit)

Multi-criteria company search.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SirenApi;

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

        SirenApi apiInstance = new SirenApi(defaultClient);
        SearchSiren searchSiren = new SearchSiren(); // SearchSiren | 
        try {
            ApiResponse<SirenSearchPost200Response> response = apiInstance.searchCompanyBySirenWithHttpInfo(searchSiren);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SirenApi#searchCompanyBySiren");
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
| **searchSiren** | [**SearchSiren**](SearchSiren.md)|  | [optional] |

### Return type

ApiResponse<[**SirenSearchPost200Response**](SirenSearchPost200Response.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns one or more companies. |  -  |
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

