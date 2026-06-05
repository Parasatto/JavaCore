package recursion;

public class Main {
    public static void main(String[] args) {

        System.out.println(factorial(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int n){
        if (n== 1 || n ==2)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);


    }
    public static int factorial(int n){

        if (n ==1)
            return 1;

        return n * factorial(n-1);
    }
}
