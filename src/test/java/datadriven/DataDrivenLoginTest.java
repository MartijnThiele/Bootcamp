package datadriven;

import Testcases.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.ContactUsPage;
import pages.Homepage;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class DataDrivenLoginTest extends TestShopScenario {

    @Parameters({"email", "password"})
    @Test
    public void fillInContactForm(String email, String password){

        Homepage homepage = new Homepage(driver);
        homepage.clickAuthenticationPage();

        AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        authenticationpage.loginToAccount(email, password);
        Assertions.assertThat(homepage.isUserLoggedIn());
        homepage.logout();
        Assertions.assertThat(!homepage.isUserLoggedIn());

    }
}
