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
public class AuthenticationPage {
    private WebDriver driver;
    @FindBy(id = "email")
    WebElement emailTextField;
    @FindBy(id = "passwd")
    WebElement passwordTextField;
    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }
    public void loginToAccount(String email, String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        submitButton.click();
    }
}




