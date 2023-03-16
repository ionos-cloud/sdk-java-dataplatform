

# Metadata

Metadata of the resource
## Properties

| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **etag** | **String** | The Entity Tag of the resource as defined in http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.11 |  [optional] |
| **createdDate** | [**OffsetDateTime**](OffsetDateTime.md) | The time the resource was created, ISO 8601 timestamp (UTC). |  [optional] |
| **createdBy** | **String** | The user that created the resource |  [optional] |
| **createdByUserId** | **String** | The ID of the user that created the resource |  [optional] |
| **createdInContractNumber** | **String** | The creators contractNumber |  [optional] |
| **lastModifiedDate** | [**OffsetDateTime**](OffsetDateTime.md) | The last time the resource was modified, ISO 8601 timestamp (UTC). |  [optional] |
| **lastModifiedBy** | **String** | The user that last modified the resource |  [optional] |
| **lastModifiedByUserId** | **String** | The ID of the user that last modified the resource |  [optional] |
| **currentDataPlatformVersion** | **String** | The version of the DataPlatform.  |  [optional] |
| **currentDataPlatformRevision** | **Long** | The current dataplatform revision of a resource. This internal revision is used to rollout non-breaking internal changes. This attribute is read-only.  |  [optional] |
| **availableUpgradeVersions** | **List&lt;String&gt;** | List of available upgrades for this cluster |  [optional] |
| **state** | [**StateEnum**](#StateEnum) | State of the resource. *AVAILABLE* There are no pending modification requests for this item; *BUSY* There is at least one modification request pending and all following requests will be queued; *DEPLOYING* Resource state DEPLOYING - the resource is being created; *FAILED* Resource state FAILED - creation of the resource failed; *UPDATING* Resource state UPDATING - the resource is being updated; *FAILED_UPDATING* Resource state FAILED_UPDATING - an update to the resource was not successful; *DESTROYING* Resource state DESTROYING - the resource is being deleted; *FAILED_DESTROYING* Resource state FAILED_DESTROYING - deletion of the resource was not successful; *TERMINATED* Resource state TERMINATED - the resource was deleted.  |  [optional] |



## Enum: StateEnum

| Name | Value |
| ---- | -----
| AVAILABLE | &quot;AVAILABLE&quot; |
| BUSY | &quot;BUSY&quot; |
| DEPLOYING | &quot;DEPLOYING&quot; |
| FAILED | &quot;FAILED&quot; |
| UPDATING | &quot;UPDATING&quot; |
| FAILED_UPDATING | &quot;FAILED_UPDATING&quot; |
| DESTROYING | &quot;DESTROYING&quot; |
| FAILED_DESTROYING | &quot;FAILED_DESTROYING&quot; |
| TERMINATED | &quot;TERMINATED&quot; |


