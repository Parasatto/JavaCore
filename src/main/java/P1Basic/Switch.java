package P1Basic;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        System.out.println("Enter ur age down below:");

        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        switch (age) {
            case 18:
                System.out.println("Можно курить");
            case 21:
                System.out.println("Можно и курить и бухать");
            case 63:
                System.out.println("Можно уже в пенсию");
        }
    }
}
