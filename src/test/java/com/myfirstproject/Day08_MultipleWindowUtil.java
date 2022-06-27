package com.myfirstproject;
import Utilities.TestBase;

import org.junit.Test;
import org.openqa.selenium.By;
public class Day08_MultipleWindowUtil extends TestBase {
    @Test
    public void multipleWindowTest(){
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("Old Window : "+driver.getCurrentUrl());
        driver.findElement(By.linkText("Click Here")).click();
//        driver is currently on window 1. use switchToTargetWindow to switch tot eh other window

//        Pass the title of the window that you want to switch to
       //switchToTargetWindow("New Window");//Switch to the window whose TITLE = New Window
        System.out.println("New Window : "+ driver.getCurrentUrl());

    }
}
