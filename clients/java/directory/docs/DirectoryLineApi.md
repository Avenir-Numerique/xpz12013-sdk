# DirectoryLineApi

All URIs are relative to *https://api.directory.company.com/directory-service*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getDirectoryLineById**](DirectoryLineApi.md#getDirectoryLineById) | **GET** /v1/directory-line/code:{addressing-identifier} | Get a directory line. |
| [**getDirectoryLineByIdWithHttpInfo**](DirectoryLineApi.md#getDirectoryLineByIdWithHttpInfo) | **GET** /v1/directory-line/code:{addressing-identifier} | Get a directory line. |
| [**searchDirectoryLine**](DirectoryLineApi.md#searchDirectoryLine) | **POST** /v1/directory-line/search | Search for a directory line |
| [**searchDirectoryLineWithHttpInfo**](DirectoryLineApi.md#searchDirectoryLineWithHttpInfo) | **POST** /v1/directory-line/search | Search for a directory line |



## getDirectoryLineById

> DirectoryLinePayloadLegalUnitFacilityRoutingCode getDirectoryLineById(addressingIdentifier, include, fields)

Get a directory line.

Retrieve the data from the directory line corresponding to the identifier passed in parameters.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.DirectoryLineApi;

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

        DirectoryLineApi apiInstance = new DirectoryLineApi(defaultClient);
        String addressingIdentifier = "dcsc456sdcsdcs556"; // String | Addressing identifier of the directory line
        List<String> include = Arrays.asList(); // List<String> | Relations to include in the response..
        List<DirectoryLineField> fields = Arrays.asList(); // List<DirectoryLineField> | Fields of the Directory Line resource
        try {
            DirectoryLinePayloadLegalUnitFacilityRoutingCode result = apiInstance.getDirectoryLineById(addressingIdentifier, include, fields);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DirectoryLineApi#getDirectoryLineById");
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
| **addressingIdentifier** | **String**| Addressing identifier of the directory line | |
| **include** | [**List&lt;String&gt;**](String.md)| Relations to include in the response.. | [optional] [enum: siren, siret, routingCode] |
| **fields** | [**List&lt;DirectoryLineField&gt;**](DirectoryLineField.md)| Fields of the Directory Line resource | [optional] |

### Return type

[**DirectoryLinePayloadLegalUnitFacilityRoutingCode**](DirectoryLinePayloadLegalUnitFacilityRoutingCode.md)


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Retourns a directory line. |  -  |
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

## getDirectoryLineByIdWithHttpInfo

> ApiResponse<DirectoryLinePayloadLegalUnitFacilityRoutingCode> getDirectoryLineById getDirectoryLineByIdWithHttpInfo(addressingIdentifier, include, fields)

Get a directory line.

Retrieve the data from the directory line corresponding to the identifier passed in parameters.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.DirectoryLineApi;

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

        DirectoryLineApi apiInstance = new DirectoryLineApi(defaultClient);
        String addressingIdentifier = "dcsc456sdcsdcs556"; // String | Addressing identifier of the directory line
        List<String> include = Arrays.asList(); // List<String> | Relations to include in the response..
        List<DirectoryLineField> fields = Arrays.asList(); // List<DirectoryLineField> | Fields of the Directory Line resource
        try {
            ApiResponse<DirectoryLinePayloadLegalUnitFacilityRoutingCode> response = apiInstance.getDirectoryLineByIdWithHttpInfo(addressingIdentifier, include, fields);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling DirectoryLineApi#getDirectoryLineById");
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
| **addressingIdentifier** | **String**| Addressing identifier of the directory line | |
| **include** | [**List&lt;String&gt;**](String.md)| Relations to include in the response.. | [optional] [enum: siren, siret, routingCode] |
| **fields** | [**List&lt;DirectoryLineField&gt;**](DirectoryLineField.md)| Fields of the Directory Line resource | [optional] |

### Return type

ApiResponse<[**DirectoryLinePayloadLegalUnitFacilityRoutingCode**](DirectoryLinePayloadLegalUnitFacilityRoutingCode.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Retourns a directory line. |  -  |
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


## searchDirectoryLine

> DirectoryLineSearchPost200Response searchDirectoryLine(searchDirectoryLine)

Search for a directory line

Search for directory lines that meet all the criteria passed as parameters and return the results in the desired format.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.DirectoryLineApi;

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

        DirectoryLineApi apiInstance = new DirectoryLineApi(defaultClient);
        SearchDirectoryLine searchDirectoryLine = new SearchDirectoryLine(); // SearchDirectoryLine | 
        try {
            DirectoryLineSearchPost200Response result = apiInstance.searchDirectoryLine(searchDirectoryLine);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DirectoryLineApi#searchDirectoryLine");
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
| **searchDirectoryLine** | [**SearchDirectoryLine**](SearchDirectoryLine.md)|  | [optional] |

### Return type

[**DirectoryLineSearchPost200Response**](DirectoryLineSearchPost200Response.md)


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | returns the directory line(s) matching the search criteria. |  -  |
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

## searchDirectoryLineWithHttpInfo

> ApiResponse<DirectoryLineSearchPost200Response> searchDirectoryLine searchDirectoryLineWithHttpInfo(searchDirectoryLine)

Search for a directory line

Search for directory lines that meet all the criteria passed as parameters and return the results in the desired format.

### Example

```java
// Import classes:
import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Configuration;
import fr.neotimo.xpz12013.directory.auth.*;
import fr.neotimo.xpz12013.directory.models.*;
import fr.neotimo.xpz12013.directory.api.DirectoryLineApi;

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

        DirectoryLineApi apiInstance = new DirectoryLineApi(defaultClient);
        SearchDirectoryLine searchDirectoryLine = new SearchDirectoryLine(); // SearchDirectoryLine | 
        try {
            ApiResponse<DirectoryLineSearchPost200Response> response = apiInstance.searchDirectoryLineWithHttpInfo(searchDirectoryLine);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling DirectoryLineApi#searchDirectoryLine");
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
| **searchDirectoryLine** | [**SearchDirectoryLine**](SearchDirectoryLine.md)|  | [optional] |

### Return type

ApiResponse<[**DirectoryLineSearchPost200Response**](DirectoryLineSearchPost200Response.md)>


### Authorization

[OAuth2](../README.md#OAuth2), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json, application/problem+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | returns the directory line(s) matching the search criteria. |  -  |
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

