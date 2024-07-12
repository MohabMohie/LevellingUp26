package Pages.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeInherited extends Page{
    //locators
    private By searchInput = By.name("q");
    //variables
    private String url = "https://www.google.com/ncr";

    public HomeInherited(WebDriver driver) {
        super(driver);
    }

    //constructor

    //actions
//    traditional POM (returns void, simple data type for assertion)
    public void navigate(){
        driver.navigate().to(url);
    }
    public void search(String query){
        driver.findElement(searchInput).sendKeys(query, Keys.RETURN);
    }

//    //fluent design (returns an object of the destination page)
//    public Home navigate(){
//        driver.navigate().to(url);
//        return this;
//    }
//
//    public Results search(String query){
//        driver.findElement(searchInput).sendKeys(query, Keys.RETURN);
//        return new Results(driver);
//    }
}