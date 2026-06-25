package JavaMultithreading.Interrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i= 0;
                while (true){
                    i++;
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Таймер остановлен!");
                        break;
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(3500);
        t1.interrupt();
        t1.join();
        System.out.println("Главный поток завершен");

    }
}
