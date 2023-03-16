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
import com.ionoscloud.dataplatform.model.AvailabilityZone;
import com.ionoscloud.dataplatform.model.MaintenanceWindow;
import com.ionoscloud.dataplatform.model.StorageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.UUID;

/**
 * A DataPlatformNodePool of a DataPlatformCluster
 */
@ApiModel(description = "A DataPlatformNodePool of a DataPlatformCluster")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-16T08:16:57.124Z[Etc/UTC]")

public class NodePool {
  
  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;


  public static final String SERIALIZED_NAME_DATA_PLATFORM_VERSION = "dataPlatformVersion";
  @SerializedName(SERIALIZED_NAME_DATA_PLATFORM_VERSION)
  private String dataPlatformVersion;


  public static final String SERIALIZED_NAME_DATACENTER_ID = "datacenterId";
  @SerializedName(SERIALIZED_NAME_DATACENTER_ID)
  private UUID datacenterId;


  public static final String SERIALIZED_NAME_NODE_COUNT = "nodeCount";
  @SerializedName(SERIALIZED_NAME_NODE_COUNT)
  private Integer nodeCount;


  public static final String SERIALIZED_NAME_CPU_FAMILY = "cpuFamily";
  @SerializedName(SERIALIZED_NAME_CPU_FAMILY)
  private String cpuFamily = "AUTO";


  public static final String SERIALIZED_NAME_CORES_COUNT = "coresCount";
  @SerializedName(SERIALIZED_NAME_CORES_COUNT)
  private Integer coresCount = 4;


  public static final String SERIALIZED_NAME_RAM_SIZE = "ramSize";
  @SerializedName(SERIALIZED_NAME_RAM_SIZE)
  private Integer ramSize = 4096;


  public static final String SERIALIZED_NAME_AVAILABILITY_ZONE = "availabilityZone";
  @SerializedName(SERIALIZED_NAME_AVAILABILITY_ZONE)
  private AvailabilityZone availabilityZone = AvailabilityZone.AUTO;


  public static final String SERIALIZED_NAME_STORAGE_TYPE = "storageType";
  @SerializedName(SERIALIZED_NAME_STORAGE_TYPE)
  private StorageType storageType = StorageType.SSD;


  public static final String SERIALIZED_NAME_STORAGE_SIZE = "storageSize";
  @SerializedName(SERIALIZED_NAME_STORAGE_SIZE)
  private Integer storageSize = 20;


