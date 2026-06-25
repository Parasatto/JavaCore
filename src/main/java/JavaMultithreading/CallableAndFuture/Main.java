package JavaMultithreading.CallableAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(1);

        Future<Integer> f1 =  ex.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                return random.nextInt(100);
            }
        });

        Future<Integer> f2 = ex.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                return random.nextInt(100);
            }
        });

        ex.shutdown();

        System.out.println("f1 and f2 are :" +f1.get()+" "+ f2.get());
        int res = (int)f1.get() + (int)f2.get();
        System.out.println("and the rusult is: " +res);
    }
}
