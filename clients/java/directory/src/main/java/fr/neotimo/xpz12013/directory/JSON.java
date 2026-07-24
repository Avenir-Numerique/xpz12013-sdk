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


package fr.neotimo.xpz12013.directory;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.openapitools.jackson.nullable.JsonNullableModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.neotimo.xpz12013.directory.model.*;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class JSON {
  private ObjectMapper mapper;

  public JSON() {
    mapper = JsonMapper.builder()
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .enable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
        .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
        .defaultDateFormat(new RFC3339DateFormat())
        .addModule(new JavaTimeModule())
        .build();
    JsonNullableModule jnm = new JsonNullableModule();
    mapper.registerModule(jnm);
  }

  /**
   * Set the date format for JSON (de)serialization with Date properties.
   *
   * @param dateFormat Date format
   */
  public void setDateFormat(DateFormat dateFormat) {
    mapper.setDateFormat(dateFormat);
  }

  /**
   * Get the object mapper
   *
   * @return object mapper
   */
  public ObjectMapper getMapper() { return mapper; }

  /**
   * Returns the target model class that should be used to deserialize the input data.
   * The discriminator mappings are used to determine the target model class.
   *
   * @param node The input data.
   * @param modelClass The class that contains the discriminator mappings.
   *
   * @return the target model class.
   */
  public static Class<?> getClassForElement(JsonNode node, Class<?> modelClass) {
    ClassDiscriminatorMapping cdm = modelDiscriminators.get(modelClass);
    if (cdm != null) {
      return cdm.getClassForElement(node, new HashSet<Class<?>>());
    }
    return null;
  }

  /**
   * Helper class to register the discriminator mappings.
   */
  @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
  private static class ClassDiscriminatorMapping {
    // The model class name.
    Class<?> modelClass;
    // The name of the discriminator property.
    String discriminatorName;
    // The discriminator mappings for a model class.
    Map<String, Class<?>> discriminatorMappings;

    // Constructs a new class discriminator.
    ClassDiscriminatorMapping(Class<?> cls, String propertyName, Map<String, Class<?>> mappings) {
      modelClass = cls;
      discriminatorName = propertyName;
      discriminatorMappings = new HashMap<String, Class<?>>();
      if (mappings != null) {
        discriminatorMappings.putAll(mappings);
      }
    }

    // Return the name of the discriminator property for this model class.
    String getDiscriminatorPropertyName() {
      return discriminatorName;
    }

    // Return the discriminator value or null if the discriminator is not
    // present in the payload.
    String getDiscriminatorValue(JsonNode node) {
      // Determine the value of the discriminator property in the input data.
      if (discriminatorName != null) {
        // Get the value of the discriminator property, if present in the input payload.
        node = node.get(discriminatorName);
        if (node != null && node.isValueNode()) {
          String discrValue = node.asText();
          if (discrValue != null) {
            return discrValue;
          }
        }
      }
      return null;
    }

    /**
     * Returns the target model class that should be used to deserialize the input data.
     * This function can be invoked for anyOf/oneOf composed models with discriminator mappings.
     * The discriminator mappings are used to determine the target model class.
     *
     * @param node The input data.
     * @param visitedClasses The set of classes that have already been visited.
     *
     * @return the target model class.
     */
    Class<?> getClassForElement(JsonNode node, Set<Class<?>> visitedClasses) {
      if (visitedClasses.contains(modelClass)) {
        // Class has already been visited.
        return null;
      }
      // Determine the value of the discriminator property in the input data.
      String discrValue = getDiscriminatorValue(node);
      if (discrValue == null) {
        return null;
      }
      Class<?> cls = discriminatorMappings.get(discrValue);
      // It may not be sufficient to return this cls directly because that target class
      // may itself be a composed schema, possibly with its own discriminator.
      visitedClasses.add(modelClass);
      for (Class<?> childClass : discriminatorMappings.values()) {
        ClassDiscriminatorMapping childCdm = modelDiscriminators.get(childClass);
        if (childCdm == null) {
          continue;
        }
        if (!discriminatorName.equals(childCdm.discriminatorName)) {
          discrValue = getDiscriminatorValue(node);
          if (discrValue == null) {
            continue;
          }
        }
        if (childCdm != null) {
          // Recursively traverse the discriminator mappings.
          Class<?> childDiscr = childCdm.getClassForElement(node, visitedClasses);
          if (childDiscr != null) {
            return childDiscr;
          }
        }
      }
      return cls;
    }
  }

  /**
   * Returns true if inst is an instance of modelClass in the OpenAPI model hierarchy.
   *
   * The Java class hierarchy is not implemented the same way as the OpenAPI model hierarchy,
   * so it's not possible to use the instanceof keyword.
   *
   * @param modelClass A OpenAPI model class.
   * @param inst The instance object.
   * @param visitedClasses The set of classes that have already been visited.
   *
   * @return true if inst is an instance of modelClass in the OpenAPI model hierarchy.
   */
  public static boolean isInstanceOf(Class<?> modelClass, Object inst, Set<Class<?>> visitedClasses) {
    if (modelClass.isInstance(inst)) {
      // This handles the 'allOf' use case with single parent inheritance.
      return true;
    }
    if (visitedClasses.contains(modelClass)) {
      // This is to prevent infinite recursion when the composed schemas have
      // a circular dependency.
      return false;
    }
    visitedClasses.add(modelClass);

    // Traverse the oneOf/anyOf composed schemas.
    Map<String, Class<?>> descendants = modelDescendants.get(modelClass);
    if (descendants != null) {
      for (Class<?> childType : descendants.values()) {
        if (isInstanceOf(childType, inst, visitedClasses)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * A map of discriminators for all model classes.
   */
  private static Map<Class<?>, ClassDiscriminatorMapping> modelDiscriminators = new HashMap<>();

  /**
   * A map of oneOf/anyOf descendants for each model class.
   */
  private static Map<Class<?>, Map<String, Class<?>>> modelDescendants = new HashMap<>();

  /**
    * Register a model class discriminator.
    *
    * @param modelClass the model class
    * @param discriminatorPropertyName the name of the discriminator property
    * @param mappings a map with the discriminator mappings.
    */
  public static void registerDiscriminator(Class<?> modelClass, String discriminatorPropertyName, Map<String, Class<?>> mappings) {
    ClassDiscriminatorMapping m = new ClassDiscriminatorMapping(modelClass, discriminatorPropertyName, mappings);
    modelDiscriminators.put(modelClass, m);
  }

  /**
    * Register the oneOf/anyOf descendants of the modelClass.
    *
    * @param modelClass the model class
    * @param descendants a map of oneOf/anyOf descendants.
    */
  public static void registerDescendants(Class<?> modelClass, Map<String, Class<?>> descendants) {
    modelDescendants.put(modelClass, descendants);
  }

  private static JSON json;

  static {
    json = new JSON();
  }

  /**
    * Get the default JSON instance.
    *
    * @return the default JSON instance
    */
  public static JSON getDefault() {
    return json;
  }

  /**
    * Set the default JSON instance.
    *
    * @param json JSON instance to be used
    */
  public static void setDefault(JSON json) {
    JSON.json = json;
  }
}
