package com.apitTestFramework.APIs;

import com.apitTestFramework.setUp.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class DeleteCustomerAPI extends BaseTest {
    public static Response sendDeleteRequestToDeleteCustomerAPIWithValidId(Hashtable<String,String> data){
        Response response = given()
                .auth()
                .basic(configProp.getProperty("validSecretKey"), "")
                .delete(configProp.getProperty("customerAPIEndPoint")+"/"+data.get("ID"));

        return response;
    }
}
