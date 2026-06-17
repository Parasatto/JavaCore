package JavaMultithreading.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
    public static void main(String[] args) {
        BlockingQueue<String> list = new ArrayBlockingQueue<>(10);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Test3.produce(list);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Test3.produce2(list);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Test3.consumer(list);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.shutdown();
    }

    private static void produce(BlockingQueue<String> list) throws InterruptedException {
        while (true){
            list.put("User Action: Login, and it was texted by: "+ Thread.currentThread().getName());
            Thread.sleep(150);
        }
    }

    private static void produce2(BlockingQueue<String> list) throws InterruptedException {
        while (true){
            list.put("System Check: OK, and it was texted by: "+ Thread.currentThread().getName());
            Thread.sleep(500);
        }
    }

    private static void consumer(BlockingQueue<String> list) throws InterruptedException {
        while (true){
            String message = list.take();
            System.out.println("[ЗАПИСЬ В БД]: "+message+ ", and it was outed by: "+ Thread.currentThread().getName());
            Thread.sleep(400);
        }
    }
}
