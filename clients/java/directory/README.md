# xpz12013-directory

AFNOR Directory Service

- API version: 1.3.0

- Generator version: 7.11.0


The __Directory Service__ API allows you to:
- View and search for companies (SIREN)
- View and search for establishments (SIRET)
- View, and search for routing codes
- View, and search for directory entries

**Authentication :** Each endpoint must be called with an access token (Bearer). This token is retrieved by a call to a token URL.

---
## Siren

Company by Siren number

- `POST /siren/search` => Search for companies (legal unit) meeting all the criteria passed as parameters, potentially multiple results returned.
  - Permissions : _according to your permissions_
  - **Request Body** : `{ <search criteria in JSON format> }`
    - filters : the list of filters to apply to the search.
    - sorting : sorting criteria by field with ascending or descending value.
    - fields : the list of fields expected in the response.
    - limit : the maximum number of results to return.
    - ignore : a number designating the offset to apply to the returned results. Useful for pagination.
  - Réponse : a paginated list of siren resources (legal unit).

- `GET /siren/code-insee:{siren}` => Consult a siren (legal unit) identified by a siren passed as a parameter.
  - Permissions : _according to your permissions_
  - Mandatory parameter: a SIREN number.
  - Response : the details of a siren resource (legal unit).

### Scenarios

Example scenarios :

1. `POST /siren/search` => Search for companies (legal units) meeting all the criteria passed as parameters, potentially returning multiple results.

2. `GET /siren/code-insee:{siren}` => Get company details.

---
## Siret

Facility by SIRET number

- `POST /siret/search` =>  Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.
  - Permissions : _according to your permissions_
  - **Request body** : `{ <search criteria in JSON format> }`
    - filters: the list of filters to apply to the search.
    - sorting: sort criteria by field with ascending or descending value.
    - fields: the list of fields expected in the response.
    - include: the list of relationships (siren) to include in the returned results.
    - limit: the maximum number of results to return.
    - ignore: A number designating the offset to apply to the returned results. Useful for pagination.
  - Response : a paginated list of SIRET (facility) resources.

- `GET /siret/code-insee:{siret}` => Get a SIRET (facility) identified by SIRET.
  - Permissions : _according to your permissions_
  - Mandatory parameter: a SIRET number.
  - Response : the details of a SIRET resource (facility).

### Scenarios

Example scenarios :

1. `POST /siret/search` => Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.

2. `GET /siret/code-insee:{siret}` => Get the facility details.

---
## Routing Code

- `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.
  - Permissions : _according to your permissions_
  - **Request body** : `{ <search criteria in JSON format> }`
    - filters: the list of filters to apply to the search.
    - sorting: sort criteria by field with ascending or descending value.
    - fields: the list of fields expected in the response.
    - limit: the maximum number of results to return
    - ignore: A number designating the offset to apply to the returned results. Useful for pagination.
  - Response : a paginated list of routing code resources.

- `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Consult the routing code identified by the SIRET and a routing identifier.
  - Permissions : _according to your permissions_
  - Mandatory parameter: the SIRET number of the routing code for which you wish to obtain details. 
  - Mandatory parameter: the routing identifier for which you want to obtain details.
  - Response : the detail of a routing code.

### Scenarios

Example scenarios :

1. `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.

2. `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Get the details of a routing code by SIRET and a routing identifier.
---
## Directory Line

The directory line is the location at which the recipient wishes to receive his invoices (SIREN or SIREN/SIRET or SIREN/SIRET/routingIdentifier). The routing identifier can be a service code, a GLN 0224 code, an ODETTE 0088 code or an internal management code used by the recipient.

- `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.
  - Permissions : _according to your permissions_
  - **Request body** : `{ <search criteria in JSON format> }`
    - filters: the list of filters to apply to the search.
    - sorting: sort criteria by field with ascending or descending value.
    - fields: the list of fields expected in the response.
    - limit: the maximum number of results to return
    - ignore: A number designating the offset to apply to the returned results. Useful for pagination.
  - Response : a paginated list of directory-line resources

- `GET /directory-line/code:{addressing-identifier}` => Get a line in the directory identified by an address identifier.
  - Permissions : _according to your permissions_
  -Mandatory parameter: un identifiant addressage.
  - Response : the detail of a directory line.

### Scenarios

Example scenarios :

  1. `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.

  2. `GET /directory-line/code:{addressing-identifier}` => Get a directory line.

