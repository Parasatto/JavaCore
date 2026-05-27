package Exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAgeException {

        Scanner scanner = new Scanner(System.in);

        int num;

        while (true){
            num = scanner.nextInt();
            if (num < 0){
                throw new IllegalAgeException("Возраст не может быть отрицательным");
            } else if (num > 150) {
                throw new IllegalAgeException("Введен слишком большой возраст");
            }
            break;
        }





    }
}
