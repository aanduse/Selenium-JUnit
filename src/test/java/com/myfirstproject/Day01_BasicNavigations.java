package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day01_BasicNavigations {
//Create a new class under : BasicNavigations
//    Create main method
    public static void main(String[] args) {
        //    Set Path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        //    Create chrome driver
        WebDriver driver = new ChromeDriver();

        //    Maximize the window
        driver.manage().window().maximize();

        //    Open google home page https://www.google.com/.
        driver.get("https://www.google.com/");
        //    driver.get("http://www.google.co.uk/");//for UK
        //    On the same class, Navigate to amazon home page https://www.amazon.com/
       //   driver.navigate().to("https://www.amazon.com/");

        //    Navigate back to google
        driver.navigate().back();

        //    Navigate forward to amazon
        driver.navigate().forward();

        //    Refresh the page
        driver.navigate().refresh();

        //    Close/Quit the browser

        driver.close();
        driver.quit();

        /*There are 2 ways to go to a page
         * 1. get("URL")
         * 2. navigate().to("URL")
         *
         * What is the difference between get and navigate?
         * get() is easier to use. it is shorter
         * get() is a little faster
         * get() takes only string parameter
         * navigate().to() accept string or URL as parameter
         * navigate has more options : go back, forward, refresh
         *
         *
         * What is the difference between close and quit?
         * First both closes the driver(browser).
         * close() --->>>closes ONLY the current active driver
         * quit()---->>>closes ALL browsers that is open during that test run
         * */
    }
}