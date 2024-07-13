package LinearTests;

import Engine.ActionsBot;
import PageObjectModelTests.TestCase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NopCommerceHoverTests extends TestCase {

    @Test
    public void testNopCommerceHover() {
//        nativeDriver.navigate().to("https://demo.nopcommerce.com/");
        By computersMenuItemLink = By.xpath("//ul[contains(@class,'notmobile')]//a[text()='Computers ']");
        By desktopsSubMenuItemLink = By.xpath("//ul[contains(@class,'notmobile')]//a[text()='Desktops ']");

//        ActionsBot.hoverToSubMenuItem(nativeDriver, computersMenuItemLink, desktopsSubMenuItemLink);

//        wait.until(d->{
//            Assert.assertEquals(nativeDriver.getCurrentUrl(),"https://demo.nopcommerce.com/desktops");
//            return true;
//        });
        driver.browser().navigateToURL("https://demo.nopcommerce.com/")
                .element().hover(computersMenuItemLink).click(desktopsSubMenuItemLink)
                .browser().assertThat().url().isEqualTo("https://demo.nopcommerce.com/desktops");
    }
}
