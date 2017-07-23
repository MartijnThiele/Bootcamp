package examples;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class Auto {

    public void setColor(String carColor){
        System.out.println("The color of the car is"+ carColor);
    }
    public void setBrand(String carBrand) {
        System.out.println("The brand of the car is" + carBrand);
    }
    public void setNumberOfDoors(int doors) {
        System.out.println("This car has " + doors + " doors");
    }
    public void setMotorType(int force, int rpms) {
        System.out.println("This car has a " + force + "PK engine, with " + rpms + "RPMS");
        System.out.println("This car has a Torque of " + ((force*5252)/rpms) + "nm");
    }

}
