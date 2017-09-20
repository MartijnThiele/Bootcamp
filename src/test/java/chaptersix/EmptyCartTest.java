package chaptersix;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.ShoppingCartPage;
import testscenarios.TestShopScenario;

/**
 * Created by Gebruiker on 13-9-2017.
 */
public class EmptyCartTest extends TestShopScenario {

    @Test
    public void emptyCart ()throws InterruptedException{

        Homepage homepage = new Homepage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        //Checks if the cart is empty and adds and iPod Nano if it is

        if (homepage.isCartEmpty()) {
            driver.findElement(By.cssSelector("a[class=\"tag_level3 first_item\"][title='More about ipod']")).click();
            driver.findElement(By.xpath("//div[@id='center_column']//*[contains(text(),'iPod Nano')]")).click();
            driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
            sleepThread(2000);
            driver.findElement(By.cssSelector(".continue.btn.btn-default.button.exclusive-medium>span")).click();
            driver.findElement(By.cssSelector(".sf-with-ul")).click();
        }

        //Goes to the shopping cart page and deletes the first item in the basket

        homepage.clickShoppingCartPage();
        shoppingCartPage.deleteEntireCart();

    }

    private void sleepThread(long ms) throws InterruptedException {
        Thread.sleep(ms);

    }
}
