package LinearTests;

import Engine.ActionsBot;
import PageObjectModelTests.TestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NopCommerceHoverTests extends TestCase {

    @Test
    public void testNopCommerceHover() {
        driver.navigate().to("https://demo.nopcommerce.com/");
        By computersMenuItemLink = By.xpath("//ul[contains(@class,'notmobile')]//a[text()='Computers ']");
        By desktopsSubMenuItemLink = By.xpath("//ul[contains(@class,'notmobile')]//a[text()='Desktops ']");

        ActionsBot.hoverToSubMenuItem(driver, computersMenuItemLink, desktopsSubMenuItemLink);

        wait.until(d->{
            Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/desktops");
            return true;
        });
    }
}
