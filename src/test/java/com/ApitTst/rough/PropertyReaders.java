package com.ApitTst.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaders {
    public static void main(String[] args) throws IOException {
        Properties configProp = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        configProp.load(fis);
        System.out.println(configProp.getProperty("baseURI"));
        System.out.println(configProp.getProperty("basePath"));
        System.out.println(configProp.getProperty("customerAPIEndPoint"));
        System.out.println(configProp.getProperty("validSecretKey"));

    }
}
