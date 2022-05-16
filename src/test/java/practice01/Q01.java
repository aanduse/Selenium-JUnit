package practice01;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
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
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        // On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        // Navigate back to google
        driver.navigate().back();
        Thread.sleep(5000);
        // Navigate forward to amazon
        driver.navigate().refresh();
        Thread.sleep(5000);
        // Refresh the page
        driver.navigate().refresh();
        System.out.println("ALL OK");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
