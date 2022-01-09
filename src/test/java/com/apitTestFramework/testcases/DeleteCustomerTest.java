package com.apitTestFramework.testcases;

import com.apitTestFramework.APIs.DeleteCustomerAPI;
import com.apitTestFramework.Listeners.ExtentListeners;
import com.apitTestFramework.setUp.BaseTest;
import com.apitTestFramework.utilities.DataUtil;
import com.apitTestFramework.utilities.TestUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteCustomerTest extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "getData")
    public void deleteCustomer(Hashtable<String, String> data) {
        Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidId(data);
        response.prettyPrint();
        ExtentListeners.testReport.get().info(data.toString());
        System.out.println(response.statusCode());


        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"), "ID key not present in json response");
        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "object"), "object key not present in json response");
        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "deleted"), "deleted key not present in json response");

        String actual_id = TestUtil.getJsonKeyValue(response.asString(), "id");
        String objectValue = TestUtil.getJsonKeyValue(response.asString(), "object");


        System.out.println(actual_id + "-----" + objectValue + "--------" + TestUtil.getJsonKeyValue(response.asString(), "deleted"));
        Assert.assertEquals(actual_id, data.get("ID"));
    }
}
