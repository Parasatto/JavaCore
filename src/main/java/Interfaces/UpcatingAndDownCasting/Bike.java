package Interfaces.UpcatingAndDownCasting;

public class Bike extends Vehicle{

    @Override
    public void move() {
        System.out.println("Bike is moving ");
    }

    public void ringBell(){
        System.out.println("Biike is ring belling");
    }
}
