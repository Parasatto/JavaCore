package RepeatingCollection;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkList {
    public static void main(String[] args) {
        LinkedList people = new LinkedList<>();

        people.add(new Person("Parasat", 24));
        people.add(new Person("Parasat", 24));
        people.add(new Person("Parasat", 24));
        people.add(new Person("Parasat", 24));

        people.removeFirst();
        people.addFirst(new Person("Saltanat", 21));

        ArrayList arr = new ArrayList<>(people);

        // Цикл успешно выполнится 4 раза
        for (int i = 0; i < arr.size(); i++) {
            // Так как дженериков нет, приводим Object к Person вручную
            Person p = (Person) arr.get(i);
            System.out.println("Индекс " + i + ": " + p.getName() + ", " + p.getAge() + " лет");
        }
    } // Закрывающая скобка для main
} // Закрывающая скобка для LinkList

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

//*Операция
//ArrayList
//LinkedList
//Почему?
//get(index)
//O(1)
//O(n)
//В LinkedList нужно перебирать элементы по ссылкам с начала или конца
//.
//add(0) (в начало)
//O(n)
//O(1)
//В LinkedList достаточно просто поменять ссылки у «головы»
//.
//remove(0)
//O(n)
//O(1)
//Не нужно сдвигать весь массив
//
