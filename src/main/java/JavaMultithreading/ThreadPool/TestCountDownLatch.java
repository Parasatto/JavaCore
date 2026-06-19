package JavaMultithreading.ThreadPool;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch ct = new CountDownLatch(3);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();
                System.out.println("Инициализация База данных");
                try {
                    Thread.sleep(ran.nextInt(2000-500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ct.countDown();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();
                System.out.println("Инициализация Конфигурация");
                try {
                    Thread.sleep(ran.nextInt(2000-500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ct.countDown();
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();
                System.out.println("Инициализация Кэш");
                try {
                    Thread.sleep(ran.nextInt(2000-500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ct.countDown();
            }
        });


        t1.start();
        t2.start();
        t3.start();

        ct.await();

        System.out.println("Good to go");







    }
}
