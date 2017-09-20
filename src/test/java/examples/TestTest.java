package examples;

import testscenarios.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Gebruiker on 27-7-2017.
 */

public class TestTest extends TestShopScenario {

    @Test
    public void goToLoginPage(){
    Homepage homepage = new Homepage(driver);
    driver.findElement(By.cssSelector(".login")).click();
    }


}
