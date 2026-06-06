package recursion;

public class Test5 {
    public static void main(String[] args) {
        sumnum(123);
    }

    public static int sumnum(int i){
        if (i < 10)
            return i;

        return (i%10) + sumnum(i / 10);


    }






}
