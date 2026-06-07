package JavaSyntaAndOOP.P1Basic;

import java.util.Scanner;

public class Exc5and1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

          String result = age < 13 ? "child" :
                          13 <= age && age <= 17 ? "teen" :
                          age <= 64 && age <= 65 ? "adult":"senior";

        System.out.println(result);
    }
}
/*
Дан возраст человека. Программа выводит:

"child" если < 13
"teen" если 13–17
"adult" если 18–64
"senior" если ≥ 65
 */