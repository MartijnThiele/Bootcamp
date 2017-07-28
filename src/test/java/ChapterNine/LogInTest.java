package ChapterNine;

import Testcases.TestShopScenario;
import org.assertj.core.api.Assertions;
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

        homepage.clickAuthenticationPage();

        AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        MyAccountPage myaccountpage = new MyAccountPage(driver);
        //Assertions.assertThat(authenticationpage.verifiyPage()).as("You don't seem to be on the right page 'Authentication page' ").isTrue();
        authenticationpage.loginToAccount("martijn@thiele.com", "1qazxsw2");
        String user = myaccountpage.accountName();
        if (homepage.isUserLoggedIn()) {
            homepage.logout();
            System.out.println("!! user " + user + " was logged in. User has been logged out so the test coould proceed !!");
        }else System.out.println("no user logged in");

        //homepage.clickAuthenticationPage();

        //Asserts that Authentication page is available and logs in with provided credentials (lands on "my account" page)
       // AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        //Assertions.assertThat(authenticationpage.verifiyPage()).as("You don't seem to be on the right page 'Authentication page' ").isTrue();
        //authenticationpage.loginToAccount("bootcamper@feelthepain.com", "1qazxsw2");

        //Asserts that you are on the my account page and if the right accountname was found
//        MyAccountPage myaccountpage = new MyAccountPage(driver);
//        Assertions.assertThat(myaccountpage.verifiyPage()).as("You don't seem to be on the right page 'My account page' ").isTrue();
//        Assertions.assertThat(homepage.accountName()).as("The expected accountname was not found").isEqualTo("Sergeant Slaughter");

    }
}
