package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String text = "Контактные телефоны: +79001234567, +18005550199, а также +441234567890";

        // Группа 1: (\+\d{1,3}) - код страны
        // Группа 2: (\d{10}) - сам номер
        Pattern pattern = Pattern.compile("(\\+\\d{1,3})(\\d{10})");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            // matcher.group(0) или group() всегда возвращает всё совпадение целиком
            System.out.println("Полный номер: " + matcher.group(0));
            System.out.println("Код страны : " + matcher.group(1));
            System.out.println("Номер: " + matcher.group(2));
            System.out.println("---"); // разделитель для наглядности
        }
    }
}
