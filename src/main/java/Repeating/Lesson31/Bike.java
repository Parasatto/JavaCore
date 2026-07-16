package Repeating.Lesson31;

public class Bike extends Vehicle{

    @Override
    public void move() {
        System.out.println("Bike is moving");
    }

    public void ringBell(){
        System.out.println("Ding, Ding");
    }
}
