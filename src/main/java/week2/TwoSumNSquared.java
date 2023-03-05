package week2;

import java.util.Arrays;

public class TwoSumNSquared {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,1,2,3,4,5,6,7,8};
        int[]res = twoSum(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]+arr[j]==0&&i!=j)
                    return new int[]{i,j};
            }
        }
        return null;
    }
}
