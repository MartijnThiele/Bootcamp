package sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.*;
import testscenarios.TestShopScenario;

import java.text.BreakIterator;
import java.util.List;

/**
 * Created by Gebruiker on 14-9-2017.
 */
public class SandBox extends TestShopScenario {

    @Test
    public void test() throws InterruptedException {

        Homepage homepage = new Homepage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        MyPersonalInfoPage myPersonalInfoPage = new MyPersonalInfoPage(driver);
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homepage.isUserLoggedIn()) {
            homepage.logout();
        }else {
            homepage.clickAuthenticationPage();
        }

        authenticationPage.loginToAccount("martijn2@thiele.com", "1qazxsw2");
        myAccountPage.goToMyPersonalInformationPage();

        System.out.println(myPersonalInfoPage.returnEmailAddress());

    }
}
