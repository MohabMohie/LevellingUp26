package Engine;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ActionsBot {
    private static Wait<WebDriver> wait;

    public static void hoverToSubMenuItem(WebDriver driver, By menuItem, By subMenuItem){
        initWait(driver);
        ActionsBot.wait.until(d->{
            new Actions(driver).moveToElement(driver.findElement(menuItem))
                    .pause(Duration.ofMillis(100))
                    .moveToElement(driver.findElement(subMenuItem))
                    .click()
                    .perform();
            return true;
        });
    }

    private static void initWait(WebDriver driver){
        ActionsBot.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
