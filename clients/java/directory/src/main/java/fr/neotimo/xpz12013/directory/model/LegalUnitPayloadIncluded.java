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
import fr.neotimo.xpz12013.directory.model.EntityType;
import fr.neotimo.xpz12013.directory.model.LegalUnitAdministrativeStatus;
import fr.neotimo.xpz12013.directory.model.SirenInstructions;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import fr.neotimo.xpz12013.directory.ApiClient;
/**
 * LegalUnitPayloadIncluded
 */
@JsonPropertyOrder({
  LegalUnitPayloadIncluded.JSON_PROPERTY_SIREN,
  LegalUnitPayloadIncluded.JSON_PROPERTY_BUSINESS_NAME,
  LegalUnitPayloadIncluded.JSON_PROPERTY_ENTITY_TYPE,
  LegalUnitPayloadIncluded.JSON_PROPERTY_ADMINISTRATIVE_STATUS,
  LegalUnitPayloadIncluded.JSON_PROPERTY_INSTRUCTIONS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class LegalUnitPayloadIncluded {
  public static final String JSON_PROPERTY_SIREN = "siren";
  @javax.annotation.Nullable
  private String siren;

  public static final String JSON_PROPERTY_BUSINESS_NAME = "businessName";
  @javax.annotation.Nullable
  private String businessName;

  public static final String JSON_PROPERTY_ENTITY_TYPE = "entityType";
  @javax.annotation.Nullable
  private EntityType entityType;

  public static final String JSON_PROPERTY_ADMINISTRATIVE_STATUS = "administrativeStatus";
  @javax.annotation.Nullable
  private LegalUnitAdministrativeStatus administrativeStatus;

  public static final String JSON_PROPERTY_INSTRUCTIONS = "instructions";
  @javax.annotation.Nullable
  private SirenInstructions instructions;

  public LegalUnitPayloadIncluded() { 
  }

  public LegalUnitPayloadIncluded siren(@javax.annotation.Nullable String siren) {
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


  public LegalUnitPayloadIncluded businessName(@javax.annotation.Nullable String businessName) {
    this.businessName = businessName;
    return this;
  }

  /**
   * Business name
   * @return businessName
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_BUSINESS_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBusinessName() {
    return businessName;
  }


  @JsonProperty(JSON_PROPERTY_BUSINESS_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBusinessName(@javax.annotation.Nullable String businessName) {
    this.businessName = businessName;
  }


  public LegalUnitPayloadIncluded entityType(@javax.annotation.Nullable EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * Get entityType
   * @return entityType
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public EntityType getEntityType() {
    return entityType;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntityType(@javax.annotation.Nullable EntityType entityType) {
    this.entityType = entityType;
  }


  public LegalUnitPayloadIncluded administrativeStatus(@javax.annotation.Nullable LegalUnitAdministrativeStatus administrativeStatus) {
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
  public LegalUnitAdministrativeStatus getAdministrativeStatus() {
    return administrativeStatus;
  }


  @JsonProperty(JSON_PROPERTY_ADMINISTRATIVE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdministrativeStatus(@javax.annotation.Nullable LegalUnitAdministrativeStatus administrativeStatus) {
    this.administrativeStatus = administrativeStatus;
  }


  public LegalUnitPayloadIncluded instructions(@javax.annotation.Nullable SirenInstructions instructions) {
    this.instructions = instructions;
    return this;
  }

  /**
   * Get instructions
   * @return instructions
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INSTRUCTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SirenInstructions getInstructions() {
    return instructions;
  }


  @JsonProperty(JSON_PROPERTY_INSTRUCTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstructions(@javax.annotation.Nullable SirenInstructions instructions) {
    this.instructions = instructions;
  }


  /**
   * Return true if this legalUnitPayloadIncluded object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegalUnitPayloadIncluded legalUnitPayloadIncluded = (LegalUnitPayloadIncluded) o;
    return Objects.equals(this.siren, legalUnitPayloadIncluded.siren) &&
        Objects.equals(this.businessName, legalUnitPayloadIncluded.businessName) &&
        Objects.equals(this.entityType, legalUnitPayloadIncluded.entityType) &&
        Objects.equals(this.administrativeStatus, legalUnitPayloadIncluded.administrativeStatus) &&
        Objects.equals(this.instructions, legalUnitPayloadIncluded.instructions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(siren, businessName, entityType, administrativeStatus, instructions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegalUnitPayloadIncluded {\n");
    sb.append("    siren: ").append(toIndentedString(siren)).append("\n");
    sb.append("    businessName: ").append(toIndentedString(businessName)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    administrativeStatus: ").append(toIndentedString(administrativeStatus)).append("\n");
    sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
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

    // add `siren` to the URL query string
    if (getSiren() != null) {
      joiner.add(String.format("%ssiren%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getSiren()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `businessName` to the URL query string
    if (getBusinessName() != null) {
      joiner.add(String.format("%sbusinessName%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getBusinessName()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `entityType` to the URL query string
    if (getEntityType() != null) {
      joiner.add(String.format("%sentityType%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getEntityType()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `administrativeStatus` to the URL query string
    if (getAdministrativeStatus() != null) {
      joiner.add(String.format("%sadministrativeStatus%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAdministrativeStatus()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `instructions` to the URL query string
    if (getInstructions() != null) {
      joiner.add(getInstructions().toUrlQueryString(prefix + "instructions" + suffix));
    }

    return joiner.toString();
  }
}

