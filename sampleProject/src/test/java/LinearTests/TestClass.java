package LinearTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void testMethod(){
        WebDriver driver;
        driver = new ChromeDriver();
//        ChromeDriver driver = new ChromeDriver();

//        WebDriver driver;
//        ChromeOptions chromeOptions;
//        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("--headless=new");
//        driver = new ChromeDriver(chromeOptions);

//        driver.get("");
////        driver.findElement()
////        driver.findElements()
//        driver.manage().window().maximize();
//        driver.getTitle();
//        driver.getCurrentUrl();
        driver.close();
        driver.quit();
    }
}
