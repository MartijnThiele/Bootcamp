package browserdriven   ;

import testscenarios.TestShopScenarioBrowserDriven;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.Homepage;



/**
 * Created by Gebruiker on 27-7-2017.
 */

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

    @Test
    public void goToLoginPage(){
        Homepage homepage = new Homepage(driver);
        driver.findElement(By.cssSelector(".login")).click();
    }


}
