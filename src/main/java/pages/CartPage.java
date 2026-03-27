package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btn);

        try { Thread.sleep(500); } catch (Exception ignored) {}

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }
    public boolean isProductAvailable(String productName){
        return driver.findElements(By.xpath("//div[text()='"+ productName + "']")).size()>0;

    }
}
