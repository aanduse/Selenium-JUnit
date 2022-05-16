package Try_Again;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01 {
// ...Exercise1...
    // Create a new class under Q1
    // Set Path
    // Create chrome driver
    // Maximize the window
    // Open google home page https://www.google.com/
    // On the same class, Navigate to amazon home page https://www.amazon.com/
    // Navigate back to google
    // Navigate forward to amazon
    // Refresh the page
    // Close/Quit the browser
    // And last step : print "ALL OK" on console
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(5000);
        // On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);
        // Navigate back to google
        driver.navigate().back();
        // Navigate forward to amazon
        driver.navigate().forward();
        // Refresh the page
        driver.navigate().refresh();
        System.out.println("ALL is Ok");

        // Close/Quit the browser




    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
