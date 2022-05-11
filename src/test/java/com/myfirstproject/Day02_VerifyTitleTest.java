package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {

           public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//WINDOWS
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
//        Navigate to google homepage
            driver.get("https://www.google.com");
//        Verify if google title is “Google”
            String actualTitle = driver.getTitle();
            String expectedTitle = "Google";
//      Verify if expected equals actual
            if (actualTitle.equals(expectedTitle)){
                System.out.println("PASS");
                System.out.println("Expected : "+expectedTitle);
                System.out.println("Actual : "+actualTitle);
            }else{
                System.out.println("FAILED");
                System.out.println("Expected : "+expectedTitle);
                System.out.println("Actual : "+actualTitle);
            }
            driver.quit();
        }
    }
