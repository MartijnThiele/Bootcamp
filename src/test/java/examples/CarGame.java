package examples;

import org.testng.annotations.Test;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class CarGame {

    @Test
    public void startGame(){
       // Auto auto = new Auto();
       // auto.setColor(" red");

       // Auto auto2 = new Auto();
        //auto2.setColor(" yellow");

        //Auto auto3 = new Auto();
        //auto3.setColor(" Blue");
        //auto3.setBrand(" Toyota");
        //auto3.setNumberOfDoors(4);
        //auto3.setMotorType(100, 6000);

    }

    @Test
    public void startGameTwo(){

        AutoAdvanced autoAdvanced = new AutoAdvanced("Toyota", 100, 6000);
    }
}
