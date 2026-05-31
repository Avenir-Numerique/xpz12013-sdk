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
import fr.neotimo.xpz12013.directory.model.RoutingCodeField;
import fr.neotimo.xpz12013.directory.model.RoutingCodeSearchFilters;
import fr.neotimo.xpz12013.directory.model.RoutingCodeSearchSortingInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import fr.neotimo.xpz12013.directory.ApiClient;
/**
 * RoutingCodeSearch
 */
@JsonPropertyOrder({
  RoutingCodeSearch.JSON_PROPERTY_FILTERS,
  RoutingCodeSearch.JSON_PROPERTY_SORTING,
  RoutingCodeSearch.JSON_PROPERTY_FIELDS,
  RoutingCodeSearch.JSON_PROPERTY_INCLUDE,
  RoutingCodeSearch.JSON_PROPERTY_LIMIT,
  RoutingCodeSearch.JSON_PROPERTY_IGNORE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class RoutingCodeSearch {
  public static final String JSON_PROPERTY_FILTERS = "filters";
  @javax.annotation.Nullable
  private RoutingCodeSearchFilters filters;

  public static final String JSON_PROPERTY_SORTING = "sorting";
  @javax.annotation.Nullable
  private List<RoutingCodeSearchSortingInner> sorting = new ArrayList<>();

  public static final String JSON_PROPERTY_FIELDS = "fields";
  @javax.annotation.Nullable
  private List<RoutingCodeField> fields = new ArrayList<>();

  /**
   * Gets or Sets include
   */
  public enum IncludeEnum {
    SIREN(String.valueOf("siren")),
    
    SIRET(String.valueOf("siret"));

    private String value;

    IncludeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IncludeEnum fromValue(String value) {
      for (IncludeEnum b : IncludeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_INCLUDE = "include";
  @javax.annotation.Nullable
  private List<IncludeEnum> include = new ArrayList<>();

  public static final String JSON_PROPERTY_LIMIT = "limit";
  @javax.annotation.Nullable
  private Integer limit;

  public static final String JSON_PROPERTY_IGNORE = "ignore";
  @javax.annotation.Nullable
  private Integer ignore;

  public RoutingCodeSearch() { 
  }

  public RoutingCodeSearch filters(@javax.annotation.Nullable RoutingCodeSearchFilters filters) {
    this.filters = filters;
    return this;
  }

  /**
   * Get filters
   * @return filters
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FILTERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RoutingCodeSearchFilters getFilters() {
    return filters;
  }


  @JsonProperty(JSON_PROPERTY_FILTERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFilters(@javax.annotation.Nullable RoutingCodeSearchFilters filters) {
    this.filters = filters;
  }


  public RoutingCodeSearch sorting(@javax.annotation.Nullable List<RoutingCodeSearchSortingInner> sorting) {
    this.sorting = sorting;
    return this;
  }

  public RoutingCodeSearch addSortingItem(RoutingCodeSearchSortingInner sortingItem) {
    if (this.sorting == null) {
      this.sorting = new ArrayList<>();
    }
    this.sorting.add(sortingItem);
    return this;
  }

  /**
   * Sorting criteria on a field and an order (ascending or descending).
   * @return sorting
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_SORTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<RoutingCodeSearchSortingInner> getSorting() {
    return sorting;
  }


  @JsonProperty(JSON_PROPERTY_SORTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSorting(@javax.annotation.Nullable List<RoutingCodeSearchSortingInner> sorting) {
    this.sorting = sorting;
  }


  public RoutingCodeSearch fields(@javax.annotation.Nullable List<RoutingCodeField> fields) {
    this.fields = fields;
    return this;
  }

  public RoutingCodeSearch addFieldsItem(RoutingCodeField fieldsItem) {
    if (this.fields == null) {
      this.fields = new ArrayList<>();
    }
    this.fields.add(fieldsItem);
    return this;
  }

  /**
   * Allows you to filter the desired fields in the response.
   * @return fields
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<RoutingCodeField> getFields() {
    return fields;
  }


  @JsonProperty(JSON_PROPERTY_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFields(@javax.annotation.Nullable List<RoutingCodeField> fields) {
    this.fields = fields;
  }


  public RoutingCodeSearch include(@javax.annotation.Nullable List<IncludeEnum> include) {
    this.include = include;
    return this;
  }

  public RoutingCodeSearch addIncludeItem(IncludeEnum includeItem) {
    if (this.include == null) {
      this.include = new ArrayList<>();
    }
    this.include.add(includeItem);
    return this;
  }

  /**
   * Get include
   * @return include
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INCLUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<IncludeEnum> getInclude() {
    return include;
  }


  @JsonProperty(JSON_PROPERTY_INCLUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInclude(@javax.annotation.Nullable List<IncludeEnum> include) {
    this.include = include;
  }


  public RoutingCodeSearch limit(@javax.annotation.Nullable Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Maximum number of results
   * @return limit
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getLimit() {
    return limit;
  }


  @JsonProperty(JSON_PROPERTY_LIMIT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLimit(@javax.annotation.Nullable Integer limit) {
    this.limit = limit;
  }


  public RoutingCodeSearch ignore(@javax.annotation.Nullable Integer ignore) {
    this.ignore = ignore;
    return this;
  }

  /**
   * Number of results to skip
   * @return ignore
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_IGNORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getIgnore() {
    return ignore;
  }


  @JsonProperty(JSON_PROPERTY_IGNORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIgnore(@javax.annotation.Nullable Integer ignore) {
    this.ignore = ignore;
  }


  /**
   * Return true if this routingCodeSearch object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoutingCodeSearch routingCodeSearch = (RoutingCodeSearch) o;
    return Objects.equals(this.filters, routingCodeSearch.filters) &&
        Objects.equals(this.sorting, routingCodeSearch.sorting) &&
        Objects.equals(this.fields, routingCodeSearch.fields) &&
        Objects.equals(this.include, routingCodeSearch.include) &&
        Objects.equals(this.limit, routingCodeSearch.limit) &&
        Objects.equals(this.ignore, routingCodeSearch.ignore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filters, sorting, fields, include, limit, ignore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoutingCodeSearch {\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    sorting: ").append(toIndentedString(sorting)).append("\n");
    sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
    sb.append("    include: ").append(toIndentedString(include)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    ignore: ").append(toIndentedString(ignore)).append("\n");
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

    // add `filters` to the URL query string
    if (getFilters() != null) {
      joiner.add(getFilters().toUrlQueryString(prefix + "filters" + suffix));
    }

    // add `sorting` to the URL query string
    if (getSorting() != null) {
      for (int i = 0; i < getSorting().size(); i++) {
        if (getSorting().get(i) != null) {
          joiner.add(getSorting().get(i).toUrlQueryString(String.format("%ssorting%s%s", prefix, suffix,
          "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
        }
      }
    }

    // add `fields` to the URL query string
    if (getFields() != null) {
      for (int i = 0; i < getFields().size(); i++) {
        if (getFields().get(i) != null) {
          joiner.add(String.format("%sfields%s%s=%s", prefix, suffix,
              "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
              URLEncoder.encode(ApiClient.valueToString(getFields().get(i)), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
        }
      }
    }

    // add `include` to the URL query string
    if (getInclude() != null) {
      for (int i = 0; i < getInclude().size(); i++) {
        joiner.add(String.format("%sinclude%s%s=%s", prefix, suffix,
            "".equals(suffix) ? "" : String.format("%s%d%s", containerPrefix, i, containerSuffix),
            URLEncoder.encode(ApiClient.valueToString(getInclude().get(i)), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
      }
    }

    // add `limit` to the URL query string
    if (getLimit() != null) {
      joiner.add(String.format("%slimit%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getLimit()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    // add `ignore` to the URL query string
    if (getIgnore() != null) {
      joiner.add(String.format("%signore%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getIgnore()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }
}

