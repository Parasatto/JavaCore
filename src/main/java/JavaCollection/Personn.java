package JavaCollection;

import org.jetbrains.annotations.NotNull;

public class Personn implements Comparable<Personn> {
    private int age;
    private String name;


    @Override
    public int compareTo(@NotNull Personn o) {
        return Integer.compare(this.age, o.getAge());
    }

    public Personn(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Personn{" +
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
