package JavaSyntaAndOOP.P1Basic;

public class StringBulderr {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Парасат");

        System.out.println(sb);


        sb.replace(0, sb.length(), "Azamat");

        System.out.println(sb);

        System.out.println(sb.append(" add new string and others type").append(24).append(true));

        //есть также класс StringBuffer и отличие от StringBuilder в том что он для многопоточного програмирование
        //все методы по функици тоже самое что и у StringBuilder
    }
}
