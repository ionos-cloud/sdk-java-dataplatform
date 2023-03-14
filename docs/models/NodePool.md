

# NodePool

A DataPlatformNodePool of a DataPlatformCluster
## Properties

| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **name** | **String** | The name of your node pool. Must be 63 characters or less and must begin and end with an alphanumeric character ([a-z0-9A-Z]) with dashes (-), underscores (_), dots (.), and alphanumerics between.  |  [optional] |
| **dataPlatformVersion** | **String** | The version of the DataPlatform.  |  [optional] |
| **datacenterId** | [**UUID**](UUID.md) | The UUID of the virtual data center (VDC) the cluster is provisioned.  |  [optional] |
| **nodeCount** | **Integer** | The number of nodes that make up the node pool.  |  [optional] |
| **cpuFamily** | **String** | A valid CPU family name or &#x60;AUTO&#x60; if the platform shall choose the best fitting option. Available CPU architectures can be retrieved from the datacenter resource.  |  [optional] |
| **coresCount** | **Integer** | The number of CPU cores per node.  |  [optional] |
| **ramSize** | **Integer** | The RAM size for one node in MB. Must be set in multiples of 1024 MB, with a minimum size is of 2048 MB. |  [optional] |
| **availabilityZone** | [**AvailabilityZone**](AvailabilityZone.md) |  |  [optional] |
| **storageType** | [**StorageType**](StorageType.md) |  |  [optional] |
| **storageSize** | **Integer** | The size of the volume in GB. The size must be greater than 10GB. |  [optional] |
| **maintenanceWindow** | [**MaintenanceWindow**](MaintenanceWindow.md) |  |  [optional] |
| **labels** | **Object** | Key-value pairs attached to the node pool resource as [Kubernetes labels](https://kubernetes.io/docs/concepts/overview/working-with-objects/labels/)  |  [optional] |
| **annotations** | **Object** | Key-value pairs attached to node pool resource as [Kubernetes annotations](https://kubernetes.io/docs/concepts/overview/working-with-objects/annotations/)  |  [optional] |


