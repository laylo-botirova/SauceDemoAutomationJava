package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProducts(String productName){
        String xpath = "//div[text()='"+ productName + "']/ancestor::div[@class='inventory_item']//button";
        driver.findElement(By.xpath(xpath)).click();

    }
    public void goToCart(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
