package com.apitTestFramework.testcases;

import com.apitTestFramework.APIs.CreateCustomerAPI;
import com.apitTestFramework.Listeners.ExtentListeners;
import com.apitTestFramework.setUp.BaseTest;
import com.apitTestFramework.utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "getData",enabled = false)
    public void validCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
        ExtentListeners.testReport.get().info(data.toString());
        ExtentListeners.testReport.get().info(response.prettyPrint());
        response.prettyPrint();
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "getData",enabled = false)
    public void validCreateCustomerAPIWithInvalidSecretKey(Hashtable<String, String> invalid_data) {
        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(invalid_data);
        ExtentListeners.testReport.get().info(invalid_data.toString());
        response.prettyPrint();
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);

    }

}
