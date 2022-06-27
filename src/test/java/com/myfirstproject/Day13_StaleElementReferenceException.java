package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day13_StaleElementReferenceException {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void staleElementReferenceException() {
        driver.get("https://www.carettahotel.com/");
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();
        driver.navigate().refresh();
        home.click();//StaleElementReferenceException
        /*
         * Solution: 1. relocate the element with a new variable and use that going forward
         * 2. do not use variable for the same elements goint forward
         *
         * */
    }

    @Test
    public void staleElementReferenceException1() {
        driver.get("https://www.carettahotel.com/");
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();
        driver.findElement(By.linkText("Log in")).click();
        driver.navigate().back();
        home.click();//StaleElementReferenceException
    }

    @Test
    public void staleElementReferenceExceptionSolution() {
        driver.get("https://www.carettahotel.com/");
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();
        driver.navigate().refresh();
//        home.click();//StaleElementReferenceException
        WebElement home2 = driver.findElement(By.linkText("Home"));
        home2.click();
        driver.navigate().refresh();
        driver.findElement(By.linkText("Home")).click();
        /*
         * Solution: 1. relocate the element with a new variable and use that going forward
         * 2. do not use variable for the same elements goint forward
         *
         * */
    }
}
