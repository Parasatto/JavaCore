package JavaCollection.Comparator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Man> manlist = new ArrayList<>();

        manlist.add(new Man(20, "man1"));
        manlist.add(new Man(26, "man1"));
        manlist.add(new Man(16, "man1"));
        manlist.add(new Man(30, "man1"));

        Collections.sort(manlist);
        System.out.println(manlist);
    }
}

class Man implements Comparable<Man>{
    private int age;
    private String name;

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Man other) {
        return Integer.compare(this.age, other.getAge());
    }


    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
