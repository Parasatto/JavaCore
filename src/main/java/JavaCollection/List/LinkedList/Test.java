package JavaCollection.List.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        LinkedList<Integer> linked = new LinkedList<>();

        System.out.print("adding time for array: ");
        addTiming(array);
        System.out.print("adding time for link: ");
        addTiming(linked);

        System.out.print("getting time for array: ");
        getTiming(array);
        System.out.print("getting time for link: ");
        getTiming(linked);

    }


    public static void addTiming(List<Integer> list){
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            list.add(0, i);
        }

        long result = System.currentTimeMillis() - start;
        System.out.println(result);
    }


    public static void getTiming(List<Integer> list){
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            list.get(i);
        }

        long result = System.currentTimeMillis() - start;
        System.out.println(result);
    }
}
