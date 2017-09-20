package datadriven;

import testscenarios.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.Homepage;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class DataDrivenLoginTest extends TestShopScenario {

    @Parameters({"email", "password"})
    @Test
    public void login(String email, String password){

        Homepage homepage = new Homepage(driver);
        homepage.clickAuthenticationPage();

        AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        authenticationpage.loginToAccount(email, password);
        Assertions.assertThat(homepage.isUserLoggedIn()).as("No user was logged in after login attempt").isTrue();
        homepage.logout();
        Assertions.assertThat(homepage.isUserLoggedIn()).as("A user was still logged in after logout attempt").isFalse();

    }
}
