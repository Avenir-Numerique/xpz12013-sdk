# neotimo_xpz12013_flow.WebhookApi

All URIs are relative to *https://api.flow.company.com/flow-service*

Method | HTTP request | Description
------------- | ------------- | -------------
[**create_webhook**](WebhookApi.md#create_webhook) | **POST** /v1/webhooks | Subscribe to a webhook
[**delete_webhook**](WebhookApi.md#delete_webhook) | **DELETE** /v1/webhooks/{webhookUid} | Unsubscribe to a webhook
[**get_webhook**](WebhookApi.md#get_webhook) | **GET** /v1/webhooks/{webhookUid} | Get a webhook content
[**list_webhooks**](WebhookApi.md#list_webhooks) | **GET** /v1/webhooks | Retrieve the list of webhooks created by the owner of the token
[**update_webhook**](WebhookApi.md#update_webhook) | **PATCH** /v1/webhooks/{webhookUid} | Update a webhook subscription


# **create_webhook**
> WebhookIdParam create_webhook(request_id=request_id, organization_id=organization_id, webhook_params=webhook_params)

Subscribe to a webhook

- Create a new webhook - With technical & security parameters - With metadata to filter on subsets 

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

# **get_webhook**
> Webhook get_webhook(webhook_uid, request_id=request_id, organization_id=organization_id)

Get a webhook content

- Get a subscription owned by the owner of the token - The operation is allowed only buy the owner of the token 

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.models.webhook import Webhook
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
        # Get a webhook content
        api_response = api_instance.get_webhook(webhook_uid, request_id=request_id, organization_id=organization_id)
        print("The response of WebhookApi->get_webhook:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling WebhookApi->get_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhook_uid** | **str**| The webhook unique ID | 
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 

### Return type

[**Webhook**](Webhook.md)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK - Webhook Retrieved |  -  |
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
**200** | OK - Webhook Id List Response |  -  |
**400** | Error 400 : Bad request. |  -  |
**401** | Error 401 : Authentication error. |  -  |
**403** | Error 403 : Forbidden. |  -  |
**500** | Error 500 : Server Internal Error. |  -  |
**503** | Error 503 : Unavailable Resource. |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **update_webhook**
> update_webhook(webhook_uid, request_id=request_id, organization_id=organization_id, webhook_patch_payload=webhook_patch_payload)

Update a webhook subscription

- Update the technical configuration of a webhook, keeping the same Metadata - The operation is allowed only buy the owner of the token 

### Example

* OAuth Authentication (OAuth2):
* Bearer (JWT) Authentication (BearerAuth):

```python
import neotimo_xpz12013_flow
from neotimo_xpz12013_flow.models.webhook_patch_payload import WebhookPatchPayload
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
    webhook_patch_payload = neotimo_xpz12013_flow.WebhookPatchPayload() # WebhookPatchPayload | Update a webhook's technical parameters (optional)

    try:
        # Update a webhook subscription
        api_instance.update_webhook(webhook_uid, request_id=request_id, organization_id=organization_id, webhook_patch_payload=webhook_patch_payload)
    except Exception as e:
        print("Exception when calling WebhookApi->update_webhook: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **webhook_uid** | **str**| The webhook unique ID | 
 **request_id** | **str**| Header parameter used to correlate logs from several components | [optional] 
 **organization_id** | **str**| The organization that is aimed in a multi tenancy context | [optional] 
 **webhook_patch_payload** | [**WebhookPatchPayload**](WebhookPatchPayload.md)| Update a webhook&#39;s technical parameters | [optional] 

### Return type

void (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
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

