package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day13_NoSuchElementException {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void noSuchElementExceptionTest(){
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.linkText("navLogon")).click();//Wrong locator.linkText should be id.NoSuchElementException
    }
    @Test
    public void noSuchElementExceptionTest2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
        String helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
        Assert.assertEquals("Hello World!",helloWorld);//ComparisonFailure. This is not same as no such element exception
    }
    @Test
    public void noSuchElementExceptionTest3(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])")).click();
        String goneMessage = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals("It's gone!",goneMessage);//NoSuchElementException. The element loads in about 5 second, but driver is so fast
//        SOLUTION:
//        Use explicit wait.
//        Use implicit wait
    }
}