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
 * Wrapper for postal addresses
 */
@JsonPropertyOrder({
  AddressRead.JSON_PROPERTY_ADDRESS_LINE1,
  AddressRead.JSON_PROPERTY_ADDRESS_LINE2,
  AddressRead.JSON_PROPERTY_ADDRESS_LINE3,
  AddressRead.JSON_PROPERTY_POSTAL_CODE,
  AddressRead.JSON_PROPERTY_COUNTRY_SUBDIVISION,
  AddressRead.JSON_PROPERTY_LOCALITY,
  AddressRead.JSON_PROPERTY_COUNTRY_CODE,
  AddressRead.JSON_PROPERTY_COUNTRY_NAME
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class AddressRead {
  public static final String JSON_PROPERTY_ADDRESS_LINE1 = "addressLine1";
  @javax.annotation.Nullable
  private String addressLine1;

  public static final String JSON_PROPERTY_ADDRESS_LINE2 = "addressLine2";
  @javax.annotation.Nullable
  private String addressLine2;

  public static final String JSON_PROPERTY_ADDRESS_LINE3 = "addressLine3";
  @javax.annotation.Nullable
  private String addressLine3;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  @javax.annotation.Nullable
  private String postalCode;

  public static final String JSON_PROPERTY_COUNTRY_SUBDIVISION = "countrySubdivision";
  @javax.annotation.Nullable
  private String countrySubdivision;

  public static final String JSON_PROPERTY_LOCALITY = "locality";
  @javax.annotation.Nullable
  private String locality;

  public static final String JSON_PROPERTY_COUNTRY_CODE = "countryCode";
  @javax.annotation.Nullable
  private String countryCode;

  public static final String JSON_PROPERTY_COUNTRY_NAME = "countryName";
  @javax.annotation.Nullable
  private String countryName;

  public AddressRead() { 
  }

  public AddressRead addressLine1(@javax.annotation.Nullable String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  /**
   * Corresponds to the address of the recipient structure having defined the directory line(s).
   * @return addressLine1
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESS_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAddressLine1() {
    return addressLine1;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS_LINE1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddressLine1(@javax.annotation.Nullable String addressLine1) {
    this.addressLine1 = addressLine1;
  }


  public AddressRead addressLine2(@javax.annotation.Nullable String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  /**
   * Corresponds to the address of the recipient structure having defined the directory line(s).
   * @return addressLine2
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESS_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAddressLine2() {
    return addressLine2;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS_LINE2)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddressLine2(@javax.annotation.Nullable String addressLine2) {
    this.addressLine2 = addressLine2;
  }


  public AddressRead addressLine3(@javax.annotation.Nullable String addressLine3) {
    this.addressLine3 = addressLine3;
    return this;
  }

  /**
   * Corresponds to the address of the recipient structure having defined the directory line(s).
   * @return addressLine3
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESS_LINE3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAddressLine3() {
    return addressLine3;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS_LINE3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddressLine3(@javax.annotation.Nullable String addressLine3) {
    this.addressLine3 = addressLine3;
  }


  public AddressRead postalCode(@javax.annotation.Nullable String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Service postal code
   * @return postalCode
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPostalCode() {
    return postalCode;
  }


  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalCode(@javax.annotation.Nullable String postalCode) {
    this.postalCode = postalCode;
  }


  public AddressRead countrySubdivision(@javax.annotation.Nullable String countrySubdivision) {
    this.countrySubdivision = countrySubdivision;
    return this;
  }

  /**
   * Subdivision of the country
   * @return countrySubdivision
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COUNTRY_SUBDIVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountrySubdivision() {
    return countrySubdivision;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY_SUBDIVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountrySubdivision(@javax.annotation.Nullable String countrySubdivision) {
    this.countrySubdivision = countrySubdivision;
  }


  public AddressRead locality(@javax.annotation.Nullable String locality) {
    this.locality = locality;
    return this;
  }

  /**
   * Municipality of the recipient structure having defined the directory line(s).
   * @return locality
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LOCALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLocality() {
    return locality;
  }


  @JsonProperty(JSON_PROPERTY_LOCALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocality(@javax.annotation.Nullable String locality) {
    this.locality = locality;
  }


  public AddressRead countryCode(@javax.annotation.Nullable String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Corresponds to the country of the recipient structure.
   * @return countryCode
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountryCode() {
    return countryCode;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountryCode(@javax.annotation.Nullable String countryCode) {
    this.countryCode = countryCode;
  }


  public AddressRead countryName(@javax.annotation.Nullable String countryName) {
    this.countryName = countryName;
    return this;
  }

  /**
   * Corresponds to the country of the recipient structure having defined the directory line(s).
   * @return countryName
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COUNTRY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountryName() {
    return countryName;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountryName(@javax.annotation.Nullable String countryName) {
    this.countryName = countryName;
  }


  /**
   * Return true if this addressRead object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressRead addressRead = (AddressRead) o;
    return Objects.equals(this.addressLine1, addressRead.addressLine1) &&
        Objects.equals(this.addressLine2, addressRead.addressLine2) &&
        Objects.equals(this.addressLine3, addressRead.addressLine3) &&
        Objects.equals(this.postalCode, addressRead.postalCode) &&
        Objects.equals(this.countrySubdivision, addressRead.countrySubdivision) &&
        Objects.equals(this.locality, addressRead.locality) &&
        Objects.equals(this.countryCode, addressRead.countryCode) &&
        Objects.equals(this.countryName, addressRead.countryName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressLine1, addressLine2, addressLine3, postalCode, countrySubdivision, locality, countryCode, countryName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressRead {\n");
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    addressLine3: ").append(toIndentedString(addressLine3)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    countrySubdivision: ").append(toIndentedString(countrySubdivision)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    countryName: ").append(toIndentedString(countryName)).append("\n");
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

    // add `addressLine1` to the URL query string
    if (getAddressLine1() != null) {
      joiner.add(String.format("%saddressLine1%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAddressLine1()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `addressLine2` to the URL query string
    if (getAddressLine2() != null) {
      joiner.add(String.format("%saddressLine2%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAddressLine2()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `addressLine3` to the URL query string
    if (getAddressLine3() != null) {
      joiner.add(String.format("%saddressLine3%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getAddressLine3()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `postalCode` to the URL query string
    if (getPostalCode() != null) {
      joiner.add(String.format("%spostalCode%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getPostalCode()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `countrySubdivision` to the URL query string
    if (getCountrySubdivision() != null) {
      joiner.add(String.format("%scountrySubdivision%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getCountrySubdivision()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `locality` to the URL query string
    if (getLocality() != null) {
      joiner.add(String.format("%slocality%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getLocality()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `countryCode` to the URL query string
    if (getCountryCode() != null) {
      joiner.add(String.format("%scountryCode%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getCountryCode()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `countryName` to the URL query string
    if (getCountryName() != null) {
      joiner.add(String.format("%scountryName%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getCountryName()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}

