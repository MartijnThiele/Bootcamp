package Testcases;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

/**
 * Created by Martijn on 20-7-2017.
 */
public class TestShopScenario {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
