# DataPlatformNodePoolApi

All URIs are relative to *https://api.ionos.com/dataplatform*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createClusterNodepool**](DataPlatformNodePoolApi.md#createclusternodepool) | **POST** /clusters/{clusterId}/nodepools | Create a DataPlatformNodePool for a distinct DataPlatformCluster |
| [**deleteClusterNodepool**](DataPlatformNodePoolApi.md#deleteclusternodepool) | **DELETE** /clusters/{clusterId}/nodepools/{nodepoolId} | Remove node pool from DataPlatformCluster. |
| [**getClusterNodepool**](DataPlatformNodePoolApi.md#getclusternodepool) | **GET** /clusters/{clusterId}/nodepools/{nodepoolId} | Retrieve a DataPlatformNodePool |
| [**getClusterNodepools**](DataPlatformNodePoolApi.md#getclusternodepools) | **GET** /clusters/{clusterId}/nodepools | List the DataPlatformNodePools of a  DataPlatformCluster |
| [**patchClusterNodepool**](DataPlatformNodePoolApi.md#patchclusternodepool) | **PATCH** /clusters/{clusterId}/nodepools/{nodepoolId} | Partially modify a DataPlatformNodePool |


<a name="createClusterNodepool"></a>
# **createClusterNodepool**
> NodePoolResponseData createClusterNodepool(clusterId, createNodePoolRequest)

Create a DataPlatformNodePool for a distinct DataPlatformCluster

Creates a new node pool and assignes the node pool resources exclusively to the defined managed cluster.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformNodePoolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformNodePoolApi apiInstance = new DataPlatformNodePoolApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    CreateNodePoolRequest createNodePoolRequest = new CreateNodePoolRequest(); // CreateNodePoolRequest | Request payload with the properties that defines a DataPlatformNodePool. 
    try {
      NodePoolResponseData result = apiInstance.createClusterNodepool(clusterId, createNodePoolRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformNodePoolApi#createClusterNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```
⚠️ **Note**: for the example above, you need to provide all parameters to the method call. Null values will resolve to the API defaults.

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **clusterId** |  [**UUID**](../models/.md)| The unique ID of the cluster. Must conform to the UUID format.  |
| **createNodePoolRequest** |  [**CreateNodePoolRequest**](../models/CreateNodePoolRequest.md)| Request payload with the properties that defines a DataPlatformNodePool.  |

### Return type

[**NodePoolResponseData**](../models/NodePoolResponseData.md)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteClusterNodepool"></a>
# **deleteClusterNodepool**
> NodePoolResponseData deleteClusterNodepool(clusterId, nodepoolId)

Remove node pool from DataPlatformCluster.

Removes the specified node pool from the specified DataPlatformCluster and deletes the node pool afterwards.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformNodePoolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformNodePoolApi apiInstance = new DataPlatformNodePoolApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    UUID nodepoolId = new UUID(); // UUID | The unique ID of the node pool. Must conform to the UUID format. 
    try {
      NodePoolResponseData result = apiInstance.deleteClusterNodepool(clusterId, nodepoolId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformNodePoolApi#deleteClusterNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```
⚠️ **Note**: for the example above, you need to provide all parameters to the method call. Null values will resolve to the API defaults.

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **clusterId** |  [**UUID**](../models/.md)| The unique ID of the cluster. Must conform to the UUID format.  |
| **nodepoolId** |  [**UUID**](../models/.md)| The unique ID of the node pool. Must conform to the UUID format.  |

### Return type

[**NodePoolResponseData**](../models/NodePoolResponseData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getClusterNodepool"></a>
# **getClusterNodepool**
> NodePoolResponseData getClusterNodepool(clusterId, nodepoolId)

Retrieve a DataPlatformNodePool

Retrieve a node pool belonging to a Kubernetes cluster running Stackable by using its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformNodePoolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformNodePoolApi apiInstance = new DataPlatformNodePoolApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    UUID nodepoolId = new UUID(); // UUID | The unique ID of the node pool. Must conform to the UUID format. 
    try {
      NodePoolResponseData result = apiInstance.getClusterNodepool(clusterId, nodepoolId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformNodePoolApi#getClusterNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```
⚠️ **Note**: for the example above, you need to provide all parameters to the method call. Null values will resolve to the API defaults.

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **clusterId** |  [**UUID**](../models/.md)| The unique ID of the cluster. Must conform to the UUID format.  |
| **nodepoolId** |  [**UUID**](../models/.md)| The unique ID of the node pool. Must conform to the UUID format.  |

### Return type

[**NodePoolResponseData**](../models/NodePoolResponseData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getClusterNodepools"></a>
# **getClusterNodepools**
> NodePoolListResponseData getClusterNodepools(clusterId)

List the DataPlatformNodePools of a  DataPlatformCluster

List all node pools assigned to the specified DataplatformCluster by its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformNodePoolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformNodePoolApi apiInstance = new DataPlatformNodePoolApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    try {
      NodePoolListResponseData result = apiInstance.getClusterNodepools(clusterId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformNodePoolApi#getClusterNodepools");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```
⚠️ **Note**: for the example above, you need to provide all parameters to the method call. Null values will resolve to the API defaults.

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **clusterId** |  [**UUID**](../models/.md)| The unique ID of the cluster. Must conform to the UUID format.  |

### Return type

[**NodePoolListResponseData**](../models/NodePoolListResponseData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="patchClusterNodepool"></a>
# **patchClusterNodepool**
> NodePoolResponseData patchClusterNodepool(clusterId, nodepoolId, patchNodePoolRequest)

Partially modify a DataPlatformNodePool

Modifies the specified node pool of a DataPlatformCluster. Update selected attributes of a node pool belonging to a Kubernetes cluster running Stackable.  The fields in the request body are applied to the cluster. Note that the application to the node pool  itself is performed asynchronously. You can check the sync state by querying the node pool with the GET method.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformNodePoolApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformNodePoolApi apiInstance = new DataPlatformNodePoolApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    UUID nodepoolId = new UUID(); // UUID | The unique ID of the node pool. Must conform to the UUID format. 
    PatchNodePoolRequest patchNodePoolRequest = new PatchNodePoolRequest(); // PatchNodePoolRequest | Request payload with the properties that shall be applied to an existing DataPlatformNodePool. 
    try {
      NodePoolResponseData result = apiInstance.patchClusterNodepool(clusterId, nodepoolId, patchNodePoolRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformNodePoolApi#patchClusterNodepool");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```
⚠️ **Note**: for the example above, you need to provide all parameters to the method call. Null values will resolve to the API defaults.

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **clusterId** |  [**UUID**](../models/.md)| The unique ID of the cluster. Must conform to the UUID format.  |
| **nodepoolId** |  [**UUID**](../models/.md)| The unique ID of the node pool. Must conform to the UUID format.  |
| **patchNodePoolRequest** |  [**PatchNodePoolRequest**](../models/PatchNodePoolRequest.md)| Request payload with the properties that shall be applied to an existing DataPlatformNodePool.  |

### Return type

[**NodePoolResponseData**](../models/NodePoolResponseData.md)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

