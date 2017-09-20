package testscenarios;

import browserfactory.BrowserFactoryAdvanced;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.assertj.core.api.Assertions;

/**
 * Created by Martijn on 20-7-2017.
 */
public class TestShopScenario {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.Browser.CHROME);
        driver.get("https://techblog.polteq.com/testshop/index.php");
        //driver.manage().window().maximize(); (uitgezet want geeft fout in firefox)
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_quantity")).isDisplayed());

    }

//   @AfterMethod
//   public void tearDown(){
//       driver.quit();
//  }
}
