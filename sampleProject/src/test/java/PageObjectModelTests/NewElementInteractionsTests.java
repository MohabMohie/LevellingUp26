package PageObjectModelTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewElementInteractionsTests extends TestCase{
    @Test
    public void testMethod(){
        driver.navigate().to("https://www.google.com");
    }

    @BeforeMethod
    public void navigation(){
        driver.navigate().to("https://www.google.com");
    }
}
