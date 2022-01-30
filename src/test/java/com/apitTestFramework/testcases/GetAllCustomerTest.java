package com.apitTestFramework.testcases;

import com.apitTestFramework.APIs.GetAllCustomersAPI;
import com.apitTestFramework.Listeners.ExtentListeners;
import com.apitTestFramework.setUp.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class GetAllCustomerTest extends BaseTest {
    @Test()
    public void getCustomerDetails() {
        Response response = GetAllCustomersAPI.GetRequestForCustomerListAPI();
        ExtentListeners.testReport.get().info(response.prettyPrint());
        response.prettyPrint();


    }
}
