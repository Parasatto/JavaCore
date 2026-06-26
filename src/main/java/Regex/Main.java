package Regex;

public class Main {

    public static void main(String[] args) {
        String[] s1 = new String[]{"123", "123456","asd"};

        for (String s : s1){
            System.out.println(Main.isValidId(s));
        }
    }

    public static boolean isValidId(String id){
        return id.matches("\\d{1,5}");
    }
}
