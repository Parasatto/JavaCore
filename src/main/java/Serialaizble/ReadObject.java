package Serialaizble;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fos = new FileInputStream("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Serialaizble/savegame.bin");
        ObjectInputStream oos = new ObjectInputStream(fos);

        GameCharacter players = (GameCharacter) oos.readObject();
        System.out.println(players);

        oos.close();
    }
}
