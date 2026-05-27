package Exception;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int num;

        try {
            num = scanner.nextInt();
            if (num < 0 || num > 150) {
                throw new IllegalAgeException("Некорректный возраст");
            }
        } catch (IllegalAgeException e){
            System.out.println("Перехвачено исключение: "+ e.getMessage());
        }
    }
}
