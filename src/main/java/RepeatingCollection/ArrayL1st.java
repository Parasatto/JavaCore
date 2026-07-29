package RepeatingCollection;

import java.util.ArrayList;

public class ArrayL1st {
    public static void main(String[] args) {
        ArrayList fastLog = new ArrayList<>(10_000);
        ArrayList slowLog = new ArrayList<>();


        long start1 = System.currentTimeMillis();
        for (int i = 0; i < fastLog.size(); i++) {
            fastLog.add("Pasik");
        }
        long end1 = System.currentTimeMillis();
        long res1 = (end1 - start1) / 1_000_000;



        long start2 = System.currentTimeMillis();
        for (int i = 0; i < fastLog.size(); i++) {
            slowLog.add("Pasik");
        }
        long end2 = System.currentTimeMillis();
        long res2 = (end2 - start2)/ 1_000_000;

        System.out.println(res1);
        System.out.println(res2);

        //*Операция
        //Сложность
        //Почему?
        //get(index)
        //O(1)
        //Мгновенный доступ к ячейке массива по адресу.
        //add(value)
        //O(1)
        //Просто запись в следующую свободную ячейку (в среднем).
        //add(index, value)
        //O(n)
        //Нужно сдвинуть вправо все элементы после вставленного.
        //remove(index)
        //O(n)
        //Нужно сдвинуть влево все элементы, чтобы закрыть «дыру».





    }
}
