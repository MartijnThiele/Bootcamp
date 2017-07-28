package ChapterNine;

import Testcases.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.ContactUsPage;
import pages.Homepage;
import pages.MyAccountPage;

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


    }
}