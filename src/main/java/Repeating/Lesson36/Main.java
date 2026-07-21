package Repeating.Lesson36;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Repeating/Lesson36/numbers.txt");

        Scanner scanner = new Scanner(file);

        int sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] numbers = line.split(" ");

            Integer[] date = new Integer[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                date[i] = Integer.parseInt(numbers[i]);
                sum = sum + date[i];
            }
        }

        System.out.println(sum);



    }
}

