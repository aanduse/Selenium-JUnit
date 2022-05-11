package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstSeleniumClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.techproeducation.com");


    }
}
