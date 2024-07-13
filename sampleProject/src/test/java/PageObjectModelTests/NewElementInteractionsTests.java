package PageObjectModelTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewElementInteractionsTests extends TestCase{
    @Test
    public void testMethod(){
        nativeDriver.navigate().to("https://www.google.com");
    }

    @BeforeMethod
    public void navigation(){
        nativeDriver.navigate().to("https://www.google.com");
    }
}
