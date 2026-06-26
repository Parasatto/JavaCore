package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        String data = "Ivan: ivan@mail.ru, Maria: maria@gmail.com, unknown: test@yandex.ru";

        // Исправлено: используем [\\w.-]+ и \\.[a-z]{2,}
        Pattern pattern = Pattern.compile("[\\w.-]+@[\\w.-]+\\.[a-z]{2,}");
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()){
            System.out.println("Найден email: " + matcher.group());
        }
    }
}
