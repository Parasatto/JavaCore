package JavaMultithreading;

public class Main {
    public static void main(String[] args) {

        VolatileTest.Worker w1 = new VolatileTest.Worker();
        Thread t1 = new Thread(w1);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Вызываем shutdown");
        w1.shutdown();
    }
}
