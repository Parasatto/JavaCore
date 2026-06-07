package JavaCollection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> fastLog = new ArrayList<>(10_000);
        ArrayList<String> slowLog = new ArrayList<>();


        for (int i = 0; i < 10_000; i++) {
            fastLog.add("Ivent");
        }   //оптимизированый вариат так как заране задали количестов элементов

        for (int i = 0; i < 10_000; i++) {
            slowLog.add("Ivent");
        }// медленне так как тут по дефолту 10 елементов и каждый раз прихоидит на 1.5 раз больше элементов добавлять и переносить туда старыне элеметны

        slowLog.add(0,"Ivent");
        // сдвиг на права так как мы добавляем эелемет самое начало и все 10к элементов надо будет сдвигать на права




    }
}
