package JavaSyntaAndOOP.recursion;

public class Test1 {
    public static void main(String[] args) {
        int i1 =Test1.sum(10);
        System.out.println(i1);
    }


    public static int sum(int n){
        if (n == 1)
            return 1;

        return  n + sum(n - 1);
    }
}
