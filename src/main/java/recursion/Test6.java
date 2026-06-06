package recursion;

public class Test6 {
    public static void main(String[] args) {
        System.out.println(power(3,3));
    }

    public static int power(int a, int n){
        if (n == 0)
            return 1;

        return  a * power(a, n-1);


    }



}
