package JavaSyntaAndOOP.recursion;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(sumDigis(123));
    }

    public static int sumDigis(int i){
        if (i < 10)
            return i;

        return (i%10) + sumDigis(i /10);

    }
}
