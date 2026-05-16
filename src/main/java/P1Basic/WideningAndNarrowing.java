package P1Basic;

public class WideningAndNarrowing {
    public static void main(String[] args) {
        //It`s ok to wide it from low to high
        // It`s the way how it supposed to be: byte → short → int → long → float → double
        byte MyByte = 2;
        short MyShort = MyByte;
        int MyInt = MyShort;
        long MyLong = MyInt;

        float MyFloat = MyLong;
        double MyDouble = MyFloat;
        System.out.println(MyDouble);

        float HerFloat = (float) MyDouble;
        long HerLong = (long) HerFloat;
        int HerInt = (int) HerLong;
        System.out.println(HerInt);
        //and so on
     }
}
