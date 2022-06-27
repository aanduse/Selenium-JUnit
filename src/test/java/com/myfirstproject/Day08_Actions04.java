package com.myfirstproject;

import Utilities.TestBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class Day08_Actions04 extends TestBase {
    @Test
    public void dragAndDropTest(){
//        Create a class: Action4
//        Create a method dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
//        We need to use Actions class to drag and drop
//        Elements are inside the iframe, so switch first
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
        /*
         * Why your test case MIGHT FAIL?
         * 1. Incorrect Locator.
         * 2. Timing. Sysncronizated. - we already have enough timeout
         * 3. New Window
         * 4. JS Alerts
         * 5. IFrame
         * */
    }
}