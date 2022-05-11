package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Review1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://youtube.com");

        String expectedTitle="youtube";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAILED");
            System.out.println("Expected Title: "+ expectedTitle+ "Actual Data: "+actualTitle);
        }
    }
}

