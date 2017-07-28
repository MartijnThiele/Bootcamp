package examples;

/**
 * Created by Gebruiker on 21-7-2017.
 */
public class AutoAdvanced {

    public String brand;
   // public int PK;
   // public int RPMS;

    public AutoAdvanced(String brand, int PK, int RPMS){
        this.brand = brand;
     //   this.PK = PK;
     //   this.RPMS = RPMS;

        System.out.println("car is ready to drive");
        System.out.println("Brand of the car is " + brand);
        calculateTorque(PK,RPMS);
    }

    public void printBrand(){
        System.out.println(brand);
    }
    public void calculateTorque(int PK, int RPMS){
        int Torque = PK*5252/RPMS;
        System.out.println("The torque of your car is " + Torque + "nM");
    }
}
