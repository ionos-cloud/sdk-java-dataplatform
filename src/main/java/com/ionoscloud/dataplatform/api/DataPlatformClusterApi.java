/*
 * IONOS Cloud - Managed Stackable Data Platform API
 * Managed Stackable Data Platform by IONOS Cloud provides a preconfigured Kubernetes cluster with pre-installed and managed Stackable operators. After the provision of these Stackable operators, the customer can interact with them directly and build his desired application on top of the Stackable platform.  The Managed Stackable Data Platform by IONOS Cloud can be configured through the IONOS Cloud API in addition or as an alternative to the \"Data Center Designer\" (DCD).  ## Getting Started  To get your DataPlatformCluster up and running, the following steps needs to be performed.  ### IONOS Cloud Account  The first step is the creation of a IONOS Cloud account if not already existing.  To register a **new account** visit [cloud.ionos.com](https://cloud.ionos.com/compute/signup).  ### Virtual Data Center (VDC)  The Managed Stackable Data Platform needs a virtual data center (VDC) hosting the cluster. This could either be a VDC that already exists, especially if you want to connect the managed data platform to other services already running within your VDC. Otherwise, if you want to place the Managed Stackable Data Platform in a new VDC or you have not yet created a VDC, you need to do so.  A new VDC can be created via the IONOS Cloud API, the IONOS Cloud CLI (ionosctl), or the DCD Web interface. For more information, see the [official documentation](https://docs.ionos.com/cloud/getting-started/tutorials/data-center-basics)  ### Get a authentication token  To interact with this API a user specific authentication token is needed. This token can be generated using the IONOS Cloud CLI the following way:  ``` ionosctl token generate ```  For more information [see](https://docs.ionos.com/cli-ionosctl/subcommands/authentication/token-generate)  ### Create a new DataPlatformCluster  Before using the Managed Stackable Data Platform, a new DataPlatformCluster must be created.  To create a cluster, use the [Create DataPlatformCluster](paths./clusters.post) API endpoint.  The provisioning of the cluster might take some time. To check the current provisioning status, you can query the cluster by calling the [Get Endpoint](#/DataPlatformCluster/getCluster) with the cluster ID that was presented to you in the response of the create cluster call.  ### Add a DataPlatformNodePool  To deploy and run a Stackable service, the cluster must have enough computational resources. The node pool that is provisioned along with the cluster is reserved for the Stackable operators. You may create further node pools with resources tailored to your use-case.  To create a new node pool use the [Create DataPlatformNodepool](paths./clusters/{clusterId}/nodepools.post) endpoint.  ### Receive Kubeconfig  Once the DataPlatformCluster is created, the kubeconfig can be accessed by the API. The kubeconfig allows the interaction with the provided cluster as with any regular Kubernetes cluster.  The kubeconfig can be downloaded with the [Get Kubeconfig](paths./clusters/{clusterId}/kubeconfig.get) endpoint using the cluster ID of the created DataPlatformCluster.  ### Create Stackable Service  To create the desired application, the Stackable service needs to be provided, using the received kubeconfig and [deploy a Stackable service](https://docs.stackable.tech/home/getting_started.html#_deploying_stackable_services)  ## Authorization  All endpoints are secured, so only an authenticated user can access them. As Authentication mechanism the default IONOS Cloud authentication mechanism is used. A detailed description can be found [here](https://api.ionos.com/docs/authentication/).  ### Basic Auth  The basic auth scheme uses the IONOS Cloud user credentials in form of a Basic Authentication Header accordingly to [RFC7617](https://datatracker.ietf.org/doc/html/rfc7617)  ### API Key as Bearer Token  The Bearer auth token used at the API Gateway is a user-related token created with the IONOS Cloud CLI. (See the [documentation](https://docs.ionos.com/cli-ionosctl/subcommands/authentication/token-generate) for details) For every request to be authenticated, the token is passed as 'Authorization Bearer' header along with the request.  ### Permissions and Access Roles  Currently, an admin can see and manipulate all resources in a contract. A normal authenticated user can only see and manipulate resources he created.  ## Components  The Managed Stackable Data Platform by IONOS Cloud consists of two components. The concept of a DataPlatformClusters and the backing DataPlatformNodePools the cluster is build on.  ### DataPlatformCluster  A DataPlatformCluster is the virtual instance of the customer services and operations running the managed services like Stackable operators. A DataPlatformCluster is a Kubernetes Cluster in the VDC of the customer. Therefore, it's possible to integrate the cluster with other resources as VLANs e.g. to shape the data center in the customer's need and integrate the cluster within the topology the customer wants to build.  In addition to the Kubernetes cluster, a small node pool is provided which is exclusively used to run the Stackable operators.  ### DataPlatformNodePool  A DataPlatformNodePool represents the physical machines a DataPlatformCluster is build on top. All nodes within a node pool are identical in setup. The nodes of a pool are provisioned into virtual data centers at a location of your choice and you can freely specify the properties of all the nodes at once before creation.  Nodes in node pools provisioned by the Managed Stackable Data Platform Cloud API are read-only in the customer's VDC and can only be modified or deleted via the API.  ## References 
 *
 * The version of the OpenAPI document: 0.0.8
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


import com.ionoscloud.dataplatform.model.ClusterListResponseData;
import com.ionoscloud.dataplatform.model.ClusterResponseData;
import com.ionoscloud.dataplatform.model.CreateClusterRequest;
import com.ionoscloud.dataplatform.model.ErrorResponse;
import com.ionoscloud.dataplatform.model.PatchClusterRequest;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPlatformClusterApi {
    private ApiClient localVarApiClient;

    public DataPlatformClusterApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DataPlatformClusterApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for clustersDelete
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersDeleteCall(UUID clusterId, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}"
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
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call clustersDeleteValidateBeforeCall(UUID clusterId, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling clustersDelete(Async)");
        }
        

        okhttp3.Call localVarCall = clustersDeleteCall(clusterId, _callback);
        return localVarCall;

    }

    /**
     * Delete a DataPlatformCluster
     * Deletes the specified DataPlatformCluster by its distinct cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return ClusterResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ClusterResponseData clustersDelete(UUID clusterId) throws ApiException {
        ApiResponse<ClusterResponseData> localVarResp = clustersDeleteWithHttpInfo(clusterId);
        return localVarResp.getData();
    }

    /**
     * Delete a DataPlatformCluster
     * Deletes the specified DataPlatformCluster by its distinct cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return ApiResponse&lt;ClusterResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ClusterResponseData> clustersDeleteWithHttpInfo(UUID clusterId) throws ApiException {
        okhttp3.Call localVarCall = clustersDeleteValidateBeforeCall(clusterId, null);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete a DataPlatformCluster (asynchronously)
     * Deletes the specified DataPlatformCluster by its distinct cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersDeleteAsync(UUID clusterId, final ApiCallback<ClusterResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = clustersDeleteValidateBeforeCall(clusterId, _callback);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for clustersFindById
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersFindByIdCall(UUID clusterId, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}"
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
    private okhttp3.Call clustersFindByIdValidateBeforeCall(UUID clusterId, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling clustersFindById(Async)");
        }
        

        okhttp3.Call localVarCall = clustersFindByIdCall(clusterId, _callback);
        return localVarCall;

    }

    /**
     * Retrieve a DataPlatformCluster
     * Retrieve the specified DataPlatformCluster by its distinct ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return ClusterResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ClusterResponseData clustersFindById(UUID clusterId) throws ApiException {
        ApiResponse<ClusterResponseData> localVarResp = clustersFindByIdWithHttpInfo(clusterId);
        return localVarResp.getData();
    }

    /**
     * Retrieve a DataPlatformCluster
     * Retrieve the specified DataPlatformCluster by its distinct ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return ApiResponse&lt;ClusterResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ClusterResponseData> clustersFindByIdWithHttpInfo(UUID clusterId) throws ApiException {
        okhttp3.Call localVarCall = clustersFindByIdValidateBeforeCall(clusterId, null);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve a DataPlatformCluster (asynchronously)
     * Retrieve the specified DataPlatformCluster by its distinct ID.  The cluster ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersFindByIdAsync(UUID clusterId, final ApiCallback<ClusterResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = clustersFindByIdValidateBeforeCall(clusterId, _callback);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for clustersGet
     * @param name Response filter to list only the clusters which include the specified name. The value is case insensitive and matched on the &#x60;name&#x60; property of the cluster. The input is limited to 63 characters with alphanumeric characters ([a-z0-9A-Z]), dashes (-), underscores (_), and dots (.) allowed.  (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of DataPlatformClusters the user can access and that fits the filter if the filter parameter was used.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersGetCall(String name, final ApiCallback<ClusterListResponseData> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (name != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("name", name));
        }

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
    private okhttp3.Call clustersGetValidateBeforeCall(String name, final ApiCallback<ClusterListResponseData> _callback) throws ApiException {
        

        okhttp3.Call localVarCall = clustersGetCall(name, _callback);
        return localVarCall;

    }

    /**
     * List the DataPlatformClusters
     * List all available DataPlatformClusters that can be accessed by the user.  The user might filter the request for the name of the DataPlatformCluster. If no cluster is available matching the request, the list will be empty. 
     * @param name Response filter to list only the clusters which include the specified name. The value is case insensitive and matched on the &#x60;name&#x60; property of the cluster. The input is limited to 63 characters with alphanumeric characters ([a-z0-9A-Z]), dashes (-), underscores (_), and dots (.) allowed.  (optional)
     * @return ClusterListResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of DataPlatformClusters the user can access and that fits the filter if the filter parameter was used.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ClusterListResponseData clustersGet(String name) throws ApiException {
        ApiResponse<ClusterListResponseData> localVarResp = clustersGetWithHttpInfo(name);
        return localVarResp.getData();
    }

    /**
     * List the DataPlatformClusters
     * List all available DataPlatformClusters that can be accessed by the user.  The user might filter the request for the name of the DataPlatformCluster. If no cluster is available matching the request, the list will be empty. 
     * @param name Response filter to list only the clusters which include the specified name. The value is case insensitive and matched on the &#x60;name&#x60; property of the cluster. The input is limited to 63 characters with alphanumeric characters ([a-z0-9A-Z]), dashes (-), underscores (_), and dots (.) allowed.  (optional)
     * @return ApiResponse&lt;ClusterListResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of DataPlatformClusters the user can access and that fits the filter if the filter parameter was used.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ClusterListResponseData> clustersGetWithHttpInfo(String name) throws ApiException {
        okhttp3.Call localVarCall = clustersGetValidateBeforeCall(name, null);
        Type localVarReturnType = new TypeToken<ClusterListResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List the DataPlatformClusters (asynchronously)
     * List all available DataPlatformClusters that can be accessed by the user.  The user might filter the request for the name of the DataPlatformCluster. If no cluster is available matching the request, the list will be empty. 
     * @param name Response filter to list only the clusters which include the specified name. The value is case insensitive and matched on the &#x60;name&#x60; property of the cluster. The input is limited to 63 characters with alphanumeric characters ([a-z0-9A-Z]), dashes (-), underscores (_), and dots (.) allowed.  (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> List of DataPlatformClusters the user can access and that fits the filter if the filter parameter was used.  </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersGetAsync(String name, final ApiCallback<ClusterListResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = clustersGetValidateBeforeCall(name, _callback);
        Type localVarReturnType = new TypeToken<ClusterListResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for clustersKubeconfigFindByClusterId
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful operation. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersKubeconfigFindByClusterIdCall(UUID clusterId, final ApiCallback<Object> _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}/kubeconfig"
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
    private okhttp3.Call clustersKubeconfigFindByClusterIdValidateBeforeCall(UUID clusterId, final ApiCallback<Object> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling clustersKubeconfigFindByClusterId(Async)");
        }
        

        okhttp3.Call localVarCall = clustersKubeconfigFindByClusterIdCall(clusterId, _callback);
        return localVarCall;

    }

    /**
     * Read the Kubeconfig
     * Retrieves the Kubernetes configuration file (kubeconfig) for the specified DataPlatformCluster by its cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful operation. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public Object clustersKubeconfigFindByClusterId(UUID clusterId) throws ApiException {
        ApiResponse<Object> localVarResp = clustersKubeconfigFindByClusterIdWithHttpInfo(clusterId);
        return localVarResp.getData();
    }

    /**
     * Read the Kubeconfig
     * Retrieves the Kubernetes configuration file (kubeconfig) for the specified DataPlatformCluster by its cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful operation. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Object> clustersKubeconfigFindByClusterIdWithHttpInfo(UUID clusterId) throws ApiException {
        okhttp3.Call localVarCall = clustersKubeconfigFindByClusterIdValidateBeforeCall(clusterId, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Read the Kubeconfig (asynchronously)
     * Retrieves the Kubernetes configuration file (kubeconfig) for the specified DataPlatformCluster by its cluster ID.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Successful operation. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersKubeconfigFindByClusterIdAsync(UUID clusterId, final ApiCallback<Object> _callback) throws ApiException {

        okhttp3.Call localVarCall = clustersKubeconfigFindByClusterIdValidateBeforeCall(clusterId, _callback);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for clustersPatch
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param patchClusterRequest Request payload with the properties that shall be applied to an existing DataPlatformCluster.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersPatchCall(UUID clusterId, PatchClusterRequest patchClusterRequest, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        Object localVarPostBody = patchClusterRequest;

        // create path and map variables
        String localVarPath = "/clusters/{clusterId}"
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
        return localVarApiClient.buildCall(localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call clustersPatchValidateBeforeCall(UUID clusterId, PatchClusterRequest patchClusterRequest, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'clusterId' is set
        if (clusterId == null) {
            throw new ApiException("Missing the required parameter 'clusterId' when calling clustersPatch(Async)");
        }
        
        // verify the required parameter 'patchClusterRequest' is set
        if (patchClusterRequest == null) {
            throw new ApiException("Missing the required parameter 'patchClusterRequest' when calling clustersPatch(Async)");
        }
        

        okhttp3.Call localVarCall = clustersPatchCall(clusterId, patchClusterRequest, _callback);
        return localVarCall;

    }

    /**
     * Partially Modify a DataPlatformCluster
     * Modifies the specified DataPlatformCluster by its distinct cluster ID. The fields in the request body are applied to the cluster. Note that the application to the cluster itself is performed asynchronously. You can check the sync state by querying the cluster with the GET method.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param patchClusterRequest Request payload with the properties that shall be applied to an existing DataPlatformCluster.  (required)
     * @return ClusterResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ClusterResponseData clustersPatch(UUID clusterId, PatchClusterRequest patchClusterRequest) throws ApiException {
        ApiResponse<ClusterResponseData> localVarResp = clustersPatchWithHttpInfo(clusterId, patchClusterRequest);
        return localVarResp.getData();
    }

    /**
     * Partially Modify a DataPlatformCluster
     * Modifies the specified DataPlatformCluster by its distinct cluster ID. The fields in the request body are applied to the cluster. Note that the application to the cluster itself is performed asynchronously. You can check the sync state by querying the cluster with the GET method.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param patchClusterRequest Request payload with the properties that shall be applied to an existing DataPlatformCluster.  (required)
     * @return ApiResponse&lt;ClusterResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ClusterResponseData> clustersPatchWithHttpInfo(UUID clusterId, PatchClusterRequest patchClusterRequest) throws ApiException {
        okhttp3.Call localVarCall = clustersPatchValidateBeforeCall(clusterId, patchClusterRequest, null);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Partially Modify a DataPlatformCluster (asynchronously)
     * Modifies the specified DataPlatformCluster by its distinct cluster ID. The fields in the request body are applied to the cluster. Note that the application to the cluster itself is performed asynchronously. You can check the sync state by querying the cluster with the GET method.  The ID can be found in the response when a cluster is created or when you GET a list of all DataPlatformClusters. 
     * @param clusterId The unique ID of the cluster. Must conform to the UUID format.  (required)
     * @param patchClusterRequest Request payload with the properties that shall be applied to an existing DataPlatformCluster.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> ### Not Found  The resource that was requested could not be found.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersPatchAsync(UUID clusterId, PatchClusterRequest patchClusterRequest, final ApiCallback<ClusterResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = clustersPatchValidateBeforeCall(clusterId, patchClusterRequest, _callback);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for clustersPost
     * @param createClusterRequest Request payload with the properties that defines a new DataPlatformCluster and the credentials to interact with the PaaS API to create it.  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersPostCall(CreateClusterRequest createClusterRequest, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        Object localVarPostBody = createClusterRequest;

        // create path and map variables
        String localVarPath = "/clusters";

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
    private okhttp3.Call clustersPostValidateBeforeCall(CreateClusterRequest createClusterRequest, final ApiCallback<ClusterResponseData> _callback) throws ApiException {
        
        // verify the required parameter 'createClusterRequest' is set
        if (createClusterRequest == null) {
            throw new ApiException("Missing the required parameter 'createClusterRequest' when calling clustersPost(Async)");
        }
        

        okhttp3.Call localVarCall = clustersPostCall(createClusterRequest, _callback);
        return localVarCall;

    }

    /**
     * Create a DataPlatformCluster
     * Creates a new DataPlatformCluster.  The cluster will be provisioned in the data center matching the provided &#x60;datacenterID&#x60;. Therefore the data center must be created upfront and must be accessible by the user issuing the request.  To create a new virtual data center (VDC) [see](https://api.ionos.com/docs/cloud/v6/#Data-centers-post-datacenters). 
     * @param createClusterRequest Request payload with the properties that defines a new DataPlatformCluster and the credentials to interact with the PaaS API to create it.  (required)
     * @return ClusterResponseData
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ClusterResponseData clustersPost(CreateClusterRequest createClusterRequest) throws ApiException {
        ApiResponse<ClusterResponseData> localVarResp = clustersPostWithHttpInfo(createClusterRequest);
        return localVarResp.getData();
    }

    /**
     * Create a DataPlatformCluster
     * Creates a new DataPlatformCluster.  The cluster will be provisioned in the data center matching the provided &#x60;datacenterID&#x60;. Therefore the data center must be created upfront and must be accessible by the user issuing the request.  To create a new virtual data center (VDC) [see](https://api.ionos.com/docs/cloud/v6/#Data-centers-post-datacenters). 
     * @param createClusterRequest Request payload with the properties that defines a new DataPlatformCluster and the credentials to interact with the PaaS API to create it.  (required)
     * @return ApiResponse&lt;ClusterResponseData&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ClusterResponseData> clustersPostWithHttpInfo(CreateClusterRequest createClusterRequest) throws ApiException {
        okhttp3.Call localVarCall = clustersPostValidateBeforeCall(createClusterRequest, null);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a DataPlatformCluster (asynchronously)
     * Creates a new DataPlatformCluster.  The cluster will be provisioned in the data center matching the provided &#x60;datacenterID&#x60;. Therefore the data center must be created upfront and must be accessible by the user issuing the request.  To create a new virtual data center (VDC) [see](https://api.ionos.com/docs/cloud/v6/#Data-centers-post-datacenters). 
     * @param createClusterRequest Request payload with the properties that defines a new DataPlatformCluster and the credentials to interact with the PaaS API to create it.  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The DataPlatformCluster as stored after the create or update operation was applied or the DataPlatformCluster properties before the delete operation was performed.  </td><td>  * ETag -  <br>  </td></tr>
        <tr><td> 400 </td><td> ### Bad Request  The request send to the API was malformed.  </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> ### Unauthorized  The request is missing authorization information or the authorization information provided are expired.  </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> ### Not Allowed  The user issuing the request does not have the needed permissions.  </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> ### Internal Server Error  An internal error occurred. We apologize for the inconvenience!  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call clustersPostAsync(CreateClusterRequest createClusterRequest, final ApiCallback<ClusterResponseData> _callback) throws ApiException {

        okhttp3.Call localVarCall = clustersPostValidateBeforeCall(createClusterRequest, _callback);
        Type localVarReturnType = new TypeToken<ClusterResponseData>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
