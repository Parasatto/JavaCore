package JavaCollection.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> stats = new HashMap<>();

        stats.put("Straight", 15);
        stats.put("Agility", 20);
        stats.put("Intelligence", 30);

        System.out.println(stats.get("Agility"));

        System.out.println(stats.get("Straight"));
        stats.put("Straight", 40);
        System.out.println(stats.get("Straight"));


        for(Map.Entry<String, Integer> entry: stats.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }





    }


}
