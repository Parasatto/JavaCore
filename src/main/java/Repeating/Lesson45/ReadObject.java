package Repeating.Lesson45;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Repeating/Lesson45/person.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person p1 = (Person) ois.readObject();
        System.out.println(p1);
        ois.close();
    }
}
