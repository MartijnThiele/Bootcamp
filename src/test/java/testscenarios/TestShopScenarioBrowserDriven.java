package testscenarios;

import browserfactory.BrowserFactoryAdvanced;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.assertj.core.api.Assertions;

/**
 * Created by Martijn on 20-7-2017.
 */
public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.Browser browser){
        driver = BrowserFactoryAdvanced.getDriver(browser);
        driver.get("https://techblog.polteq.com/testshop/index.php");
        //driver.manage().window().maximize();
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());

    }

//   @AfterMethod
//   public void tearDown(){
//       driver.quit();
//  }
}
