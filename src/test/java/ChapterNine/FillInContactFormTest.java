package ChapterNine;

import Testcases.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Homepage;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class FillInContactFormTest extends TestShopScenario {

    @Test
    public void fillInContactForm(){

        Homepage homepage = new Homepage(driver);
        homepage.clickContactPage();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInContactform("ik@hier.nu", "123456", "Dit is een testbericht");

        Assertions.assertThat(contactUsPage.verifySubmitSuccess()).as("Check alert message").isEqualTo("Your message has been successfully sent to our team.");


    }
}
