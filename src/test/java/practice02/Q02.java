package practice02;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q02 extends TestBase {
    // 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    // 2. Click "CLICK ME" of JavaScript Alert
    // 3. Get the pop-up text
    // 4. Verify that message is "I am an alert box!"
    // 5. Accept pop-up
    @Test
    public void alert() throws InterruptedException {
        // 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2. Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.id("button1")).click();
        Thread.sleep(3000);
        // 3. Get the pop-up text
        String alertMessage = driver.switchTo().alert().getText();
        // 4. Verify that message is "I am an alert box!"
        Assert.assertEquals("I am an alert box!",alertMessage);
        // 5. Accept pop-up
        driver.switchTo().alert().accept();
    }
}













