# coding: utf-8

"""
    AFNOR Directory Service

     The __Directory Service__ API allows you to: - View and search for companies (SIREN) - View and search for establishments (SIRET) - View, and search for routing codes - View, and search for directory entries  **Authentication :** Each endpoint must be called with an access token (Bearer). This token is retrieved by a call to a token URL.  --- ## Siren  Company by Siren number  - `POST /siren/search` => Search for companies (legal unit) meeting all the criteria passed as parameters, potentially multiple results returned.   - Permissions : _according to your permissions_   - **Request Body** : `{ <search criteria in JSON format> }`     - filters : the list of filters to apply to the search.     - sorting : sorting criteria by field with ascending or descending value.     - fields : the list of fields expected in the response.     - limit : the maximum number of results to return.     - ignore : a number designating the offset to apply to the returned results. Useful for pagination.   - Réponse : a paginated list of siren resources (legal unit).  - `GET /siren/code-insee:{siren}` => Consult a siren (legal unit) identified by a siren passed as a parameter.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIREN number.   - Response : the details of a siren resource (legal unit).  ### Scenarios  Example scenarios :  1. `POST /siren/search` => Search for companies (legal units) meeting all the criteria passed as parameters, potentially returning multiple results.  2. `GET /siren/code-insee:{siren}` => Get company details.  --- ## Siret  Facility by SIRET number  - `POST /siret/search` =>  Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - include: the list of relationships (siren) to include in the returned results.     - limit: the maximum number of results to return.     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of SIRET (facility) resources.  - `GET /siret/code-insee:{siret}` => Get a SIRET (facility) identified by SIRET.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIRET number.   - Response : the details of a SIRET resource (facility).  ### Scenarios  Example scenarios :  1. `POST /siret/search` => Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.  2. `GET /siret/code-insee:{siret}` => Get the facility details.  --- ## Routing Code  - `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of routing code resources.  - `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Consult the routing code identified by the SIRET and a routing identifier.   - Permissions : _according to your permissions_   - Mandatory parameter: the SIRET number of the routing code for which you wish to obtain details.    - Mandatory parameter: the routing identifier for which you want to obtain details.   - Response : the detail of a routing code.  ### Scenarios  Example scenarios :  1. `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.  2. `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Get the details of a routing code by SIRET and a routing identifier. --- ## Directory Line  The directory line is the location at which the recipient wishes to receive his invoices (SIREN or SIREN/SIRET or SIREN/SIRET/routingIdentifier). The routing identifier can be a service code, a GLN 0224 code, an ODETTE 0088 code or an internal management code used by the recipient.  - `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of directory-line resources  - `GET /directory-line/code:{addressing-identifier}` => Get a line in the directory identified by an address identifier.   - Permissions : _according to your permissions_   -Mandatory parameter: un identifiant addressage.   - Response : the detail of a directory line.  ### Scenarios  Example scenarios :    1. `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.    2. `GET /directory-line/code:{addressing-identifier}` => Get a directory line.  --- ## Supervisor  - `GET /healthcheck` => Check if the Directory API is online.   - Permissions : _according to your permissions_   History:   - `1.0.0` : First release   - `1.1.0` : Fixes following SG5 meeting     - Remove the concept of history     - Remove the platformRegistrationNumber, effectiveEndDate, dateFrom and dateTo from the available filters, the payloads and the responses     - Remove PUT /v1/directory-line/id-instance:{id-instance}     - Add the major version number in the path      - Remove the PPF-affiliations from the headers     - Standardize the language so that no French remains in the SWAGGER     - Standardize the responses from GET /v1/siret/id-instance:{id-instance} and GET /v1/siret/code-insee:{siren}     - Modify the routingCode regex     - Change PDP to PA     - Translate PPF and PA into a UNTDID 3035 code   - `1.2.0` : Fixes following 2026/01/12 SG5 meeting     - __WARNING: Breaking changes occured in this version__     - Remove POST /v1/directory-line     - Remove DELETE /v1/directory-line/id-instance:{id-instance}     - Remove PATCH /v1/directory-line/id-instance:{id-instance}     - Remove GET /v1/siren/id-instance:{id-instance}     - Remove GET /v1/siret/id-instance:{id-instance}     - Remove GET /v1/routing-code/id-instance:{id-instance}     - Remove GET /v1/directory-line/id-instance:{id-instance}     - Remove id-instance from the ressource fields     - Change platformStatus into directoryLineStatus     - Add Upcoming as a directoryLineStatus option      - Add OAuth2 security scheme     - Remove Accept-language and Content-Language from the header     - Change diffusible into salesProspectingForbidden     - Add 204 response for search routes   - `1.3.0` : Fixes following SG5 meeting     - Add directoryLineStatus to the GET /v1/directory-line/code:{addressing-identifier} response     - Remove 206 response for search route     - Add include to the POST /v1/directory-line/search     - Add base path in server URL     - Add instructions to included legalUnit and facility     - Change behavior for nb of returned results (-1 if not managed)     - Remove 204 error codes for search routes     - Set default ignore to 0     - Add startWith operator to businessName, name, addressLines and postalCode     - Match exemple and schema for order (sorting) 

    The version of the OpenAPI document: 1.3.0
    Contact: sg5@afnor.org
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from pydantic import BaseModel, ConfigDict, Field
from typing import Any, ClassVar, Dict, List, Optional
from neotimo_xpz12013_directory.models.routing_code_search_filters_administrative_status import RoutingCodeSearchFiltersAdministrativeStatus
from neotimo_xpz12013_directory.models.routing_code_search_filters_routing_code_name import RoutingCodeSearchFiltersRoutingCodeName
from neotimo_xpz12013_directory.models.routing_code_search_filters_routing_identifier import RoutingCodeSearchFiltersRoutingIdentifier
from neotimo_xpz12013_directory.models.search_siret_filters_address_lines import SearchSiretFiltersAddressLines
from neotimo_xpz12013_directory.models.search_siret_filters_locality import SearchSiretFiltersLocality
from neotimo_xpz12013_directory.models.search_siret_filters_postal_code import SearchSiretFiltersPostalCode
from neotimo_xpz12013_directory.models.search_siret_filters_siret import SearchSiretFiltersSiret
from typing import Optional, Set
from typing_extensions import Self

class RoutingCodeSearchFilters(BaseModel):
    """
    RoutingCodeSearchFilters
    """ # noqa: E501
    routing_identifier: Optional[RoutingCodeSearchFiltersRoutingIdentifier] = Field(default=None, alias="routingIdentifier")
    siret: Optional[SearchSiretFiltersSiret] = None
    routing_code_name: Optional[RoutingCodeSearchFiltersRoutingCodeName] = Field(default=None, alias="routingCodeName")
    administrative_status: Optional[RoutingCodeSearchFiltersAdministrativeStatus] = Field(default=None, alias="administrativeStatus")
    address_lines: Optional[SearchSiretFiltersAddressLines] = Field(default=None, alias="addressLines")
    postal_code: Optional[SearchSiretFiltersPostalCode] = Field(default=None, alias="postalCode")
    locality: Optional[SearchSiretFiltersLocality] = None
    __properties: ClassVar[List[str]] = ["routingIdentifier", "siret", "routingCodeName", "administrativeStatus", "addressLines", "postalCode", "locality"]

    model_config = ConfigDict(
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )


    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True, exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of RoutingCodeSearchFilters from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        excluded_fields: Set[str] = set([
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of routing_identifier
        if self.routing_identifier:
            _dict['routingIdentifier'] = self.routing_identifier.to_dict()
        # override the default output from pydantic by calling `to_dict()` of siret
        if self.siret:
            _dict['siret'] = self.siret.to_dict()
        # override the default output from pydantic by calling `to_dict()` of routing_code_name
        if self.routing_code_name:
            _dict['routingCodeName'] = self.routing_code_name.to_dict()
        # override the default output from pydantic by calling `to_dict()` of administrative_status
        if self.administrative_status:
            _dict['administrativeStatus'] = self.administrative_status.to_dict()
        # override the default output from pydantic by calling `to_dict()` of address_lines
        if self.address_lines:
            _dict['addressLines'] = self.address_lines.to_dict()
        # override the default output from pydantic by calling `to_dict()` of postal_code
        if self.postal_code:
            _dict['postalCode'] = self.postal_code.to_dict()
        # override the default output from pydantic by calling `to_dict()` of locality
        if self.locality:
            _dict['locality'] = self.locality.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of RoutingCodeSearchFilters from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "routingIdentifier": RoutingCodeSearchFiltersRoutingIdentifier.from_dict(obj["routingIdentifier"]) if obj.get("routingIdentifier") is not None else None,
            "siret": SearchSiretFiltersSiret.from_dict(obj["siret"]) if obj.get("siret") is not None else None,
            "routingCodeName": RoutingCodeSearchFiltersRoutingCodeName.from_dict(obj["routingCodeName"]) if obj.get("routingCodeName") is not None else None,
            "administrativeStatus": RoutingCodeSearchFiltersAdministrativeStatus.from_dict(obj["administrativeStatus"]) if obj.get("administrativeStatus") is not None else None,
            "addressLines": SearchSiretFiltersAddressLines.from_dict(obj["addressLines"]) if obj.get("addressLines") is not None else None,
            "postalCode": SearchSiretFiltersPostalCode.from_dict(obj["postalCode"]) if obj.get("postalCode") is not None else None,
            "locality": SearchSiretFiltersLocality.from_dict(obj["locality"]) if obj.get("locality") is not None else None
        })
        return _obj


