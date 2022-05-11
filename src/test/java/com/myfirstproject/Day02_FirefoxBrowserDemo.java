package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxBrowserDemo {
//    Create a new class under : FirefoxBrowserDemo
//    Create main method
//    Set Path
//    Create gecko driver
//    Open google home page https://www.google.com/
//    Maximize the window
//    Close/Quit the browser

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");

        //    Create gecko driver
        WebDriver driver=new FirefoxDriver();

        //    Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        //    Maximize the window
        driver.manage().window().maximize();

        //    Close/Quit the browser
        driver.quit();


    }


}