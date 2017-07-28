package examples;

/**
 * Created by Gebruiker on 27-7-2017.
 */
public class enumExample {

    public enum BootCampDays{
        DAYONE,
        DAYTWO,
        DAYTHREE,
        DAYFOUR,
        DAYFIVE;
    }

    public static String checkBootcampDays(BootCampDays bootCampDays){
        switch(bootCampDays){
            case DAYONE:
                return "Zin in!";

            case DAYTWO:
                return "Spijt van!";

            case DAYTHREE:
                return "Dynamic hell!";

            case DAYFOUR:
                return "Getting better!";

            case DAYFIVE:
                return "Finally!";

            default:
                return "Welke dag bedoel je?";
        }

    }
}
