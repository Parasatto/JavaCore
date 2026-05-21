package P1Basic;

public class Inheritance {
    public static void main(String[] args) {

    }
}

class Animal{
    private String name;

    public void eat(){
        System.out.println("it`s eating");
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("this Dog is eating");
    }
}
