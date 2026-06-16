package JavaMultithreading.ThreadPool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    public static void main(String[] args) {

        ExecutorService executer = Executors.newFixedThreadPool(4);

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executer.submit(new Runnable() {
            @Override
            public void run(){
                System.out.println("2 " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });




        executer.shutdown();

    }
}
