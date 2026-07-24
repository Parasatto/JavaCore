package StreamAPI;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
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
        Stream<String> s4 = Stream.empty();

        //Task
        List<Integer> nums = List.of(5, 12, 5, 8, 20, 12, 1, 30);

        nums.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .skip(1)
                .forEach(System.out::println);


        //nums.stream().forEach(System.out::println);


        List<String> names = List.of("Ivan", "Petr", "Anna");

        names.stream().peek(name -> System.out.println("Делаем это имя:" + name))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Order order1 = new Order(List.of("Rice", "Apple", "Pineapple"));
        Order order2 = new Order(List.of("Bread", "Milk", "Apple"));
        List<Order> orders = List.of(order1, order2);


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
                .filter(n -> n > 1000.00)
                .findAny();

        System.out.println(anyHighNum);

        //Task 7
        List<Integer> nums7 = List.of(10, 20, 30, 40);

        long count = nums7.stream().count();

        int sum = nums7.stream().reduce(1, (a, b) -> a * b);

        Optional<Integer> min = nums7.stream().min(Integer::compare);
        Optional<Integer> max = nums7.stream().max(Integer::compare);

        System.out.println(count);
        System.out.println(sum);
        System.out.println(min);
        System.out.println(max);


        List<Employee> workers = List.of(
                new Employee("Parasat", "DIS", 500_000),
                new Employee("Parasat", "DIS", 900_000),

                new Employee("Azamat", "DRPI", 400_000),
                new Employee("Saltanat", "DST", 600_000),
                new Employee("Bauka", "DRR", 300_000)
        );

        Map<String, Double> res = workers.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));

        System.out.println(res);

        List<String> numbers = List.of("18", "25", "30", "42", "15");

        double avgAge = numbers.stream()
                .mapToInt(Integer::parseInt)
                .filter(n -> n >= 18)
                .average()
                        .orElse(0.0);


        System.out.println("avg age: " + avgAge);


    }
}
