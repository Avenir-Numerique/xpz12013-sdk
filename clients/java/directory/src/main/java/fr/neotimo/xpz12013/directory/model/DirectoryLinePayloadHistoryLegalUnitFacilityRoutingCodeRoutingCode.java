/*
 * AFNOR Directory Service
 *  The __Directory Service__ API allows you to: - View and search for companies (SIREN) - View and search for establishments (SIRET) - View, and search for routing codes - View, and search for directory entries  **Authentication :** Each endpoint must be called with an access token (Bearer). This token is retrieved by a call to a token URL.  --- ## Siren  Company by Siren number  - `POST /siren/search` => Search for companies (legal unit) meeting all the criteria passed as parameters, potentially multiple results returned.   - Permissions : _according to your permissions_   - **Request Body** : `{ <search criteria in JSON format> }`     - filters : the list of filters to apply to the search.     - sorting : sorting criteria by field with ascending or descending value.     - fields : the list of fields expected in the response.     - limit : the maximum number of results to return.     - ignore : a number designating the offset to apply to the returned results. Useful for pagination.   - Réponse : a paginated list of siren resources (legal unit).  - `GET /siren/code-insee:{siren}` => Consult a siren (legal unit) identified by a siren passed as a parameter.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIREN number.   - Response : the details of a siren resource (legal unit).  ### Scenarios  Example scenarios :  1. `POST /siren/search` => Search for companies (legal units) meeting all the criteria passed as parameters, potentially returning multiple results.  2. `GET /siren/code-insee:{siren}` => Get company details.  --- ## Siret  Facility by SIRET number  - `POST /siret/search` =>  Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - include: the list of relationships (siren) to include in the returned results.     - limit: the maximum number of results to return.     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of SIRET (facility) resources.  - `GET /siret/code-insee:{siret}` => Get a SIRET (facility) identified by SIRET.   - Permissions : _according to your permissions_   - Mandatory parameter: a SIRET number.   - Response : the details of a SIRET resource (facility).  ### Scenarios  Example scenarios :  1. `POST /siret/search` => Search for establishments meeting all of the criteria passed as parameters, potentially returning multiple results.  2. `GET /siret/code-insee:{siret}` => Get the facility details.  --- ## Routing Code  - `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of routing code resources.  - `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Consult the routing code identified by the SIRET and a routing identifier.   - Permissions : _according to your permissions_   - Mandatory parameter: the SIRET number of the routing code for which you wish to obtain details.    - Mandatory parameter: the routing identifier for which you want to obtain details.   - Response : the detail of a routing code.  ### Scenarios  Example scenarios :  1. `POST /routing-code/search` => Search for routing codes that meet all the criteria passed as parameters, potentially returning multiple results.  2. `GET /routing-code/siret:{siret}/code:{routing-identifier}` => Get the details of a routing code by SIRET and a routing identifier. --- ## Directory Line  The directory line is the location at which the recipient wishes to receive his invoices (SIREN or SIREN/SIRET or SIREN/SIRET/routingIdentifier). The routing identifier can be a service code, a GLN 0224 code, an ODETTE 0088 code or an internal management code used by the recipient.  - `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.   - Permissions : _according to your permissions_   - **Request body** : `{ <search criteria in JSON format> }`     - filters: the list of filters to apply to the search.     - sorting: sort criteria by field with ascending or descending value.     - fields: the list of fields expected in the response.     - limit: the maximum number of results to return     - ignore: A number designating the offset to apply to the returned results. Useful for pagination.   - Response : a paginated list of directory-line resources  - `GET /directory-line/code:{addressing-identifier}` => Get a line in the directory identified by an address identifier.   - Permissions : _according to your permissions_   -Mandatory parameter: un identifiant addressage.   - Response : the detail of a directory line.  ### Scenarios  Example scenarios :    1. `POST /directory-line/search` => Search for directory lines that meet all the criteria passed as parameters, potentially returning multiple results.    2. `GET /directory-line/code:{addressing-identifier}` => Get a directory line.  --- ## Supervisor  - `GET /healthcheck` => Check if the Directory API is online.   - Permissions : _according to your permissions_   History:   - `1.0.0` : First release   - `1.1.0` : Fixes following SG5 meeting     - Remove the concept of history     - Remove the platformRegistrationNumber, effectiveEndDate, dateFrom and dateTo from the available filters, the payloads and the responses     - Remove PUT /v1/directory-line/id-instance:{id-instance}     - Add the major version number in the path      - Remove the PPF-affiliations from the headers     - Standardize the language so that no French remains in the SWAGGER     - Standardize the responses from GET /v1/siret/id-instance:{id-instance} and GET /v1/siret/code-insee:{siren}     - Modify the routingCode regex     - Change PDP to PA     - Translate PPF and PA into a UNTDID 3035 code   - `1.2.0` : Fixes following 2026/01/12 SG5 meeting     - __WARNING: Breaking changes occured in this version__     - Remove POST /v1/directory-line     - Remove DELETE /v1/directory-line/id-instance:{id-instance}     - Remove PATCH /v1/directory-line/id-instance:{id-instance}     - Remove GET /v1/siren/id-instance:{id-instance}     - Remove GET /v1/siret/id-instance:{id-instance}     - Remove GET /v1/routing-code/id-instance:{id-instance}     - Remove GET /v1/directory-line/id-instance:{id-instance}     - Remove id-instance from the ressource fields     - Change platformStatus into directoryLineStatus     - Add Upcoming as a directoryLineStatus option      - Add OAuth2 security scheme     - Remove Accept-language and Content-Language from the header     - Change diffusible into salesProspectingForbidden     - Add 204 response for search routes 
 *
 * The version of the OpenAPI document: 1.2.0
 * Contact: sg5@afnor.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package fr.neotimo.xpz12013.directory.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import fr.neotimo.xpz12013.directory.model.AddressRead;
import fr.neotimo.xpz12013.directory.model.RoutingCodeAdministrativeStatus;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import fr.neotimo.xpz12013.directory.ApiClient;
/**
 * DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode
 */
