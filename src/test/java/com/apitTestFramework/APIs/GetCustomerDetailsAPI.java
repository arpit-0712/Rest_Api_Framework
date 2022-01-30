package com.apitTestFramework.APIs;

import com.apitTestFramework.setUp.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class GetCustomerDetailsAPI extends BaseTest {
    public static Response sendGetRequestToForCustomerAPIWithValidId(Hashtable<String,String> data){
        Response response = given()
                .auth()
                .basic(configProp.getProperty("validSecretKey"), "")
                .get(configProp.getProperty("customerAPIEndPoint")+"/"+data.get("ID"));
        return response;

    }
}
