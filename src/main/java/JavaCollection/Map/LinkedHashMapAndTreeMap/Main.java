package JavaCollection.Map.LinkedHashMapAndTreeMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Map<Integer, String> players = new LinkedHashMap<>();

        players.put(15,"player1");
        players.put(5, "player2");
        players.put(1, "player3");

        System.out.println("LinkedHashMap: " + players);

        TreeMap<Integer, String> playersOfTree = new TreeMap<>(players);
        System.out.println("Tree Map: " + playersOfTree);
    }
}
