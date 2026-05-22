package Interfaces.Homework2;

public class Animal {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();


        Animal[] animals = {a1, a2};

        for(Animal theAnimal: animals){
            theAnimal.eat();
        }
    }

    public void eat(){
        System.out.println("it`s eating");
    };
}
