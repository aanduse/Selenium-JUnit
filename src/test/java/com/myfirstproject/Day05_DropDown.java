package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
public class Day05_DropDown {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        //Go to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void  selectByIndexTest() throws InterruptedException {
        //Create method selectByIndexTest
        // and Select Option 1 using index
        //1. Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. create a select object
        Select select = new Select(dropdown);
        //3. select any option using by index- NOTE index starts at 0
        Thread.sleep(5000);//NOT MANDATORY
        select.selectByIndex(1);//option 1
        Thread.sleep(5000);
        select.selectByIndex(2);//option 2
        Thread.sleep(5000);
        select.selectByIndex(1);//option 1
    }
    @Test
    public void selectByValueTest() throws InterruptedException {
        //2.Create method selectByValueTest Select Option 2 by value
        //1. Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. create a select object
        Select select = new Select(dropdown);
        //3. select any option using by value
        select.selectByValue("2");
        Thread.sleep(5000);
    }
    //    //3.Create method selectByVisibleTextTest
    //    Select Option 1 value by visible text
    @Test
    public void selectByVisibleTextTest() throws InterruptedException {
        //1. Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. create a select object
        Select select = new Select(dropdown);
        //3. select any option using by visible text
        Thread.sleep(5000);
        select.selectByVisibleText("Option 1");
        Thread.sleep(5000);
        select.selectByVisibleText("Option 2");
        Thread.sleep(5000);
    }
    @Test
    public void printAllTest(){
        //4.Create method printAllTest
        // Print all dropdown value
        //1. Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. create a select object
        Select select = new Select(dropdown);
        //3. select all options using getOptions()
        List<WebElement> allOptions = select.getOptions();
        for (WebElement eachOption : allOptions){
//            System.out.println(eachOption);
            System.out.println(eachOption.getText());
        }
        //    5. Verify the dropdown has Option 2 text
        boolean flag=false;
        for (WebElement eachOption : allOptions){
            if(eachOption.getText().equals("Option 2")){
                flag=true;
            }
        }
        Assert.assertTrue(flag);//PASS WHEN flag=true; THIS FAILS WHEN flag=false
    }
    //6.Create method printFirstSelectedOptionTest
    // Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
        //1. Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. create a select object
        Select select = new Select(dropdown);
        //3. get the first selected option(default selected) by getFirstSelectedOption() method
        //If multiple option is selected, this returns the 1st one
        //if you change an other option, this returns the new 1st selected option
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("Selected Option : "+firstSelectedOption.getText());
        //select option 2
        select.selectByVisibleText("Option 2");
        System.out.println("Now selected : "+select.getFirstSelectedOption().getText());
        //NOTE
        List<WebElement> allSelectedOption = select.getAllSelectedOptions(); // RETURNS ALL OPTIONS IF MULTIPLE SELECTED AS List<WebElement>.
        for (WebElement eachSelectedOption:allSelectedOption){
            System.out.println("Selected Option : "+eachSelectedOption.getText());
        }
    }
    //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
    @Test
    public void sizeTest(){
        //1. Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. create a select object
        Select select = new Select(dropdown);
        //3.print Expected Is Not Equal Actual if there are not 3 elements in the dropdown
        List<WebElement> allOption = select.getOptions();
        //
        int numberOfDropdownOptions = allOption.size();
        Assert.assertEquals("Expected Is Not Equal Actual",numberOfDropdownOptions,3);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}