package com.browserstack;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;


public class LocalTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {
        // visit your local site here
        driver.get("http://bs-local.com:45454");
        Assert.assertTrue(driver.getTitle().contains("BrowserStack Local"));

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
    }
}
