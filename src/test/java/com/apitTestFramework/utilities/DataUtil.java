package com.apitTestFramework.utilities;

import com.apitTestFramework.setUp.BaseTest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class DataUtil extends BaseTest {
    @DataProvider(name = "getData")
    public static Object[][] getData(Method method) {
        int rows = excelReader.getRowCount(configProp.getProperty("testDataSheetName"));
        String testName = method.getName();
        int testCaseRowNum;
        for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {
            String testCaseName = excelReader.getCellData(configProp.getProperty("testDataSheetName"), 0, testCaseRowNum);
            if (testCaseName.equalsIgnoreCase(testName))
                break;
        }

        int dataStartRowNum = testCaseRowNum + 2;

        int test_rows = 0;
        while (!excelReader.getCellData(configProp.getProperty("testDataSheetName"), 0, dataStartRowNum + test_rows).equals("")) {
            test_rows++;
        }


        int test_cols = 0;
        int colStartColNum = testCaseRowNum + 1;
        while (!excelReader.getCellData(configProp.getProperty("testDataSheetName"), test_cols, colStartColNum).equals("")) {
            test_cols++;
        }

        Object[][] data = new Object[test_rows][1];// This is done because we are using the hashtable to get the data
        int counter = 0;
        for (int rowNum = dataStartRowNum; rowNum < (dataStartRowNum + test_rows); rowNum++) {
            Hashtable<String, String> hashtable = new Hashtable<>();
            for (int colNum = 0; colNum < test_cols; colNum++) {

                // data[rowNum - dataStartRowNum][colNum] = excelReader.getCellData(Constants.DATA_SHEET, colNum, rowNum);
                String testData = excelReader.getCellData(configProp.getProperty("testDataSheetName"), colNum, rowNum);
                String colName = excelReader.getCellData(configProp.getProperty("testDataSheetName"), colNum, colStartColNum);
                hashtable.put(colName, testData);
            }
            data[counter][0] = hashtable;
            counter++;
        }

        return data;
    }
}
