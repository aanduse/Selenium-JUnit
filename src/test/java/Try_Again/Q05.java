package Try_Again;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Q05 {
    /*
...Exercise...
// http://the-internet.herokuapp.com/add_remove_elements/
// click on the "Add Element" button 100 times
// write a function that takes a number, and clicks the "Delete" button
// given number of times, and then validates that given number of buttons was deleted


1.method : createButtons()
2.deleteButtonsAndValidate()
*/
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons02(driver,100);
        deleteButtonsAndValidateo2(driver,20);


    }


    public void createButtons02(WebDriver driver, int numOfDelete){
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < numOfDelete; i++) {
            addElementButton.click();
        }

    }

    public void deleteButtonsAndValidateo2(WebDriver driver,int numberOfDelete){
        List<WebElement>beforeDeleting=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeOfBeforeDeleting=beforeDeleting.size();
        System.out.println(sizeOfBeforeDeleting);

        int counter = 0;
        for (WebElement w:beforeDeleting) {
            counter++;
            if(counter>numberOfDelete){
                break;
            }

            w.click();

        }
        List<WebElement>afterDeleting=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println(afterDeleting.size());
        Assert.assertEquals(sizeOfBeforeDeleting-afterDeleting.size(),numberOfDelete);


    }



    }
