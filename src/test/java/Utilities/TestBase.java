package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
public abstract class TestBase {
    /*
     * What is TestBase?
     * TestBase is a class that has repeated pre condition and post condiditon
     * We have @Before and @After methods
     *
     * TestBase should be an abstract class.We just want to implement the methods in TestBase
     * We don't want to create an object od TestBase class
     *
     * */
    protected static WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        Code about extent reports
//        Report PATH= creates the html report right under test-output
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/report/"+currentDate+"test_report.html";
//      Create html reporter using the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        Create extent report
        extentReports = new ExtentReports();
//        Add custom information
        extentReports.setSystemInfo("Environment","Test Environment");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("SQA","John");
        extentHtmlReporter.config().setDocumentTitle("TechProEd BlueCar");
        extentHtmlReporter.config().setReportName("TechProEd Extent Report");
//        Attach html and extent reports
        extentReports.attachReporter(extentHtmlReporter);
//        Report is complete. Now we just need to create test using extentTest object
        extentTest = extentReports.createTest("My Project Extent Report","This is for smoke test report");
//        Done with configuration......
    }
    //    @After
//    public void tearDown(){
//        driver.quit();
//        extentReports.flush();
//    }
    /*
     * Create a reusable method for clicking checkbox
     * @param checkboxElement : WebElement of the checkbox
     * @param checked : boolean of the checkbox element
     *
     * Example: if you want to click when checkbox is checked then checked = true
     *         if you want to click when checkbox is not checked then checked = false
     *
     *         selectCheckBox(checkbox1, true); make sure the checkbox1 is checked
     *         selectCheckBox(checkbox1, false); make sure the checkbox1 is unchecked
     */
    public static void selectCheckBox(WebElement checkboxElement, boolean checked){
        if(checked){
            if (!checkboxElement.isSelected()){
                checkboxElement.click();
            }
        }else{
            if (checkboxElement.isSelected()){
                checkboxElement.click();
            }
        }
    }
    /*
    Accepts windowHandle as parameter
    And switches to that window
    * */
    public static void switchToTargetWindow(String targetTitle) {
        for (String handle : driver.getWindowHandles()) {
            String title = driver.switchTo().window(handle).getTitle();
            if (title.equals(targetTitle)) {
                System.out.println("Page found : "+driver.getTitle());
                return;
            }
        }
    }
    public void takeScreenShot() throws IOException {
//        1. Taking screenshot using getScreenshotAs
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        /*
        Alternatively
        TakesScreenshot ts=(TakesScreenshot)driver;
        File image = ts.getScreenshotAs(OutputType.FILE);
         */
//        2. We will save the image in this path. using currentDate for getting different name every time
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        System.out.println(currentDate);
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"test-image.png";
        File finalPath = new File(path);
        FileUtils.copyFile(image,finalPath);
    }
    //  Scrolls onto a specific element. Param : webelement
    public void scrollIntoViewByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    //    Scroll all the way down of a page
    public void scrollAllDownByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //    Scroll al the way up of a page
    public void scrollAllUpByJS(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    //    Click on a specific element. Param: WebElement
    public void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);
    }
    //    Set the value of an input using js executor. Params: WebElement element, String text
//    This method changes the value attribute of an element.
//    It changes the input text
    public void setValueByJS(WebElement element, String text){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",element);
    }
    //    get the value of an input. param: idOfElement
    public void getValueByJS(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String value=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();
        System.out.println(value);
//        How you get get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get teh value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return teh text in an input
    }
    //    Changes the changeBackgroundColorByJS of an element. Params: WebElement element, String color
    public void changeBackgroundColorByJS(WebElement element, String color){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }
    public void addBorderWithJS(WebElement element, String borderStyle){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='"+borderStyle+"'",element);
    }
}