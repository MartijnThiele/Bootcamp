package examples;

import org.testng.annotations.Test;

/**
 * Created by Gebruiker on 20-7-2017.
 */
public class conditionExercises {


    int minimumAge = 21;
    int pensioenGerechtigd = 65;

    public void bootcampAgeChecker(int age) {

        if (age >= minimumAge && age <= pensioenGerechtigd) {
            System.out.println("Deelnemer toegelaten");
        }
        else if (age < minimumAge) {
            System.out.println("Te jong");
        }
        else if (age > pensioenGerechtigd) {
            System.out.println("Deelnemer niet toegelaten, check bij de manager.");
        }
    }

    @Test
    public void testMember(){
        bootcampAgeChecker(12);
        bootcampAgeChecker(21);
        bootcampAgeChecker(64);
        bootcampAgeChecker(65);
        bootcampAgeChecker(66);
    }

}
