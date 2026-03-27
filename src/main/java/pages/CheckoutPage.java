package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By continueBtn = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillInfo(String fn, String ln, String zc) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(zip).sendKeys(zc);
    }

    public void continueCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("summary_total_label")));
    }
}