package Others;

public class OldCalculator {

    public static void main(String[] args) {
        OldCalculator.sum(1,2);
    }

    @Deprecated
    public static int sum(int a, int b){
        return a + b;
    }

    public static int newSum(int a, int b){
        return a + b;
    }
}
