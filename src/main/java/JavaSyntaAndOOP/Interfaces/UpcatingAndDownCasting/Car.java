package JavaSyntaAndOOP.Interfaces.UpcatingAndDownCasting;

public class Car extends Vehicle{



    @Override
    public void move() {
        System.out.println("Car is moving");
    }


    public void refuel(){
        System.out.println("it`s refueling");
    }
}
