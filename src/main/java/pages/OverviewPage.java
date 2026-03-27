package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OverviewPage {
    WebDriver driver;


    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    By itemPrices = By.className("inventory_item_price");
    By totalPrice = By.className("summary_total_label");
    By finishBtn = By.id("finish");

    public double getItemsTotal(){
        List<WebElement> prices =driver.findElements(itemPrices);
        double sum = 0;

        for(WebElement price: prices){
            sum+= Double.parseDouble(price.getText().replace("$", ""));
        }
        return  sum;

    }

    public double getFinalTotal(){
        String text = driver.findElement(totalPrice).getText();

        return  Double.parseDouble(text.replace("Total: $",""));
    }

    public void clickFinish(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        btn.click();
    }
}
