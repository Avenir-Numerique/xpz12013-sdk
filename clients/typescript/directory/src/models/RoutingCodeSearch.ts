/* tslint:disable */
/* eslint-disable */
/**
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

import { mapValues } from '../runtime';
import type { RoutingCodeField } from './RoutingCodeField';
import {
    RoutingCodeFieldFromJSON,
    RoutingCodeFieldFromJSONTyped,
    RoutingCodeFieldToJSON,
    RoutingCodeFieldToJSONTyped,
} from './RoutingCodeField';
import type { RoutingCodeSearchSortingInner } from './RoutingCodeSearchSortingInner';
import {
    RoutingCodeSearchSortingInnerFromJSON,
    RoutingCodeSearchSortingInnerFromJSONTyped,
    RoutingCodeSearchSortingInnerToJSON,
    RoutingCodeSearchSortingInnerToJSONTyped,
} from './RoutingCodeSearchSortingInner';
import type { RoutingCodeSearchFilters } from './RoutingCodeSearchFilters';
import {
    RoutingCodeSearchFiltersFromJSON,
    RoutingCodeSearchFiltersFromJSONTyped,
    RoutingCodeSearchFiltersToJSON,
    RoutingCodeSearchFiltersToJSONTyped,
} from './RoutingCodeSearchFilters';

/**
 * 
 * @export
 * @interface RoutingCodeSearch
 */
export interface RoutingCodeSearch {
    /**
     * 
     * @type {RoutingCodeSearchFilters}
     * @memberof RoutingCodeSearch
     */
    filters?: RoutingCodeSearchFilters;
    /**
     * Sorting criteria on a field and an order (ascending or descending).
     * @type {Array<RoutingCodeSearchSortingInner>}
     * @memberof RoutingCodeSearch
     */
    sorting?: Array<RoutingCodeSearchSortingInner>;
    /**
     * Allows you to filter the desired fields in the response.
     * @type {Array<RoutingCodeField>}
     * @memberof RoutingCodeSearch
     */
    fields?: Array<RoutingCodeField>;
    /**
     * 
     * @type {Array<string>}
     * @memberof RoutingCodeSearch
     */
    include?: Array<RoutingCodeSearchIncludeEnum>;
    /**
     * Maximum number of results
     * @type {number}
     * @memberof RoutingCodeSearch
     */
    limit?: number;
    /**
     * Number of results to skip
     * @type {number}
     * @memberof RoutingCodeSearch
     */
    ignore?: number;
}


/**
 * @export
 */
export const RoutingCodeSearchIncludeEnum = {
    Siren: 'siren',
    Siret: 'siret'
} as const;
export type RoutingCodeSearchIncludeEnum = typeof RoutingCodeSearchIncludeEnum[keyof typeof RoutingCodeSearchIncludeEnum];


/**
 * Check if a given object implements the RoutingCodeSearch interface.
 */
export function instanceOfRoutingCodeSearch(value: object): value is RoutingCodeSearch {
    return true;
}

export function RoutingCodeSearchFromJSON(json: any): RoutingCodeSearch {
    return RoutingCodeSearchFromJSONTyped(json, false);
}

export function RoutingCodeSearchFromJSONTyped(json: any, ignoreDiscriminator: boolean): RoutingCodeSearch {
    if (json == null) {
        return json;
    }
    return {
        
        'filters': json['filters'] == null ? undefined : RoutingCodeSearchFiltersFromJSON(json['filters']),
        'sorting': json['sorting'] == null ? undefined : ((json['sorting'] as Array<any>).map(RoutingCodeSearchSortingInnerFromJSON)),
        'fields': json['fields'] == null ? undefined : ((json['fields'] as Array<any>).map(RoutingCodeFieldFromJSON)),
        'include': json['include'] == null ? undefined : json['include'],
        'limit': json['limit'] == null ? undefined : json['limit'],
        'ignore': json['ignore'] == null ? undefined : json['ignore'],
    };
}

export function RoutingCodeSearchToJSON(json: any): RoutingCodeSearch {
    return RoutingCodeSearchToJSONTyped(json, false);
}

export function RoutingCodeSearchToJSONTyped(value?: RoutingCodeSearch | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'filters': RoutingCodeSearchFiltersToJSON(value['filters']),
        'sorting': value['sorting'] == null ? undefined : ((value['sorting'] as Array<any>).map(RoutingCodeSearchSortingInnerToJSON)),
        'fields': value['fields'] == null ? undefined : ((value['fields'] as Array<any>).map(RoutingCodeFieldToJSON)),
        'include': value['include'],
        'limit': value['limit'],
        'ignore': value['ignore'],
    };
}

