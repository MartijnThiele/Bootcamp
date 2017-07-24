package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.Keys;

/**
 * Created by Gebruiker on 23-7-2017.
 */
public class MyWishlistsPage {



    private WebDriver driver;
            @FindBy(css = "hier_komt_een_locator_waarin_de_namen_van _wishlists_terg_te_vinden_moeten_zijn") //nog uitzoeken hoe je een locator bouwt die te vergelijken is met een deel van de totel van een wishlist
            WebElement checkForWishListName;
            @FindBy(xpath = ".//*[@id='name']")
            WebElement enterNewWishlistTextfield;
            @FindBy(xpath = ".//*[@id='submitWishlist']")
            WebElement saveNewWishlistButton;

    public MyWishlistsPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void deleteWishlistsEntry (String sRowValue) {

        //This loop finds the first row which' title matches sRowvalue
        for (int i = 1; i <= 5; i++) {
            String sValue = null;
            sValue = driver.findElement(By.xpath(".//tr[" + i + "]/td[1]")).getText();
            if (sValue.equalsIgnoreCase(sRowValue)) {
                // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                driver.findElement(By.xpath(".//tr[" + i + "]/td[7]/a/i")).click();
                driver.switchTo().alert().accept();
            }
        }
    }
    public void createNewWishlist(String title){
        enterNewWishlistTextfield.sendKeys(title);
        saveNewWishlistButton.click();

    }
}

