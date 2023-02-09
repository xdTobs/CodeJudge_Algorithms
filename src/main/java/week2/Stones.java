package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Stones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        String a = scanner.nextLine(), arr = scanner.nextLine();
        int weight = Integer.parseInt(a.split(" ")[1]);
        String[] stringNums = arr.split(" ");
        int[]nums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            nums[i] = Integer.parseInt(stringNums[i]);
        }
        System.out.println(stones(nums,weight));

    }

    private static int stones(int[] nums, int weight) {
        Arrays.sort(nums);
        int stones = 0;
        while(stones<nums.length&&weight>=nums[stones]){
            weight -=nums[stones];
            stones++;
        }
        return stones;
    }
}
