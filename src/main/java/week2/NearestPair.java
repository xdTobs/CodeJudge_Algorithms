package week2;

import java.util.Arrays;

public class NearestPair {
    public static void main(String[] args) {
        int[]arr = new int[]{1,2,4,6,8};
        int[]res = nearestPair(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] nearestPair(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int[]res = new int[2];
        for (int i = 1; i <arr.length ; i++) {
            if(minDiff>arr[i]-arr[i-1]){
                minDiff = arr[i]-arr[i-1];
                res[0] = i-1;
                res[1] = i;
            }

        }
        return res;
    }
}
