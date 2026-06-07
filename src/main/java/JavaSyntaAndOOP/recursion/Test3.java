package JavaSyntaAndOOP.recursion;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(counter(5));
    }

    public static String counter(int i) {
        if (i == 1)
            return "1";

        return counter(i-1) + " " + i;

    }
}

/*
A: От 1 до n
Дано натуральное число n. Выведите все числа от 1 до n.
 */