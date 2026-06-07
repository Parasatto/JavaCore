package JavaSyntaAndOOP.NastedClasses;

public class Main {
    public static void main(String[] args) {


        Computer c1 = new Computer("model one");

        c1.performSelfTest();
        Computer.Ram r1 = new Computer.Ram();

        r1.getSpace();
    }
}
