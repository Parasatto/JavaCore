package JavaMultithreading.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Parking {
    public static void main(String[] args) {
        Semaphore parikngPlace = new Semaphore(3);
        ExecutorService ex = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            ex.submit(new Runnable() {

                int id = finalI;

                @Override
                public void run() {
                    try {
                        System.out.println("Машина "+ id +" подъехала к парковке");
                        parikngPlace.acquire();

                        System.out.println("Машина "+id+" припарковалась");
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        System.out.println("Машина "+id+" уехала");
                        parikngPlace.release();
                    }
                }
            });
        }

        ex.shutdown();
    }


}
