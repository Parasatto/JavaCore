package Repeating.Lesson42;

import java.util.Objects;

public class Book {

    public static void main(String[] args) {
        Book b1 = new Book("name", 1);
        Book b2 = new Book("name", 1);

        String s1 = "pp";
        String s2 = new String("pp");

        System.out.println(b1==b2);
        System.out.println(s1==s2);
        System.out.println(b1.equals(b2));
    }


    String title;
    int id;


    public Book(String title, int id) {
        this.title = title;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return id == book.id && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id);
    }
}
