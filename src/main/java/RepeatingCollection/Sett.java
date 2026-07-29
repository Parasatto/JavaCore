package RepeatingCollection;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java.util.TreeSet;

public class Sett {
    public static void main(String[] args) {
        Set<Charactar> heros = new HashSet<>();

        heros.add(new Charactar("Aragorn", 100));
        heros.add(new Charactar("Legolas", 100));
        heros.add(new Charactar("Gimli", 100));
        heros.add(new Charactar("Aragorn", 70));

        System.out.println(heros.contains(new Charactar("Gimli", 100)));

        heros.remove(new Charactar("Aragorn", 70));

        for (Charactar c : heros){
            System.out.println(c);
        }

        TreeSet<Charactar> sorted = new TreeSet<>((c1, c2) -> c1.getName().compareTo(c2.getName()));

        sorted.addAll(heros);

        for (Charactar c : sorted){
            System.out.println(c);
        }



    }
}

class Charactar {
    private String name;
    private int hp;

    public Charactar(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Charactar{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Charactar charactar)) return false;
        return hp == charactar.hp && Objects.equals(name, charactar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hp);
    }



}
