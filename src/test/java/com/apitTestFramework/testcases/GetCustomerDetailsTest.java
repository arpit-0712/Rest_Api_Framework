package com.apitTestFramework.testcases;

import com.apitTestFramework.APIs.GetCustomerDetailsAPI;
import com.apitTestFramework.Listeners.ExtentListeners;
import com.apitTestFramework.setUp.BaseTest;
import com.apitTestFramework.utilities.DataUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GetCustomerDetailsTest extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "getData")
    public void getCustomerDetails(Hashtable<String, String> data) {
        Response response = GetCustomerDetailsAPI.sendGetRequestToForCustomerAPIWithValidId(data);
        response.prettyPrint();


    }
}
