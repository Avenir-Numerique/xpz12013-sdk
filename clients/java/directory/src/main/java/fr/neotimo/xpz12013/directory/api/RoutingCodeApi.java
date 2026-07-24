/*
 * AFNOR Directory Service
 *  The __Directory Service__ API allows you to: - View and search for companies (SIREN) - View and search for establishments (SIRET) - View, and search for routing codes - View, and search for directory entries  **Authentication :** Each endpoint must be called with an access token (Bearer). This token is retrieved by a call to a token URL.  --- ## Siren  Company by Siren number  - `POST /siren/search` => Search for companies (legal unit) meeting all the criteria passed as parameters, potentially multiple results returned.   - Permissions : _according to your permissions_   - **Request Body** : `{ <search criteria in JSON format> }`     - filters : the list of filters to apply to the search.     - sorting : sorting criteria by field with ascending or descending value.     - fields : the list of fields expected in the response.     - limit : the maximum number of results to return.     - ignore : a number designating the offset to apply to the returned results. Useful for pagination.   - Réponse : a paginated list of siren resources (legal unit).  - `GET /siren/code-insee:{siren}` => Consult a siren (legal unit) identified by a siren passed as a parameter.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIREN number.   - Response : the details of a siren resource (legal unit).  ### Scenarios  Example scenarios :  1. `POST /siren/search` => Search for companies (legal units) meeting all the criteria passed as parameters, potentially returning multiple results.  2. `GET /siren/code-insee:{siren}` => Get company details.  --- ## Siret  Facility by SIRET number  - `POST /siret/search` =>  Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - include: the list of relationships (siren) to include in the returned results.     - limit: the maximum number of results to return.     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of SIRET (facility) resources.  - `GET /siret/code-insee:{siret}` => Get a SIRET (facility) identified by SIRET.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIRET number.   - Response : the details of a SIRET resource (facility).  ### Scenarios  Example scenarios :  1. `POST /siret/search` => Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.  2. `GET /siret/code-insee:{siret}` => Get the facility details.  --- ## Routing Code  - `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of routing code resources.  - `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Consult the routing code identified by the SIRET and a routing identifier.   - Permissions : _according to your permissions_   - Mandatory parameter: the SIRET number of the routing code for which you wish to obtain details.    - Mandatory parameter: the routing identifier for which you want to obtain details.   - Response : the detail of a routing code.  ### Scenarios  Example scenarios :  1. `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.  2. `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Get the details of a routing code by SIRET and a routing identifier. --- ## Directory Line  The directory line is the location at which the recipient wishes to receive his invoices (SIREN or SIREN/SIRET or SIREN/SIRET/routingIdentifier). The routing identifier can be a service code, a GLN 0224 code, an ODETTE 0088 code or an internal management code used by the recipient.  - `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of directory-line resources  - `GET /directory-line/code:{addressing-identifier}` => Get a line in the directory identified by an address identifier.   - Permissions : _according to your permissions_   -Mandatory parameter: un identifiant addressage.   - Response : the detail of a directory line.  ### Scenarios  Example scenarios :    1. `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.    2. `GET /directory-line/code:{addressing-identifier}` => Get a directory line.  --- ## Supervisor  - `GET /healthcheck` => Check if the Directory API is online.   - Permissions : _according to your permissions_   History:   - `1.0.0` : First release   - `1.1.0` : Fixes following SG5 meeting     - Remove the concept of history     - Remove the platformRegistrationNumber, effectiveEndDate, dateFrom and dateTo from the available filters, the payloads and the responses     - Remove PUT /v1/directory-line/id-instance:{id-instance}     - Add the major version number in the path      - Remove the PPF-affiliations from the headers     - Standardize the language so that no French remains in the SWAGGER     - Standardize the responses from GET /v1/siret/id-instance:{id-instance} and GET /v1/siret/code-insee:{siren}     - Modify the routingCode regex     - Change PDP to PA     - Translate PPF and PA into a UNTDID 3035 code   - `1.2.0` : Fixes following 2026/01/12 SG5 meeting     - __WARNING: Breaking changes occured in this version__     - Remove POST /v1/directory-line     - Remove DELETE /v1/directory-line/id-instance:{id-instance}     - Remove PATCH /v1/directory-line/id-instance:{id-instance}     - Remove GET /v1/siren/id-instance:{id-instance}     - Remove GET /v1/siret/id-instance:{id-instance}     - Remove GET /v1/routing-code/id-instance:{id-instance}     - Remove GET /v1/directory-line/id-instance:{id-instance}     - Remove id-instance from the ressource fields     - Change platformStatus into directoryLineStatus     - Add Upcoming as a directoryLineStatus option      - Add OAuth2 security scheme     - Remove Accept-language and Content-Language from the header     - Change diffusible into salesProspectingForbidden     - Add 204 response for search routes   - `1.3.0` : Fixes following SG5 meeting     - Add directoryLineStatus to the GET /v1/directory-line/code:{addressing-identifier} response     - Remove 206 response for search route     - Add include to the POST /v1/directory-line/search     - Add base path in server URL     - Add instructions to included legalUnit and facility     - Change behavior for nb of returned results (-1 if not managed)     - Remove 204 error codes for search routes     - Set default ignore to 0     - Add startWith operator to businessName, name, addressLines and postalCode     - Match exemple and schema for order (sorting) 
 *
 * The version of the OpenAPI document: 1.3.0
 * Contact: sg5@afnor.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package fr.neotimo.xpz12013.directory.api;

import fr.neotimo.xpz12013.directory.ApiClient;
import fr.neotimo.xpz12013.directory.ApiException;
import fr.neotimo.xpz12013.directory.ApiResponse;
import fr.neotimo.xpz12013.directory.Pair;

import fr.neotimo.xpz12013.directory.model.Error;
import fr.neotimo.xpz12013.directory.model.RoutingCodeField;
import fr.neotimo.xpz12013.directory.model.RoutingCodePayloadHistoryLegalUnitFacility;
import fr.neotimo.xpz12013.directory.model.RoutingCodeSearch;
import fr.neotimo.xpz12013.directory.model.RoutingCodeSearchPost200Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class RoutingCodeApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public RoutingCodeApi() {
    this(new ApiClient());
  }

  public RoutingCodeApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Get a routing code by SIRET and routing identifier
   * Retrieve the Routing Code data corresponding to the identifier passed in parameters.
   * @param siret SIRET number of a facility. (required)
   * @param routingIdentifier Routing Identifier of a routing code (required)
   * @param include Relations to include in the response. (optional)
   * @param fields Fields of the Routing Code resource (optional)
   * @return RoutingCodePayloadHistoryLegalUnitFacility
   * @throws ApiException if fails to make API call
   */
  public RoutingCodePayloadHistoryLegalUnitFacility getRoutingCodeBySiretAndId(String siret, String routingIdentifier, List<String> include, List<RoutingCodeField> fields) throws ApiException {
    ApiResponse<RoutingCodePayloadHistoryLegalUnitFacility> localVarResponse = getRoutingCodeBySiretAndIdWithHttpInfo(siret, routingIdentifier, include, fields);
    return localVarResponse.getData();
  }

  /**
   * Get a routing code by SIRET and routing identifier
   * Retrieve the Routing Code data corresponding to the identifier passed in parameters.
   * @param siret SIRET number of a facility. (required)
   * @param routingIdentifier Routing Identifier of a routing code (required)
   * @param include Relations to include in the response. (optional)
   * @param fields Fields of the Routing Code resource (optional)
   * @return ApiResponse&lt;RoutingCodePayloadHistoryLegalUnitFacility&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<RoutingCodePayloadHistoryLegalUnitFacility> getRoutingCodeBySiretAndIdWithHttpInfo(String siret, String routingIdentifier, List<String> include, List<RoutingCodeField> fields) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getRoutingCodeBySiretAndIdRequestBuilder(siret, routingIdentifier, include, fields);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getRoutingCodeBySiretAndId", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<RoutingCodePayloadHistoryLegalUnitFacility>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<RoutingCodePayloadHistoryLegalUnitFacility>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<RoutingCodePayloadHistoryLegalUnitFacility>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getRoutingCodeBySiretAndIdRequestBuilder(String siret, String routingIdentifier, List<String> include, List<RoutingCodeField> fields) throws ApiException {
    // verify the required parameter 'siret' is set
    if (siret == null) {
      throw new ApiException(400, "Missing the required parameter 'siret' when calling getRoutingCodeBySiretAndId");
    }
    // verify the required parameter 'routingIdentifier' is set
    if (routingIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'routingIdentifier' when calling getRoutingCodeBySiretAndId");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/v1/routing-code/siret:{siret}/code:{routing-identifier}"
        .replace("{siret}", ApiClient.urlEncode(siret.toString()))
        .replace("{routing-identifier}", ApiClient.urlEncode(routingIdentifier.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "include";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("csv", "include", include));
    localVarQueryParameterBaseName = "fields";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("csv", "fields", fields));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json, application/problem+json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Search for a routing code
   * Search for routing codes that meet all the criteria passed as parameters and return the routing codes in the desired format.
   * @param routingCodeSearch  (required)
   * @return RoutingCodeSearchPost200Response
   * @throws ApiException if fails to make API call
   */
  public RoutingCodeSearchPost200Response searchRoutingCode(RoutingCodeSearch routingCodeSearch) throws ApiException {
    ApiResponse<RoutingCodeSearchPost200Response> localVarResponse = searchRoutingCodeWithHttpInfo(routingCodeSearch);
    return localVarResponse.getData();
  }

  /**
   * Search for a routing code
   * Search for routing codes that meet all the criteria passed as parameters and return the routing codes in the desired format.
   * @param routingCodeSearch  (required)
   * @return ApiResponse&lt;RoutingCodeSearchPost200Response&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<RoutingCodeSearchPost200Response> searchRoutingCodeWithHttpInfo(RoutingCodeSearch routingCodeSearch) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = searchRoutingCodeRequestBuilder(routingCodeSearch);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("searchRoutingCode", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<RoutingCodeSearchPost200Response>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<RoutingCodeSearchPost200Response>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<RoutingCodeSearchPost200Response>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder searchRoutingCodeRequestBuilder(RoutingCodeSearch routingCodeSearch) throws ApiException {
    // verify the required parameter 'routingCodeSearch' is set
    if (routingCodeSearch == null) {
      throw new ApiException(400, "Missing the required parameter 'routingCodeSearch' when calling searchRoutingCode");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/v1/routing-code/search";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json, application/problem+json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(routingCodeSearch);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

}
