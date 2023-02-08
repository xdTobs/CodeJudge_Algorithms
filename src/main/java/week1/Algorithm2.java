package week1;

import java.util.Scanner;

public class Algorithm2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        String a = scanner.nextLine(), arr = scanner.nextLine();
        String[] stringNums = arr.split(" ");
        int[]nums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            nums[i] = Integer.parseInt(stringNums[i]);
        }
        System.out.println(max(nums));

    }

    private static int max(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>nums[max])max = i;
        }
        return max;
    }


}
