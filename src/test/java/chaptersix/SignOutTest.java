package chaptersix;

import testscenarios.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

/**
 * Created by Martijn on 20-7-2017.
 */
public class SignOutTest extends TestShopScenario{


    @Test
    public void logInLogOut() {

        //Login with credentials
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        //Validate login in two different ways
        Assertions.assertThat(driver.findElement(By.className("page-heading")).getText()).as("My account not available").isEqualTo("MY ACCOUNT");
        Assertions.assertThat(driver.findElement(By.cssSelector("a.logout")).isDisplayed()).as("Logout link should be displayed").isTrue();

        //logout
        driver.findElement(By.className("logout")).click();

        //Validate logout
        Assertions.assertThat(driver.findElement(By.className("page-heading")).getText()).as("AuthenticationPage not available").isEqualTo("AUTHENTICATION");
        Assertions.assertThat(driver.findElement(By.cssSelector(".login")).getText()).as("AuthenticationPage not available").isEqualTo("Sign in");




    }
}
