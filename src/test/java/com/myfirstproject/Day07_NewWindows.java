package com.myfirstproject;


import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Set;
public class Day07_NewWindows extends TestBase {
    @Test
    public void windowHandle() throws InterruptedException {
        //        Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //        NOTE: Getting thhe window handle of the first window
        //        I need this so I can switch back to this window
        String window1Handle = driver.getWindowHandle();
        System.out.println("WINDOW 1 HANDLE : "+window1Handle);
        //        Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);
        //        Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet",driver.getTitle());
        //        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

        //        Then user verifies the new window title is “New Window”
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        //        We must switch to the 2nd window
        for (String eachHandle : allWindowHandles){
            if (!eachHandle.equals(window1Handle)){//if each handle is NOT equal to window1 handle
                //                Then it must be equal to window 2 handle. Then switch to that window
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        //        DRIVER IS ON WINDOW 2
        String window2Handle = driver.getWindowHandle();


        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window",window2Title);
        //        Then user verifies the text: “New Window”
        String window2Text = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        Assert.assertEquals("New Window",window2Text);
        //        When user goes back to the previous window and then verifies the title : “The Internet”
        Thread.sleep(5000);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());
        Thread.sleep(5000);
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);
        driver.switchTo().window(window2Handle);
    }
}






