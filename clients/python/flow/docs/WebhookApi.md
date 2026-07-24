# neotimo_xpz12013_flow.WebhookApi

All URIs are relative to *https://api.flow.company.com/flow-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_webhook**](WebhookApi.md#create_webhook) | **POST** /v1/webhooks | Subscribe to a webhook
[**delete_webhook**](WebhookApi.md#delete_webhook) | **DELETE** /v1/webhooks/{webhookUid} | Unsubscribe to a webhook
[**list_webhooks**](WebhookApi.md#list_webhooks) | **GET** /v1/webhooks | Retrieve the list of webhooks created by the owner of the token


# **create_webhook**
> WebhookIdParam create_webhook(request_id=request_id, organization_id=organization_id, webhook_params=webhook_params)

Subscribe to a webhook

This operation creates and configures a new webhook, providing: - The callback URL - The metadata to filter on subsets of events  The webhook belongs to the owner of the token and cannot be seen from others: - It returns an id and a signing key (256 or 512 bits) that should be kept - The signing key allows to validate the signature of each received event.  How the signature is managed: - At webhook creation a signing Key is randomly generated in a secure way   - 256 bits are enough if the random generator is secure    - 512 bits are necessary if the generator is not secure - Each time an event is sent:   - a SHA-256 fingerprint is generated based on the concatenation of:     - the JSON payload of the response (as is, no canonical format)     - a separator : @     - the current epoch time in seconds   - a HMAC signature is computed over the fingerprint with the callback signing key   - the signature is base64 encoded for the transport    The signature and the timestamp are returned in the following headers of the callback:   - Afnor-Signature is the signature (base64)   - Afnor-Signature-Timestamp is the epoch timestamp in seconds 

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.models.webhook_id_param import WebhookIdParam
from neotimo_xpz12013_flow.models.webhook_params import WebhookParams
from neotimo_xpz12013_flow.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.flow.company.com/flow-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_flow.Configuration(
    host = "https://api.flow.company.com/flow-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): BearerAuth
configuration = neotimo_xpz12013_flow.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_flow.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_flow.WebhookApi(api_client)
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)
    webhook_params = neotimo_xpz12013_flow.WebhookParams() # WebhookParams | Create a webhook (optional)

    try:
        # Subscribe to a webhook
        api_response = api_instance.create_webhook(request_id=request_id, organization_id=organization_id, webhook_params=webhook_params)
        print("The response of WebhookApi->create_webhook:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling WebhookApi->create_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 
 **webhook_params** | [**WebhookParams**](WebhookParams.md)| Create a webhook | [optional] 

### Return type

[**WebhookIdParam**](WebhookIdParam.md)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**201** | OK - Webhook Created |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_webhook**
> delete_webhook(webhook_uid, request_id=request_id, organization_id=organization_id)

Unsubscribe to a webhook

- Delete a subscription owned by the owner of the token - The operation is allowed only buy the owner of the token 

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.flow.company.com/flow-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_flow.Configuration(
    host = "https://api.flow.company.com/flow-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): BearerAuth
configuration = neotimo_xpz12013_flow.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_flow.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_flow.WebhookApi(api_client)
    webhook_uid = 'webhook_uid_example' # str | The webhook unique ID
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)

    try:
        # Unsubscribe to a webhook
        api_instance.delete_webhook(webhook_uid, request_id=request_id, organization_id=organization_id)
    except Exception as e:
        print("Exception when calling WebhookApi->delete_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhook_uid** | **str**| The webhook unique ID | 
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 

### Return type

void (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | No Content - No content expected |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**404** | Error 404 : Resource Not Found. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **list_webhooks**
> ListWebhooks200Response list_webhooks(request_id=request_id, organization_id=organization_id)

Retrieve the list of webhooks created by the owner of the token

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.models.list_webhooks200_response import ListWebhooks200Response
from neotimo_xpz12013_flow.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.flow.company.com/flow-service
# See configuration.py for a list of all supported configuration parameters.
configuration = neotimo_xpz12013_flow.Configuration(
    host = "https://api.flow.company.com/flow-service"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

configuration.access_token = os.environ["ACCESS_TOKEN"]

# Configure Bearer authorization (JWT): BearerAuth
configuration = neotimo_xpz12013_flow.Configuration(
    access_token = os.environ["BEARER_TOKEN"]
)

# Enter a context with an instance of the API client
with neotimo_xpz12013_flow.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = neotimo_xpz12013_flow.WebhookApi(api_client)
    request_id = 'request_id_example' # str | Header parameter used to correlate logs from several components (optional)
    organization_id = 'organization_id_example' # str | The organization that is aimed in a multi tenancy context (optional)

    try:
        # Retrieve the list of webhooks created by the owner of the token
        api_response = api_instance.list_webhooks(request_id=request_id, organization_id=organization_id)
        print("The response of WebhookApi->list_webhooks:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling WebhookApi->list_webhooks: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 

### Return type

[**ListWebhooks200Response**](ListWebhooks200Response.md)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK - Webhook List Response |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

