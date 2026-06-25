package JavaMultithreading.Deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private final Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account(1000);
        Account a2 = new Account(2000);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.submit(new Runnable() {
            @Override
            public void run() {
                Account.transfer(a1, a2, 500);
            }
        });

        ex.submit(new Runnable() {
            @Override
            public void run() {
                Account.transfer(a2, a1, 300);
            }
        });

        ex.shutdown();

        // Фиксация: ждем завершения потоков перед выводом результата
        if (ex.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println(a1.getBalance() + " : " + a2.getBalance()); // Выведет 800 : 2200
        }
    }

    public static void transfer(Account acc1, Account acc2, int sum){
        int hash1 = System.identityHashCode(acc1);
        int hash2 = System.identityHashCode(acc2);

        Lock firstLock;
        Lock secondLock;

        if (hash1 < hash2){
            firstLock = acc1.getLock();
            secondLock = acc2.getLock();
        } else if (hash1 > hash2) {
            firstLock = acc2.getLock();
            secondLock = acc1.getLock();
        } else {
            // Теперь здесь всё инициализируется корректно, NullPointerException исключен
            firstLock = acc1.getLock();
            secondLock = acc2.getLock();

            synchronized (Account.class){
                firstLock.lock();
                secondLock.lock();
            }
            try {
                executeTransfer(acc1, acc2, sum);
            } finally {
                secondLock.unlock();
                firstLock.unlock();
            }
            return;
        }

        firstLock.lock();
        secondLock.lock();

        try {
            executeTransfer(acc1, acc2, sum);
        } finally {
            secondLock.unlock();
            firstLock.unlock();
        }
    }

    public static void executeTransfer(Account acc1, Account acc2, int sum){
        acc1.setBalance(acc1.getBalance() - sum);
        acc2.setBalance(acc2.getBalance() + sum);
    }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
    public Lock getLock() { return lock; }
}
