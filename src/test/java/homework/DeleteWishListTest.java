package homework;

import Testcases.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

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
        mywishlistspage.deleteWishlistsEntry();


        //verifieer dat de lijst verdwenen is



        //voeg de lijst opnieuw toe (zodat hij later opnieuw te verwijderen is
        mywishlistspage.createNewWishlist("Feel the Pain");

    }

}
