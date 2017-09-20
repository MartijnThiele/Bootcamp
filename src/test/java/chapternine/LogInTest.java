package chapternine;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import sun.font.TrueTypeFont;
import testscenarios.TestShopScenario;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class LogInTest extends TestShopScenario {

    @Test
    public void login(){



        //Checks if a user is logged in, logs out if one is and then goes to authentication page
        Homepage homepage = new Homepage(driver);
        AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        MyAccountPage myaccountpage = new MyAccountPage(driver);

        if (homepage.isUserLoggedIn()) {
            System.out.println("!! user '" + myaccountpage.accountName() + "' was logged in. They have been logged out so the test could proceed !!");
            homepage.logout();
        }else {
            homepage.clickAuthenticationPage();
        }

        Assertions.assertThat(authenticationpage.verifyPage()).as("VerifyPage: You don't seem to be on the right page 'Authentication page' ").isTrue();

        authenticationpage.loginToAccount("bootcamper@feelthepain.com", "1qazxsw2");

        Assertions.assertThat(myaccountpage.verifyPage()).as("You don't seem to be on the right page 'My account page' ").isTrue();
        Assertions.assertThat(homepage.accountName()).as("The expected accountname was not found").isEqualTo("Sergeant Slaughter");

        homepage.logout();
        Assertions.assertThat(homepage.isUserLoggedIn()).as("A user was still logged in after trying to log out").isFalse();
    }
}
