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
import type { FacilityPayloadHistoryUleB2gAdditionalData } from './FacilityPayloadHistoryUleB2gAdditionalData';
import {
    FacilityPayloadHistoryUleB2gAdditionalDataFromJSON,
    FacilityPayloadHistoryUleB2gAdditionalDataFromJSONTyped,
    FacilityPayloadHistoryUleB2gAdditionalDataToJSON,
    FacilityPayloadHistoryUleB2gAdditionalDataToJSONTyped,
} from './FacilityPayloadHistoryUleB2gAdditionalData';
import type { AddressRead } from './AddressRead';
import {
    AddressReadFromJSON,
    AddressReadFromJSONTyped,
    AddressReadToJSON,
    AddressReadToJSONTyped,
} from './AddressRead';
import type { FacilityAdministrativeStatus } from './FacilityAdministrativeStatus';
import {
    FacilityAdministrativeStatusFromJSON,
    FacilityAdministrativeStatusFromJSONTyped,
    FacilityAdministrativeStatusToJSON,
    FacilityAdministrativeStatusToJSONTyped,
} from './FacilityAdministrativeStatus';
import type { LegalUnitPayloadIncluded } from './LegalUnitPayloadIncluded';
import {
    LegalUnitPayloadIncludedFromJSON,
    LegalUnitPayloadIncludedFromJSONTyped,
    LegalUnitPayloadIncludedToJSON,
    LegalUnitPayloadIncludedToJSONTyped,
} from './LegalUnitPayloadIncluded';
import type { SiretInstructions } from './SiretInstructions';
import {
    SiretInstructionsFromJSON,
    SiretInstructionsFromJSONTyped,
    SiretInstructionsToJSON,
    SiretInstructionsToJSONTyped,
} from './SiretInstructions';
import type { FacilityType } from './FacilityType';
import {
    FacilityTypeFromJSON,
    FacilityTypeFromJSONTyped,
    FacilityTypeToJSON,
    FacilityTypeToJSONTyped,
} from './FacilityType';

/**
 * 
 * @export
 * @interface FacilityPayloadHistory
 */
export interface FacilityPayloadHistory {
    /**
     * SIRET Number
     * @type {string}
     * @memberof FacilityPayloadHistory
     */
    siret?: string;
    /**
     * SIREN number
     * @type {string}
     * @memberof FacilityPayloadHistory
     */
    siren?: string;
    /**
     * business name
     * @type {string}
     * @memberof FacilityPayloadHistory
     */
    name?: string;
    /**
     * 
     * @type {FacilityType}
     * @memberof FacilityPayloadHistory
     */
    facilityType?: FacilityType;
    /**
     * 
     * @type {FacilityAdministrativeStatus}
     * @memberof FacilityPayloadHistory
     */
    administrativeStatus?: FacilityAdministrativeStatus;
    /**
     * 
     * @type {SiretInstructions}
     * @memberof FacilityPayloadHistory
     */
    siretInstructions?: SiretInstructions;
    /**
     * 
     * @type {AddressRead}
     * @memberof FacilityPayloadHistory
     */
    address?: AddressRead;
    /**
     * 
     * @type {FacilityPayloadHistoryUleB2gAdditionalData}
     * @memberof FacilityPayloadHistory
     */
    b2gAdditionalData?: FacilityPayloadHistoryUleB2gAdditionalData;
    /**
     * 
     * @type {LegalUnitPayloadIncluded}
     * @memberof FacilityPayloadHistory
     */
    legalUnit?: LegalUnitPayloadIncluded;
}



/**
 * Check if a given object implements the FacilityPayloadHistory interface.
 */
export function instanceOfFacilityPayloadHistory(value: object): value is FacilityPayloadHistory {
    return true;
}

export function FacilityPayloadHistoryFromJSON(json: any): FacilityPayloadHistory {
    return FacilityPayloadHistoryFromJSONTyped(json, false);
}

export function FacilityPayloadHistoryFromJSONTyped(json: any, ignoreDiscriminator: boolean): FacilityPayloadHistory {
    if (json == null) {
        return json;
    }
    return {
        
        'siret': json['siret'] == null ? undefined : json['siret'],
        'siren': json['siren'] == null ? undefined : json['siren'],
        'name': json['name'] == null ? undefined : json['name'],
        'facilityType': json['facilityType'] == null ? undefined : FacilityTypeFromJSON(json['facilityType']),
        'administrativeStatus': json['administrativeStatus'] == null ? undefined : FacilityAdministrativeStatusFromJSON(json['administrativeStatus']),
        'siretInstructions': json['siretInstructions'] == null ? undefined : SiretInstructionsFromJSON(json['siretInstructions']),
        'address': json['address'] == null ? undefined : AddressReadFromJSON(json['address']),
        'b2gAdditionalData': json['b2gAdditionalData'] == null ? undefined : FacilityPayloadHistoryUleB2gAdditionalDataFromJSON(json['b2gAdditionalData']),
        'legalUnit': json['legalUnit'] == null ? undefined : LegalUnitPayloadIncludedFromJSON(json['legalUnit']),
    };
}

export function FacilityPayloadHistoryToJSON(json: any): FacilityPayloadHistory {
    return FacilityPayloadHistoryToJSONTyped(json, false);
}

export function FacilityPayloadHistoryToJSONTyped(value?: FacilityPayloadHistory | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'siret': value['siret'],
        'siren': value['siren'],
        'name': value['name'],
        'facilityType': FacilityTypeToJSON(value['facilityType']),
        'administrativeStatus': FacilityAdministrativeStatusToJSON(value['administrativeStatus']),
        'siretInstructions': SiretInstructionsToJSON(value['siretInstructions']),
        'address': AddressReadToJSON(value['address']),
        'b2gAdditionalData': FacilityPayloadHistoryUleB2gAdditionalDataToJSON(value['b2gAdditionalData']),
        'legalUnit': LegalUnitPayloadIncludedToJSON(value['legalUnit']),
    };
}

