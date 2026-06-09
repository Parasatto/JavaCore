package JavaCollection.Set;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test1 {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Person p1 = new Person(18,"Hero");
        map.put(p1, "Warrior");

        System.out.println(map.get(new Person(18, "Hero")));

        //Ответ на вопрос потому что все хашмапы работает чез хаш код, так как у класса не переопределен хеш код
        // выдает другой хаш и по этому не можем найти обьект по ключу
    }
}

