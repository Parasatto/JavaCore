package P1Basic;

public class BreakAndContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5 ) {
                System.out.println("It`s skipped");
                continue;
            } else
                System.out.println(i);
            if (i == 8) break;
        }
    }
}
