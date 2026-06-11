package JavaCollection.Queue;

import JavaCollection.Personn;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskQueue {

    public static void main(String[] args) {

        Queue<Personn> listPerson = new LinkedList<>();

        listPerson.offer(new Personn(40, "Hero"));
        listPerson.offer(new Personn(20, "Hero"));
        listPerson.offer(new Personn(30, "Hero"));
        listPerson.offer(new Personn(17, "Hero"));

        while (!listPerson.isEmpty()){
            System.out.println(listPerson.poll());
        }

        System.out.println("Prioritet queue");
        PriorityQueue<Personn> listPriorPerson = new PriorityQueue<>();
        listPriorPerson.offer(new Personn(40, "Hero"));
        listPriorPerson.offer(new Personn(20, "Hero"));
        listPriorPerson.offer(new Personn(30, "Hero"));
        listPriorPerson.offer(new Personn(17, "Hero"));


        while (!listPriorPerson.isEmpty()){
            System.out.println(listPriorPerson.poll());
        }
    }
}
