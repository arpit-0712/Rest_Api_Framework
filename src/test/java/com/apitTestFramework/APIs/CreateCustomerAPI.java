package com.apitTestFramework.APIs;

import com.apitTestFramework.Listeners.ExtentListeners;
import com.apitTestFramework.setUp.BaseTest;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class CreateCustomerAPI extends BaseTest {
    public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String,String> data){
        Response response = given()
                .auth()
                .basic(configProp.getProperty("validSecretKey"), "")
                .formParam("name", data.get("name"))
                .formParam("email", data.get("email"))
                .formParam("description", data.get("description"))
                .post(configProp.getProperty("customerAPIEndPoint"));
        ExtentListeners.testReport.get().info(data.toString());
        return response;
    }

    public static Response sendPostRequestToCreateCustomerAPIWithInvalidAuthKey(Hashtable<String,String> invalid_data){
        Response response = given()
                .auth()
                .basic(configProp.getProperty("invalidSecretKey"), "")
                .formParam("name", invalid_data.get("name"))
                .formParam("email", invalid_data.get("email"))
                .formParam("description", invalid_data.get("description"))
                .post(configProp.getProperty("customerAPIEndPoint"));
        ExtentListeners.testReport.get().info(invalid_data.toString());// This line is added to determine what
                                                                        // data has been input
        return response;
    }
}
