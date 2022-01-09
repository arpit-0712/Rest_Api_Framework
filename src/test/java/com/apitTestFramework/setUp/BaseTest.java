package com.apitTestFramework.setUp;

import com.apitTestFramework.utilities.ExcelReader;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
public static Properties configProp = new Properties();
private FileInputStream fis;
public static ExcelReader excelReader = new ExcelReader("./src/test/resources/TestData/TestData.xlsx");

    @BeforeSuite
    public void setUp()  {
        try {
            fis = new FileInputStream("./src/test/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            configProp.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = configProp.getProperty("baseURI");
        RestAssured.basePath = configProp.getProperty("basePath");
    }
    @AfterSuite
    public void tearDown(){

    }
}