---
## Supervisor

- `GET /healthcheck` => Check if the Directory API is online.
  - Permissions : _according to your permissions_


History:
  - `1.0.0` : First release
  - `1.1.0` : Fixes following SG5 meeting
    - Remove the concept of history
    - Remove the platformRegistrationNumber, effectiveEndDate, dateFrom and dateTo from the available filters, the payloads and the responses
    - Remove PUT /v1/directory-line/id-instance:{id-instance}
    - Add the major version number in the path 
    - Remove the PPF-affiliations from the headers
    - Standardize the language so that no French remains in the SWAGGER
    - Standardize the responses from GET /v1/siret/id-instance:{id-instance} and GET /v1/siret/code-insee:{siren}
    - Modify the routingCode regex
    - Change PDP to PA
    - Translate PPF and PA into a UNTDID 3035 code
  - `1.2.0` : Fixes following 2026/01/12 SG5 meeting
    - __WARNING: Breaking changes occured in this version__
    - Remove POST /v1/directory-line
    - Remove DELETE /v1/directory-line/id-instance:{id-instance}
    - Remove PATCH /v1/directory-line/id-instance:{id-instance}
    - Remove GET /v1/siren/id-instance:{id-instance}
    - Remove GET /v1/siret/id-instance:{id-instance}
    - Remove GET /v1/routing-code/id-instance:{id-instance}
    - Remove GET /v1/directory-line/id-instance:{id-instance}
    - Remove id-instance from the ressource fields
    - Change platformStatus into directoryLineStatus
    - Add Upcoming as a directoryLineStatus option 
    - Add OAuth2 security scheme
    - Remove Accept-language and Content-Language from the header
    - Change diffusible into salesProspectingForbidden
    - Add 204 response for search routes
  - `1.3.0` : Fixes following SG5 meeting
    - Add directoryLineStatus to the GET /v1/directory-line/code:{addressing-identifier} response
    - Remove 206 response for search route
    - Add include to the POST /v1/directory-line/search
    - Add base path in server URL
    - Add instructions to included legalUnit and facility
    - Change behavior for nb of returned results (-1 if not managed)
    - Remove 204 error codes for search routes
    - Set default ignore to 0
    - Add startWith operator to businessName, name, addressLines and postalCode
    - Match exemple and schema for order (sorting)



*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 11+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>fr.neotimo</groupId>
  <artifactId>xpz12013-directory</artifactId>
  <version>1.3.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "fr.neotimo:xpz12013-directory:1.3.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/xpz12013-directory-1.3.0.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import fr.neotimo.xpz12013.directory.*;
import fr.neotimo.xpz12013.directory.model.*;
import fr.neotimo.xpz12013.directory.api.DirectoryLineApi;

public class DirectoryLineApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        // Configure clients using the `defaultClient` object, such as
        // overriding the host and port, timeout, etc.
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

## Documentation for API Endpoints

