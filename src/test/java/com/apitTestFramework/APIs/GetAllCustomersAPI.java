package com.apitTestFramework.APIs;

import com.apitTestFramework.Listeners.ExtentListeners;
import com.apitTestFramework.setUp.BaseTest;
import com.aventstack.extentreports.Status;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class GetAllCustomersAPI extends BaseTest {
    public static Response GetRequestForCustomerListAPI(){
        Response response = given()
                .auth()
                .basic(configProp.getProperty("validSecretKey"), "")
                .get(configProp.getProperty("customerAPIEndPoint"));
        return response;

    }
}
