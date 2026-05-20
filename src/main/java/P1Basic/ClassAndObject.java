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

        System.out.println(Car.speed + " this is the car classes variable");
        int res = Car.get2xspeed(200);
        System.out.println(res + " this is the result of the static method class");
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

class Car {

    private String name;
    private int year;
    private String country;

    public static int speed = 200;

    public Car(String name, int year, String country) {
        this.name = name;
        this.year = year;
        this.country = country;
    }

    public static int get2xspeed(int hpower){
        return hpower * speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
