package homework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

/*
Create A Class: AmazonDropdown
Create A Method dropdownTest
Go to https://www.amazon.com/
Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
Print the the total number of options in the dropdown
Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
BONUS: Assert if the dropdown is in Alphabetical Order
 */
public class amazon_dropbox {
    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void amazonDropdownTest() throws InterruptedException {
     WebElement dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
     Select select=new Select(dropdown);
     select.selectByIndex(1);
     Thread.sleep(2000);
     //Print the first selected option and assert if it equals “All Departments”.
    // If it fails, then comment that code out and continue rest of the test case.
     WebElement firstSelectElement=select.getFirstSelectedOption();
        Assert.assertEquals("Doesn't match","Arts & Crafts",firstSelectElement.getText());
//Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        WebElement firstSelectedelemen04= select.getFirstSelectedOption();
        Assert.assertEquals("Doesnt match 'Amazon Devices'","Amazon Devices",firstSelectedelemen04.getText());

    }

}
