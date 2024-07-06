package LinearTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementActionTests {
    private WebDriver driver;

    @Test
    void testMethod(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        By textInput;
        textInput = By.id("my-text-id");            //*[@id='my-text-id']
        textInput = By.tagName("input");            //input
        textInput = By.className("form-control");   //*[@class='form-control']
        textInput = By.name("my-text");             //*[@name='my-text']
        textInput = By.xpath("//input[@id='my-text-id']"); //when all else fails, write an xpath
//        textInput = By.cssSelector("");

        By selectDropdown = By.name("my-select");
        String dropdownText = driver.findElement(selectDropdown).getText();

        String expectedText = "                Open this select menu\n" +
                "                One\n" +
                "                Two\n" +
                "                Three\n" +
                "              ";

        Assert.assertEquals(dropdownText, expectedText);

        By selectedOption = By.xpath("//option[@selected]");
        String selectedOptionText = driver.findElement(selectedOption).getText();

        Assert.assertEquals(selectedOptionText, "Open this select menu");

        driver.findElement(selectedOption).sendKeys("Selenium", Keys.RETURN);

        /**
         * Implicit wait-------------
         * Explicit wait
         * Custom wait (Fluent wait)
         * Thread.sleep(10000)-------
         */

        Wait<WebDriver> wait;

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d -> {
            driver.findElement(selectedOption).click();
            return true;
        });
    }

    @BeforeMethod
    void beforeMethod(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    void afterMethod(){
        driver.quit();
    }
}
