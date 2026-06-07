package JavaSyntaAndOOP.Enum;

public class Main {
    public static void main(String[] args) {
        Difficulty d1 = Difficulty.valueOf("EASY");
        System.out.println(d1);

        System.out.println("Выбран уревень: "+ d1.name());

        System.out.println(d1.getMultiplier());

        System.out.println(d1.ordinal());
    }
}
