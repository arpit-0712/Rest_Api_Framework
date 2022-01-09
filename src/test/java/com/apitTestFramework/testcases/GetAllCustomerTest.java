package com.apitTestFramework.testcases;

import com.apitTestFramework.APIs.GetAllCustomersAPI;
import com.apitTestFramework.setUp.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class GetAllCustomerTest extends BaseTest {
    @Test()
    public void getCustomerDetails() {
        Response response = GetAllCustomersAPI.GetRequestForCustomerListAPI();
        response.prettyPrint();

    }
}
