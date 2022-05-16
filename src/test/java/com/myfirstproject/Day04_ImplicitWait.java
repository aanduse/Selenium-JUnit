package com.myfirstproject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day04_ImplicitWait {
    @Test
    public void implicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        implicit wait for 30 seconds
        /*
         * implicit wait puts DYNAMIC WAIT meaning wait will be depends on the page speed
         * We can use implicit wait right after creating the driver object
         * We can use implicit wit once per test. That is enough.
         * Whenever driver is used, then driver will remember the imlicit wait
         *
         * */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.google.com");//puts 30 seconds wait IF NEEDED
        driver.findElement(By.className("q"));//puts 30 seconds wait ID NEEDED
    }
    @Test
    public void threadSleep() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(30000);//Hard wait. Waits for 30 seconds for no reason
    }
}