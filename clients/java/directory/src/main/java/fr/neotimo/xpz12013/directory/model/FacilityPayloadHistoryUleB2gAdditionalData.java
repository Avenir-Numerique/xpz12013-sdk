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
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import fr.neotimo.xpz12013.directory.ApiClient;
/**
 * FacilityPayloadHistoryUleB2gAdditionalData
 */
@JsonPropertyOrder({
  FacilityPayloadHistoryUleB2gAdditionalData.JSON_PROPERTY_PM,
  FacilityPayloadHistoryUleB2gAdditionalData.JSON_PROPERTY_PM_ONLY,
  FacilityPayloadHistoryUleB2gAdditionalData.JSON_PROPERTY_MANAGES_PAYMENT_STATUS,
  FacilityPayloadHistoryUleB2gAdditionalData.JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_CODE,
  FacilityPayloadHistoryUleB2gAdditionalData.JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_OR_SERVICE_CODE,
  FacilityPayloadHistoryUleB2gAdditionalData.JSON_PROPERTY_SERVICE_CODE_STATUS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class FacilityPayloadHistoryUleB2gAdditionalData {
  public static final String JSON_PROPERTY_PM = "pm";
  @javax.annotation.Nullable
  private Boolean pm;

  public static final String JSON_PROPERTY_PM_ONLY = "pmOnly";
  @javax.annotation.Nullable
  private Boolean pmOnly;

  public static final String JSON_PROPERTY_MANAGES_PAYMENT_STATUS = "managesPaymentStatus";
  @javax.annotation.Nullable
  private Boolean managesPaymentStatus;

  public static final String JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_CODE = "managesLegalCommitmentCode";
  @javax.annotation.Nullable
  private Boolean managesLegalCommitmentCode;

  public static final String JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_OR_SERVICE_CODE = "managesLegalCommitmentOrServiceCode";
  @javax.annotation.Nullable
  private Boolean managesLegalCommitmentOrServiceCode;

  public static final String JSON_PROPERTY_SERVICE_CODE_STATUS = "serviceCodeStatus";
  @javax.annotation.Nullable
  private Boolean serviceCodeStatus;

  public FacilityPayloadHistoryUleB2gAdditionalData() { 
  }

  public FacilityPayloadHistoryUleB2gAdditionalData pm(@javax.annotation.Nullable Boolean pm) {
    this.pm = pm;
    return this;
  }

  /**
   * Indicates whether the public structure acts as project manager for work invoices in addition to receiving simple invoices. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level.
   * @return pm
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getPm() {
    return pm;
  }


  @JsonProperty(JSON_PROPERTY_PM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPm(@javax.annotation.Nullable Boolean pm) {
    this.pm = pm;
  }


  public FacilityPayloadHistoryUleB2gAdditionalData pmOnly(@javax.annotation.Nullable Boolean pmOnly) {
    this.pmOnly = pmOnly;
    return this;
  }

  /**
   * Indicates whether the public structure only acts as a project manager; if so, it can only receive invoices for work. This attribute is only returned if the directory line is defined for a public structure at the SIREN/SIRET or SIREN/SIRET/Routing code level.
   * @return pmOnly
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PM_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getPmOnly() {
    return pmOnly;
  }


  @JsonProperty(JSON_PROPERTY_PM_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPmOnly(@javax.annotation.Nullable Boolean pmOnly) {
    this.pmOnly = pmOnly;
  }


  public FacilityPayloadHistoryUleB2gAdditionalData managesPaymentStatus(@javax.annotation.Nullable Boolean managesPaymentStatus) {
    this.managesPaymentStatus = managesPaymentStatus;
    return this;
  }

  /**
   * Indicates whether the public structure manages the payment status of invoices. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level.
   * @return managesPaymentStatus
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MANAGES_PAYMENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getManagesPaymentStatus() {
    return managesPaymentStatus;
  }


  @JsonProperty(JSON_PROPERTY_MANAGES_PAYMENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setManagesPaymentStatus(@javax.annotation.Nullable Boolean managesPaymentStatus) {
    this.managesPaymentStatus = managesPaymentStatus;
  }


  public FacilityPayloadHistoryUleB2gAdditionalData managesLegalCommitmentCode(@javax.annotation.Nullable Boolean managesLegalCommitmentCode) {
    this.managesLegalCommitmentCode = managesLegalCommitmentCode;
    return this;
  }

  /**
   * Indicates whether the public structure requires a legal commitment number. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level.
   * @return managesLegalCommitmentCode
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getManagesLegalCommitmentCode() {
    return managesLegalCommitmentCode;
  }


  @JsonProperty(JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setManagesLegalCommitmentCode(@javax.annotation.Nullable Boolean managesLegalCommitmentCode) {
    this.managesLegalCommitmentCode = managesLegalCommitmentCode;
  }


  public FacilityPayloadHistoryUleB2gAdditionalData managesLegalCommitmentOrServiceCode(@javax.annotation.Nullable Boolean managesLegalCommitmentOrServiceCode) {
    this.managesLegalCommitmentOrServiceCode = managesLegalCommitmentOrServiceCode;
    return this;
  }

  /**
   * Indicates whether the public structure requires a service code or a commitment code in its exchanges. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level.
   * @return managesLegalCommitmentOrServiceCode
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_OR_SERVICE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getManagesLegalCommitmentOrServiceCode() {
    return managesLegalCommitmentOrServiceCode;
  }


  @JsonProperty(JSON_PROPERTY_MANAGES_LEGAL_COMMITMENT_OR_SERVICE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setManagesLegalCommitmentOrServiceCode(@javax.annotation.Nullable Boolean managesLegalCommitmentOrServiceCode) {
    this.managesLegalCommitmentOrServiceCode = managesLegalCommitmentOrServiceCode;
  }


  public FacilityPayloadHistoryUleB2gAdditionalData serviceCodeStatus(@javax.annotation.Nullable Boolean serviceCodeStatus) {
    this.serviceCodeStatus = serviceCodeStatus;
    return this;
  }

  /**
   * Indicates whether the structure requires a service code. This attribute is only returned if the directory line is defined for a public structure at the SIREN / SIRET or SIREN / SIRET / Routing code level.
   * @return serviceCodeStatus
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SERVICE_CODE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getServiceCodeStatus() {
    return serviceCodeStatus;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_CODE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceCodeStatus(@javax.annotation.Nullable Boolean serviceCodeStatus) {
    this.serviceCodeStatus = serviceCodeStatus;
  }


  /**
   * Return true if this facilityPayloadHistoryUleB2gAdditionalData object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FacilityPayloadHistoryUleB2gAdditionalData facilityPayloadHistoryUleB2gAdditionalData = (FacilityPayloadHistoryUleB2gAdditionalData) o;
    return Objects.equals(this.pm, facilityPayloadHistoryUleB2gAdditionalData.pm) &&
        Objects.equals(this.pmOnly, facilityPayloadHistoryUleB2gAdditionalData.pmOnly) &&
        Objects.equals(this.managesPaymentStatus, facilityPayloadHistoryUleB2gAdditionalData.managesPaymentStatus) &&
        Objects.equals(this.managesLegalCommitmentCode, facilityPayloadHistoryUleB2gAdditionalData.managesLegalCommitmentCode) &&
        Objects.equals(this.managesLegalCommitmentOrServiceCode, facilityPayloadHistoryUleB2gAdditionalData.managesLegalCommitmentOrServiceCode) &&
        Objects.equals(this.serviceCodeStatus, facilityPayloadHistoryUleB2gAdditionalData.serviceCodeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pm, pmOnly, managesPaymentStatus, managesLegalCommitmentCode, managesLegalCommitmentOrServiceCode, serviceCodeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FacilityPayloadHistoryUleB2gAdditionalData {\n");
    sb.append("    pm: ").append(toIndentedString(pm)).append("\n");
    sb.append("    pmOnly: ").append(toIndentedString(pmOnly)).append("\n");
    sb.append("    managesPaymentStatus: ").append(toIndentedString(managesPaymentStatus)).append("\n");
    sb.append("    managesLegalCommitmentCode: ").append(toIndentedString(managesLegalCommitmentCode)).append("\n");
    sb.append("    managesLegalCommitmentOrServiceCode: ").append(toIndentedString(managesLegalCommitmentOrServiceCode)).append("\n");
    sb.append("    serviceCodeStatus: ").append(toIndentedString(serviceCodeStatus)).append("\n");
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

    // add `pm` to the URL query string
    if (getPm() != null) {
      joiner.add(String.format("%spm%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getPm()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `pmOnly` to the URL query string
    if (getPmOnly() != null) {
      joiner.add(String.format("%spmOnly%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getPmOnly()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `managesPaymentStatus` to the URL query string
    if (getManagesPaymentStatus() != null) {
      joiner.add(String.format("%smanagesPaymentStatus%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getManagesPaymentStatus()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `managesLegalCommitmentCode` to the URL query string
    if (getManagesLegalCommitmentCode() != null) {
      joiner.add(String.format("%smanagesLegalCommitmentCode%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getManagesLegalCommitmentCode()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `managesLegalCommitmentOrServiceCode` to the URL query string
    if (getManagesLegalCommitmentOrServiceCode() != null) {
      joiner.add(String.format("%smanagesLegalCommitmentOrServiceCode%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getManagesLegalCommitmentOrServiceCode()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `serviceCodeStatus` to the URL query string
    if (getServiceCodeStatus() != null) {
      joiner.add(String.format("%sserviceCodeStatus%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getServiceCodeStatus()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}

