# neotimo-xpz12013-directory

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


This Python package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: 1.2.0
- Package version: 1.2.0
- Generator version: 7.11.0
- Build package: org.openapitools.codegen.languages.PythonClientCodegen

## Requirements.

Python 3.8+

## Installation & Usage
### pip install

If the python package is hosted on a repository, you can install directly using:

```sh
pip install git+https://github.com/GIT_USER_ID/GIT_REPO_ID.git
```
(you may need to run `pip` with root permission: `sudo pip install git+https://github.com/GIT_USER_ID/GIT_REPO_ID.git`)

Then import the package:
```python
import neotimo_xpz12013_directory
```

### Setuptools

Install via [Setuptools](http://pypi.python.org/pypi/setuptools).

```sh
python setup.py install --user
```
(or `sudo python setup.py install` to install the package for all users)

Then import the package:
```python
import neotimo_xpz12013_directory
```

### Tests

Execute `pytest` to run the tests.

## Getting Started

Please follow the [installation procedure](#installation--usage) and then run the following:

```python

import neotimo_xpz12013_directory
from neotimo_xpz12013_directory.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.directory.company.com/directory-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_directory.Configuration(
    host = "https://api.directory.company.com/directory-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): bearerAuth
configuration = neotimo_xpz12013_directory.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)


# Enter a context with an instance of the API client
with neotimo_xpz12013_directory.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_directory.DirectoryLineApi(api_client)
    addressing_identifier = 'dcsc456sdcsdcs556' # str | Addressing identifier of the directory line
    include = ['[\"siren\",\"siret\",\"routingCode\"]'] # List[str] | Relations to include in the response.. (optional)
    fields = [neotimo_xpz12013_directory.DirectoryLineField()] # List[DirectoryLineField] | Fields of the Directory Line resource (optional)

    try:
        # Get a directory line.
        api_response = api_instance.get_directory_line_by_id(addressing_identifier, include=include, fields=fields)
        print("The response of DirectoryLineApi->get_directory_line_by_id:\n")
        pprint(api_response)
    except ApiException as e:
        print("Exception when calling DirectoryLineApi->get_directory_line_by_id: %s\n" % e)

```

## Documentation for API Endpoints

All URIs are relative to *https://api.directory.company.com/directory-service*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DirectoryLineApi* | [**get_directory_line_by_id**](docs/DirectoryLineApi.md#get_directory_line_by_id) | **GET** /v1/directory-line/code:{addressing-identifier} | Get a directory line.
*DirectoryLineApi* | [**search_directory_line**](docs/DirectoryLineApi.md#search_directory_line) | **POST** /v1/directory-line/search | Search for a directory line
*RoutingCodeApi* | [**get_routing_code_by_siret_and_id**](docs/RoutingCodeApi.md#get_routing_code_by_siret_and_id) | **GET** /v1/routing-code/siret:{siret}/code:{routing-identifier} | Get a routing code by SIRET and routing identifier
*RoutingCodeApi* | [**search_routing_code**](docs/RoutingCodeApi.md#search_routing_code) | **POST** /v1/routing-code/search | Search for a routing code
*SirenApi* | [**get_company_by_siren**](docs/SirenApi.md#get_company_by_siren) | **GET** /v1/siren/code-insee:{siren} | Consult a siren (legal unit) by SIREN number
*SirenApi* | [**search_company_by_siren**](docs/SirenApi.md#search_company_by_siren) | **POST** /v1/siren/search | SIREN search (or legal unit)
*SiretApi* | [**get_facility_by_siret**](docs/SiretApi.md#get_facility_by_siret) | **GET** /v1/siret/code-insee:{siret} | Gets a siret (facility) by SIRET number
*SiretApi* | [**search_facility_by_siret**](docs/SiretApi.md#search_facility_by_siret) | **POST** /v1/siret/search | Search for a SIRET (facility)
*SupervisorApi* | [**get_health**](docs/SupervisorApi.md#get_health) | **GET** /v1/healthcheck | Checks if the API connection is operational.


## Documentation For Models

 - [AddressRead](docs/AddressRead.md)
 - [ContainsOperator](docs/ContainsOperator.md)
 - [ContainsOrStrictOperator](docs/ContainsOrStrictOperator.md)
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


<a id="documentation-for-authorization"></a>
## Documentation For Authorization


Authentication schemes defined for the API:
<a id="bearerAuth"></a>
### bearerAuth

- **Type**: Bearer authentication (JWT)

<a id="OAuth2"></a>
### OAuth2

- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: N/A


## Author

sg5@afnor.org


