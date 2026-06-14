package JavaMultithreading.MiniProject2BankAccountSynchronized;

public class Main {
    public static void main(String[] args) {
        BackAccount b1 = new BackAccount();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                b1.withdrow(10);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b1.deposit(10);
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ended all thread works");
        System.out.println(b1.getBalance());
    }
}
