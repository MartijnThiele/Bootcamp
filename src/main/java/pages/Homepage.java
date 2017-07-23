package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class Homepage {
    private WebDriver driver;
    @FindBy(css = "li#header_link_contact > a")
    WebElement goToContactPage;
    @FindBy(css = ".login")
    WebElement goToAuthenticationPage;

    public Homepage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);

    }

    public void clickContactPage() {
        goToContactPage.click();
    }

    public void clickAuthenticationPage() {
        goToAuthenticationPage.click();
    }
}