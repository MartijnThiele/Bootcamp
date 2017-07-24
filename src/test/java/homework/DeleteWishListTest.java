package homework;

import Testcases.TestShopScenario;
import com.sun.glass.ui.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.awt.Robot;

/**
 * Created by Gebruiker on 23-7-2017.
 */
public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void deleteWishlist(){

        //ga naar de login pagina vanuit de homepage
        Homepage homepage = new Homepage(driver);
        homepage.clickAuthenticationPage();

        //log in met opgegeven credentials (land op my account pagina)
        AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        authenticationpage.loginToAccount("martijn@thiele.com", "1qazxsw2");

        //ga naar de my wishlist pagina vanuit de my account pagina
        MyAccountPage myaccountpage = new MyAccountPage(driver);
        myaccountpage.goToMyWishlistsPage();

        //verwijder een wistlist uit de lijst
        MyWishlistsPage mywishlistspage = new MyWishlistsPage(driver);
        mywishlistspage.deleteWishlistsEntry("Feel the pain");

        //verifieer dat de lijst verdwenen is (deze assertation werkt nog niet, asserteren op nog te creeren dynamische locator)
        //Assertions.assertThat(mywishlistspage.getWishlistTitle()).isNotEqualTo("Spinning round round");


        //voeg de lijst opnieuw toe (zodat hij later opnieuw te verwijderen is)
        mywishlistspage.createNewWishlist("Feel the Pin");

    }

}
