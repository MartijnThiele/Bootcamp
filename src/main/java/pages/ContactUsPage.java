package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


/**
 * Created by Martijn on 21-7-2017.
 */
public class ContactUsPage {
    private WebDriver driver;
    @FindBy(css = "input#email") //# is voor ID, id = email had ook gekund, maar is in uitgebreide situaties soms niet uniek genoeg
    WebElement emailTextField;
    @FindBy(css = "input#id_order")
    WebElement idOrderTextField;
    @FindBy(css = "textarea#message")
    WebElement contactMessage;
    @FindBy(css = "button#submitMessage")
    WebElement submitButton;
    @FindBy(css = ".alert.alert-success")
    WebElement submitSuccess;
    @FindBy(xpath = ".//*[@class='form-group form-error']/input[@id='email']")
    WebElement invalidEmail;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);

    }

    public void fillInContactform(String email, String orderID, String message) {
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");
        emailTextField.sendKeys(email);
        idOrderTextField.sendKeys(orderID);
        contactMessage.sendKeys(message);
        submitButton.click();

    }

    public void fillInSubjectHeading() {
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");
    }

    public void fillInEmailtextfield(String email) {
        emailTextField.sendKeys(email);
    }

    public void fillInIdOrderTextfield(String orderID) {
        idOrderTextField.sendKeys(orderID);
    }

    public void fillInContactMessage(String message) {
        contactMessage.sendKeys(message);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

   public String verifySubmitSuccess() {
       return submitSuccess.getText();
   }

   public boolean invalidEmail(){
       List<WebElement> wrongEmail = driver.findElements(By.cssSelector(".//*[@class='form-group form-error']/input[@id='email']"));
       if (wrongEmail.size() ==1) {
           return true;
       }else

           return  false;

   }
   }



