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


package com.ionoscloud.dataplatform.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.ionoscloud.dataplatform.model.MaintenanceWindow;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.UUID;

/**
 * A DataPlatformCluster
 */
@ApiModel(description = "A DataPlatformCluster")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-14T12:03:12.246Z[Etc/UTC]")

public class Cluster {
  
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;


  public static final String SERIALIZED_NAME_DATA_PLATFORM_VERSION = "dataPlatformVersion";
  @SerializedName(SERIALIZED_NAME_DATA_PLATFORM_VERSION)
  private String dataPlatformVersion;


  public static final String SERIALIZED_NAME_DATACENTER_ID = "datacenterId";
  @SerializedName(SERIALIZED_NAME_DATACENTER_ID)
  private UUID datacenterId;


  public static final String SERIALIZED_NAME_MAINTENANCE_WINDOW = "maintenanceWindow";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_WINDOW)
  private MaintenanceWindow maintenanceWindow;

  

  public Cluster name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of your cluster. Must be 63 characters or less and must begin and end with an alphanumeric character ([a-z0-9A-Z]) with dashes (-), underscores (_), dots (.), and alphanumerics between. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "my-cluster", value = "The name of your cluster. Must be 63 characters or less and must begin and end with an alphanumeric character ([a-z0-9A-Z]) with dashes (-), underscores (_), dots (.), and alphanumerics between. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }



  public Cluster dataPlatformVersion(String dataPlatformVersion) {
    
    this.dataPlatformVersion = dataPlatformVersion;
    return this;
  }

   /**
   * The version of the DataPlatform. 
   * @return dataPlatformVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1.0.0", value = "The version of the DataPlatform. ")

  public String getDataPlatformVersion() {
    return dataPlatformVersion;
  }


  public void setDataPlatformVersion(String dataPlatformVersion) {
    this.dataPlatformVersion = dataPlatformVersion;
  }



  public Cluster datacenterId(UUID datacenterId) {
    
    this.datacenterId = datacenterId;
    return this;
  }

   /**
   * The UUID of the virtual data center (VDC) the cluster is provisioned. 
   * @return datacenterId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The UUID of the virtual data center (VDC) the cluster is provisioned. ")

  public UUID getDatacenterId() {
    return datacenterId;
  }


  public void setDatacenterId(UUID datacenterId) {
    this.datacenterId = datacenterId;
  }



  public Cluster maintenanceWindow(MaintenanceWindow maintenanceWindow) {
    
    this.maintenanceWindow = maintenanceWindow;
    return this;
  }

   /**
   * Get maintenanceWindow
   * @return maintenanceWindow
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public MaintenanceWindow getMaintenanceWindow() {
    return maintenanceWindow;
  }


  public void setMaintenanceWindow(MaintenanceWindow maintenanceWindow) {
    this.maintenanceWindow = maintenanceWindow;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cluster cluster = (Cluster) o;
    return Objects.equals(this.name, cluster.name) && Objects.equals(this.dataPlatformVersion, cluster.dataPlatformVersion) && Objects.equals(this.datacenterId, cluster.datacenterId) && Objects.equals(this.maintenanceWindow, cluster.maintenanceWindow);
  }




  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cluster {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");

    sb.append("    dataPlatformVersion: ").append(toIndentedString(dataPlatformVersion)).append("\n");

    sb.append("    datacenterId: ").append(toIndentedString(datacenterId)).append("\n");

    sb.append("    maintenanceWindow: ").append(toIndentedString(maintenanceWindow)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

