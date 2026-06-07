package JavaSyntaAndOOP.Equels;

public class Main {
    public static void main(String[] args) {


        Book b1 = new Book("Book", 1);
        Book b2 = new Book("Book", 1);


        System.out.println(b1.equals(b2));
    }
}
