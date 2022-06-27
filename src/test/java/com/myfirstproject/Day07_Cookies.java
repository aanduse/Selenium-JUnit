package com.myfirstproject;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;
public class Day07_Cookies extends TestBase {
    @Test
    public void cookies(){
//
//                -Go to amazon  and automate the tasks:
        driver.get("https://www.amazon.com");
//        1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("Number of cookies : "+ numOfCookies);
//        2. Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Each cookie : "+eachCookie);
            System.out.println("Each Cookie Name : "+eachCookie.getName());
            System.out.println("Each Cookie Value : "+eachCookie.getValue());
        }
//        3. Get the cookies by their name
        System.out.println(driver.manage().getCookieNamed("ubid-main"));//ubid-main=132-6617915-9715221; expires=Thu, 18 May 2023 08:42:37 CDT; path=/; domain=.amazon.com;secure;
//        4. Add new cookie
        //creating a new cookie
        Cookie myCookie = new Cookie("MyFavCookie","WhiteChocolate");
        driver.manage().addCookie(myCookie);
        //Check if cookie size is increased
        allCookies=driver.manage().getCookies();
        System.out.println("Cookie Size After Add : "+allCookies.size());

//        5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");//deleting the cookie whose name is session-id

//        6. Delete all of the cookies
        driver.manage().deleteAllCookies();//delete all cookies from the browser

        allCookies = driver.manage().getCookies();
        System.out.println("Cookie Number After Delete All " + allCookies.size());//0
    }
}
