package examples;

import org.testng.annotations.Test;

/**
 * Created by Gebruiker on 27-7-2017.
 */
public class CallEnumExample {

    @Test

    public void printBootcampDays(){
        System.out.println(enumExample.checkBootcampDays(enumExample.BootCampDays.DAYONE));
        System.out.println(enumExample.checkBootcampDays(enumExample.BootCampDays.DAYTWO));
        System.out.println(enumExample.checkBootcampDays(enumExample.BootCampDays.DAYTHREE));
        System.out.println(enumExample.checkBootcampDays(enumExample.BootCampDays.DAYFOUR));
        System.out.println(enumExample.checkBootcampDays(enumExample.BootCampDays.DAYFIVE));

    }

}
