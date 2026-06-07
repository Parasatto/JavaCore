package JavaSyntaAndOOP.P1Basic;

import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        Scanner MyScan = new Scanner(System.in);

        System.out.println("Enter ur age");
        int age = MyScan.nextInt();
        System.out.println("ur age is " + age);
    }
}
