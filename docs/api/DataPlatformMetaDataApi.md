# DataPlatformMetaDataApi

All URIs are relative to *https://api.ionos.com/dataplatform*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**versionsGet**](DataPlatformMetaDataApi.md#versionsget) | **GET** /versions | Managed Stackable Data Platform API Versions |


<a name="versionsGet"></a>
# **versionsGet**
> List&lt;String&gt; versionsGet()

Managed Stackable Data Platform API Versions

Retrieves all available versions of the Managed Stackable Data Platform.

### Example
```java
// Import classes:
import com.ionoscloud.dataplatform.ApiClient;
import com.ionoscloud.dataplatform.ApiException;
import com.ionoscloud.dataplatform.Configuration;
import com.ionoscloud.dataplatform.auth.*;
import com.ionoscloud.dataplatform.model.*;
import com.ionoscloud.dataplatform.api.DataPlatformMetaDataApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    
    // Configure HTTP basic authorization: basicAuth
    HttpBasicAuth basicAuthentication = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuthentication.setUsername("YOUR USERNAME");
    basicAuthentication.setPassword("YOUR PASSWORD");


    DataPlatformMetaDataApi apiInstance = new DataPlatformMetaDataApi(defaultClient);
    try {
      List<String> result = apiInstance.versionsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DataPlatformMetaDataApi#versionsGet");
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
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

