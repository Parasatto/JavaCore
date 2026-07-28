package Repeating.Lesson44;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Repeating/Lesson44/diary.txt");

        PrintWriter pw = new PrintWriter(file);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            if ("STOP".equals(s1)){
                break;
            } else {
                pw.print(s1);
            }

        }
        scanner.close();
        pw.close();
    }
}
