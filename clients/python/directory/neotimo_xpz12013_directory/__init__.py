# coding: utf-8

# flake8: noqa

"""
    AFNOR Directory Service

     The __Directory Service__ API allows you to: - View and search for companies (SIREN) - View and search for establishments (SIRET) - View, and search for routing codes - View, and search for directory entries  **Authentication :** Each endpoint must be called with an access token (Bearer). This token is retrieved by a call to a token URL.  --- ## Siren  Company by Siren number  - `POST /siren/search` => Search for companies (legal unit) meeting all the criteria passed as parameters, potentially multiple results returned.   - Permissions : _according to your permissions_   - **Request Body** : `{ <search criteria in JSON format> }`     - filters : the list of filters to apply to the search.     - sorting : sorting criteria by field with ascending or descending value.     - fields : the list of fields expected in the response.     - limit : the maximum number of results to return.     - ignore : a number designating the offset to apply to the returned results. Useful for pagination.   - Réponse : a paginated list of siren resources (legal unit).  - `GET /siren/code-insee:{siren}` => Consult a siren (legal unit) identified by a siren passed as a parameter.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIREN number.   - Response : the details of a siren resource (legal unit).  ### Scenarios  Example scenarios :  1. `POST /siren/search` => Search for companies (legal units) meeting all the criteria passed as parameters, potentially returning multiple results.  2. `GET /siren/code-insee:{siren}` => Get company details.  --- ## Siret  Facility by SIRET number  - `POST /siret/search` =>  Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - include: the list of relationships (siren) to include in the returned results.     - limit: the maximum number of results to return.     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of SIRET (facility) resources.  - `GET /siret/code-insee:{siret}` => Get a SIRET (facility) identified by SIRET.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIRET number.   - Response : the details of a SIRET resource (facility).  ### Scenarios  Example scenarios :  1. `POST /siret/search` => Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.  2. `GET /siret/code-insee:{siret}` => Get the facility details.  --- ## Routing Code  - `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of routing code resources.  - `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Consult the routing code identified by the SIRET and a routing identifier.   - Permissions : _according to your permissions_   - Mandatory parameter: the SIRET number of the routing code for which you wish to obtain details.    - Mandatory parameter: the routing identifier for which you want to obtain details.   - Response : the detail of a routing code.  ### Scenarios  Example scenarios :  1. `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.  2. `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Get the details of a routing code by SIRET and a routing identifier. --- ## Directory Line  The directory line is the location at which the recipient wishes to receive his invoices (SIREN or SIREN/SIRET or SIREN/SIRET/routingIdentifier). The routing identifier can be a service code, a GLN 0224 code, an ODETTE 0088 code or an internal management code used by the recipient.  - `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of directory-line resources  - `GET /directory-line/code:{addressing-identifier}` => Get a line in the directory identified by an address identifier.   - Permissions : _according to your permissions_   -Mandatory parameter: un identifiant addressage.   - Response : the detail of a directory line.  ### Scenarios  Example scenarios :    1. `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.    2. `GET /directory-line/code:{addressing-identifier}` => Get a directory line.  --- ## Supervisor  - `GET /healthcheck` => Check if the Directory API is online.   - Permissions : _according to your permissions_   History:   - `1.0.0` : First release   - `1.1.0` : Fixes following SG5 meeting     - Remove the concept of history     - Remove the platformRegistrationNumber, effectiveEndDate, dateFrom and dateTo from the available filters, the payloads and the responses     - Remove PUT /v1/directory-line/id-instance:{id-instance}     - Add the major version number in the path      - Remove the PPF-affiliations from the headers     - Standardize the language so that no French remains in the SWAGGER     - Standardize the responses from GET /v1/siret/id-instance:{id-instance} and GET /v1/siret/code-insee:{siren}     - Modify the routingCode regex     - Change PDP to PA     - Translate PPF and PA into a UNTDID 3035 code   - `1.2.0` : Fixes following 2026/01/12 SG5 meeting     - __WARNING: Breaking changes occured in this version__     - Remove POST /v1/directory-line     - Remove DELETE /v1/directory-line/id-instance:{id-instance}     - Remove PATCH /v1/directory-line/id-instance:{id-instance}     - Remove GET /v1/siren/id-instance:{id-instance}     - Remove GET /v1/siret/id-instance:{id-instance}     - Remove GET /v1/routing-code/id-instance:{id-instance}     - Remove GET /v1/directory-line/id-instance:{id-instance}     - Remove id-instance from the ressource fields     - Change platformStatus into directoryLineStatus     - Add Upcoming as a directoryLineStatus option      - Add OAuth2 security scheme     - Remove Accept-language and Content-Language from the header     - Change diffusible into salesProspectingForbidden     - Add 204 response for search routes 

    The version of the OpenAPI document: 1.2.0
    Contact: sg5@afnor.org
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


__version__ = "1.2.0"

# import apis into sdk package
from neotimo_xpz12013_directory.api.directory_line_api import DirectoryLineApi
from neotimo_xpz12013_directory.api.routing_code_api import RoutingCodeApi
from neotimo_xpz12013_directory.api.siren_api import SirenApi
from neotimo_xpz12013_directory.api.siret_api import SiretApi
from neotimo_xpz12013_directory.api.supervisor_api import SupervisorApi

# import ApiClient
from neotimo_xpz12013_directory.api_response import ApiResponse
from neotimo_xpz12013_directory.api_client import ApiClient
from neotimo_xpz12013_directory.configuration import Configuration
from neotimo_xpz12013_directory.exceptions import OpenApiException
from neotimo_xpz12013_directory.exceptions import ApiTypeError
from neotimo_xpz12013_directory.exceptions import ApiValueError
from neotimo_xpz12013_directory.exceptions import ApiKeyError
from neotimo_xpz12013_directory.exceptions import ApiAttributeError
from neotimo_xpz12013_directory.exceptions import ApiException

# import models into sdk package
from neotimo_xpz12013_directory.models.address_read import AddressRead
from neotimo_xpz12013_directory.models.contains_operator import ContainsOperator
from neotimo_xpz12013_directory.models.contains_or_strict_operator import ContainsOrStrictOperator
from neotimo_xpz12013_directory.models.directory_line_field import DirectoryLineField
from neotimo_xpz12013_directory.models.directory_line_payload_history_legal_unit_facility_routing_code_routing_code import DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode
from neotimo_xpz12013_directory.models.directory_line_payload_legal_unit_facility_routing_code import DirectoryLinePayloadLegalUnitFacilityRoutingCode
from neotimo_xpz12013_directory.models.directory_line_payload_status_legal_unit_facility_routing_code import DirectoryLinePayloadStatusLegalUnitFacilityRoutingCode
from neotimo_xpz12013_directory.models.directory_line_search_post200_response import DirectoryLineSearchPost200Response
from neotimo_xpz12013_directory.models.directory_line_status import DirectoryLineStatus
from neotimo_xpz12013_directory.models.entity_type import EntityType
from neotimo_xpz12013_directory.models.error import Error
from neotimo_xpz12013_directory.models.facility_administrative_status import FacilityAdministrativeStatus
from neotimo_xpz12013_directory.models.facility_payload_history import FacilityPayloadHistory
from neotimo_xpz12013_directory.models.facility_payload_history_ule_b2g_additional_data import FacilityPayloadHistoryUleB2gAdditionalData
from neotimo_xpz12013_directory.models.facility_payload_included import FacilityPayloadIncluded
from neotimo_xpz12013_directory.models.facility_type import FacilityType
from neotimo_xpz12013_directory.models.legal_unit_administrative_status import LegalUnitAdministrativeStatus
from neotimo_xpz12013_directory.models.legal_unit_payload_history import LegalUnitPayloadHistory
from neotimo_xpz12013_directory.models.legal_unit_payload_included import LegalUnitPayloadIncluded
from neotimo_xpz12013_directory.models.recipient_platform_type import RecipientPlatformType
from neotimo_xpz12013_directory.models.routing_code_administrative_status import RoutingCodeAdministrativeStatus
from neotimo_xpz12013_directory.models.routing_code_field import RoutingCodeField
from neotimo_xpz12013_directory.models.routing_code_payload_history_legal_unit_facility import RoutingCodePayloadHistoryLegalUnitFacility
from neotimo_xpz12013_directory.models.routing_code_search import RoutingCodeSearch
from neotimo_xpz12013_directory.models.routing_code_search_filters import RoutingCodeSearchFilters
from neotimo_xpz12013_directory.models.routing_code_search_filters_administrative_status import RoutingCodeSearchFiltersAdministrativeStatus
from neotimo_xpz12013_directory.models.routing_code_search_filters_routing_code_name import RoutingCodeSearchFiltersRoutingCodeName
from neotimo_xpz12013_directory.models.routing_code_search_filters_routing_identifier import RoutingCodeSearchFiltersRoutingIdentifier
from neotimo_xpz12013_directory.models.routing_code_search_post200_response import RoutingCodeSearchPost200Response
from neotimo_xpz12013_directory.models.routing_code_search_sorting_inner import RoutingCodeSearchSortingInner
from neotimo_xpz12013_directory.models.search_directory_line import SearchDirectoryLine
from neotimo_xpz12013_directory.models.search_directory_line_filters import SearchDirectoryLineFilters
from neotimo_xpz12013_directory.models.search_directory_line_filters_addressing_identifier import SearchDirectoryLineFiltersAddressingIdentifier
from neotimo_xpz12013_directory.models.search_directory_line_filters_addressing_suffix import SearchDirectoryLineFiltersAddressingSuffix
from neotimo_xpz12013_directory.models.search_directory_line_sorting_inner import SearchDirectoryLineSortingInner
from neotimo_xpz12013_directory.models.search_siren import SearchSiren
from neotimo_xpz12013_directory.models.search_siren_filters import SearchSirenFilters
from neotimo_xpz12013_directory.models.search_siren_filters_administrative_status import SearchSirenFiltersAdministrativeStatus
from neotimo_xpz12013_directory.models.search_siren_filters_business_name import SearchSirenFiltersBusinessName
from neotimo_xpz12013_directory.models.search_siren_filters_entity_type import SearchSirenFiltersEntityType
from neotimo_xpz12013_directory.models.search_siren_filters_siren import SearchSirenFiltersSiren
from neotimo_xpz12013_directory.models.search_siren_sorting_inner import SearchSirenSortingInner
from neotimo_xpz12013_directory.models.search_siret import SearchSiret
from neotimo_xpz12013_directory.models.search_siret_filters import SearchSiretFilters
from neotimo_xpz12013_directory.models.search_siret_filters_address_lines import SearchSiretFiltersAddressLines
from neotimo_xpz12013_directory.models.search_siret_filters_administrative_status import SearchSiretFiltersAdministrativeStatus
from neotimo_xpz12013_directory.models.search_siret_filters_country_subdivision import SearchSiretFiltersCountrySubdivision
from neotimo_xpz12013_directory.models.search_siret_filters_facility_type import SearchSiretFiltersFacilityType
from neotimo_xpz12013_directory.models.search_siret_filters_locality import SearchSiretFiltersLocality
from neotimo_xpz12013_directory.models.search_siret_filters_name import SearchSiretFiltersName
from neotimo_xpz12013_directory.models.search_siret_filters_postal_code import SearchSiretFiltersPostalCode
from neotimo_xpz12013_directory.models.search_siret_filters_siret import SearchSiretFiltersSiret
from neotimo_xpz12013_directory.models.search_siret_sorting_inner import SearchSiretSortingInner
from neotimo_xpz12013_directory.models.siren_field import SirenField
from neotimo_xpz12013_directory.models.siren_instructions import SirenInstructions
from neotimo_xpz12013_directory.models.siren_search_post200_response import SirenSearchPost200Response
from neotimo_xpz12013_directory.models.siret_field import SiretField
from neotimo_xpz12013_directory.models.siret_instructions import SiretInstructions
from neotimo_xpz12013_directory.models.siret_search_post200_response import SiretSearchPost200Response
from neotimo_xpz12013_directory.models.sorting_order import SortingOrder
from neotimo_xpz12013_directory.models.strict_operator import StrictOperator
from neotimo_xpz12013_directory.models.strict_or_start_with_operator import StrictOrStartWithOperator
