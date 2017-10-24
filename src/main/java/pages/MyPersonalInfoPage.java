package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gebruiker on 25-9-2017.
 */
public class MyPersonalInfoPage {
    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='email']")
    WebElement myEmailAddress;
    @FindBy(xpath = ".//*[@id='firstname']")
    WebElement myFirstName;
    @FindBy(xpath = ".//*[@id='old_passwd']")
    WebElement myOldPassword;
    @FindBy(xpath = ".//*[@name='submitIdentity']")
    WebElement submitButton;

    public MyPersonalInfoPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public String returnEmailAddress(){
        return myEmailAddress.getAttribute("value");
    }
    public String returnFirstname(){
        return myFirstName.getAttribute("value");
    }
    public void fillFirstname(String firstname){
        myFirstName.clear();
        myFirstName.sendKeys(firstname);
    }
    public void fillOldPassword(String oldpassword){
        myOldPassword.sendKeys(oldpassword);
    }
    public void submitForm(){
        submitButton.click();
    }

}
