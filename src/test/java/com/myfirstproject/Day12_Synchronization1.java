package com.myfirstproject;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Day12_Synchronization1 extends TestBase {
    @Test
    public void synchronization1() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        //div[@id='finish']//h4 is the xpath of the Hello World! element
//        1. Waits for teh element DYNAMICALLY
//        2. returns the element. So no need to use findElement with explicit wait
        WebElement helloWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloWord.getText());
//        Thread.sleep(5000);//works but this is not recommended
//        Then verify the ‘Hello World!’ Shows up on the screen
//        String helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
//        Assert.assertEquals("Hello World!",helloWorld);
//        Implicit wait is not enough to handle the load issue
    }
}