package Try_Again;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        // Open google home page https://www.google.com/.
        driver.navigate().to("https://www.google.com/");
        // Wait for 3 seconds
        Thread.sleep(3000);

        driver.get("https://www.amazon.com");

        // Get the title and URL of the page
        String amazonTitle=driver.getTitle();
        System.out.println("amazone title: "+amazonTitle);

        String amazonUrl= driver.getCurrentUrl();
        System.out.println("amazon Web site URL: "+  amazonUrl);
        // Check if the title contains the word "oto" print console "Title contains oto" or "Title does not contain oto"
       if(amazonTitle.contains("oto")){
           System.out.println("Amazon site title contain 'oto'");
       }
       else{
           System.out.println("Amazon site doesn't contain 'oto'");
       }
       if (amazonUrl.contains("oto")){
           System.out.println("Amazon site Url contain 'oto'");
       }
       else{
           System.out.println("Amazon site Url doesn't contain 'oto'");
       }

       driver.get("https://www.gittigidiyor.com");
        // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
       String gittiTitle= driver.getTitle();
       String gittiUrl=driver.getCurrentUrl();

       if(gittiTitle.contains("site")){
           System.out.println("Title contains 'site'");
       }
       else {
           System.out.println("Title does not contain 'site'");
       }
       Thread.sleep(2000);
       driver.navigate().back();
       Thread.sleep(2000);
       driver.navigate().refresh();
        Thread.sleep(2000);
       driver.navigate().forward();
        Thread.sleep(2000);

    }
    @After
    public void end(){
        driver.quit();
    }

}