  public static final String SERIALIZED_NAME_MAINTENANCE_WINDOW = "maintenanceWindow";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_WINDOW)
  private MaintenanceWindow maintenanceWindow;


  public static final String SERIALIZED_NAME_LABELS = "labels";
  @SerializedName(SERIALIZED_NAME_LABELS)
  private Object labels;


  public static final String SERIALIZED_NAME_ANNOTATIONS = "annotations";
  @SerializedName(SERIALIZED_NAME_ANNOTATIONS)
  private Object annotations;

  

  public NodePool name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of your node pool. Must be 63 characters or less and must begin and end with an alphanumeric character ([a-z0-9A-Z]) with dashes (-), underscores (_), dots (.), and alphanumerics between. 
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "my-node-pool", value = "The name of your node pool. Must be 63 characters or less and must begin and end with an alphanumeric character ([a-z0-9A-Z]) with dashes (-), underscores (_), dots (.), and alphanumerics between. ")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }



  public NodePool dataPlatformVersion(String dataPlatformVersion) {
    
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



  public NodePool datacenterId(UUID datacenterId) {
    
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



  public NodePool nodeCount(Integer nodeCount) {
    
    this.nodeCount = nodeCount;
    return this;
  }

   /**
   * The number of nodes that make up the node pool. 
   * minimum: 1
   * @return nodeCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "The number of nodes that make up the node pool. ")

  public Integer getNodeCount() {
    return nodeCount;
  }


  public void setNodeCount(Integer nodeCount) {
    this.nodeCount = nodeCount;
  }



  public NodePool cpuFamily(String cpuFamily) {
    
    this.cpuFamily = cpuFamily;
    return this;
  }

   /**
   * A valid CPU family name or &#x60;AUTO&#x60; if the platform shall choose the best fitting option. Available CPU architectures can be retrieved from the datacenter resource. 
   * @return cpuFamily
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "AUTO", value = "A valid CPU family name or `AUTO` if the platform shall choose the best fitting option. Available CPU architectures can be retrieved from the datacenter resource. ")

  public String getCpuFamily() {
    return cpuFamily;
  }


  public void setCpuFamily(String cpuFamily) {
    this.cpuFamily = cpuFamily;
  }



  public NodePool coresCount(Integer coresCount) {
    
    this.coresCount = coresCount;
    return this;
  }

   /**
   * The number of CPU cores per node. 
   * minimum: 1
   * @return coresCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "4", value = "The number of CPU cores per node. ")

  public Integer getCoresCount() {
    return coresCount;
  }


  public void setCoresCount(Integer coresCount) {
    this.coresCount = coresCount;
  }



  public NodePool ramSize(Integer ramSize) {
    
    this.ramSize = ramSize;
    return this;
  }

   /**
   * The RAM size for one node in MB. Must be set in multiples of 1024 MB, with a minimum size is of 2048 MB.
   * minimum: 2048
   * @return ramSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "4096", value = "The RAM size for one node in MB. Must be set in multiples of 1024 MB, with a minimum size is of 2048 MB.")

  public Integer getRamSize() {
    return ramSize;
  }


  public void setRamSize(Integer ramSize) {
    this.ramSize = ramSize;
  }



  public NodePool availabilityZone(AvailabilityZone availabilityZone) {
    
    this.availabilityZone = availabilityZone;
    return this;
  }

   /**
   * Get availabilityZone
   * @return availabilityZone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AvailabilityZone getAvailabilityZone() {
    return availabilityZone;
  }


  public void setAvailabilityZone(AvailabilityZone availabilityZone) {
    this.availabilityZone = availabilityZone;
  }



  public NodePool storageType(StorageType storageType) {
    
    this.storageType = storageType;
    return this;
  }

   /**
   * Get storageType
   * @return storageType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public StorageType getStorageType() {
    return storageType;
  }


  public void setStorageType(StorageType storageType) {
    this.storageType = storageType;
  }



  public NodePool storageSize(Integer storageSize) {
    
    this.storageSize = storageSize;
    return this;
  }

   /**
   * The size of the volume in GB. The size must be greater than 10GB.
   * minimum: 10
   * @return storageSize
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "20", value = "The size of the volume in GB. The size must be greater than 10GB.")

  public Integer getStorageSize() {
    return storageSize;
  }


  public void setStorageSize(Integer storageSize) {
    this.storageSize = storageSize;
  }



  public NodePool maintenanceWindow(MaintenanceWindow maintenanceWindow) {
    
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



  public NodePool labels(Object labels) {
    
    this.labels = labels;
    return this;
  }

   /**
   * Key-value pairs attached to the node pool resource as [Kubernetes labels](https://kubernetes.io/docs/concepts/overview/working-with-objects/labels/) 
   * @return labels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{\"foo\":\"bar\"}", value = "Key-value pairs attached to the node pool resource as [Kubernetes labels](https://kubernetes.io/docs/concepts/overview/working-with-objects/labels/) ")

  public Object getLabels() {
    return labels;
  }


  public void setLabels(Object labels) {
    this.labels = labels;
  }



  public NodePool annotations(Object annotations) {
    
    this.annotations = annotations;
    return this;
  }

   /**
   * Key-value pairs attached to node pool resource as [Kubernetes annotations](https://kubernetes.io/docs/concepts/overview/working-with-objects/annotations/) 
   * @return annotations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "{\"foo\":\"bar\"}", value = "Key-value pairs attached to node pool resource as [Kubernetes annotations](https://kubernetes.io/docs/concepts/overview/working-with-objects/annotations/) ")

  public Object getAnnotations() {
    return annotations;
  }


  public void setAnnotations(Object annotations) {
    this.annotations = annotations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodePool nodePool = (NodePool) o;
    return Objects.equals(this.name, nodePool.name) && Objects.equals(this.dataPlatformVersion, nodePool.dataPlatformVersion) && Objects.equals(this.datacenterId, nodePool.datacenterId) && Objects.equals(this.nodeCount, nodePool.nodeCount) && Objects.equals(this.cpuFamily, nodePool.cpuFamily) && Objects.equals(this.coresCount, nodePool.coresCount) && Objects.equals(this.ramSize, nodePool.ramSize) && Objects.equals(this.availabilityZone, nodePool.availabilityZone) && Objects.equals(this.storageType, nodePool.storageType) && Objects.equals(this.storageSize, nodePool.storageSize) && Objects.equals(this.maintenanceWindow, nodePool.maintenanceWindow) && Objects.equals(this.labels, nodePool.labels) && Objects.equals(this.annotations, nodePool.annotations);
  }




  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodePool {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");

    sb.append("    dataPlatformVersion: ").append(toIndentedString(dataPlatformVersion)).append("\n");

    sb.append("    datacenterId: ").append(toIndentedString(datacenterId)).append("\n");

    sb.append("    nodeCount: ").append(toIndentedString(nodeCount)).append("\n");

    sb.append("    cpuFamily: ").append(toIndentedString(cpuFamily)).append("\n");

    sb.append("    coresCount: ").append(toIndentedString(coresCount)).append("\n");

    sb.append("    ramSize: ").append(toIndentedString(ramSize)).append("\n");

    sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");

    sb.append("    storageType: ").append(toIndentedString(storageType)).append("\n");

    sb.append("    storageSize: ").append(toIndentedString(storageSize)).append("\n");

    sb.append("    maintenanceWindow: ").append(toIndentedString(maintenanceWindow)).append("\n");

    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");

    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
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

