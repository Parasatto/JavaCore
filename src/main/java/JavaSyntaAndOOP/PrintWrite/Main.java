package JavaSyntaAndOOP.PrintWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/JavaSyntaAndOOP.PrintWrite/diary.txt");
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(file);

        while (true) {
            String s1 = scanner.nextLine();

            if (s1.equals("STOP")) {
                break;
            }

            // Исправлено: добавление переноса строки после записи
            pw.println(s1);
            pw.flush();
        }

        pw.close();
        scanner.close();
    }
}
