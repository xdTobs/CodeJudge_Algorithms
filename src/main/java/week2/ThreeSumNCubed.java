package week2;

import java.util.Arrays;

public class ThreeSumNCubed {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,1,2,3,4,5,6,7,8};
        int[]res = twoSum(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if(arr[i]+arr[j]+arr[k]==0)
                        return new int[]{i,j,k};
                }
            }
        }

        return null;
    }
}
