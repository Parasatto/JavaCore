package JavaSyntaAndOOP.P1Basic;

public class Arrays {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i<numbers.length; i++){
            numbers[i] = i;
        }

        for (int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }


        int[] nums = {1, 3, 5, 7, 9};

        System.out.println("it`s a second array");
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
