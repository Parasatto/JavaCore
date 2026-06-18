package JavaMultithreading.ThreadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyBuffer {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    MyBuffer.produce(list);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ex.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    MyBuffer.consumer(list);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ex.shutdown();


    }

    private static int limit = 5;

    private final static Object lock = new Object();
    public static void produce(LinkedList<String> list) throws InterruptedException {
        while (true){
            synchronized (lock) {
                while (list.size() ==limit){
                    lock.wait();
                }
                System.out.println("Inputing text from produce");
                list.add("Text");
                lock.notify();
            }
        }
    }

    private static void consumer(LinkedList<String> list) throws InterruptedException {
        while (true){
            synchronized (lock){
                Thread.sleep(100);
                while (list.size() == 0){
                    lock.wait();
                }
                System.out.println("deleting from consumer "+list.poll());
                lock.notify();
            }
        }
    }
}
