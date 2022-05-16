package practice01;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Q02 {
    //  ...Exercise2...
    // Create a new class under Q02
    // Set Path
    // Create chrome driver
    // Maximize the window
    // Open google home page https://www.google.com/.
    // Wait for 3 seconds
    // Go to the "https://www.amazon.com"
    // Get the title and URL of the page
    // Check if the title contains the word "oto" print console "Title contains oto" or "Title does not contain oto"
    // Check if the URL contains the word "oto" print console "URL contains oto" or "URL does not contain oto"
    // Then go to "https://www.gittigidiyor.com"
    // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
    // Back to the previous webpage, https://www.amazon.com"
    // Refresh the page
    // Navigate to gittigidiyor.com
    // Wait for 3 seconds
    // Close the browser
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
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Go to the "https://www.amazon.com"
        driver.get("https://www.amazon.com");
        // Get the title and URL of the page
        String amazonTitle = driver.getTitle();
        String amazonURL = driver.getCurrentUrl();
        // Check if the title contains the word "auto" print console "Title contains auto" or "Title does not contain auto"
        if(amazonTitle.contains("auto")){
            System.out.println("Title contains auto");
        } else {
            System.out.println("Title does not contain auto");
        }
        // Check if the URL contains the word "auto" print console "URL contains auto" or "URL does not contain auto"
        if(amazonURL.contains("auto")){
            System.out.println("URL contains auto");
        } else {
            System.out.println("URL does not contain auto");
        }
        // Then go to "https://www.gittigidiyor.com"
        driver.get("https://www.gittigidiyor.com");
        // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
        String gittiGidiyorTitle = driver.getTitle();
        if(gittiGidiyorTitle.contains("site")){
            System.out.println("Title contains site");
        } else {
            System.out.println("Title does not contain site");
        }
        // Back to the previous webpage, https://www.amazon.com"
        driver.navigate().back(); // amazon
        // Refresh the page
        driver.navigate().refresh();//refresh
        // Navigate to gittigidiyor.com
        driver.navigate().forward();
        // Wait for 3 seconds
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}