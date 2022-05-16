package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {

    // ...Exercise4...
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

        WebElement firstBox = driver.findElement(By.xpath("//input[@id='number1']"));
        WebElement secondBox = driver.findElement(By.xpath("//input[@id='number2']"));

        firstBox.sendKeys("20");
        secondBox.sendKeys("35");

        // Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        // Verify the result
        String result = driver.findElement(By.xpath("//span[@id='answer']")).getText();
        Assert.assertEquals("55",result);
        Thread.sleep(5000);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}