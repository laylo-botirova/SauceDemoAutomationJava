package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String productName) {
        String xpath = "//div[@class='inventory_item']//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By locator = By.xpath(xpath);

        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", btn
        );

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))
        );

        cartBtn.click();
    }
}
