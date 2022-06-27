package com.myfirstproject;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_CheckboxUtil extends TestBase {
    @Test
    public void checkboxUtil() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        selectCheckBox(checkbox1,true);
        Thread.sleep(2000);
        selectCheckBox(checkbox2,true);

        Thread.sleep(2000);
        selectCheckBox(checkbox1,false);
        Thread.sleep(2000);
        selectCheckBox(checkbox2,false);
        Thread.sleep(2000);



        }

}
