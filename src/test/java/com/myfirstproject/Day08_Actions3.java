package com.myfirstproject;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions3 extends TestBase {
    @Test
    public void scrollUpDown() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        Actions action=new Actions(driver);

        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
    }
}
