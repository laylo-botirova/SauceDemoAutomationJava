package steps;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        DriverManager.setDriver(driver);
    }
    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
}
