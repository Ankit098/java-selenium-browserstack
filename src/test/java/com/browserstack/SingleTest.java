package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
    	// navigate to bstackdemo
        driver.get("https://www.bstackdemo.com");
        // Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // local java code
        URL url = new URL("http://www.google.com"); // your API endpoint
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        int status = con.getResponseCode();
        con.disconnect();
        System.out.println("\n Response Code :: ");
        System.out.println(status);
        //local java code over

        // continue with the rest of the test
        Thread.sleep(5000);
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));
    }
}
