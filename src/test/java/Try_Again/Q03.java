package Try_Again;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q03 {
    // ...Exercise3...
    // go to url : https://www.techlistic.com/p/selenium-practice-form.html
    //fill the firstname
    //fill the lastname
    //check the gender
    //check the experience
    //fill the date
    //choose your profession -> Automation Tester
    //choose your tool -> Selenium Webdriver
    //choose your continent -> Antartica
    //choose your command  -> Browser Commands
    //click submit button
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test(){
      driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
      driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ahmet");
      driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mendi");
      driver.findElement(By.xpath("//input[@id='sex-0']")).click();
      driver.findElement(By.xpath("(//input[@name='exp'])[2]")).click();
      driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/10/2021");
      driver.findElement(By.xpath("//input[@id='profession-1']")).click();
      driver.findElement(By.xpath("//input[@id='tool-2']")).click();
      driver.findElement(By.xpath("(//select[@class='input-xlarge'])[1]")).sendKeys("Antartica");
      driver.findElement(By.xpath("(//option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;'])[8]")).click();
    }
}
