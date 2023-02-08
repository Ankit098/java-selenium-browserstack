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

        // execute script start
        String postReqScript = "function makeRequest (method, url) {\n" +
                "    var xhr = new XMLHttpRequest();\n" +
                "    xhr.open(method, url,false);\n" +
                "    var sr = '<?xml version=\"1.0\" encoding=\"utf-8\"?>' +\n" +
                "    '<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">' +\n" +
                "        '<soap:Body>' +\n" +
                "            '<NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">' +\n" +
                "                '<ubiNum>500</ubiNum>' +\n" +
                "            '</NumberToWords>' +\n" +
                "        '</soap:Body>' +\n" +
                "    '</soap:Envelope>'\n" +
                "    xhr.setRequestHeader('Content-Type', 'text/xml');\n" +
                "    xhr.send(sr);\n" +
                "    return xhr.response;\n" +
                "}\n" +
                "return makeRequest('POST', 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso');\n";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String result = (String) js.executeScript(postReqScript);
        System.out.println("\nResult of SOAP POST request:\n");
        System.out.println(result);
        // execute script over

        // continue with the rest of the selenium test
        Assert.assertTrue(driver.getTitle().matches("Number Conversion Service"));
    }
}
