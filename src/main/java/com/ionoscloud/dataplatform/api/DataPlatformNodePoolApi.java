/*
 * IONOS Cloud - Managed Stackable Data Platform API
 * Managed Stackable Data Platform by IONOS Cloud provides a preconfigured Kubernetes cluster with pre-installed and managed Stackable operators. After the provision of these Stackable operators, the customer can interact with them directly and build his desired application on top of the Stackable Platform.  Managed Stackable Data Platform by IONOS Cloud can be configured through the IONOS Cloud API in addition or as an alternative to the \"Data Center Designer\" (DCD).  ## Getting Started  To get your DataPlatformCluster up and running, the following steps needs to be performed.  ### IONOS Cloud Account  The first step is the creation of a IONOS Cloud account if not already existing.  To register a **new account** visit [cloud.ionos.com](https://cloud.ionos.com/compute/signup).  ### Virtual Datacenter (VDC)  The Managed Data Stack needs a virtual datacenter (VDC) hosting the cluster. This could either be a VDC that already exists, especially if you want to connect the managed DataPlatform to other services already running within your VDC. Otherwise, if you want to place the Managed Data Stack in a new VDC or you have not yet created a VDC, you need to do so.  A new VDC can be created via the IONOS Cloud API, the IONOS-CLI or the DCD Web interface. For more information, see the [official documentation](https://docs.ionos.com/cloud/getting-started/tutorials/data-center-basics)  ### Get a authentication token  To interact with this API a user specific authentication token is needed. This token can be generated using the IONOS-CLI the following way:  ``` ionosctl token generate ```  For more information [see](https://docs.ionos.com/cli-ionosctl/subcommands/authentication/token-generate)  ### Create a new DataPlatformCluster  Before using Managed Stackable Data Platform, a new DataPlatformCluster must be created.  To create a cluster, use the [Create DataPlatformCluster](paths./clusters.post) API endpoint.  The provisioning of the cluster might take some time. To check the current provisioning status, you can query the cluster by calling the [Get Endpoint](#/DataPlatformCluster/getCluster) with the cluster ID that was presented to you in the response of the create cluster call.  ### Add a DataPlatformNodePool  To deploy and run a Stackable service, the cluster must have enough computational resources. The node pool that is provisioned along with the cluster is reserved for the Stackable operators. You may create further node pools with resources tailored to your use-case.  To create a new node pool use the [Create DataPlatformNodepool](paths./clusters/{clusterId}/nodepools.post) endpoint.  ### Receive Kubeconfig  Once the DataPlatformCluster is created, the kubeconfig can be accessed by the API. The kubeconfig allows the interaction with the provided cluster as with any regular Kubernetes cluster.  The kubeconfig can be downloaded with the [Get Kubeconfig](paths./clusters/{clusterId}/kubeconfig.get) endpoint using the cluster ID of the created DataPlatformCluster.  ### Create Stackable Service  To create the desired application, the Stackable service needs to be provided, using the received kubeconfig and [deploy a Stackable service](https://docs.stackable.tech/home/getting_started.html#_deploying_stackable_services)  ## Authorization  All endpoints are secured, so only an authenticated user can access them. As Authentication mechanism the default IONOS Cloud authentication mechanism is used. A detailed description can be found [here](https://api.ionos.com/docs/authentication/).  ### Basic-Auth  The basic auth scheme uses the IONOS Cloud user credentials in form of a Basic Authentication Header accordingly to [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)  ### API-Key as Bearer Token  The Bearer auth token used at the API-Gateway is a user related token created with the IONOS-CLI. (See the [documentation](https://docs.ionos.com/cli-ionosctl/subcommands/authentication/token-generate) for details) For every request to be authenticated, the token is passed as 'Authorization Bearer' header along with the request.  ### Permissions and access roles  Currently, an admin can see and manipulate all resources in a contract. A normal authenticated user can only see and manipulate resources he created.   ## Components  The Managed Stackable Data Platform by IONOS Cloud consists of two components. The concept of a DataPlatformClusters and the backing DataPlatformNodePools the cluster is build on.  ### DataPlatformCluster  A DataPlatformCluster is the virtual instance of the customer services and operations running the managed Services like Stackable operators. A DataPlatformCluster is a Kubernetes Cluster in the VDC of the customer. Therefore, it's possible to integrate the cluster with other resources as vLANs e.G. to shape the datacenter in the customer's need and integrate the cluster within the topology the customer wants to build.  In addition to the Kubernetes cluster a small node pool is provided which is exclusively used to run the Stackable operators.  ### DataPlatformNodePool  A DataPlatformNodePool represents the physical machines a DataPlatformCluster is build on top. All nodes within a node pool are identical in setup. The nodes of a pool are provisioned into virtual data centers at a location of your choice and you can freely specify the properties of all the nodes at once before creation.  Nodes in node pools provisioned by the Managed Stackable Data Platform Cloud API are readonly in the customer's VDC and can only be modified or deleted via the API.  ### References 
 *
 * The version of the OpenAPI document: 0.0.7
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ionoscloud.dataplatform.api;

import com.ionoscloud.dataplatform.ApiCallback;
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.ApiResponse;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.Pair;
import com.ionoscloud.dataplatform.ProgressRequestBody;
import com.ionoscloud.dataplatform.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.ionoscloud.dataplatform.model.CreateNodePoolRequest;
import com.ionoscloud.dataplatform.model.ErrorResponse;
import com.ionoscloud.dataplatform.model.NodePoolListResponseData;
import com.ionoscloud.dataplatform.model.NodePoolResponseData;
import com.ionoscloud.dataplatform.model.PatchNodePoolRequest;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPlatformNodePoolApi {
    private ApiClient localVarApiClient;

    public DataPlatformNodePoolApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DataPlatformNodePoolApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createClusterNodepool
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param createNodePoolRequest Request payload with the properties that defines a DataPlatformNodePool.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createClusterNodepoolCall(UUID clusterId, CreateNodePoolRequest createNodePoolRequest, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        Object localVarPostBody = createNodePoolRequest;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}/nodepools"
            .replaceAll("\\{" + "clusterId" + "\\}", localVarApiClient.escapeString(clusterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth", "tokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createClusterNodepoolValidateBeforeCall(UUID clusterId, CreateNodePoolRequest createNodePoolRequest, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling createClusterNodepool(Async)");
        }
        
        // verify the required parameter 'createNodePoolRequest' is set
        if (createNodePoolRequest == null) {
            throw new ApiException("Missing the required parameter 'createNodePoolRequest' when calling createClusterNodepool(Async)");
        }
        

        okhttp3.Call localVarCall = createClusterNodepoolCall(clusterId, createNodePoolRequest, _callback);
        return localVarCall;

    }

    /**
     * Create a DataPlatformNodePool for a distinct DataPlatformCluster
     * Creates a new node pool and assignes the node pool resources exclusively to the defined managed cluster.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param createNodePoolRequest Request payload with the properties that defines a DataPlatformNodePool.  (required)
     * @return NodePoolResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public NodePoolResponseData createClusterNodepool(UUID clusterId, CreateNodePoolRequest createNodePoolRequest) throws ApiException {
        ApiResponse<NodePoolResponseData> localVarResp = createClusterNodepoolWithHttpInfo(clusterId, createNodePoolRequest);
        return localVarResp.getData();
    }

    /**
     * Create a DataPlatformNodePool for a distinct DataPlatformCluster
     * Creates a new node pool and assignes the node pool resources exclusively to the defined managed cluster.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param createNodePoolRequest Request payload with the properties that defines a DataPlatformNodePool.  (required)
     * @return ApiResponse&lt;NodePoolResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<NodePoolResponseData> createClusterNodepoolWithHttpInfo(UUID clusterId, CreateNodePoolRequest createNodePoolRequest) throws ApiException {
        okhttp3.Call localVarCall = createClusterNodepoolValidateBeforeCall(clusterId, createNodePoolRequest, null);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a DataPlatformNodePool for a distinct DataPlatformCluster (asynchronously)
     * Creates a new node pool and assignes the node pool resources exclusively to the defined managed cluster.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param createNodePoolRequest Request payload with the properties that defines a DataPlatformNodePool.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createClusterNodepoolAsync(UUID clusterId, CreateNodePoolRequest createNodePoolRequest, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = createClusterNodepoolValidateBeforeCall(clusterId, createNodePoolRequest, _callback);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteClusterNodepool
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteClusterNodepoolCall(UUID clusterId, UUID nodepoolId, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}/nodepools/{nodepoolId}"
            .replaceAll("\\{" + "clusterId" + "\\}", localVarApiClient.escapeString(clusterId.toString()))
            .replaceAll("\\{" + "nodepoolId" + "\\}", localVarApiClient.escapeString(nodepoolId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth", "tokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteClusterNodepoolValidateBeforeCall(UUID clusterId, UUID nodepoolId, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling deleteClusterNodepool(Async)");
        }
        
        // verify the required parameter 'nodepoolId' is set
        if (nodepoolId == null) {
            throw new ApiException("Missing the required parameter 'nodepoolId' when calling deleteClusterNodepool(Async)");
        }
        

        okhttp3.Call localVarCall = deleteClusterNodepoolCall(clusterId, nodepoolId, _callback);
        return localVarCall;

    }

    /**
     * Remove node pool from DataPlatformCluster.
     * Removes the specified node pool from the specified DataPlatformCluster and deletes the node pool afterwards.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @return NodePoolResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public NodePoolResponseData deleteClusterNodepool(UUID clusterId, UUID nodepoolId) throws ApiException {
        ApiResponse<NodePoolResponseData> localVarResp = deleteClusterNodepoolWithHttpInfo(clusterId, nodepoolId);
        return localVarResp.getData();
    }

    /**
     * Remove node pool from DataPlatformCluster.
     * Removes the specified node pool from the specified DataPlatformCluster and deletes the node pool afterwards.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @return ApiResponse&lt;NodePoolResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<NodePoolResponseData> deleteClusterNodepoolWithHttpInfo(UUID clusterId, UUID nodepoolId) throws ApiException {
        okhttp3.Call localVarCall = deleteClusterNodepoolValidateBeforeCall(clusterId, nodepoolId, null);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Remove node pool from DataPlatformCluster. (asynchronously)
     * Removes the specified node pool from the specified DataPlatformCluster and deletes the node pool afterwards.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteClusterNodepoolAsync(UUID clusterId, UUID nodepoolId, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteClusterNodepoolValidateBeforeCall(clusterId, nodepoolId, _callback);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getClusterNodepool
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getClusterNodepoolCall(UUID clusterId, UUID nodepoolId, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}/nodepools/{nodepoolId}"
            .replaceAll("\\{" + "clusterId" + "\\}", localVarApiClient.escapeString(clusterId.toString()))
            .replaceAll("\\{" + "nodepoolId" + "\\}", localVarApiClient.escapeString(nodepoolId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth", "tokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getClusterNodepoolValidateBeforeCall(UUID clusterId, UUID nodepoolId, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling getClusterNodepool(Async)");
        }
        
        // verify the required parameter 'nodepoolId' is set
        if (nodepoolId == null) {
            throw new ApiException("Missing the required parameter 'nodepoolId' when calling getClusterNodepool(Async)");
        }
        

        okhttp3.Call localVarCall = getClusterNodepoolCall(clusterId, nodepoolId, _callback);
        return localVarCall;

    }

    /**
     * Retrieve a DataPlatformNodePool
     * Retrieve a node pool belonging to a Kubernetes cluster running Stackable by using its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @return NodePoolResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public NodePoolResponseData getClusterNodepool(UUID clusterId, UUID nodepoolId) throws ApiException {
        ApiResponse<NodePoolResponseData> localVarResp = getClusterNodepoolWithHttpInfo(clusterId, nodepoolId);
        return localVarResp.getData();
    }

    /**
     * Retrieve a DataPlatformNodePool
     * Retrieve a node pool belonging to a Kubernetes cluster running Stackable by using its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @return ApiResponse&lt;NodePoolResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<NodePoolResponseData> getClusterNodepoolWithHttpInfo(UUID clusterId, UUID nodepoolId) throws ApiException {
        okhttp3.Call localVarCall = getClusterNodepoolValidateBeforeCall(clusterId, nodepoolId, null);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve a DataPlatformNodePool (asynchronously)
     * Retrieve a node pool belonging to a Kubernetes cluster running Stackable by using its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getClusterNodepoolAsync(UUID clusterId, UUID nodepoolId, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = getClusterNodepoolValidateBeforeCall(clusterId, nodepoolId, _callback);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getClusterNodepools
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all node pools assigned to a specific DataPlatformCluster  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getClusterNodepoolsCall(UUID clusterId, final ApiCallback<NodePoolListResponseData> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}/nodepools"
            .replaceAll("\\{" + "clusterId" + "\\}", localVarApiClient.escapeString(clusterId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth", "tokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getClusterNodepoolsValidateBeforeCall(UUID clusterId, final ApiCallback<NodePoolListResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling getClusterNodepools(Async)");
        }
        

        okhttp3.Call localVarCall = getClusterNodepoolsCall(clusterId, _callback);
        return localVarCall;

    }

    /**
     * List the DataPlatformNodePools of a  DataPlatformCluster
     * List all node pools assigned to the specified DataplatformCluster by its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return NodePoolListResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all node pools assigned to a specific DataPlatformCluster  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public NodePoolListResponseData getClusterNodepools(UUID clusterId) throws ApiException {
        ApiResponse<NodePoolListResponseData> localVarResp = getClusterNodepoolsWithHttpInfo(clusterId);
        return localVarResp.getData();
    }

    /**
     * List the DataPlatformNodePools of a  DataPlatformCluster
     * List all node pools assigned to the specified DataplatformCluster by its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return ApiResponse&lt;NodePoolListResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all node pools assigned to a specific DataPlatformCluster  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<NodePoolListResponseData> getClusterNodepoolsWithHttpInfo(UUID clusterId) throws ApiException {
        okhttp3.Call localVarCall = getClusterNodepoolsValidateBeforeCall(clusterId, null);
        Type localVarReturnType = new TypeToken<NodePoolListResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List the DataPlatformNodePools of a  DataPlatformCluster (asynchronously)
     * List all node pools assigned to the specified DataplatformCluster by its ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of all node pools assigned to a specific DataPlatformCluster  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getClusterNodepoolsAsync(UUID clusterId, final ApiCallback<NodePoolListResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = getClusterNodepoolsValidateBeforeCall(clusterId, _callback);
        Type localVarReturnType = new TypeToken<NodePoolListResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for patchClusterNodepool
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param patchNodePoolRequest Request payload with the properties that shall be applied to an existing DataPlatformNodePool.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call patchClusterNodepoolCall(UUID clusterId, UUID nodepoolId, PatchNodePoolRequest patchNodePoolRequest, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        Object localVarPostBody = patchNodePoolRequest;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}/nodepools/{nodepoolId}"
            .replaceAll("\\{" + "clusterId" + "\\}", localVarApiClient.escapeString(clusterId.toString()))
            .replaceAll("\\{" + "nodepoolId" + "\\}", localVarApiClient.escapeString(nodepoolId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "basicAuth", "tokenAuth" };
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call patchClusterNodepoolValidateBeforeCall(UUID clusterId, UUID nodepoolId, PatchNodePoolRequest patchNodePoolRequest, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling patchClusterNodepool(Async)");
        }
        
        // verify the required parameter 'nodepoolId' is set
        if (nodepoolId == null) {
            throw new ApiException("Missing the required parameter 'nodepoolId' when calling patchClusterNodepool(Async)");
        }
        
        // verify the required parameter 'patchNodePoolRequest' is set
        if (patchNodePoolRequest == null) {
            throw new ApiException("Missing the required parameter 'patchNodePoolRequest' when calling patchClusterNodepool(Async)");
        }
        

        okhttp3.Call localVarCall = patchClusterNodepoolCall(clusterId, nodepoolId, patchNodePoolRequest, _callback);
        return localVarCall;

    }

    /**
     * Partially modify a DataPlatformNodePool
     * Modifies the specified node pool of a DataPlatformCluster. Update selected attributes of a node pool belonging to a Kubernetes cluster running Stackable.  The fields in the request body are applied to the cluster. Note that the application to the node pool  itself is performed asynchronously. You can check the sync state by querying the node pool with the GET method.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param patchNodePoolRequest Request payload with the properties that shall be applied to an existing DataPlatformNodePool.  (required)
     * @return NodePoolResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public NodePoolResponseData patchClusterNodepool(UUID clusterId, UUID nodepoolId, PatchNodePoolRequest patchNodePoolRequest) throws ApiException {
        ApiResponse<NodePoolResponseData> localVarResp = patchClusterNodepoolWithHttpInfo(clusterId, nodepoolId, patchNodePoolRequest);
        return localVarResp.getData();
    }

    /**
     * Partially modify a DataPlatformNodePool
     * Modifies the specified node pool of a DataPlatformCluster. Update selected attributes of a node pool belonging to a Kubernetes cluster running Stackable.  The fields in the request body are applied to the cluster. Note that the application to the node pool  itself is performed asynchronously. You can check the sync state by querying the node pool with the GET method.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param patchNodePoolRequest Request payload with the properties that shall be applied to an existing DataPlatformNodePool.  (required)
     * @return ApiResponse&lt;NodePoolResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<NodePoolResponseData> patchClusterNodepoolWithHttpInfo(UUID clusterId, UUID nodepoolId, PatchNodePoolRequest patchNodePoolRequest) throws ApiException {
        okhttp3.Call localVarCall = patchClusterNodepoolValidateBeforeCall(clusterId, nodepoolId, patchNodePoolRequest, null);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Partially modify a DataPlatformNodePool (asynchronously)
     * Modifies the specified node pool of a DataPlatformCluster. Update selected attributes of a node pool belonging to a Kubernetes cluster running Stackable.  The fields in the request body are applied to the cluster. Note that the application to the node pool  itself is performed asynchronously. You can check the sync state by querying the node pool with the GET method.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters.  The node pool ID can be found in the response when a node pool is created or when you GET a list of all node pools assigned to a specific DataPlatformCluster. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param nodepoolId The unique ID of the node pool. Must conform to the UUID format.  (required)
     * @param patchNodePoolRequest Request payload with the properties that shall be applied to an existing DataPlatformNodePool.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster node pool as stored after the create or update operation was applied or the DataPlatformCluster node pool properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occured. We appologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call patchClusterNodepoolAsync(UUID clusterId, UUID nodepoolId, PatchNodePoolRequest patchNodePoolRequest, final ApiCallback<NodePoolResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = patchClusterNodepoolValidateBeforeCall(clusterId, nodepoolId, patchNodePoolRequest, _callback);
        Type localVarReturnType = new TypeToken<NodePoolResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
