package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class Homepage {
    private WebDriver driver;
    @FindBy(css = "li#header_link_contact > a")
    WebElement goToContactPage;
    @FindBy(css = ".login")
    WebElement goToAuthenticationPage;
    @FindBy(css = ".account>span")
    WebElement goToAccountPage;
    @FindBy(css = ".account>span")
    WebElement myAccountName;
    @FindBy(css = ".logout")
    WebElement logout;
    public Homepage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);

    }
    public boolean isUserLoggedIn() {
    List<WebElement> logoutAvailable = driver.findElements(By.cssSelector(".logout"));
        if (logoutAvailable.size() ==1) {
            System.out.println(logoutAvailable.size());
            return true;
        }else

        return  false;

    }

    public String accountName(){
        return myAccountName.getText();
    }

    public void logout(){
        driver.findElement(By.cssSelector(".logout")).click();
    }

    public void clickContactPage() {

        goToContactPage.click();
    }
    public void clickAuthenticationPage() {

        goToAuthenticationPage.click();
    }
    public void clickMyAccountPage(){

        goToAccountPage.click();

    }
}