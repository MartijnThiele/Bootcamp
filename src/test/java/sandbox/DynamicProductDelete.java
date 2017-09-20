package sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.ShoppingCartPage;
import testscenarios.TestShopScenario;

import java.text.BreakIterator;
import java.util.List;

/**
 * Created by Gebruiker on 14-9-2017.
 */
public class DynamicProductDelete extends TestShopScenario{

    @Test
    public void emptyCart ()throws InterruptedException {

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

        List<WebElement> columns = driver.findElements(By.xpath(".//thead//th"));
        System.out.println(columns.size());
        for (int j = 1; j <= columns.size(); j++) {
            String columnValue = driver.findElement(By.xpath(".//tbody//tr[1]/td[" + j + "]")).getAttribute("data-title");
            System.out.println(columnValue);




        }
    }

    private void sleepThread(long ms) throws InterruptedException {
        Thread.sleep(ms);

    }
}
