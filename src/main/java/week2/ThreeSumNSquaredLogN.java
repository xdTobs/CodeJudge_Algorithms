package week2;

import java.util.Arrays;

public class ThreeSumNSquaredLogN {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,1,2,3,4,5,6,7,8};
        int[]res = twoSum(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
                int l =0,r=arr.length-1;
                while (l<=r){
                    if(arr[l]+arr[r]+arr[i]==0&&l!=r&&r!=i&&l!=i)
                        return new int[]{l,r,i};
                    if(arr[l]+arr[r]+arr[i]>0){
                        r--;
                        continue;
                    }

                        l++;

                }
        }

        return null;
    }
}
