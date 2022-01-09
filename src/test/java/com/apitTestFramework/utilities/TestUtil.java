package com.apitTestFramework.utilities;

import com.apitTestFramework.Listeners.ExtentListeners;
import org.json.JSONObject;

public class TestUtil {
    /*
    * Method to validate that if the Json has the key
    * in the response */
    public static boolean jsonHasKey(String json,String key){
        JSONObject jsonObject = new JSONObject(json);
        ExtentListeners.testReport.get().info("Validating the presence of the key: "+key);
        return jsonObject.has(key);
    }
/*
* Method to get the json key value */
    public static String getJsonKeyValue(String json,String key){
        JSONObject jsonObject = new JSONObject(json);
        ExtentListeners.testReport.get().info("Validating the value of the key :"+ key);
        return jsonObject.get(key).toString();
    }
}
