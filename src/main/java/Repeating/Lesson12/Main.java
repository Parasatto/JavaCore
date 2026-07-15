package Repeating.Lesson12;

public class Main {
    public static void main(String[] args) {
        String[] myString = new String[3];

        myString[0] = "Parasat";
        myString[1] = "Azamat";
        myString[2] = "Kaza";

        for(String s: myString){
            System.out.println(s + ", добро пожаловать на вечеринку!");
        }

        int[] myInt = {150, 200, 100};

        int sum = 0;

        for (int i: myInt){
            sum += i;
        }
        System.out.println(sum);
    }
}
