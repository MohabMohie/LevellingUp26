package Pages.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    private WebDriver driver;
    //locators
    By firstSearchResultLink = By.xpath("(//h3[contains(@class,'LC20lb')])[1]");

    //variables

    //constructor
    public Results(WebDriver driver) {
        this.driver = driver;
    }

    public void openFirstSearchResult(){
        driver.findElement(firstSearchResultLink).click();
    }
}
