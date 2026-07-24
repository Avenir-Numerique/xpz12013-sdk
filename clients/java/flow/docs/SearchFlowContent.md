

# SearchFlowContent

A set of flows matching criterias, provided into the request

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**limit** | **Integer** | Pagination, Maximum number of results that may be returned |  [optional] |
|**nextCursor** | **String** | Pagination management: - If present, says where to start for next page, set nextCursor as the cursor in the next request - If omitted, says that pagination is finished  |  [optional] |
|**filters** | [**SearchFlowFilters**](SearchFlowFilters.md) |  |  [optional] |
|**results** | [**List&lt;Flow&gt;**](Flow.md) |  |  [optional] |



