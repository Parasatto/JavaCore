package JavaSyntaAndOOP.Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) throws FileNotFoundException {
        File s1 = new File("asdasd");



        try {
            Scanner scanner = new Scanner(s1);
            System.out.println("Файл успешно открыт");
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
