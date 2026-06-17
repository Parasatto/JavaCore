package JavaMultithreading.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitAndNotify {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    WaitAndNotify.receiver();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ex.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    WaitAndNotify.sender();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        ex.shutdown();
    }

    private static final Object lock = new Object();

    public static void receiver() throws InterruptedException {
        synchronized (lock){
            System.out.println("Ждем сигнал");
            lock.wait();
            System.out.println("Получили сигнал");
        }
    }

    public static void sender() throws InterruptedException {
        synchronized (lock){
            Thread.sleep(100);
            System.out.println("Отправялем сигнал");
            lock.notify();
        }
    }


}
