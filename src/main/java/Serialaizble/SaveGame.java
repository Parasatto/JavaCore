package Serialaizble;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGame {

    public static void main(String[] args) throws IOException {

        GameCharacter player1 = new GameCharacter("Archer", 15, 80);
        GameCharacter player2 = new GameCharacter("AshenOne", 18,65);

        FileOutputStream fos = new FileOutputStream("/Users/parasattynysbekov/Desktop/JavaSyntax/src/main/java/Serialaizble/savegame.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(player1);
        oos.writeObject(player2);

        oos.close();
    }
}
