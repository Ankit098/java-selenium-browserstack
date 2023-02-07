package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;

public class ExecuteScriptTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
    	// navigate to your website
        driver.get("https://www.dataaccess.com/webservicesserver/NumberConversion.wso"); // replace with your url
        // Perform your selenium commands..
        Assert.assertTrue(driver.getTitle().matches("Number Conversion Service"));

        // execute script
        String newLine = System.getProperty("line.separator");
        String postReqScript = "let xmlhttp = new XMLHttpRequest();" + newLine
                                + "xmlhttp.open('POST', 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso', true);" + newLine // your API endpoint here
                                + "let sr = '<?xml version=\"1.0\" encoding=\"utf-8\"?>' +" + newLine
                                + "'<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">' +" + newLine
                                + "'<soap:Body>' +" + newLine
                                + "'<NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">' +" + newLine
                                + "'<ubiNum>500</ubiNum>' +" + newLine
                                + "'</NumberToWords>' +" + newLine
                                + "'</soap:Body>' +" + newLine
                                + "'</soap:Envelope>'" + newLine
                                + "xmlhttp.onreadystatechange = function () {" + newLine
                                + "if (xmlhttp.readyState == 4) {" + newLine
                                + "if (xmlhttp.status == 200) {" + newLine
                                + "console.log(xmlhttp.responseText);" + newLine
                                + "}" + newLine
                                + "}" + newLine
                                + "}" + newLine
                                + "xmlhttp.setRequestHeader('Content-Type', 'text/xml');" + newLine
                                + "xmlhttp.send(sr);";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(postReqScript);
        // execute script over

        // continue with the rest of the test
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().matches("Number Conversion Service"));
    }
}
