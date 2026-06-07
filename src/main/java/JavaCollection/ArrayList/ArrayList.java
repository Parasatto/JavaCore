package JavaCollection.ArrayList;

import JavaSyntaAndOOP.Serialaizble.GameCharacter;

import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        GameCharacter g1 = new GameCharacter("Parasat", 12, 100);
        GameCharacter g2 = new GameCharacter("Azamat", 13, 90);
        GameCharacter g3 = new GameCharacter("Saltanat", 15, 80);
        GameCharacter g4 = new GameCharacter("Baha", 20, 70);


        List<GameCharacter> players = new java.util.ArrayList<>();
        players.add(g1);
        players.add(g2);
        players.add(g3);
        players.add(g4);

        System.out.println(players.size());
        players.remove(3);

        for(GameCharacter p : players){
            System.out.println(p.toString());
        }





    }
}
