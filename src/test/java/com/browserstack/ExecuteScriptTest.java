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
    	// navigate to bstackdemo
        driver.get("https://www.bstackdemo.com");
        // Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // execute script
        String newLine = System.getProperty("line.separator");
        String postReqScript = "let xhr = new XMLHttpRequest();" + newLine
                                + "xhr.open(\"POST\", \"https://reqbin.com/echo/post/json\");" + newLine // your API endpoint
                                + "xhr.setRequestHeader(\"Accept\", \"application/json\");" + newLine
                                + "xhr.setRequestHeader(\"Content-Type\", \"application/json\");" + newLine
                                + "xhr.onreadystatechange = function () {" + newLine
                                + "if (xhr.readyState === 4) {" + newLine
                                + "console.log(xhr.status);" + newLine
                                + "console.log(xhr.responseText);" + newLine
                                + "}};" + newLine
                                + "let data = `{" + newLine
                                + "\"Id\": 78912," + newLine
                                + "\"Customer\": \"Jason Sweet\"," + newLine
                                + "\"Quantity\": 1," + newLine
                                + "\"Price\": 18.00" + newLine
                                + "}`;" + newLine
                                + "xhr.send(data);";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(postReqScript);
        // execute script over

        // rest of the test
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));
    }
}
