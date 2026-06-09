package JavaCollection.Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Collision {
    public static void main(String[] args) {
        HashMap<Person, String> hashMap = new HashMap<>();
        Set<Person> set = new HashSet<>();


        Person p1 = new Person(18, "Parasat");
        Person p2 = new Person(18, "Parasat");


        hashMap.put(p1, "p1");
        hashMap.put(p2, "p1");
        System.out.println(hashMap);

        set.add(p1);
        set.add(p2);
        System.out.println(set);


    }
}



class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
