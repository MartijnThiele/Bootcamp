package datadriven;

import Testcases.TestShopScenario;
import browserdriven.TestshopScenarioBrowserDriven;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Homepage;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class DataDrivenFillInContactFormTest extends TestShopScenario {

    @Parameters({"email", "orderID", "message"})
    @Test
    public void fillInContactForm(String email, String orderID, String message){

        Homepage homepage = new Homepage(driver);
        homepage.clickContactPage();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactform(email, orderID, message);

        Assertions.assertThat(contactUsPage.verifySubmitSuccess()).as("Check alert message").isEqualTo("Your message has been successfully sent to our team.");


    }
}
