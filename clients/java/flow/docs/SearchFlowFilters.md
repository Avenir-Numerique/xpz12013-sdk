

# SearchFlowFilters

Filtering criteria, at least one is required

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**updatedAfter** | **OffsetDateTime** | The comparison with current date is strict : updatedAt &gt; updatedAfter |  [optional] |
|**updatedBefore** | **OffsetDateTime** |  |  [optional] |
|**processingRule** | **List&lt;ProcessingRule&gt;** |  |  [optional] |
|**flowType** | **List&lt;FlowType&gt;** |  |  [optional] |
|**flowDirection** | **List&lt;FlowDirection&gt;** |  |  [optional] |
|**trackingId** | **String** | Unique identifier supporting UUID but not only, for flexibility purpose |  [optional] |
|**ackStatus** | **FlowAckStatus** |  |  [optional] |