@JsonPropertyOrder({
  DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.JSON_PROPERTY_ROUTING_IDENTIFIER,
  DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.JSON_PROPERTY_ROUTING_IDENTIFIER_TYPE,
  DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.JSON_PROPERTY_ROUTING_CODE_NAME,
  DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT,
  DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.JSON_PROPERTY_ADMINISTRATIVE_STATUS,
  DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.JSON_PROPERTY_ADDRESS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode {
  public static final String JSON_PROPERTY_ROUTING_IDENTIFIER = "routingIdentifier";
  @javax.annotation.Nullable
  private String routingIdentifier;

  public static final String JSON_PROPERTY_ROUTING_IDENTIFIER_TYPE = "routingIdentifierType";
  @javax.annotation.Nullable
  private String routingIdentifierType;

  public static final String JSON_PROPERTY_ROUTING_CODE_NAME = "routingCodeName";
  @javax.annotation.Nullable
  private String routingCodeName;

  public static final String JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT = "managesLegalCommitment";
  @javax.annotation.Nullable
  private Boolean managesLegalCommitment;

  public static final String JSON_PROPERTY_ADMINISTRATIVE_STATUS = "administrativeStatus";
  @javax.annotation.Nullable
  private RoutingCodeAdministrativeStatus administrativeStatus;

  public static final String JSON_PROPERTY_ADDRESS = "address";
  @javax.annotation.Nullable
  private AddressRead address;

  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode() { 
  }

  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode routingIdentifier(@javax.annotation.Nullable String routingIdentifier) {
    this.routingIdentifier = routingIdentifier;
    return this;
  }

  /**
   * Routing identifier od a routing code.
   * @return routingIdentifier
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROUTING_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRoutingIdentifier() {
    return routingIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_ROUTING_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoutingIdentifier(@javax.annotation.Nullable String routingIdentifier) {
    this.routingIdentifier = routingIdentifier;
  }


  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode routingIdentifierType(@javax.annotation.Nullable String routingIdentifierType) {
    this.routingIdentifierType = routingIdentifierType;
    return this;
  }

  /**
   * Routing Identifier type.
   * @return routingIdentifierType
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROUTING_IDENTIFIER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRoutingIdentifierType() {
    return routingIdentifierType;
  }


  @JsonProperty(JSON_PROPERTY_ROUTING_IDENTIFIER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoutingIdentifierType(@javax.annotation.Nullable String routingIdentifierType) {
    this.routingIdentifierType = routingIdentifierType;
  }


  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode routingCodeName(@javax.annotation.Nullable String routingCodeName) {
    this.routingCodeName = routingCodeName;
    return this;
  }

  /**
   * Name of the directory line routing code. This attribute is only returned if the directory line is defined at the SIREN / SIRET / Routing code mesh.
   * @return routingCodeName
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROUTING_CODE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRoutingCodeName() {
    return routingCodeName;
  }


  @JsonProperty(JSON_PROPERTY_ROUTING_CODE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoutingCodeName(@javax.annotation.Nullable String routingCodeName) {
    this.routingCodeName = routingCodeName;
  }


  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode managesLegalCommitment(@javax.annotation.Nullable Boolean managesLegalCommitment) {
    this.managesLegalCommitment = managesLegalCommitment;
    return this;
  }

  /**
   * Indicates whether the public structure requires a legal commitment number. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level.
   * @return managesLegalCommitment
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getManagesLegalCommitment() {
    return managesLegalCommitment;
  }


  @JsonProperty(JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setManagesLegalCommitment(@javax.annotation.Nullable Boolean managesLegalCommitment) {
    this.managesLegalCommitment = managesLegalCommitment;
  }


  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode administrativeStatus(@javax.annotation.Nullable RoutingCodeAdministrativeStatus administrativeStatus) {
    this.administrativeStatus = administrativeStatus;
    return this;
  }

  /**
   * Get administrativeStatus
   * @return administrativeStatus
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADMINISTRATIVE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RoutingCodeAdministrativeStatus getAdministrativeStatus() {
    return administrativeStatus;
  }


  @JsonProperty(JSON_PROPERTY_ADMINISTRATIVE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdministrativeStatus(@javax.annotation.Nullable RoutingCodeAdministrativeStatus administrativeStatus) {
    this.administrativeStatus = administrativeStatus;
  }


  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode address(@javax.annotation.Nullable AddressRead address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public AddressRead getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(@javax.annotation.Nullable AddressRead address) {
    this.address = address;
  }


  /**
   * Return true if this directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode = (DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode) o;
    return Objects.equals(this.routingIdentifier, directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.routingIdentifier) &&
        Objects.equals(this.routingIdentifierType, directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.routingIdentifierType) &&
        Objects.equals(this.routingCodeName, directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.routingCodeName) &&
        Objects.equals(this.managesLegalCommitment, directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.managesLegalCommitment) &&
        Objects.equals(this.administrativeStatus, directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.administrativeStatus) &&
        Objects.equals(this.address, directoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(routingIdentifier, routingIdentifierType, routingCodeName, managesLegalCommitment, administrativeStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode {\n");
    sb.append("    routingIdentifier: ").append(toIndentedString(routingIdentifier)).append("\n");
    sb.append("    routingIdentifierType: ").append(toIndentedString(routingIdentifierType)).append("\n");
    sb.append("    routingCodeName: ").append(toIndentedString(routingCodeName)).append("\n");
    sb.append("    managesLegalCommitment: ").append(toIndentedString(managesLegalCommitment)).append("\n");
    sb.append("    administrativeStatus: ").append(toIndentedString(administrativeStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `routingIdentifier` to the URL query string
    if (getRoutingIdentifier() != null) {
      joiner.add(String.format("%sroutingIdentifier%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getRoutingIdentifier()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `routingIdentifierType` to the URL query string
    if (getRoutingIdentifierType() != null) {
      joiner.add(String.format("%sroutingIdentifierType%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getRoutingIdentifierType()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `routingCodeName` to the URL query string
    if (getRoutingCodeName() != null) {
      joiner.add(String.format("%sroutingCodeName%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getRoutingCodeName()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `managesLegalCommitment` to the URL query string
    if (getManagesLegalCommitment() != null) {
      joiner.add(String.format("%smanagesLegalCommitment%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getManagesLegalCommitment()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `administrativeStatus` to the URL query string
    if (getAdministrativeStatus() != null) {
      joiner.add(String.format("%sadministrativeStatus%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAdministrativeStatus()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `address` to the URL query string
    if (getAddress() != null) {
      joiner.add(getAddress().toUrlQueryString(prefix + "address" + suffix));
    }

    return joiner.toString();
  }
}

