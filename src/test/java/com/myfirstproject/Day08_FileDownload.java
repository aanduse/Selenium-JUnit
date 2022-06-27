package com.myfirstproject;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day08_FileDownload extends TestBase {
    @Test
    public void downloadTest() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//        Download sample.png file
        driver.findElement(By.linkText("sample.png")).click();
//        It takes about a second to download the file
//        Implicit wait cannot solve this issue, cause this is related to Desktop application
        Thread.sleep(3000);//Test will wait for 3 secs
//        Then verify if the file downloaded successfully
        String path = System.getProperty("user.home")+"/Downloads/sample.png";
//        Assert if this path exist
        boolean isExist = Files.exists(Paths.get(path));
        Assert.assertTrue(isExist);
    }
}
