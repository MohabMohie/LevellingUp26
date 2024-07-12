package PageObjectModelTests;

import Pages.Google.Home;
import Pages.Google.Results;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestCase {
    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeMethod
    void setUp(){
        // Open Mozilla Firefox
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Setup fluent wait
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
