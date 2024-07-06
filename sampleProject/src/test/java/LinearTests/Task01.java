package LinearTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task01 {
    ChromeDriver driver;
    /**
     * Task01
     * - Given you have the project on intellij
     * - Given you're using JDK 21
     * - Add selenium and testng dependencies to your pom.xml
     * - Open chrome browser
     * - navigate to "https://www.selenium.dev/"
     * - assert that page title is "Selenium"
     *
     * //flow of execution
     * class level variables
     * -beforemethod
     * -method
     * -aftermethod
     *
     * Task01_1
     * make one test fail, and one test pass
     * manage the flow of execution using beforemethod and aftermethod
     * try using beforeclass and afterclass and discuss
     */
    @Test
    public void task01() {
        driver.navigate().to("https://www.selenium.dev/");
        var pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Seleniumxxxxxxxxxxxxxx");
    }

    @Test
    public void task01_1() {
        driver.navigate().to("https://www.selenium.dev/");
        var pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Selenium");
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
