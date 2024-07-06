package LinearTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task02 {
    /**
     * create three test methods
     * one assertion per method
     * and use depends on methods to highlight dependencies
     * setup and teardown using before/after class
     */
    //Test scenario, one scenario per class
    WebDriver driver;

    @Test
    public void action3() {
        //add item to cart
        //assert item added successfully
        Assert.assertEquals("--", "--");
    }

    @Test(dependsOnMethods = "action3")
    public void action2(){
        //navigate to cart
        //assert total calculated successfully
        Assert.assertEquals("--", "--");
    }

    @Test(dependsOnMethods = "action2")
    public void action1(){
        //complete checkout
        //assert order status is in progress
        Assert.assertEquals("--", "--");
    }

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //login to application
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
