package com.myfirstproject;
import Utilities.TestBase;

import org.junit.Test;
public class Day06_TestBaseDemo extends TestBase {
    //    WebDriver driver;
//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
    //=> setUp => test1 => tearDown
    //=> setUp => test2 => teardown
}

