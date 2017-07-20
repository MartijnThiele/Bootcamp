package examples;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

/**
 * Created by Gebruiker on 19-7-2017.
 */
public class FirstSeleniumTest {

    @Test
    public void logInSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("tester@test.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
        String knop = driver.findElement(By.className("page-heading")).getText();
        Boolean elementPresent = driver.findElement(By.className("page-heading")).isDisplayed();
        Assertions.assertThat(elementPresent).as("my account not found").isTrue();
        Assertions.assertThat(knop).as("my account wrong text").isEqualTo("MY ACCONT");

    }

    public void assertString(){
        String naam = "MartijnThiele";

        Assertions.assertThat(naam).doesNotContain("@");
        Assertions.assertThat(naam).doesNotContain("@");

    }
    @Test
    public void assertBoolean() {
        Boolean truthy = false;

        Assertions.assertThat(truthy).isEqualTo(true);
    }
}
