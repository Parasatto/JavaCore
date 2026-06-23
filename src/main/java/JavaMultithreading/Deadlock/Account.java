package JavaMultithreading.Deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private final Lock lock = new ReentrantLock();


    public Account(int balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
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

        System.out.println(a1.getBalance() +" : "+a2.getBalance());



    }

    public static void transfer(Account acc1, Account acc2, int sum){
        acc1.getLock().lock();
        acc2.getLock().lock();

        acc1.setBalance(acc1.getBalance() - sum);
        acc2.setBalance(acc2.getBalance() + sum);

        acc1.getLock().unlock();
        acc2.getLock().unlock();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }
}
