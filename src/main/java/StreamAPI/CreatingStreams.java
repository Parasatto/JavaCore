package StreamAPI;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class CreatingStreams {
    public static void main(String[] args) {
        //From collection
        List<String> list = List.of("a", "b", "s");
        Stream<String> s1 = list.stream();

        //From array
        String[] arr = {"a", "b", "c"};
        Stream<String> s2 = Arrays.stream(arr);

        //From each element
        Stream<String> s3 = Stream.of("a", "b", "c");

        //Empty stream
        Stream<String> s4= Stream.empty();

        //Task
        List<Integer> nums = List.of(5, 12, 5, 8, 20, 12, 1, 30);

        nums.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .skip(1)
                .forEach(System.out::println);


        //nums.stream().forEach(System.out::println);


        List<String> names = List.of("Ivan", "Petr", "Anna");

        names.stream().peek(name -> System.out.println("Делаем это имя:"+ name))
                        .map(String::toUpperCase)
                        .forEach(System.out::println);

        Order order1 = new Order(List.of("Rice", "Apple", "Pineapple"));
        Order order2 = new Order(List.of("Bread", "Milk", "Apple"));
        List<Order> orders = List.of(order1,order2);


        List<String> allProducts = orders
                .stream()
                .flatMap(o -> o.getProducts().stream())
                .toList();

        System.out.println(allProducts);

        List<Person> people = List.of(
                new Person("Parasat", 24, 70),
                new Person("Bauka", 24, 75),
                new Person("Azamat", 22, 80)
        );

        List<Person> sort = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getWeight))
                .toList();


        System.out.println(sort);


        List<Double> prices = List.of(0.00, 1000.00, 2000.00, 500.00);

        boolean hasIt = prices
                .stream()
                .allMatch(n -> n >= 0);

        Optional<Double> anyHighNum = prices
                .stream()
                .filter( n -> n > 1000.00)
                .findAny();

        System.out.println(anyHighNum);






    }
}
