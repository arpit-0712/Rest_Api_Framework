package com.ApitTst.rough;

import com.apitTestFramework.utilities.MonitoringMail;
import com.apitTestFramework.utilities.TestConfig;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestMail {
    static String messageBody;
    public static void main(String[] args) throws  MessagingException {
       try {
           messageBody = "http://"+ InetAddress.getLocalHost().getHostAddress()+":8080/job/GitCheckAPIProject/HTML_20Report/";
       } catch (UnknownHostException e) {
           e.printStackTrace();
       }
        MonitoringMail main = new MonitoringMail();
        main.sendMail(TestConfig.server,TestConfig.from, TestConfig.to,TestConfig.subject,messageBody);



    }
}
