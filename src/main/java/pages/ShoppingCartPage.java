package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Gebruiker on 14-9-2017.
 */
public class ShoppingCartPage {

    private WebDriver driver;

    @FindBy(xpath = ".//tbody//tr//td//i")
    WebElement deleteButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;

        //This call sets the WebElements
        PageFactory.initElements(driver, this);
    }

    //This method deletes the first item from the basket
    public void deleteFirstItem() {
        deleteButton.click();
    }

    //This method deletes one specific product from the basket
    public void deleteSpecifiedItem(String productToDelete) {

        //These lists gets the number of rows en columns from the table
        List<WebElement> rows = driver.findElements(By.xpath(".//tbody//tr"));
        System.out.println("there are " + rows.size() + " rows");
        List<WebElement> columns = driver.findElements(By.xpath(".//thead//th"));
        System.out.println("there are " + columns.size() + " columns");
        int x = 0;

        //This loop finds the number of the first row which' title matches productToDelete and assigns it to x
        for (int i = 1; i <= rows.size(); i++) {
            String rowValue = driver.findElement(By.xpath(".//tbody//tr[" + i + "]/td[2]/p/a")).getText();
            System.out.println("row found with description: " + rowValue);
            if (rowValue.equalsIgnoreCase(productToDelete)) {
                System.out.println(productToDelete + " was found on row nr " + i);
                x = i;
                break;
            }
        }
        //If the required row was found, this loop finds the number of the delete column and deletes the row
        if (x > 0) {
            for (int j = 1; j <= columns.size(); j++) {
                String columnValue = driver.findElement(By.xpath(".//tbody/tr[1]/td[" + j + "]")).getAttribute("class");
                if (columnValue.equalsIgnoreCase("cart_delete text-center")) {

                    // If the required list is found, and it's row has a delete button, it will be clicked
                    driver.findElement(By.xpath(".//tbody/tr[" + x + "]/td[" + j + "]//i")).click();
                    System.out.println(productToDelete + "has been deleted from the shopping cart ");
                    break;

                }
            }


        } else System.out.println(productToDelete + " was not found, nothing has been deleted");
    }

    public void deleteEntireCart() {
        List<WebElement> rows = driver.findElements(By.xpath(".//tbody//tr"));

        for (int i = 1; i <= rows.size(); i++) {
            System.out.println("rows: " + rows.size());
            System.out.println("value of i: " + i);
            deleteButton.click();
            System.out.println("past delete action");

        }
        System.out.println("exited loop");
    }
}





