package Repeating.Lesson31;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        Vehicle myVehicle = myCar;
        //myVehicle.refueil

        Car myCar1 = (Car) myVehicle;
        myCar1.refuel();


        Bike myBike = new Bike();

        Vehicle[] garage = {myBike, myCar};

        for(Vehicle v: garage){
            if(v instanceof Car){
                Car myCary = (Car)v;
                myCary.refuel();
            } else if (v instanceof Bike) {
                Bike MyBB = (Bike) v;
                MyBB.ringBell();
            }

        }

    }
}
