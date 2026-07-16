package Repeating.Lesson31;

public class Car extends Vehicle{
    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    public void refuel(){
        System.out.println("Car is refueling");
    }
}
