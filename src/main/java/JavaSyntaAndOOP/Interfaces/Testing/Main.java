package JavaSyntaAndOOP.Interfaces.Testing;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String int1 = scanner.nextLine();
        String double1 = scanner.nextLine();


        Integer n1 = Integer.parseInt(int1);
        Double n2 = Double.parseDouble(double1);

        double d2 = n1.doubleValue();
        double d3 = n2.doubleValue();
        double sum = d2 + d3;

        System.out.println(sum);
    }

}


