package Lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalPrograming {
    public static void main(String[] args) {
        Predicate<String> LetterA = text -> text.startsWith("A");
        System.out.println(LetterA.test("Parasat"));

        Consumer<String> upperCase = text -> System.out.println(text.toUpperCase());

        upperCase.accept("Hello world");

        Function<Integer, Double> radius = num -> Math.PI * num * num;

        System.out.println(radius.apply(5));

    }
}
