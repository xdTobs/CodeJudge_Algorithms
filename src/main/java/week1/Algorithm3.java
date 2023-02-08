package week1;

import java.util.Scanner;

public class Algorithm3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Read input from System.in
        String a = scanner.nextLine(), arr = scanner.nextLine();
        String[] stringNums = arr.split(" ");
        int[]nums = new int[stringNums.length];
        for (int i = 0; i < stringNums.length; i++) {
            nums[i] = Integer.parseInt(stringNums[i]);
        }
        System.out.println(peak(nums,0,nums.length-1));

    }

    private static int peak(int[] nums,int l,int r) {
        int m =(l+r)/2;
        if(m == nums.length-1 && nums[m]>=nums[m-1])
            return m;
        else if (m == 0 && nums[m]>=nums[m+1])
            return m;
        else if(nums[m]>=nums[m-1]&&nums[m]>=nums[m+1])
            return m;
        else if (nums[m]<nums[m-1])
            return peak(nums,l,m-1);
        else if(nums[m]<nums[m+1])
            return peak(nums,m+1,r);
        return -1;
    }


}
