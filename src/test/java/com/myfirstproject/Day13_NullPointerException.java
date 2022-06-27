package com.myfirstproject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day13_NullPointerException {
    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerException(){
        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
        driver.manage().window().maximize();//NullPointerException. driver is declared but not initilazed
    }
    @Test
    public void nullPointerException2(){
        System.out.println(faker.name().fullName());//NullPointerException. faker is declared but not initilazed
    }
}