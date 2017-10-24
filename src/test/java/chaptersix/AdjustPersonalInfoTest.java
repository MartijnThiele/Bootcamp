package chaptersix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.Homepage;
import pages.MyAccountPage;
import pages.MyPersonalInfoPage;
import testscenarios.TestShopScenario;

/**
 * Created by Gebruiker on 25-9-2017.
 */
public class AdjustPersonalInfoTest extends TestShopScenario{

    @Test
    public void adjustPersonalInfo(){

        Homepage homepage = new Homepage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        MyPersonalInfoPage myPersonalInfoPage = new MyPersonalInfoPage(driver);

        String email = "martijn2@thiele.com";
        String password = "1qazxsw2";
        String defaultfirstname = "Martijn";
        String alternativefirstname = "Mnezz";
        String currentfirstname;

        if  (homepage.isUserLoggedIn()) {
            homepage.clickMyAccountPage();
            myAccountPage.goToMyPersonalInformationPage();

                if  (!email.equals(myPersonalInfoPage.returnEmailAddress())){
                    homepage.logout();
                    homepage.clickAuthenticationPage();
                    authenticationPage.loginToAccount(email,password);
                    myAccountPage.goToMyPersonalInformationPage();
                }

        }else {
            homepage.clickAuthenticationPage();
            authenticationPage.loginToAccount(email,password);
            myAccountPage.goToMyPersonalInformationPage();
        }

        if  (myPersonalInfoPage.returnFirstname().equals(defaultfirstname)){
            myPersonalInfoPage.fillFirstname(alternativefirstname);
            currentfirstname=alternativefirstname;

        }else{
            myPersonalInfoPage.fillFirstname(defaultfirstname);
            currentfirstname=defaultfirstname;
        }

        myPersonalInfoPage.fillOldPassword(password);
        myPersonalInfoPage.submitForm();

        Assertions.assertThat(driver.findElement(By.xpath(".//*[@class='alert alert-success']")).isDisplayed()).as("Succesfull update message not found");
        Assertions.assertThat(homepage.accountName()).as("de huidge voornaam lijkt niet te kloppen").startsWith(currentfirstname);

    }


}
