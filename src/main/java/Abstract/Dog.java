package Abstract;

public class Dog extends Animal implements MoveAble{

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void makeSound() {
        System.out.println("barking");
    }

    @Override
    public void move() {
        System.out.println("Dob moving");
    }
}
