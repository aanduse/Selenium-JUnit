package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

        /*
        Create a new class : Review1
        Using ChromeDriver, Go to youtube and verify if page title is “youtube”, If not, print the correct title.
        Verify if the page URL contains youtube if not, print the right url.
        Then Navigate to https://www.amazon.com/
        Navigate back to youtube
        Refresh the page
        Navigate forward to amazon
        Maximize the window
        Then verify if page title includes “Amazon”, If not, print the correct title.
        Verify if the page URL is https://www.amazon.com/, if not print the correct url
        Quit the browser
         */

public class Review1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://youtube.com");

        String expectedTitle="youtube";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAILED");
            System.out.println("Expected Title: "+ expectedTitle+ "   Actual Data: "+actualTitle);
        }
       String expectedText="youtube";
        String currentURL= driver.getCurrentUrl();
        System.out.println(currentURL);
        if(currentURL.contains("youtube")){
            System.out.println("PASS--Current URL contains : "+expectedText);
        }
        else{
            System.out.println("Failed--Current URL contains : "+ currentURL);
        }
        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.manage().window().maximize();

        String expectedAmazonTitle="Amazon";
        String currentAmazonTitle= driver.getTitle();
        if(currentAmazonTitle.contains(expectedAmazonTitle)){
            System.out.println("PASS -- amazon.com includes 'Amazon' Title "+ expectedAmazonTitle);
        }
        else {
            System.out.println("FAILED -- amazon.com doesn't include 'Amazon' "+ currentAmazonTitle);
        }
        String expectedURL="https://www.amazon.com";
        String currentURL02= driver.getCurrentUrl();
        if(currentURL02.equals(currentURL02)){
            System.out.println("PASS-- Current URL: " +currentURL02);
        }
        else {
            System.out.println("FAILED-- Current URL: "+currentURL02);
        }
    }
}

