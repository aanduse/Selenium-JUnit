package com.myfirstproject;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Day08_FileUpload extends TestBase {
    @Test
    public void fileUploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
//        locate Choose file input button
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
//        find the path of the file that you want to upload
        String filePath ="/Users/techproed/Desktop/logo.jpeg";
//        sendKeys(path);
        chooseFile.sendKeys(filePath);
//        click on Upload button
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
//        Verify the upload message
        String uploadedMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadedMessage);
        /*
         * 1. Do Manual Testing first to understand the functionality
         *   -click on choose file
         *           - locate choose file input
         *   -select a file
         *           - use sendKeys(pathOfFile)
         *   -click upload
         *           -locate upload element and click on it
         *   -verify message : File Uploaded!
         *           -get the text of the message and do assertion
         * */
    }
}