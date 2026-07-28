package Repeating.Lesson45;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        Person p1 = new Person("Parasat", 24);


        FileOutputStream fos = new FileOutputStream("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Repeating/Lesson45/person.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(p1);
        oos.close();


    }
}
