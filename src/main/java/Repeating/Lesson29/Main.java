package Repeating.Lesson29;

public class Main {
    public static void main(String[] args) {
        Animal[] ans = {new Animal(), new Cat(), new Dog()};

        for (Animal a: ans){
            a.eat();
        }
    }
}
