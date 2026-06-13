package JavaMultithreading;

public class VolatileTest {

    public static class Worker implements Runnable{
        private volatile boolean active = true;

        public void shutdown(){
            this.active = false;
        }

        @Override
        public void run() {
            while (active){
                System.out.println("Сканирование");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Поток Worker успешно остановлен.");
        }


    }
}
