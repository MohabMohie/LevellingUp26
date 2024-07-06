package PageObjectModelTests;

import Pages.Google.Home;
import Pages.Google.Results;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Steps:
 * Open Mozilla Firefox
 * Navigate to [https://www.google.com/ncr]
 * Search for [Selenium WebDriver]
 * Open the first search result
 * Assert that the page title is [Selenium | WebDriver]
 * Assert that the page header is [WebDriver]
 * Close Mozilla Firefox
 *
 * Requirements:
 * use TestNG to manage the flow of execution
 * handle synchronization correctly
 */
public class ElementInteractionsTests {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    @Test
    void checkPageTitle(){
        // Assert that the page title is [Selenium | WebDriver]
//        String pageTitleText = driver.getTitle();
        AtomicReference<String> pageTitleText = new AtomicReference<>();
        wait.until(f -> {
            pageTitleText.set(driver.getTitle());
            return true;
        });
        Assert.assertEquals(pageTitleText.get(), "Selenium | WebDriver");
    }

//    @Test
//    void checkPageHeader(){
//        // Assert that the page header is [WebDriver]
//        By pageHeaderLabel = By.tagName("h1");
//        String pageHeaderText = driver.findElement(pageHeaderLabel).getText();
//        Assert.assertEquals(pageHeaderText, "WebDriver");
//    }

//    @Test
//    void checkPageHeader(){
//        // Assert that the page header is [WebDriver]
//        By pageHeaderLabel = By.tagName("h1");
//        AtomicReference<String> pageHeaderText = new AtomicReference<>();
//        wait.until(f -> {
//            pageHeaderText.set(driver.findElement(pageHeaderLabel).getText());
//            return true;
//        });
//        Assert.assertEquals(pageHeaderText.get(), "WebDriver");
//    }

    @Test
    void checkPageHeader(){
        // Assert that the page header is [WebDriver]
        By pageHeaderLabel = By.tagName("h1");
        wait.until(f -> {
            String pageHeaderText = driver.findElement(pageHeaderLabel).getText();
            Assert.assertEquals(pageHeaderText, "WebDriver");
            return true;
        });
    }

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

        // Navigate to [https://www.google.com/ncr]

//        // Traditional POM
        Home homePage = new Home(driver);
        homePage.navigate();
        homePage.search("Selenium WebDriver");

        Results resultsPage = new Results(driver);
        resultsPage.openFirstSearchResult();

//        //Fluent Design
//        new Home(driver)
//                .navigate()
//                .search("Selenium WebDriver")
//                .openFirstSearchResult();

    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
