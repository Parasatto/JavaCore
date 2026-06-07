package JavaSyntaAndOOP.Interfaces.FileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Interfaces/FileReading/file.txt");

        Scanner scanner = new Scanner(file1);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}
