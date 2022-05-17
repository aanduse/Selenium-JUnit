package com.myfirstproject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class Day04_RadioButton {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void radio(){
//        Create a class : RadioButton
//        Complete the following task
//        Go to https://www.facebook.com/
//
//        TEST CASE:
//        Click on Create new account
        driver.findElement(By.linkText("Create new account")).click();
//        Enter first name
        driver.findElement(By.name("firstname")).sendKeys("fname");
//        Enter last name
        driver.findElement(By.name("lastname")).sendKeys("lname");
//        Enter mobile number or email
        driver.findElement(By.name("reg_email__")).sendKeys("7804075355");
//        Enter new password
        driver.findElement(By.name("reg_passwd__")).sendKeys("secretPass!");
//        Enter birthday(LATER)
//        Jan / 10 / 2000
//        1. Locate the dropdown element
        WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
//        2. Crereate select object
        Select selectMonth = new Select(monthElement);
//        3. Select Jan
        selectMonth.selectByVisibleText("Jan");
//        DAY
        WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(dayElement);
        selectDay.selectByVisibleText("10");
//        YEAR
        WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(yearElement);
        selectYear.selectByVisibleText("2000");

//        Enter gender
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
//        Click Sign Up
        driver.findElement(By.name("websubmit")).click();
    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}