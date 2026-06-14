package JavaMultithreading.MiniProject2BankAccountSynchronized;

public class Main2 {
    public static void main(String[] args) {
        
        GameStore g1 = new GameStore();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    g1.sellArmor();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    g1.sellWeapon();
                }
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

        System.out.println(g1.getArmorSales());
        System.out.println(g1.getWeaponSales());
    }
}
