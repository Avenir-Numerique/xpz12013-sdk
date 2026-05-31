

# RoutingCodeSearch


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**filters** | [**RoutingCodeSearchFilters**](RoutingCodeSearchFilters.md) |  |  [optional] |
|**sorting** | [**List&lt;RoutingCodeSearchSortingInner&gt;**](RoutingCodeSearchSortingInner.md) | Sorting criteria on a field and an order (ascending or descending). |  [optional] |
|**fields** | **List&lt;RoutingCodeField&gt;** | Allows you to filter the desired fields in the response. |  [optional] |
|**include** | [**List&lt;IncludeEnum&gt;**](#List&lt;IncludeEnum&gt;) |  |  [optional] |
|**limit** | **Integer** | Maximum number of results |  [optional] |
|**ignore** | **Integer** | Number of results to skip |  [optional] |



## Enum: List&lt;IncludeEnum&gt;

| Name | Value |
|---- | -----|
| SIREN | &quot;siren&quot; |
| SIRET | &quot;siret&quot; |



