package Junit;

public class MyMath {

    public static int add (int a, int b){
        return a + b;
    }

    public static double divide(int a, int b){
        if (a == 0 || b == 0){
            throw new ArithmeticException("Can not be divided by zero");
        }
        return (double) a / b;
    }
}
