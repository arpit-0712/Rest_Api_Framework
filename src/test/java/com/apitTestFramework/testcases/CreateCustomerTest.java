package com.apitTestFramework.testcases;

import com.apitTestFramework.APIs.CreateCustomerAPI;
import com.apitTestFramework.setUp.BaseTest;
import com.apitTestFramework.utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest {

    @Test(dataProviderClass = DataUtil.class, dataProvider = "getData")
    public void validCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {

        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);

        response.prettyPrint();
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "getData")
    public void validCreateCustomerAPIWithInvalidSecretKey(Hashtable<String, String> invalid_data) {
        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(invalid_data);

        response.prettyPrint();
        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);

    }

}
