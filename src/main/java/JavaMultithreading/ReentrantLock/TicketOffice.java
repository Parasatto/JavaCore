package JavaMultithreading.ReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketOffice {
    private static int tickets = 10;
    private final Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(15);
        TicketOffice t1 = new TicketOffice();

        for (int i = 0; i < 15; i++) {
            String s = String.valueOf(i);
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        t1.buyTickets(s);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        ex.shutdown();

    }

    public void buyTickets(String custemerName) throws InterruptedException {
        lock.lock();
        try {
            if (TicketOffice.tickets > 0){
                System.out.println(custemerName + " купил билет. Осталось: "+ --tickets);
                Thread.sleep(100);
            }
        }finally {
            lock.unlock();
        }
    }


}
