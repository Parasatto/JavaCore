package P1Basic;

public class ClassAndObject {
    public static void main(String[] args) {
        Person p1 = new Person();

        p1.setName("Parasat");
        p1.setAge(24);


        p1.speak();
        p1.sayHello();

        int years = p1.calculateYearsToRetirement();
        System.out.println("До пенси осталсоь: "+ years);

        p1.setName("");
        p1.setAge(-1);



        p1.speak();
    }
}

class Person{
    private String name;
    private int age;

    public void setName(String name) {
        if (name.isEmpty()){
            System.out.println("can not be empty");
            return;
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0){
            System.out.println("age can not be lower than zero");
            return;}
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    int calculateYearsToRetirement(){
        int years = 63- age;
        return years;
    }

    void speak(){
        System.out.println("Меня зовут " + name +" и мне "+ age);
    }

    void sayHello(){
        System.out.println("Hi");
    }
}
