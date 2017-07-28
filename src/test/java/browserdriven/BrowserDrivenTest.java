package browserdriven   ;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.Homepage;



/**
 * Created by Gebruiker on 27-7-2017.
 */

public class BrowserDrivenTest extends TestshopScenarioBrowserDriven {

    @Test
    public void goToLoginPage(){
        Homepage homepage = new Homepage(driver);
        driver.findElement(By.cssSelector(".login")).click();
    }


}