All URIs are relative to *https://api.directory.company.com/directory-service*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DirectoryLineApi* | [**getDirectoryLineById**](docs/DirectoryLineApi.md#getDirectoryLineById) | **GET** /v1/directory-line/code:{addressing-identifier} | Get a directory line.
*DirectoryLineApi* | [**getDirectoryLineByIdWithHttpInfo**](docs/DirectoryLineApi.md#getDirectoryLineByIdWithHttpInfo) | **GET** /v1/directory-line/code:{addressing-identifier} | Get a directory line.
*DirectoryLineApi* | [**searchDirectoryLine**](docs/DirectoryLineApi.md#searchDirectoryLine) | **POST** /v1/directory-line/search | Search for a directory line
*DirectoryLineApi* | [**searchDirectoryLineWithHttpInfo**](docs/DirectoryLineApi.md#searchDirectoryLineWithHttpInfo) | **POST** /v1/directory-line/search | Search for a directory line
*RoutingCodeApi* | [**getRoutingCodeBySiretAndId**](docs/RoutingCodeApi.md#getRoutingCodeBySiretAndId) | **GET** /v1/routing-code/siret:{siret}/code:{routing-identifier} | Get a routing code by SIRET and routing identifier
*RoutingCodeApi* | [**getRoutingCodeBySiretAndIdWithHttpInfo**](docs/RoutingCodeApi.md#getRoutingCodeBySiretAndIdWithHttpInfo) | **GET** /v1/routing-code/siret:{siret}/code:{routing-identifier} | Get a routing code by SIRET and routing identifier
*RoutingCodeApi* | [**searchRoutingCode**](docs/RoutingCodeApi.md#searchRoutingCode) | **POST** /v1/routing-code/search | Search for a routing code
*RoutingCodeApi* | [**searchRoutingCodeWithHttpInfo**](docs/RoutingCodeApi.md#searchRoutingCodeWithHttpInfo) | **POST** /v1/routing-code/search | Search for a routing code
*SirenApi* | [**getCompanyBySiren**](docs/SirenApi.md#getCompanyBySiren) | **GET** /v1/siren/code-insee:{siren} | Consult a siren (legal unit) by SIREN number
*SirenApi* | [**getCompanyBySirenWithHttpInfo**](docs/SirenApi.md#getCompanyBySirenWithHttpInfo) | **GET** /v1/siren/code-insee:{siren} | Consult a siren (legal unit) by SIREN number
*SirenApi* | [**searchCompanyBySiren**](docs/SirenApi.md#searchCompanyBySiren) | **POST** /v1/siren/search | SIREN search (or legal unit)
*SirenApi* | [**searchCompanyBySirenWithHttpInfo**](docs/SirenApi.md#searchCompanyBySirenWithHttpInfo) | **POST** /v1/siren/search | SIREN search (or legal unit)
*SiretApi* | [**getFacilityBySiret**](docs/SiretApi.md#getFacilityBySiret) | **GET** /v1/siret/code-insee:{siret} | Gets a siret (facility) by SIRET number
*SiretApi* | [**getFacilityBySiretWithHttpInfo**](docs/SiretApi.md#getFacilityBySiretWithHttpInfo) | **GET** /v1/siret/code-insee:{siret} | Gets a siret (facility) by SIRET number
*SiretApi* | [**searchFacilityBySiret**](docs/SiretApi.md#searchFacilityBySiret) | **POST** /v1/siret/search | Search for a SIRET (facility)
*SiretApi* | [**searchFacilityBySiretWithHttpInfo**](docs/SiretApi.md#searchFacilityBySiretWithHttpInfo) | **POST** /v1/siret/search | Search for a SIRET (facility)
*SupervisorApi* | [**getHealth**](docs/SupervisorApi.md#getHealth) | **GET** /v1/healthcheck | Checks if the API connection is operational.
*SupervisorApi* | [**getHealthWithHttpInfo**](docs/SupervisorApi.md#getHealthWithHttpInfo) | **GET** /v1/healthcheck | Checks if the API connection is operational.


## Documentation for Models

 - [AddressRead](docs/AddressRead.md)
 - [ContainsOrStartWithOperator](docs/ContainsOrStartWithOperator.md)
 - [ContainsOrStrictOperator](docs/ContainsOrStrictOperator.md)
 - [ContainsOrStrictOrStartWithOperator](docs/ContainsOrStrictOrStartWithOperator.md)
 - [DirectoryLineField](docs/DirectoryLineField.md)
 - [DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode](docs/DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.md)
 - [DirectoryLinePayloadLegalUnitFacilityRoutingCode](docs/DirectoryLinePayloadLegalUnitFacilityRoutingCode.md)
 - [DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode](docs/DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode.md)
 - [DirectoryLineSearchPost200Response](docs/DirectoryLineSearchPost200Response.md)
 - [DirectoryLineStatus](docs/DirectoryLineStatus.md)
 - [EntityType](docs/EntityType.md)
 - [Error](docs/Error.md)
 - [FacilityAdministrativeStatus](docs/FacilityAdministrativeStatus.md)
 - [FacilityPayloadHistory](docs/FacilityPayloadHistory.md)
 - [FacilityPayloadHistoryUleB2gAdditionalData](docs/FacilityPayloadHistoryUleB2gAdditionalData.md)
 - [FacilityPayloadIncluded](docs/FacilityPayloadIncluded.md)
 - [FacilityType](docs/FacilityType.md)
 - [LegalUnitAdministrativeStatus](docs/LegalUnitAdministrativeStatus.md)
 - [LegalUnitPayloadHistory](docs/LegalUnitPayloadHistory.md)
 - [LegalUnitPayloadIncluded](docs/LegalUnitPayloadIncluded.md)
 - [RecipientPlatformType](docs/RecipientPlatformType.md)
 - [RoutingCodeAdministrativeStatus](docs/RoutingCodeAdministrativeStatus.md)
 - [RoutingCodeField](docs/RoutingCodeField.md)
 - [RoutingCodePayloadHistoryLegalUnitFacility](docs/RoutingCodePayloadHistoryLegalUnitFacility.md)
 - [RoutingCodeSearch](docs/RoutingCodeSearch.md)
 - [RoutingCodeSearchFilters](docs/RoutingCodeSearchFilters.md)
 - [RoutingCodeSearchFiltersAdministrativeStatus](docs/RoutingCodeSearchFiltersAdministrativeStatus.md)
 - [RoutingCodeSearchFiltersRoutingCodeName](docs/RoutingCodeSearchFiltersRoutingCodeName.md)
 - [RoutingCodeSearchFiltersRoutingIdentifier](docs/RoutingCodeSearchFiltersRoutingIdentifier.md)
 - [RoutingCodeSearchPost200Response](docs/RoutingCodeSearchPost200Response.md)
 - [RoutingCodeSearchSortingInner](docs/RoutingCodeSearchSortingInner.md)
 - [SearchDirectoryLine](docs/SearchDirectoryLine.md)
 - [SearchDirectoryLineFilters](docs/SearchDirectoryLineFilters.md)
 - [SearchDirectoryLineFiltersAddressingIdentifier](docs/SearchDirectoryLineFiltersAddressingIdentifier.md)
 - [SearchDirectoryLineFiltersAddressingSuffix](docs/SearchDirectoryLineFiltersAddressingSuffix.md)
 - [SearchDirectoryLineSortingInner](docs/SearchDirectoryLineSortingInner.md)
 - [SearchSiren](docs/SearchSiren.md)
 - [SearchSirenFilters](docs/SearchSirenFilters.md)
 - [SearchSirenFiltersAdministrativeStatus](docs/SearchSirenFiltersAdministrativeStatus.md)
 - [SearchSirenFiltersBusinessName](docs/SearchSirenFiltersBusinessName.md)
 - [SearchSirenFiltersEntityType](docs/SearchSirenFiltersEntityType.md)
 - [SearchSirenFiltersSiren](docs/SearchSirenFiltersSiren.md)
 - [SearchSirenSortingInner](docs/SearchSirenSortingInner.md)
 - [SearchSiret](docs/SearchSiret.md)
 - [SearchSiretFilters](docs/SearchSiretFilters.md)
 - [SearchSiretFiltersAddressLines](docs/SearchSiretFiltersAddressLines.md)
 - [SearchSiretFiltersAdministrativeStatus](docs/SearchSiretFiltersAdministrativeStatus.md)
 - [SearchSiretFiltersCountrySubdivision](docs/SearchSiretFiltersCountrySubdivision.md)
 - [SearchSiretFiltersFacilityType](docs/SearchSiretFiltersFacilityType.md)
 - [SearchSiretFiltersLocality](docs/SearchSiretFiltersLocality.md)
 - [SearchSiretFiltersName](docs/SearchSiretFiltersName.md)
 - [SearchSiretFiltersPostalCode](docs/SearchSiretFiltersPostalCode.md)
 - [SearchSiretFiltersSiret](docs/SearchSiretFiltersSiret.md)
 - [SearchSiretSortingInner](docs/SearchSiretSortingInner.md)
 - [SirenField](docs/SirenField.md)
 - [SirenInstructions](docs/SirenInstructions.md)
 - [SirenSearchPost200Response](docs/SirenSearchPost200Response.md)
 - [SiretField](docs/SiretField.md)
 - [SiretInstructions](docs/SiretInstructions.md)
 - [SiretSearchPost200Response](docs/SiretSearchPost200Response.md)
 - [SortingOrder](docs/SortingOrder.md)
 - [StrictOperator](docs/StrictOperator.md)
 - [StrictOrStartWithOperator](docs/StrictOrStartWithOperator.md)
 - [UniqueDirectoryLineStatus](docs/UniqueDirectoryLineStatus.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="bearerAuth"></a>
### bearerAuth


- **Type**: HTTP Bearer Token authentication (JWT)

<a id="OAuth2"></a>
### OAuth2


- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: N/A


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.
However, the instances of the api clients created from the `ApiClient` are thread-safe and can be re-used.

## Author

sg5@afnor.org

