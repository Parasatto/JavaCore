package JavaMultithreading;

public class Test {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        Thread th1 = new Thread(m1);
        Thread th2 = new Thread(m2);
        th2.start();
        th1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("From 'main' "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread implements Runnable{

    private static int counter = 0; // Статический счетчик для всего класса
    private int num;                // Индивидуальный номер объекта

    public MyThread() {
        counter++;                  // Увеличиваем общий счетчик
        this.num = counter;         // Присваиваем текущее значение объекту
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("From 'RunableNum" +  + this.num+ " "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        MyThread.counter = counter;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
