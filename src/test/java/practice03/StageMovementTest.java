package practice03;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class StageMovementTest extends TestBase {
    @Test
    public void stageMovements() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement image1 = driver.findElement(By.xpath("(//img[@class='replace-2x img-responsive'])[1]"));
        scrollIntoViewByJS(image1);
        Thread.sleep(3000);
//        hover over the product
        Actions actions = new Actions(driver);
        actions.moveToElement(image1).perform();
        Thread.sleep(3000);
        WebElement addToCartButton = driver.findElement(By.xpath("(//span[.='Add to cart'])[1]"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]")));//Product successfully added to your shopping cart
        String productText = product.getText();
        Assert.assertEquals("Product successfully added to your shopping cart",productText);
//        And verifies the color, size, quantity, price, shipping, Total Price
//        And verifies the color, size => Orange, S
        WebElement colourAndSize = driver.findElement(By.id("layer_cart_product_attributes"));
        Assert.assertEquals("Orange, S", colourAndSize.getText());
//       Verify Quantity is equal to 1
        WebElement quantity = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']"));
        Assert.assertEquals("1",quantity.getText());
//        Assert the price is equal to "$16.51"
        WebElement price = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']"));
        String expectedPrice = price.getText();
        Assert.assertEquals("$16.51",price.getText());
//        Assert that shipping is equal to "$2.00"
        WebElement shippingPrice = driver.findElement(By.xpath("//span[@class='ajax_cart_shipping_cost']"));
        Assert.assertEquals("$2.00",shippingPrice.getText());
//        Assert that total price is equal to "$18.51"   => (16.51 + 2.00 = 18.51)
        WebElement totalPrice = driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']"));
        Assert.assertEquals("$18.51",totalPrice.getText());
//        And clicks on Proceed to checkout
        driver.findElement(By.linkText("Proceed to checkout")).click();
//      Verify that user is on the summary stage, VERIFY => SHOPPING-CART SUMMARY is displayed
        WebElement cartSummary = driver.findElement(By.id("cart_title"));
        Assert.assertTrue(cartSummary.isDisplayed());
//        Then verify the product is in stock
        WebElement inStock = driver.findElement(By.xpath("//span[@class='label label-success']"));
        Assert.assertEquals("In stock", inStock.getText());
//        Then verify the Unit price matches the price that is on the Add To Card page
        WebElement unitPrice = driver.findElement(By.xpath("//span[@id='product_price_1_1_0']"));
        String actualUnitPrice = unitPrice.getText();
        Assert.assertEquals(expectedPrice,actualUnitPrice);
//        And user clicks on + sign
        driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
        Thread.sleep(3000);
//        Then verifies the TOTAL price is 2*price+shipping => 2 * 16.51 + 2.00 = 35.02
        WebElement totalPrice2 = driver.findElement(By.xpath("//span[@id='total_price']"));
        Assert.assertEquals("$35.02",totalPrice2.getText());

        //And click on Proceed to checkout
        driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();

        //Then verify sign-in page displayed
        WebElement authentication=driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(authentication.isDisplayed());

        //Then the user enters a username password and sign in
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("abdullah@gmail.com");

        WebElement password=driver.findElement(By.xpath("//input[@id='passwd']"));
        password.sendKeys("12345");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

    }
}