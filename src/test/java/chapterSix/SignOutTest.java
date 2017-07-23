package chapterSix;

import Testcases.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Martijn on 20-7-2017.
 */
public class SignOutTest extends TestShopScenario{


    @Test
    public void logInLogOut() {
        //ChromeDriverManager.getInstance().setup();
        //WebDriver driver = new ChromeDriver();


        //Go to website and maximize
        //driver.get("https://techblog.polteq.com/testshop/index.php");
        //driver.manage().window().maximize();

        //Login with credentials
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();

        //Validate login
        Assertions.assertThat(driver.findElement(By.className("page-heading")).getText()).as("My account not available").isEqualTo("MY ACCOUNT");

        //logout
        driver.findElement(By.className("logout")).click();

        //Validate logout
        Assertions.assertThat(driver.findElement(By.className("page-heading")).getText()).as("Authentication not available").isEqualTo("AUTHENTICATION");

        //Close browser
        //driver.quit();
    }
}
