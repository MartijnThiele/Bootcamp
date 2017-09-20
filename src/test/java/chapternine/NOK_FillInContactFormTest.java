package chapternine;

import testscenarios.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Homepage;

/**
 * Created by Gebruiker on 27-7-2017.
 */
public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void contactFormerror() {
        //Checks if a user is logged in, logs out if one is and then goes to authentication page
        Homepage homepage = new Homepage(driver);
        Assertions.assertThat(homepage.isUserLoggedIn()).as("A user was already logged in").isFalse();
        homepage.clickContactPage();

        ContactUsPage contactuspage = new ContactUsPage(driver);
        contactuspage.fillInSubjectHeading();
        contactuspage.fillInEmailtextfield("nope");
        contactuspage.fillInIdOrderTextfield("nope");
        Assertions.assertThat(contactuspage.invalidEmail());




    }
}
