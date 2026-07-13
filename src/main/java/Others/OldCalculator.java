package Others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface MethodInfo{
        String author() default "Parasat";
        int dateOfCreation();
        String revision();

    }

    @MethodInfo(dateOfCreation = 2026, revision = "Test")
    public static void test(){}
}
