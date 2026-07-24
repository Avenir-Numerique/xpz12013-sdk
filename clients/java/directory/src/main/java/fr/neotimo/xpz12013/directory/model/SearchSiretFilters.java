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
import fr.neotimo.xpz12013.directory.model.SearchSirenFiltersSiren;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersAddressLines;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersAdministrativeStatus;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersCountrySubdivision;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersFacilityType;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersLocality;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersName;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersPostalCode;
import fr.neotimo.xpz12013.directory.model.SearchSiretFiltersSiret;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import fr.neotimo.xpz12013.directory.ApiClient;
/**
 * SearchSiretFilters
 */
@JsonPropertyOrder({
  SearchSiretFilters.JSON_PROPERTY_SIRET,
  SearchSiretFilters.JSON_PROPERTY_SIREN,
  SearchSiretFilters.JSON_PROPERTY_FACILITY_TYPE,
  SearchSiretFilters.JSON_PROPERTY_NAME,
  SearchSiretFilters.JSON_PROPERTY_ADDRESS_LINES,
  SearchSiretFilters.JSON_PROPERTY_POSTAL_CODE,
  SearchSiretFilters.JSON_PROPERTY_COUNTRY_SUBDIVISION,
  SearchSiretFilters.JSON_PROPERTY_LOCALITY,
  SearchSiretFilters.JSON_PROPERTY_ADMINISTRATIVE_STATUS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class SearchSiretFilters {
  public static final String JSON_PROPERTY_SIRET = "siret";
  @javax.annotation.Nullable
  private SearchSiretFiltersSiret siret;

  public static final String JSON_PROPERTY_SIREN = "siren";
  @javax.annotation.Nullable
  private SearchSirenFiltersSiren siren;

  public static final String JSON_PROPERTY_FACILITY_TYPE = "facilityType";
  @javax.annotation.Nullable
  private SearchSiretFiltersFacilityType facilityType;

  public static final String JSON_PROPERTY_NAME = "name";
  @javax.annotation.Nullable
  private SearchSiretFiltersName name;

  public static final String JSON_PROPERTY_ADDRESS_LINES = "addressLines";
  @javax.annotation.Nullable
  private SearchSiretFiltersAddressLines addressLines;

  public static final String JSON_PROPERTY_POSTAL_CODE = "postalCode";
  @javax.annotation.Nullable
  private SearchSiretFiltersPostalCode postalCode;

  public static final String JSON_PROPERTY_COUNTRY_SUBDIVISION = "countrySubdivision";
  @javax.annotation.Nullable
  private SearchSiretFiltersCountrySubdivision countrySubdivision;

  public static final String JSON_PROPERTY_LOCALITY = "locality";
  @javax.annotation.Nullable
  private SearchSiretFiltersLocality locality;

  public static final String JSON_PROPERTY_ADMINISTRATIVE_STATUS = "administrativeStatus";
  @javax.annotation.Nullable
  private SearchSiretFiltersAdministrativeStatus administrativeStatus;

  public SearchSiretFilters() { 
  }

  public SearchSiretFilters siret(@javax.annotation.Nullable SearchSiretFiltersSiret siret) {
    this.siret = siret;
    return this;
  }

  /**
   * Get siret
   * @return siret
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersSiret getSiret() {
    return siret;
  }


  @JsonProperty(JSON_PROPERTY_SIRET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSiret(@javax.annotation.Nullable SearchSiretFiltersSiret siret) {
    this.siret = siret;
  }


  public SearchSiretFilters siren(@javax.annotation.Nullable SearchSirenFiltersSiren siren) {
    this.siren = siren;
    return this;
  }

  /**
   * Get siren
   * @return siren
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SIREN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSirenFiltersSiren getSiren() {
    return siren;
  }


  @JsonProperty(JSON_PROPERTY_SIREN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSiren(@javax.annotation.Nullable SearchSirenFiltersSiren siren) {
    this.siren = siren;
  }


  public SearchSiretFilters facilityType(@javax.annotation.Nullable SearchSiretFiltersFacilityType facilityType) {
    this.facilityType = facilityType;
    return this;
  }

  /**
   * Get facilityType
   * @return facilityType
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FACILITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersFacilityType getFacilityType() {
    return facilityType;
  }


  @JsonProperty(JSON_PROPERTY_FACILITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFacilityType(@javax.annotation.Nullable SearchSiretFiltersFacilityType facilityType) {
    this.facilityType = facilityType;
  }


  public SearchSiretFilters name(@javax.annotation.Nullable SearchSiretFiltersName name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersName getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(@javax.annotation.Nullable SearchSiretFiltersName name) {
    this.name = name;
  }


  public SearchSiretFilters addressLines(@javax.annotation.Nullable SearchSiretFiltersAddressLines addressLines) {
    this.addressLines = addressLines;
    return this;
  }

  /**
   * Get addressLines
   * @return addressLines
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESS_LINES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersAddressLines getAddressLines() {
    return addressLines;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS_LINES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddressLines(@javax.annotation.Nullable SearchSiretFiltersAddressLines addressLines) {
    this.addressLines = addressLines;
  }


  public SearchSiretFilters postalCode(@javax.annotation.Nullable SearchSiretFiltersPostalCode postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersPostalCode getPostalCode() {
    return postalCode;
  }


  @JsonProperty(JSON_PROPERTY_POSTAL_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPostalCode(@javax.annotation.Nullable SearchSiretFiltersPostalCode postalCode) {
    this.postalCode = postalCode;
  }


  public SearchSiretFilters countrySubdivision(@javax.annotation.Nullable SearchSiretFiltersCountrySubdivision countrySubdivision) {
    this.countrySubdivision = countrySubdivision;
    return this;
  }

  /**
   * Get countrySubdivision
   * @return countrySubdivision
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COUNTRY_SUBDIVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersCountrySubdivision getCountrySubdivision() {
    return countrySubdivision;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY_SUBDIVISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountrySubdivision(@javax.annotation.Nullable SearchSiretFiltersCountrySubdivision countrySubdivision) {
    this.countrySubdivision = countrySubdivision;
  }


  public SearchSiretFilters locality(@javax.annotation.Nullable SearchSiretFiltersLocality locality) {
    this.locality = locality;
    return this;
  }

  /**
   * Get locality
   * @return locality
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LOCALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchSiretFiltersLocality getLocality() {
    return locality;
  }


  @JsonProperty(JSON_PROPERTY_LOCALITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocality(@javax.annotation.Nullable SearchSiretFiltersLocality locality) {
    this.locality = locality;
  }


  public SearchSiretFilters administrativeStatus(@javax.annotation.Nullable SearchSiretFiltersAdministrativeStatus administrativeStatus) {
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
  public SearchSiretFiltersAdministrativeStatus getAdministrativeStatus() {
    return administrativeStatus;
  }


  @JsonProperty(JSON_PROPERTY_ADMINISTRATIVE_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdministrativeStatus(@javax.annotation.Nullable SearchSiretFiltersAdministrativeStatus administrativeStatus) {
    this.administrativeStatus = administrativeStatus;
  }


  /**
   * Return true if this searchSiretFilters object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchSiretFilters searchSiretFilters = (SearchSiretFilters) o;
    return Objects.equals(this.siret, searchSiretFilters.siret) &&
        Objects.equals(this.siren, searchSiretFilters.siren) &&
        Objects.equals(this.facilityType, searchSiretFilters.facilityType) &&
        Objects.equals(this.name, searchSiretFilters.name) &&
        Objects.equals(this.addressLines, searchSiretFilters.addressLines) &&
        Objects.equals(this.postalCode, searchSiretFilters.postalCode) &&
        Objects.equals(this.countrySubdivision, searchSiretFilters.countrySubdivision) &&
        Objects.equals(this.locality, searchSiretFilters.locality) &&
        Objects.equals(this.administrativeStatus, searchSiretFilters.administrativeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(siret, siren, facilityType, name, addressLines, postalCode, countrySubdivision, locality, administrativeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchSiretFilters {\n");
    sb.append("    siret: ").append(toIndentedString(siret)).append("\n");
    sb.append("    siren: ").append(toIndentedString(siren)).append("\n");
    sb.append("    facilityType: ").append(toIndentedString(facilityType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    addressLines: ").append(toIndentedString(addressLines)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    countrySubdivision: ").append(toIndentedString(countrySubdivision)).append("\n");
    sb.append("    locality: ").append(toIndentedString(locality)).append("\n");
    sb.append("    administrativeStatus: ").append(toIndentedString(administrativeStatus)).append("\n");
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

    // add `siret` to the URL query string
    if (getSiret() != null) {
      joiner.add(getSiret().toUrlQueryString(prefix + "siret" + suffix));
    }

    // add `siren` to the URL query string
    if (getSiren() != null) {
      joiner.add(getSiren().toUrlQueryString(prefix + "siren" + suffix));
    }

    // add `facilityType` to the URL query string
    if (getFacilityType() != null) {
      joiner.add(getFacilityType().toUrlQueryString(prefix + "facilityType" + suffix));
    }

    // add `name` to the URL query string
    if (getName() != null) {
      joiner.add(getName().toUrlQueryString(prefix + "name" + suffix));
    }

    // add `addressLines` to the URL query string
    if (getAddressLines() != null) {
      joiner.add(getAddressLines().toUrlQueryString(prefix + "addressLines" + suffix));
    }

    // add `postalCode` to the URL query string
    if (getPostalCode() != null) {
      joiner.add(getPostalCode().toUrlQueryString(prefix + "postalCode" + suffix));
    }

    // add `countrySubdivision` to the URL query string
    if (getCountrySubdivision() != null) {
      joiner.add(getCountrySubdivision().toUrlQueryString(prefix + "countrySubdivision" + suffix));
    }

    // add `locality` to the URL query string
    if (getLocality() != null) {
      joiner.add(getLocality().toUrlQueryString(prefix + "locality" + suffix));
    }

    // add `administrativeStatus` to the URL query string
    if (getAdministrativeStatus() != null) {
      joiner.add(getAdministrativeStatus().toUrlQueryString(prefix + "administrativeStatus" + suffix));
    }

    return joiner.toString();
  }
}

