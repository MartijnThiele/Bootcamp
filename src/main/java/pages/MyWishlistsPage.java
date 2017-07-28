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

    public void deleteWishlistsEntry (String sRowValue, String sColumnValue) {

        //This list gets the number of rows from the table
        List<WebElement> rows = driver.findElements(By.xpath(".//tr"));
        List<WebElement> columns = driver.findElements(By.xpath(".//tr/th"));

        //This loop finds the first row which' title matches sRowValue
        for (int i = 1; i < rows.size(); i++) {
            String rowValue = driver.findElement(By.xpath(".//tr[" + i + "]/td[1]")).getText();
            if (rowValue.equalsIgnoreCase(sRowValue)) {

                for (int j = 1; j <= columns.size(); j++) {
                    String columnValue = driver.findElement(By.xpath(".//tr/th[" + j + "]")).getText();
                    if (columnValue.equalsIgnoreCase(sColumnValue)) {

                        // If the sValue matches with the description, the element in the seventh column of the row will be clicked
                        driver.findElement(By.xpath(".//tr[" + i + "]/td[" + j + "]/a/i")).click();
                        driver.switchTo().alert().accept();
                        break;

                    }


                }

            }
        }
        //Wait for element not be stale
        //rows = driver.findElements(By.xpath(".//tr"));
        //Assert wishlist gone
    }

    public void createNewWishlist(String title){
        enterNewWishlistTextfield.sendKeys(title);
        saveNewWishlistButton.click();


    }
}

