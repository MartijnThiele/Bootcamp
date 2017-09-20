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
    @FindBy(xpath = ".//*[@title='View my shopping cart']")
    WebElement goToShoppingCartPage;
    @FindBy(css = ".account>span")
    WebElement myAccountName;
    @FindBy(css = ".logout")
    WebElement logout;

    public Homepage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);

    }

    //Returns true if user is logged in, false if no user logged in

    public boolean isUserLoggedIn() {
    List<WebElement> logoutAvailable = driver.findElements(By.cssSelector(".logout"));
        if (logoutAvailable.size() ==1) {
            return true;
        }else

        return  false;

    }


    public String accountName(){
        List<WebElement> logoutAvailable = driver.findElements(By.cssSelector(".logout"));
        if (logoutAvailable.size() ==1) {
            return myAccountName.getText();
        }else

            return  null;

    }

    public void logout(){

        driver.findElement(By.cssSelector(".logout")).click();
    }

    //These methods are used to navigate to another page

    public void clickShoppingCartPage(){
       goToShoppingCartPage.click();
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

    //Returns true if cart is empty, false if cart is filled

    public boolean isCartEmpty(){
        String cartquantity = (driver.findElement(By.cssSelector(".ajax_cart_quantity")).getText());
        if (cartquantity.isEmpty()) {
            System.out.println("mandje is leeg");
            return true;
        }else{
            System.out.println("mandje is gevuld ( " + Integer.parseInt(driver.findElement(By.cssSelector(".ajax_cart_quantity")).getText()) + (" artikel(en))"));
            return false;
        }
    }

    //Returns the number of items in the cart

    public int cartQuantity() {
        String cartquantity = (driver.findElement(By.cssSelector(".ajax_cart_quantity")).getText());
        if (cartquantity.isEmpty()) {
            return 0;
        }else{
            return Integer.parseInt(driver.findElement(By.cssSelector(".ajax_cart_quantity")).getText());
        }
    }

}