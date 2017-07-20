package examples;

import org.testng.annotations.Test;
import java.util.Scanner;

/**
 * Created by Gebruiker on 19-7-2017.
 */
public class AboutMethods {

    int a = 150;
    int b = 6;
    @Test
    public void printProduct() {
        multiply(a,b);
        System.out.println(multiply(a,b));
    }

    private int multiply(int a, int b) {
        return a * b;

        }
}
