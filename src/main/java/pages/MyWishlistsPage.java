package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Created by Martijn on 23-7-2017.
 */
public class MyWishlistsPage {


    private WebDriver driver;

            @FindBy(xpath = ".//*[@id='name']")
            WebElement enterNewWishlistTextfield;
            @FindBy(xpath = ".//*[@id='submitWishlist']")
            WebElement saveNewWishlistButton;

    public MyWishlistsPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    public boolean verifiyPage() {
        if (enterNewWishlistTextfield.isDisplayed()) ;
        return true;
    }

    public Boolean isWishlistAvailable(String nameToAssert){
        //This list gets the number of rows from the table
        List<WebElement> rows = driver.findElements(By.xpath(".//tr"));

        //This loop finds the first row which' title matches sRowValue
        for (int i = 1; i < rows.size(); i++) {
            String sValue = driver.findElement(By.xpath(".//tr[" + i + "]/td[1]")).getText();
            if (sValue.equalsIgnoreCase(nameToAssert)) {
                return true;

            }

        }
        return false;
    }

    public void deleteWishlistsEntry (String sRowValue) {

        //This list gets the number of rows from the table
        List<WebElement> rows = driver.findElements(By.xpath(".//tr"));

        //This loop finds the first row which' title matches sRowValue
        for (int i = 1; i < rows.size(); i++) {
            String sValue = driver.findElement(By.xpath(".//tr[" + i + "]/td[1]")).getText();
            if (sValue.equalsIgnoreCase(sRowValue)) {
                // If the sValue matches with the description, the element in the seventh column of the row will be clicked
                driver.findElement(By.xpath(".//tr[" + i + "]/td[7]/a/i")).click();
                driver.switchTo().alert().accept();
//                try {
//                    Thread.sleep(10000);
//                } catch(InterruptedException ex) {
//                    Thread.currentThread().interrupt();
//                }
//                driver.navigate().refresh();

            }


        }

    }

    public void createNewWishlist(String title){
        enterNewWishlistTextfield.sendKeys(title);
        saveNewWishlistButton.click();


    }
}

