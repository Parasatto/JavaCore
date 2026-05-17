package P1Basic;

public class MultyArrays {
    public static void main(String[] args) {
        int[][] ints = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(ints[1][1]);

        int[][] table = new int[5][5];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                    table[i][j] = i * j;
            }
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                System.out.print(table[i][j]);;
            }
            System.out.println();
        }


        int[][] num2 = {
                {0,0},
                {0,0,0,0,0},
                {0}
        };

        for (int i = 0; i < num2.length; i++) {
            for (int n = 0; n < num2[i].length; n++) {
                System.out.print(num2[i][n]);
            }
            System.out.println();
        }

        int[][] deportaments = {
                {500, 700,800},
                {120, 123, 233, 500},
                {33, 444}
        };
        int selarySum = 0;
        for (int i = 0; i < deportaments.length; i++) {
            for (int j = 0; j < deportaments[i].length; j++) {
                selarySum = selarySum + deportaments[i][j];
            }
        }

        System.out.println(selarySum);

        System.out.println("next");
        for (int[] row: deportaments){
            for(int num: row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
