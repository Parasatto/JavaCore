package StreamAPI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
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


    }
}
