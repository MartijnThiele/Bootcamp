package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


/**
 * Created by Gebruiker on 23-7-2017.
 */
public class MyAccountPage {
    private WebDriver driver;
    @FindBy(css = ".lnk_wishlist>a>span")
    WebElement myWishlistsButton;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public void goToMyWishlistsPage(){
        myWishlistsButton.click();
    }
}