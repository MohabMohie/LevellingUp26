package PageObjectModelTests;

import com.shaft.driver.SHAFT;
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
    public SHAFT.GUI.WebDriver driver;
    public WebDriver nativeDriver;
    public Wait<WebDriver> wait;

    @BeforeMethod
    public void setUp(){
        // Open Mozilla Firefox
        driver = new SHAFT.GUI.WebDriver();
        nativeDriver = driver.getDriver();

        // Setup fluent wait
        wait = new FluentWait<>(nativeDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
