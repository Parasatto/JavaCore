package JavaSyntaAndOOP.Exception;

public class Test5 {

    public static void main(String[] args) {
        try {
            Test5.run();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) { // Теперь компилируется!
            System.out.println("It`s ok: " + e.getClass().getSimpleName());
        }
    }

    public static void run() {
        int num = 1; // Меняем на 2, чтобы сработал else и выбросил NullPointerException

        if (num == 0) {
            System.out.println("ok");
        } else if (num == 1) {
            throw new ArrayIndexOutOfBoundsException(); // Если выпадет оно, программа упадет (мы его не ловим)
        } else {
            throw new NullPointerException(); // Будет перехвачено в main
        }
    }
}