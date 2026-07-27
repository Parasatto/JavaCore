package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Speed {
    public static void main(String[] args) {

        // Генерируем список из 1 000 000 случайных чисел
        Random ran = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            list.add(ran.nextInt(100));
        }

        // Тест 1: Обычный stream()
        long start = System.currentTimeMillis();

        int sumOne = list.stream()
                .reduce(0, (a, b) -> a + b);

        long end = System.currentTimeMillis();
        long resTime = end - start;
        System.out.println("Result time of casual stream is: " + resTime + " ms");
        System.out.println("Sum One: " + sumOne);

        // Тест 2: Параллельный parallelStream()
        long start2 = System.currentTimeMillis();

        int sumTwo = list.parallelStream()
                .reduce(0, (a, b) -> a + b);

        long end2 = System.currentTimeMillis();
        long resTime2 = end2 - start2;
        System.out.println("Result time of parallel stream is: " + resTime2 + " ms");
        System.out.println("Sum Two: " + sumTwo);
    }
}
