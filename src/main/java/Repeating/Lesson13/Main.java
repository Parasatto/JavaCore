package Repeating.Lesson13;

public class Main {
    public static void main(String[] args) {

        int myInt[][] = new int[3][3];


        myInt[1][2] = 1;

        for (int i = 0; i < myInt.length; i++) {
            for (int j = 0; j < myInt[i].length; j++) {
                System.out.print(myInt[i][j]);
            }
            System.out.println();
        }


    }
}
