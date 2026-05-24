package Interfaces.FileReading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        File file = new File("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Interfaces/FileReading/file.txt");

        try {
            Scanner scanner = new Scanner(file);
            System.out.println("File found");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
