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
import fr.neotimo.xpz12013.directory.model.DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode;
import fr.neotimo.xpz12013.directory.model.FacilityPayloadIncluded;
import fr.neotimo.xpz12013.directory.model.LegalUnitPayloadIncluded;
import fr.neotimo.xpz12013.directory.model.RecipientPlatformType;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import fr.neotimo.xpz12013.directory.ApiClient;
/**
 * DirectoryLinePayloadLegalUnitFacilityRoutingCode
 */
@JsonPropertyOrder({
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_ADDRESSING_IDENTIFIER,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_PLATFORM_TYPE,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_SIREN,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_SIRET,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_ADDRESSING_SUFFIX,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_ROUTING_CODE,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_LEGAL_UNIT,
  DirectoryLinePayloadLegalUnitFacilityRoutingCode.JSON_PROPERTY_FACILITY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class DirectoryLinePayloadLegalUnitFacilityRoutingCode {
  public static final String JSON_PROPERTY_ADDRESSING_IDENTIFIER = "addressingIdentifier";
  @javax.annotation.Nullable
  private String addressingIdentifier;

  public static final String JSON_PROPERTY_PLATFORM_TYPE = "platformType";
  @javax.annotation.Nullable
  private RecipientPlatformType platformType;

  public static final String JSON_PROPERTY_SIREN = "siren";
  @javax.annotation.Nullable
  private String siren;

  public static final String JSON_PROPERTY_SIRET = "siret";
  @javax.annotation.Nullable
  private String siret;

  public static final String JSON_PROPERTY_ADDRESSING_SUFFIX = "addressingSuffix";
  @javax.annotation.Nullable
  private String addressingSuffix;

  public static final String JSON_PROPERTY_ROUTING_CODE = "routingCode";
  @javax.annotation.Nullable
  private DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode routingCode;

  public static final String JSON_PROPERTY_LEGAL_UNIT = "legalUnit";
  @javax.annotation.Nullable
  private LegalUnitPayloadIncluded legalUnit;

  public static final String JSON_PROPERTY_FACILITY = "facility";
  @javax.annotation.Nullable
  private FacilityPayloadIncluded facility;

  public DirectoryLinePayloadLegalUnitFacilityRoutingCode() { 
  }

  public DirectoryLinePayloadLegalUnitFacilityRoutingCode addressingIdentifier(@javax.annotation.Nullable String addressingIdentifier) {
    this.addressingIdentifier = addressingIdentifier;
    return this;
  }

  /**
   * Addressing identifier of the directory line.
   * @return addressingIdentifier
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESSING_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAddressingIdentifier() {
    return addressingIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESSING_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddressingIdentifier(@javax.annotation.Nullable String addressingIdentifier) {
    this.addressingIdentifier = addressingIdentifier;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode platformType(@javax.annotation.Nullable RecipientPlatformType platformType) {
    this.platformType = platformType;
    return this;
  }

  /**
   * Get platformType
   * @return platformType
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PLATFORM_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RecipientPlatformType getPlatformType() {
    return platformType;
  }


  @JsonProperty(JSON_PROPERTY_PLATFORM_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlatformType(@javax.annotation.Nullable RecipientPlatformType platformType) {
    this.platformType = platformType;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode siren(@javax.annotation.Nullable String siren) {
    this.siren = siren;
    return this;
  }

  /**
   * SIREN number
   * @return siren
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIREN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSiren() {
    return siren;
  }


  @JsonProperty(JSON_PROPERTY_SIREN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSiren(@javax.annotation.Nullable String siren) {
    this.siren = siren;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode siret(@javax.annotation.Nullable String siret) {
    this.siret = siret;
    return this;
  }

  /**
   * SIRET Number
   * @return siret
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSiret() {
    return siret;
  }


  @JsonProperty(JSON_PROPERTY_SIRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSiret(@javax.annotation.Nullable String siret) {
    this.siret = siret;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode addressingSuffix(@javax.annotation.Nullable String addressingSuffix) {
    this.addressingSuffix = addressingSuffix;
    return this;
  }

  /**
   * suffix of the directory line which defines an address mesh not attached to a facility
   * @return addressingSuffix
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESSING_SUFFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAddressingSuffix() {
    return addressingSuffix;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESSING_SUFFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddressingSuffix(@javax.annotation.Nullable String addressingSuffix) {
    this.addressingSuffix = addressingSuffix;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode routingCode(@javax.annotation.Nullable DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode routingCode) {
    this.routingCode = routingCode;
    return this;
  }

  /**
   * Get routingCode
   * @return routingCode
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROUTING_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode getRoutingCode() {
    return routingCode;
  }


  @JsonProperty(JSON_PROPERTY_ROUTING_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoutingCode(@javax.annotation.Nullable DirectoryLinePayloadHistoryLegalUnitFacilityRoutingCodeRoutingCode routingCode) {
    this.routingCode = routingCode;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode legalUnit(@javax.annotation.Nullable LegalUnitPayloadIncluded legalUnit) {
    this.legalUnit = legalUnit;
    return this;
  }

  /**
   * Get legalUnit
   * @return legalUnit
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LEGAL_UNIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public LegalUnitPayloadIncluded getLegalUnit() {
    return legalUnit;
  }


  @JsonProperty(JSON_PROPERTY_LEGAL_UNIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLegalUnit(@javax.annotation.Nullable LegalUnitPayloadIncluded legalUnit) {
    this.legalUnit = legalUnit;
  }


  public DirectoryLinePayloadLegalUnitFacilityRoutingCode facility(@javax.annotation.Nullable FacilityPayloadIncluded facility) {
    this.facility = facility;
    return this;
  }

  /**
   * Get facility
   * @return facility
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FACILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public FacilityPayloadIncluded getFacility() {
    return facility;
  }


  @JsonProperty(JSON_PROPERTY_FACILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFacility(@javax.annotation.Nullable FacilityPayloadIncluded facility) {
    this.facility = facility;
  }


  /**
   * Return true if this directoryLinePayloadLegalUnitFacilityRoutingCode object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DirectoryLinePayloadLegalUnitFacilityRoutingCode directoryLinePayloadLegalUnitFacilityRoutingCode = (DirectoryLinePayloadLegalUnitFacilityRoutingCode) o;
    return Objects.equals(this.addressingIdentifier, directoryLinePayloadLegalUnitFacilityRoutingCode.addressingIdentifier) &&
        Objects.equals(this.platformType, directoryLinePayloadLegalUnitFacilityRoutingCode.platformType) &&
        Objects.equals(this.siren, directoryLinePayloadLegalUnitFacilityRoutingCode.siren) &&
        Objects.equals(this.siret, directoryLinePayloadLegalUnitFacilityRoutingCode.siret) &&
        Objects.equals(this.addressingSuffix, directoryLinePayloadLegalUnitFacilityRoutingCode.addressingSuffix) &&
        Objects.equals(this.routingCode, directoryLinePayloadLegalUnitFacilityRoutingCode.routingCode) &&
        Objects.equals(this.legalUnit, directoryLinePayloadLegalUnitFacilityRoutingCode.legalUnit) &&
        Objects.equals(this.facility, directoryLinePayloadLegalUnitFacilityRoutingCode.facility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressingIdentifier, platformType, siren, siret, addressingSuffix, routingCode, legalUnit, facility);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DirectoryLinePayloadLegalUnitFacilityRoutingCode {\n");
    sb.append("    addressingIdentifier: ").append(toIndentedString(addressingIdentifier)).append("\n");
    sb.append("    platformType: ").append(toIndentedString(platformType)).append("\n");
    sb.append("    siren: ").append(toIndentedString(siren)).append("\n");
    sb.append("    siret: ").append(toIndentedString(siret)).append("\n");
    sb.append("    addressingSuffix: ").append(toIndentedString(addressingSuffix)).append("\n");
    sb.append("    routingCode: ").append(toIndentedString(routingCode)).append("\n");
    sb.append("    legalUnit: ").append(toIndentedString(legalUnit)).append("\n");
    sb.append("    facility: ").append(toIndentedString(facility)).append("\n");
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

    // add `addressingIdentifier` to the URL query string
    if (getAddressingIdentifier() != null) {
      joiner.add(String.format("%saddressingIdentifier%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAddressingIdentifier()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `platformType` to the URL query string
    if (getPlatformType() != null) {
      joiner.add(String.format("%splatformType%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getPlatformType()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `siren` to the URL query string
    if (getSiren() != null) {
      joiner.add(String.format("%ssiren%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getSiren()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `siret` to the URL query string
    if (getSiret() != null) {
      joiner.add(String.format("%ssiret%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getSiret()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `addressingSuffix` to the URL query string
    if (getAddressingSuffix() != null) {
      joiner.add(String.format("%saddressingSuffix%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAddressingSuffix()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `routingCode` to the URL query string
    if (getRoutingCode() != null) {
      joiner.add(getRoutingCode().toUrlQueryString(prefix + "routingCode" + suffix));
    }

    // add `legalUnit` to the URL query string
    if (getLegalUnit() != null) {
      joiner.add(getLegalUnit().toUrlQueryString(prefix + "legalUnit" + suffix));
    }

    // add `facility` to the URL query string
    if (getFacility() != null) {
      joiner.add(getFacility().toUrlQueryString(prefix + "facility" + suffix));
    }

    return joiner.toString();
  }
}

