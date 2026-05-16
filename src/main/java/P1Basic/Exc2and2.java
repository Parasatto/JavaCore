package P1Basic;
import java.lang.Math;
import java.util.Scanner;


public class Exc2and2 {
    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        double radius = scann.nextDouble();
        double Spatium = Math.PI * Math.pow(radius,2);
        System.out.println(Spatium);
    }
}
