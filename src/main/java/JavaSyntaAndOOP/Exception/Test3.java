package JavaSyntaAndOOP.Exception;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String[] strings = {"one","two","three"};

        Scanner scanner = new Scanner(System.in);

        int index = scanner.nextInt();

        if (index > strings.length || index < 0){
            System.out.println("индекс некорректен");
        } else {
            System.out.println(strings[index]);
        }

        String s1 = null;

        if (s1 == null){
            System.out.println("Can not use length");
        } else
            System.out.println(s1.length());
    }
}
