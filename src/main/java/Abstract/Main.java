package Abstract;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("asdasd");
            }
        };
    }
}
