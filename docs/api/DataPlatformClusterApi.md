# DataPlatformClusterApi

All URIs are relative to *https://api.ionos.com/dataplatform*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**clustersDelete**](DataPlatformClusterApi.md#clustersdelete) | **DELETE** /clusters/{clusterId} | Delete a DataPlatformCluster |
| [**clustersFindById**](DataPlatformClusterApi.md#clustersfindbyid) | **GET** /clusters/{clusterId} | Retrieve a DataPlatformCluster |
| [**clustersGet**](DataPlatformClusterApi.md#clustersget) | **GET** /clusters | List the DataPlatformClusters |
| [**clustersKubeconfigFindByClusterId**](DataPlatformClusterApi.md#clusterskubeconfigfindbyclusterid) | **GET** /clusters/{clusterId}/kubeconfig | Read the Kubeconfig |
| [**clustersPatch**](DataPlatformClusterApi.md#clusterspatch) | **PATCH** /clusters/{clusterId} | Partially Modify a DataPlatformCluster |
| [**clustersPost**](DataPlatformClusterApi.md#clusterspost) | **POST** /clusters | Create a DataPlatformCluster |


<a name="clustersDelete"></a>
# **clustersDelete**
> ClusterResponseData clustersDelete(clusterId)

Delete a DataPlatformCluster

Deletes the specified DataPlatformCluster by its distinct cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformClusterApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformClusterApi apiInstance = new DataPlatformClusterApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    try {
      ClusterResponseData result = apiInstance.clustersDelete(clusterId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformClusterApi#clustersDelete");
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

[**ClusterResponseData**](../models/ClusterResponseData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clustersFindById"></a>
# **clustersFindById**
> ClusterResponseData clustersFindById(clusterId)

Retrieve a DataPlatformCluster

Retrieve the specified DataPlatformCluster by its distinct ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformClusterApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformClusterApi apiInstance = new DataPlatformClusterApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    try {
      ClusterResponseData result = apiInstance.clustersFindById(clusterId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformClusterApi#clustersFindById");
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

[**ClusterResponseData**](../models/ClusterResponseData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clustersGet"></a>
# **clustersGet**
> ClusterListResponseData clustersGet(name)

List the DataPlatformClusters

List all available DataPlatformClusters that can be accessed by the user.  The user might filter the request for the name of the DataPlatformCluster. If no cluster is available matching the request, the list will be empty. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformClusterApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformClusterApi apiInstance = new DataPlatformClusterApi(defaultClient);
    String name = "name_example"; // String | Response filter to list only the clusters which include the specified name. The value is case insensitive and matched on the `name` property of the cluster. The input is limited to 63 characters with alphanumeric characters ([a-z0-9A-Z]), dashes (-), underscores (_), and dots (.) allowed. 
    try {
      ClusterListResponseData result = apiInstance.clustersGet(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformClusterApi#clustersGet");
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
| **name** | **String**| Response filter to list only the clusters which include the specified name. The value is case insensitive and matched on the &#x60;name&#x60; property of the cluster. The input is limited to 63 characters with alphanumeric characters ([a-z0-9A-Z]), dashes (-), underscores (_), and dots (.) allowed.  | [optional]

### Return type

[**ClusterListResponseData**](../models/ClusterListResponseData.md)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clustersKubeconfigFindByClusterId"></a>
# **clustersKubeconfigFindByClusterId**
> Object clustersKubeconfigFindByClusterId(clusterId)

Read the Kubeconfig

Retrieves the Kubernetes configuration file (kubeconfig) for the specified DataPlatformCluster by its cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformClusterApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformClusterApi apiInstance = new DataPlatformClusterApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    try {
      Object result = apiInstance.clustersKubeconfigFindByClusterId(clusterId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformClusterApi#clustersKubeconfigFindByClusterId");
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

**Object**

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clustersPatch"></a>
# **clustersPatch**
> ClusterResponseData clustersPatch(clusterId, patchClusterRequest)

Partially Modify a DataPlatformCluster

Modifies the specified DataPlatformCluster by its distinct cluster ID. The fields in the request body are applied to the cluster. Note that the application to the cluster itself is performed asynchronously. You can check the sync state by querying the cluster with the GET method.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformClusterApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformClusterApi apiInstance = new DataPlatformClusterApi(defaultClient);
    UUID clusterId = new UUID(); // UUID | The unique ID of the cluster. Must conform to the UUID format. 
    PatchClusterRequest patchClusterRequest = new PatchClusterRequest(); // PatchClusterRequest | Request payload with the properties that shall be applied to an existing DataPlatformCluster. 
    try {
      ClusterResponseData result = apiInstance.clustersPatch(clusterId, patchClusterRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformClusterApi#clustersPatch");
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
| **patchClusterRequest** |  [**PatchClusterRequest**](../models/PatchClusterRequest.md)| Request payload with the properties that shall be applied to an existing DataPlatformCluster.  |

### Return type

[**ClusterResponseData**](../models/ClusterResponseData.md)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="clustersPost"></a>
# **clustersPost**
> ClusterResponseData clustersPost(createClusterRequest)

Create a DataPlatformCluster

Creates a new DataPlatformCluster.  The cluster will be provisioned in the data center matching the provided &#x60;datacenterID&#x60;. Therefore the data center must be created upfront and must be accessible by the user issuing the request.  To create a new virtual data center (VDC) [see](https://api.ionos.com/docs/cloud/v6/#Data-centers-post-datacenters). 

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformClusterApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformClusterApi apiInstance = new DataPlatformClusterApi(defaultClient);
    CreateClusterRequest createClusterRequest = new CreateClusterRequest(); // CreateClusterRequest | Request payload with the properties that defines a new DataPlatformCluster and the credentials to interact with the PaaS API to create it. 
    try {
      ClusterResponseData result = apiInstance.clustersPost(createClusterRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformClusterApi#clustersPost");
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
| **createClusterRequest** |  [**CreateClusterRequest**](../models/CreateClusterRequest.md)| Request payload with the properties that defines a new DataPlatformCluster and the credentials to interact with the PaaS API to create it.  |

### Return type

[**ClusterResponseData**](../models/ClusterResponseData.md)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

