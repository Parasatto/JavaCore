import Junit.MyMath;
// Используем аннотацию именно из пакета jupyter
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyMathTest {

    @Test
    public void testAdd(){
        Assertions.assertEquals(4, MyMath.add(2, 2));
    }

    @Test
    public void testDivide() {
        // Указываем 2.0, так как метод возвращает double
        Assertions.assertEquals(2.0, MyMath.divide(6, 3));
    }

    @Test
    public void testDivideByZero(){
        Assertions.assertThrows(ArithmeticException.class, () ->{
           MyMath.divide(10, 0);
        });
    }
}