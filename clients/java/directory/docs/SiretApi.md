# SiretApi

All URIs are relative to *https://api.directory.company.com/directory-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getFacilityBySiret**](SiretApi.md#getFacilityBySiret) | **GET** /v1/siret/code-insee:{siret} | Gets a siret (facility) by SIRET number |
| [**getFacilityBySiretWithHttpInfo**](SiretApi.md#getFacilityBySiretWithHttpInfo) | **GET** /v1/siret/code-insee:{siret} | Gets a siret (facility) by SIRET number |
| [**searchFacilityBySiret**](SiretApi.md#searchFacilityBySiret) | **POST** /v1/siret/search | Search for a SIRET (facility) |
| [**searchFacilityBySiretWithHttpInfo**](SiretApi.md#searchFacilityBySiretWithHttpInfo) | **POST** /v1/siret/search | Search for a SIRET (facility) |



## getFacilityBySiret

> FacilityPayloadHistory getFacilityBySiret(siret, fields, include)

Gets a siret (facility) by SIRET number

Returns the details of a facility associated to a SIRET.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SiretApi;

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

        SiretApi apiInstance = new SiretApi(defaultClient);
        String siret = "70204275500240"; // String | SIRET number of a facility.
        List<SiretField> fields = Arrays.asList(); // List<SiretField> | Fields of the SIRET resource.
        List<String> include = Arrays.asList(); // List<String> | Relations to include in the response.
        try {
            FacilityPayloadHistory result = apiInstance.getFacilityBySiret(siret, fields, include);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SiretApi#getFacilityBySiret");
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
| **fields** | [**List&lt;SiretField&gt;**](SiretField.md)| Fields of the SIRET resource. | [optional] |
| **include** | [**List&lt;String&gt;**](String.md)| Relations to include in the response. | [optional] [enum: siren] |

### Return type

[**FacilityPayloadHistory**](FacilityPayloadHistory.md)


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns a facility. |  -  |
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

## getFacilityBySiretWithHttpInfo

> ApiResponse<FacilityPayloadHistory> getFacilityBySiret getFacilityBySiretWithHttpInfo(siret, fields, include)

Gets a siret (facility) by SIRET number

Returns the details of a facility associated to a SIRET.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SiretApi;

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

        SiretApi apiInstance = new SiretApi(defaultClient);
        String siret = "70204275500240"; // String | SIRET number of a facility.
        List<SiretField> fields = Arrays.asList(); // List<SiretField> | Fields of the SIRET resource.
        List<String> include = Arrays.asList(); // List<String> | Relations to include in the response.
        try {
            ApiResponse<FacilityPayloadHistory> response = apiInstance.getFacilityBySiretWithHttpInfo(siret, fields, include);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SiretApi#getFacilityBySiret");
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
| **fields** | [**List&lt;SiretField&gt;**](SiretField.md)| Fields of the SIRET resource. | [optional] |
| **include** | [**List&lt;String&gt;**](String.md)| Relations to include in the response. | [optional] [enum: siren] |

### Return type

ApiResponse<[**FacilityPayloadHistory**](FacilityPayloadHistory.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns a facility. |  -  |
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


## searchFacilityBySiret

> SiretSearchPost200Response searchFacilityBySiret(searchSiret)

Search for a SIRET (facility)

Multi-criteria search for facilities.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SiretApi;

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

        SiretApi apiInstance = new SiretApi(defaultClient);
        SearchSiret searchSiret = new SearchSiret(); // SearchSiret | 
        try {
            SiretSearchPost200Response result = apiInstance.searchFacilityBySiret(searchSiret);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SiretApi#searchFacilityBySiret");
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
| **searchSiret** | [**SearchSiret**](SearchSiret.md)|  | [optional] |

### Return type

[**SiretSearchPost200Response**](SiretSearchPost200Response.md)


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns an establishment as defined on a given observation date or as defined on the current date if the observation date is not specified. |  -  |
| **204** | No Content - No content expected |  -  |
| **206** | Request processed without error, but the volume of information returned has been reduced. |  -  |
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

## searchFacilityBySiretWithHttpInfo

> ApiResponse<SiretSearchPost200Response> searchFacilityBySiret searchFacilityBySiretWithHttpInfo(searchSiret)

Search for a SIRET (facility)

Multi-criteria search for facilities.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.SiretApi;

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

        SiretApi apiInstance = new SiretApi(defaultClient);
        SearchSiret searchSiret = new SearchSiret(); // SearchSiret | 
        try {
            ApiResponse<SiretSearchPost200Response> response = apiInstance.searchFacilityBySiretWithHttpInfo(searchSiret);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling SiretApi#searchFacilityBySiret");
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
| **searchSiret** | [**SearchSiret**](SearchSiret.md)|  | [optional] |

### Return type

ApiResponse<[**SiretSearchPost200Response**](SiretSearchPost200Response.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returns an establishment as defined on a given observation date or as defined on the current date if the observation date is not specified. |  -  |
| **204** | No Content - No content expected |  -  |
| **206** | Request processed without error, but the volume of information returned has been reduced. |  -  |
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

