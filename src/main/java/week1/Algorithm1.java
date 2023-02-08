package week1;

import java.util.Scanner;

public class Algorithm1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in); // Read input from System.in
            String a = scanner.nextLine(), arr = scanner.nextLine();
            String[] stringNums = arr.split(" ");
            int[]nums = new int[stringNums.length];
            for (int i = 0; i < stringNums.length; i++) {
                nums[i] = Integer.parseInt(stringNums[i]);
            }
            System.out.println(peak(nums));

        }

        private static int peak(int[] nums) {
            if(nums[0]>=nums[1])
                return 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if(nums[i]>=nums[i-1]&& nums[i]>=nums[i+1])
                    return i;
            }
            if(nums[nums.length-2]<=nums[nums.length-1])
                return nums.length-1;
            return -1;
        }


}
