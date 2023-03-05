package week2;

import java.util.Arrays;

public class TwoSumNlogN {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,1,2,3,4,5,6,7,8};
        int[]res = twoSum(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] arr) {
        Arrays.sort(arr);
        int l =0,r=arr.length-1;
        while (l<=r){
            if(arr[l]+arr[r]==0)
                return new int[]{l,r};
            if(arr[l]+arr[r]>0){
                r--;
                continue;
            }
            if(arr[l]+arr[r]<0){
                l++;
                continue;
            }
        }

        return null;
    }
}
