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


package com.ionoscloud.dataplatform.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * Metadata of the resource
 */
@ApiModel(description = "Metadata of the resource")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-03-24T08:29:47.972Z[Etc/UTC]")

public class Metadata {
  
  public static final String SERIALIZED_NAME_ETAG = "ETag";
  @SerializedName(SERIALIZED_NAME_ETAG)
  private String etag;


  public static final String SERIALIZED_NAME_CREATED_DATE = "createdDate";
  @SerializedName(SERIALIZED_NAME_CREATED_DATE)
  private OffsetDateTime createdDate;


  public static final String SERIALIZED_NAME_CREATED_BY = "createdBy";
  @SerializedName(SERIALIZED_NAME_CREATED_BY)
  private String createdBy;


  public static final String SERIALIZED_NAME_CREATED_BY_USER_ID = "createdByUserId";
  @SerializedName(SERIALIZED_NAME_CREATED_BY_USER_ID)
  private String createdByUserId;


  public static final String SERIALIZED_NAME_CREATED_IN_CONTRACT_NUMBER = "createdInContractNumber";
  @SerializedName(SERIALIZED_NAME_CREATED_IN_CONTRACT_NUMBER)
  private String createdInContractNumber;


  public static final String SERIALIZED_NAME_LAST_MODIFIED_DATE = "lastModifiedDate";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED_DATE)
  private OffsetDateTime lastModifiedDate;


  public static final String SERIALIZED_NAME_LAST_MODIFIED_BY = "lastModifiedBy";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED_BY)
  private String lastModifiedBy;


  public static final String SERIALIZED_NAME_LAST_MODIFIED_BY_USER_ID = "lastModifiedByUserId";
  @SerializedName(SERIALIZED_NAME_LAST_MODIFIED_BY_USER_ID)
  private String lastModifiedByUserId;


  public static final String SERIALIZED_NAME_CURRENT_DATA_PLATFORM_VERSION = "currentDataPlatformVersion";
  @SerializedName(SERIALIZED_NAME_CURRENT_DATA_PLATFORM_VERSION)
  private String currentDataPlatformVersion;


  public static final String SERIALIZED_NAME_CURRENT_DATA_PLATFORM_REVISION = "currentDataPlatformRevision";
  @SerializedName(SERIALIZED_NAME_CURRENT_DATA_PLATFORM_REVISION)
  private Long currentDataPlatformRevision;


  public static final String SERIALIZED_NAME_AVAILABLE_UPGRADE_VERSIONS = "availableUpgradeVersions";
  @SerializedName(SERIALIZED_NAME_AVAILABLE_UPGRADE_VERSIONS)
  private List<String> availableUpgradeVersions = null;


  /**
   * State of the resource. *AVAILABLE* There are no pending modification requests for this item; *BUSY* There is at least one modification request pending and all following requests will be queued; *DEPLOYING* Resource state DEPLOYING - the resource is being created; *FAILED* Resource state FAILED - creation of the resource failed; *UPDATING* Resource state UPDATING - the resource is being updated; *FAILED_UPDATING* Resource state FAILED_UPDATING - an update to the resource was not successful; *DESTROYING* Resource state DESTROYING - the resource is being deleted; *FAILED_DESTROYING* Resource state FAILED_DESTROYING - deletion of the resource was not successful; *TERMINATED* Resource state TERMINATED - the resource was deleted. 
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    AVAILABLE("AVAILABLE"),
    
    BUSY("BUSY"),
    
    DEPLOYING("DEPLOYING"),
    
    FAILED("FAILED"),
    
    UPDATING("UPDATING"),
    
    FAILED_UPDATING("FAILED_UPDATING"),
    
    DESTROYING("DESTROYING"),
    
    FAILED_DESTROYING("FAILED_DESTROYING"),
    
    TERMINATED("TERMINATED");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StateEnum fromValue(String value) {

      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private StateEnum state;

  

  public Metadata etag(String etag) {
    
    this.etag = etag;
    return this;
  }

   /**
   * The Entity Tag of the resource as defined in http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.11
   * @return etag
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "123aaa5d587dcd0d58f767d464abcdef", value = "The Entity Tag of the resource as defined in http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.11")

  public String getEtag() {
    return etag;
  }


  public void setEtag(String etag) {
    this.etag = etag;
  }



  public Metadata createdDate(OffsetDateTime createdDate) {
    
    this.createdDate = createdDate;
    return this;
  }

   /**
   * The time the resource was created, ISO 8601 timestamp (UTC).
   * @return createdDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2020-12-10T13:37:50Z", value = "The time the resource was created, ISO 8601 timestamp (UTC).")

  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }


  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }



  public Metadata createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * The user that created the resource
   * @return createdBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "john.doe@example.com", value = "The user that created the resource")

  public String getCreatedBy() {
    return createdBy;
  }


  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }



  public Metadata createdByUserId(String createdByUserId) {
    
    this.createdByUserId = createdByUserId;
    return this;
  }

   /**
   * The ID of the user that created the resource
   * @return createdByUserId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12345693-9ae1-40c5-9b49-7c0afeabcdef", value = "The ID of the user that created the resource")

  public String getCreatedByUserId() {
    return createdByUserId;
  }


  public void setCreatedByUserId(String createdByUserId) {
    this.createdByUserId = createdByUserId;
  }



  public Metadata createdInContractNumber(String createdInContractNumber) {
    
    this.createdInContractNumber = createdInContractNumber;
    return this;
  }

   /**
   * The creators contractNumber
   * @return createdInContractNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12315812", value = "The creators contractNumber")

  public String getCreatedInContractNumber() {
    return createdInContractNumber;
  }


  public void setCreatedInContractNumber(String createdInContractNumber) {
    this.createdInContractNumber = createdInContractNumber;
  }



  public Metadata lastModifiedDate(OffsetDateTime lastModifiedDate) {
    
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

   /**
   * The last time the resource was modified, ISO 8601 timestamp (UTC).
   * @return lastModifiedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2020-12-11T13:37:50Z", value = "The last time the resource was modified, ISO 8601 timestamp (UTC).")

  public OffsetDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }


  public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }



  public Metadata lastModifiedBy(String lastModifiedBy) {
    
    this.lastModifiedBy = lastModifiedBy;
    return this;
  }

   /**
   * The user that last modified the resource
   * @return lastModifiedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "jane.doe@example.com", value = "The user that last modified the resource")

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }


  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }



  public Metadata lastModifiedByUserId(String lastModifiedByUserId) {
    
    this.lastModifiedByUserId = lastModifiedByUserId;
    return this;
  }

   /**
   * The ID of the user that last modified the resource
   * @return lastModifiedByUserId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "98765493-9ae1-40c5-9b49-7c0afefedcba", value = "The ID of the user that last modified the resource")

  public String getLastModifiedByUserId() {
    return lastModifiedByUserId;
  }


  public void setLastModifiedByUserId(String lastModifiedByUserId) {
    this.lastModifiedByUserId = lastModifiedByUserId;
  }



  public Metadata currentDataPlatformVersion(String currentDataPlatformVersion) {
    
    this.currentDataPlatformVersion = currentDataPlatformVersion;
    return this;
  }

   /**
   * The version of the data platform. 
   * @return currentDataPlatformVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "22.11", value = "The version of the data platform. ")

  public String getCurrentDataPlatformVersion() {
    return currentDataPlatformVersion;
  }


  public void setCurrentDataPlatformVersion(String currentDataPlatformVersion) {
    this.currentDataPlatformVersion = currentDataPlatformVersion;
  }



  public Metadata currentDataPlatformRevision(Long currentDataPlatformRevision) {
    
    this.currentDataPlatformRevision = currentDataPlatformRevision;
    return this;
  }

   /**
   * The current data platform revision of a resource. This internal revision is used to roll out non-breaking internal changes. This attribute is read-only. 
   * minimum: 0
   * @return currentDataPlatformRevision
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "The current data platform revision of a resource. This internal revision is used to roll out non-breaking internal changes. This attribute is read-only. ")

  public Long getCurrentDataPlatformRevision() {
    return currentDataPlatformRevision;
  }


  public void setCurrentDataPlatformRevision(Long currentDataPlatformRevision) {
    this.currentDataPlatformRevision = currentDataPlatformRevision;
  }



  public Metadata availableUpgradeVersions(List<String> availableUpgradeVersions) {
    
    this.availableUpgradeVersions = availableUpgradeVersions;
    return this;
  }

  public Metadata addAvailableUpgradeVersionsItem(String availableUpgradeVersionsItem) {
    if (this.availableUpgradeVersions == null) {
      this.availableUpgradeVersions = new ArrayList<String>();
    }
    this.availableUpgradeVersions.add(availableUpgradeVersionsItem);
    return this;
  }

   /**
   * List of available upgrades for this cluster
   * @return availableUpgradeVersions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of available upgrades for this cluster")

  public List<String> getAvailableUpgradeVersions() {
    return availableUpgradeVersions;
  }


  public void setAvailableUpgradeVersions(List<String> availableUpgradeVersions) {
    this.availableUpgradeVersions = availableUpgradeVersions;
  }



  public Metadata state(StateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * State of the resource. *AVAILABLE* There are no pending modification requests for this item; *BUSY* There is at least one modification request pending and all following requests will be queued; *DEPLOYING* Resource state DEPLOYING - the resource is being created; *FAILED* Resource state FAILED - creation of the resource failed; *UPDATING* Resource state UPDATING - the resource is being updated; *FAILED_UPDATING* Resource state FAILED_UPDATING - an update to the resource was not successful; *DESTROYING* Resource state DESTROYING - the resource is being deleted; *FAILED_DESTROYING* Resource state FAILED_DESTROYING - deletion of the resource was not successful; *TERMINATED* Resource state TERMINATED - the resource was deleted. 
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "AVAILABLE", value = "State of the resource. *AVAILABLE* There are no pending modification requests for this item; *BUSY* There is at least one modification request pending and all following requests will be queued; *DEPLOYING* Resource state DEPLOYING - the resource is being created; *FAILED* Resource state FAILED - creation of the resource failed; *UPDATING* Resource state UPDATING - the resource is being updated; *FAILED_UPDATING* Resource state FAILED_UPDATING - an update to the resource was not successful; *DESTROYING* Resource state DESTROYING - the resource is being deleted; *FAILED_DESTROYING* Resource state FAILED_DESTROYING - deletion of the resource was not successful; *TERMINATED* Resource state TERMINATED - the resource was deleted. ")

  public StateEnum getState() {
    return state;
  }


  public void setState(StateEnum state) {
    this.state = state;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Metadata metadata = (Metadata) o;
    return Objects.equals(this.etag, metadata.etag) && Objects.equals(this.createdDate, metadata.createdDate) && Objects.equals(this.createdBy, metadata.createdBy) && Objects.equals(this.createdByUserId, metadata.createdByUserId) && Objects.equals(this.createdInContractNumber, metadata.createdInContractNumber) && Objects.equals(this.lastModifiedDate, metadata.lastModifiedDate) && Objects.equals(this.lastModifiedBy, metadata.lastModifiedBy) && Objects.equals(this.lastModifiedByUserId, metadata.lastModifiedByUserId) && Objects.equals(this.currentDataPlatformVersion, metadata.currentDataPlatformVersion) && Objects.equals(this.currentDataPlatformRevision, metadata.currentDataPlatformRevision) && Objects.equals(this.availableUpgradeVersions, metadata.availableUpgradeVersions) && Objects.equals(this.state, metadata.state);
  }




  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metadata {\n");
    
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");

    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");

    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");

    sb.append("    createdByUserId: ").append(toIndentedString(createdByUserId)).append("\n");

    sb.append("    createdInContractNumber: ").append(toIndentedString(createdInContractNumber)).append("\n");

    sb.append("    lastModifiedDate: ").append(toIndentedString(lastModifiedDate)).append("\n");

    sb.append("    lastModifiedBy: ").append(toIndentedString(lastModifiedBy)).append("\n");

    sb.append("    lastModifiedByUserId: ").append(toIndentedString(lastModifiedByUserId)).append("\n");

    sb.append("    currentDataPlatformVersion: ").append(toIndentedString(currentDataPlatformVersion)).append("\n");

    sb.append("    currentDataPlatformRevision: ").append(toIndentedString(currentDataPlatformRevision)).append("\n");

    sb.append("    availableUpgradeVersions: ").append(toIndentedString(availableUpgradeVersions)).append("\n");

    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

