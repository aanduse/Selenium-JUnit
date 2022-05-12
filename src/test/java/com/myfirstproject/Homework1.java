package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
    /*
Create a new class : Homework1
Using ChromeDriver, Go to facebook and verify if page title is “facebook”, If not, print the correct title.
Verify if the page URL contains facebook  if not, print the right url.
Then Navigate to https://www.walmart.com/
Verify if the walmart page title includes “Walmart.com”
Navigate back to facebook
Refresh the page
Maximize the window
Close the browser
     */
    public static void main(String[] args) {
        //Using ChromeDriver,
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Go to facebook and verify if page title is “facebook”, If not, print the correct title.
        driver.get("https://facebook.com");
        String expectedFacebookTitle="facebook";
        String actualFacebookTitle=driver.getTitle();
        if(actualFacebookTitle.equals(expectedFacebookTitle)){
            System.out.println("PASS--");
        }
        else{
            System.out.println("FAIL -- Expected Title: "+ expectedFacebookTitle+ "  Actual Title: "+actualFacebookTitle);
        }

        //Verify if the page URL contains facebook  if not, print the right url.
        String expectedText="facebook";
        String actualUrl= driver.getCurrentUrl();
        if(actualUrl.contains(expectedText)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL--Expected Text '" +expectedText+ "' doesnt include in the current url");
        }

        //Then Navigate to https://www.walmart.com/
        driver.get("https://www.walmart.com");

        //Verify if the walmart page title includes “Walmart.com”
        String expectedWalmartTitle="Walmart.com";
        String actualWalmartTitle=driver.getTitle();
        if(actualWalmartTitle.contains(expectedWalmartTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL--Actual Walmart Title is  "+actualWalmartTitle+ "Expected Walmart Title is "+expectedWalmartTitle);
        }

        //Navigate back to facebook
        driver.navigate().back();

        //Refresh the page
        driver.navigate().refresh();

        //Maximize the window
        driver.manage().window().maximize();

        //Close the browser
        driver.close();
    }
}
