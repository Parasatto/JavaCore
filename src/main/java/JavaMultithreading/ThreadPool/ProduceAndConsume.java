package JavaMultithreading.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProduceAndConsume {
    // 1. Используем строковый тип
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static void produce() {
        int num = 0;
        while (true) {
            try {
                num++;
                String order = "Заказ №" + num;
                queue.put(order);
                System.out.println("Производитель добавил: " + order);
                // Производитель генерирует заказы каждые 200 мс
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
                break;
            }
        }
    }

    private static void consume() {
        while (true) {
            try {
                // 2. Потребитель работает медленно - 1000 мс (1 секунда)
                Thread.sleep(1000);
                String takenOrder = queue.take();
                System.out.println("--- " + takenOrder + " обработан. Осталось в очереди: " + queue.size());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Используем лямбды для более лаконичного кода (заменяет new Runnable() {...})
        executor.submit(() -> produce());
        executor.submit(() -> consume());

        // Запускаем плавное завершение пула потоков (хотя в бесконечном цикле без interrupt он не остановится)
        executor.shutdown();
    }
}