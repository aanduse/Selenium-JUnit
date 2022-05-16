package my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
 */

public class practice01 {
    WebDriver driver;
    @Before
            public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Test() throws InterruptedException {

        driver.get("http://automationexercise.com");
        //Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //Verify 'New User Signup!' is visible
        String pageSource=driver.getPageSource();
        System.out.println(pageSource);
        if(pageSource.contains("New User Signup!")){
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
        //Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Mehmet");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("mehmet@gmail.com");
Thread.sleep(3000);
        //Click 'Signup' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        Thread.sleep(3000);
        //Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed());
        Thread.sleep(3000);
        //Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("3");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("Canada");















    }
}
