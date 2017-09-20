package homework;

import testscenarios.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Martijn on 23-7-2017.
 */
public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void deleteWishlist(){

        //Goes to login page from homepage
        Homepage homepage = new Homepage(driver);
        homepage.clickAuthenticationPage();

        //Asserts that Authentication page is available and logs in with provided credentials (lands on "my account" page)
        AuthenticationPage authenticationpage = new AuthenticationPage(driver);
        Assertions.assertThat(authenticationpage.verifyPage()).as("You don't seem to be on the right page 'Authentication page' ").isTrue();
        authenticationpage.loginToAccount("martijn@thiele.com", "1qazxsw2");

        //Goes to wishlist page from my account page
        MyAccountPage myaccountpage = new MyAccountPage(driver);
        Assertions.assertThat(myaccountpage.verifyPage()).as("You don't seem to be on the right page 'My account page' ").isTrue();
        myaccountpage.goToMyWishlistsPage();

        //Asserts that the chosen list is there, and creates it if it is not
        String listToAssert = "Feel the pain";
        MyWishlistsPage mywishlistspage = new MyWishlistsPage(driver);
        Assertions.assertThat(mywishlistspage.verifiyPage()).as("You don't seem to be on the right page 'My wishlists page' ").isTrue();


        if (mywishlistspage.isWishlistAvailable(listToAssert).equals(false)){
            mywishlistspage.createNewWishlist(listToAssert);
            System.out.println("!! The list you were trying to remove was not in the table, an attempt has been made to create it so the test could proceed !!");
        }

        Assertions.assertThat(mywishlistspage.isWishlistAvailable(listToAssert)).as("The list you were trying to delete did not exist, and an attempt to create it failed ").isTrue();

        //Deletes the chosen list
        mywishlistspage.deleteWishlistsEntry(listToAssert);

        //Verifies that list has been deleted
        homepage.clickMyAccountPage();
        myaccountpage.goToMyWishlistsPage();
        Assertions.assertThat(mywishlistspage.isWishlistAvailable(listToAssert)).as("The list you tried to delete is still there").isFalse();

        //Adds the list back to the wishlist table, so that it can be deleted again
        mywishlistspage.createNewWishlist(listToAssert);

    }

}
