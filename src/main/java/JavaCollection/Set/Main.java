package JavaCollection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> names1 = new HashSet<>();
        Set<String> names2 = new LinkedHashSet<>();
        Set<String> names3 = new TreeSet<>();


        names1.add("Zorro");
        names1.add("Alice");
        names1.add("Bob");
        names1.add("Zorro");
        System.out.println("Количесвто hashset: "+ names1.size());
        System.out.println(names1);


        names2.add("Zorro");
        names2.add("Alice");
        names2.add("Bob");
        names2.add("Zorro");
        System.out.println("Количесвто LinkedHashSet: "+ names2.size());
        System.out.println(names2);

        names3.add("Zorro");
        names3.add("Alice");
        names3.add("Bob");
        names3.add("Zorro");
        System.out.println("Количесвто TreeSet: "+ names3.size());
        System.out.println(names3);

        //ответ на вопрос, потому что у обьектов может быть одинакывые хэш коды из-за чего созбается колезия когда хэш
        //коды одинакывые но содержимвые разное по этому их нужно переопределять по их полей обектов

    }
}
