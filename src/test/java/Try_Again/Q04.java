package Try_Again;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q04 {
    // ...Exercise4...
    // Navigate to  https://testpages.herokuapp.com/styled/index.html
    // Click on  Calculate under Micro Apps
    // Type any number in the first input
    // Type any number in the second input
    // Click on Calculate
    // Get the result
    // Verify the result
    // Print the result
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='calculate']")).click();
        driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("30");
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("40");
        WebElement button=driver.findElement(By.xpath("//input[@id='calculate']"));
        button.click();
        WebElement answer=driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println(answer.getText());
        Assert.assertEquals(70,answer);
    }

}
