package chaptersix;

import pages.Homepage;
import testscenarios.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gebruiker on 20-7-2017.
 */

public class FillCartTest extends TestShopScenario {

//    @Test
//    public void validateEmptyCart9() throws InterruptedException {
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Assertions.assertThat(driver.findElement(By.cssSelector(("ajax_cart_quantity"))).isDisplayed()).as("Check if cart empty").isTrue();
//        driver.findElement(By.cssSelector("a[class=\"tag_level3 first_item\"][title='More about ipod']")).click();
//        driver.findElement(By.xpath("(//a[contains(@href, 'https://techblog.polteq.com/testshop/index.php?id_product=2&controller=product')])[2]")).click();
//        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
//        sleepThread(2000);
//        driver.findElement(By.cssSelector(".continue.btn.btn-default.button.exclusive-medium>span")).click();
//        Assertions.assertThat(driver.findElement(By.cssSelector(".ajax_cart_quantity.unvisible")).isDisplayed()).as("Check if cart filled").isTrue();
//    }
//
//
//    private void sleepThread(long ms ) throws InterruptedException {
//        Thread.sleep(ms);
//    }
//}

    @Test
    public void fillCart() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Homepage homepage = new Homepage(driver);
        homepage.isCartEmpty();
        driver.findElement(By.cssSelector("a[class=\"tag_level3 first_item\"][title='More about ipod']")).click();
        driver.findElement(By.xpath("//div[@id='center_column']//*[contains(text(),'iPod Nano')]")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        sleepThread(2000);
        driver.findElement(By.cssSelector(".continue.btn.btn-default.button.exclusive-medium>span")).click();
        driver.findElement(By.cssSelector(".sf-with-ul")).click();
        Assertions.assertThat(driver.findElement(By.cssSelector(".ajax_cart_quantity")).getText()).as("Cart is empty after adding product").isEqualTo("1");
        homepage.isCartEmpty();
        driver.findElement(By.cssSelector("a[class=\"tag_level3 first_item\"][title='More about ipod']")).click();
        driver.findElement(By.xpath("//div[@id='center_column']//*[contains(text(),'iPod Nano')]")).click();
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        sleepThread(2000);
        driver.findElement(By.cssSelector(".continue.btn.btn-default.button.exclusive-medium>span")).click();
        driver.findElement(By.cssSelector(".sf-with-ul")).click();
        homepage.isCartEmpty();


    }

    private void sleepThread(long ms) throws InterruptedException {
        Thread.sleep(ms);

    }
}
