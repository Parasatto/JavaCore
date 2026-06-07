package JavaSyntaAndOOP.Serialaizble;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fos = new FileInputStream("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/JavaSyntaAndOOP.Serialaizble/all_heroes.bin");
        ObjectInputStream oos = new ObjectInputStream(fos);



        GameCharacter[] loadedCharacters = (GameCharacter[]) oos.readObject();

        System.out.println(Arrays.toString(loadedCharacters));

        oos.close();
    }
}
