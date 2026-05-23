package Interfaces.UpcatingAndDownCasting;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();
        Vehicle v3 = new Vehicle();
        Vehicle v4 = new Vehicle();

        v1.move();
        //v1.refuel не сработает

        v2.move();
        //v2.ringBell тоже не сработает

        Car myCar = (Car) v1;
        Bike myBike = (Bike) v2;

        myCar.refuel();
        myBike.ringBell();//теперь все сработает

        System.out.println("Instanceof");
        Vehicle[] garage = {v1, v3,v2, v4};

        for (Vehicle v: garage){
            if (v instanceof Car c){
                c.refuel();
            } else if (v instanceof Bike b) {
                b.ringBell();
            }
            else v.move();
        }
    }
}
