package JavaSyntaAndOOP.P1Basic;

public class StringArrays {
    public static void main(String[] args) {
        String[] strings = new String[3];

        strings[0]= "Pasik";
        strings[1] = "Aza";
        strings[2] = "Zenin";

        for(String ss: strings){
            System.out.println(ss + " добро пожаловать на вечеринку!");
        }

        int[] ints = {100, 1231, 233};
        int sum = 0;
        for(int i : ints){
          sum = sum + i;
        }

        System.out.println(sum);
    }
}
