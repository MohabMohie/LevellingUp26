package LinearTests;

import PageObjectModelTests.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NopCommerceHoverTests extends TestCase {

    @Test
    public void testNopCommerceHover() {
        driver.navigate().to("https://demo.nopcommerce.com/");
        By computersMenuItemLink = By.xpath("//ul[contains(@class,'notmobile')]//a[text()='Computers ']");
        By desktopsSubMenuItemLink = By.xpath("//ul[contains(@class,'notmobile')]//a[text()='Desktops ']");

        wait.until(d->{
            new Actions(driver).moveToElement(driver.findElement(computersMenuItemLink))
                            .pause(Duration.ofMillis(100))
                            .moveToElement(driver.findElement(desktopsSubMenuItemLink))
                            .click()
                            .perform();
            return true;
        });

        wait.until(d->{
            Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/desktops");
            return true;
        });
    }
}
