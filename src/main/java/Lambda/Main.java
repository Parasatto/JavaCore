package Lambda;

public class Main {
    public static void main(String[] args) {
        StringExecutable ss = text -> text.length();

        System.out.println(ss.execute("Pasik"));
    }
}
