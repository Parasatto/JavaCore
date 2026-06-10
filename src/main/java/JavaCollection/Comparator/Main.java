package JavaCollection.Comparator;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("rrrree");
        names.add("qq");
        names.add("wwww");

        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(0);
        nums.add(6);
        nums.add(4);

        Collections.sort(names);
        Collections.sort(nums);
        System.out.println(names);
        System.out.println(nums);

        People p1 = new People(20, "Parasttoooo");
        People p2 = new People(22, "Azamat");
        People p3 = new People(21, "Saltanat");

        List<People> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        System.out.println(people);

        Collections.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.getAge() > o2.getAge())
                    return -1;
                else if (o1.getAge() < o2.getAge()) {
                    return 1;
                }else return 0;
            }
        });

        System.out.println(people);


        Collections.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.getName().length() > o2.getName().length())
                    return -1;
                else if (o1.getName().length() < o2.getName().length()) {
                    return 1;
                } else return 0;
            }
        });


        System.out.println(people);



        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return -1;
                else if (o1.length() < o2.length()) {
                    return 1;
                }
                else
                    return 0;
            }
        });

        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2) {
                    return 1;
                }
                else return 0;
            }
        });



        System.out.println(names);
        System.out.println(nums);
}}


class People{
    private int age;
    private String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return "People{" +
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
