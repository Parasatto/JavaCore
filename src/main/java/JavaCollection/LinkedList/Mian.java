package JavaCollection.LinkedList;

import JavaSyntaAndOOP.Serialaizble.GameCharacter;

import java.util.LinkedList;
import java.util.List;

public class Mian {
    public static void main(String[] args) {
        GameCharacter g1 = new GameCharacter("Parasat", 12, 100);
        GameCharacter g2 = new GameCharacter("Azamat", 13, 90);
        GameCharacter g3 = new GameCharacter("Saltanat", 15, 80);
        GameCharacter g4 = new GameCharacter("Baha", 20, 70);


        List<GameCharacter> players = new LinkedList<>();

        players.add(g1);
        players.add(g2);
        players.add(g3);
        players.add(g4);

        players = (LinkedList) players;
        ((LinkedList<GameCharacter>) players).removeFirst();


        GameCharacter g5 = new GameCharacter("Hero", 25, 100);
        ((LinkedList<GameCharacter>) players).addFirst(g5);

        //Линкед литс использует больше памяти потому что хранит себе две ссылки на голову и на хвост но блогодопя этому
        // он такой быстроый когда нужно добавлять или же удалять элементы потому что он не делает сдвиг куче элементов а
        // а просто меняет ссылку на след обьект


    }
}
