package week2;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSumNSquared {
    public static void main(String[] args) {
        int[] arr = new int[]{-3,1,2,3,4,5,6,7,8};
        int[]res = twoSum(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
            for (int j = 0; j < arr.length; j++) {
                int c = -(arr[i]+arr[j]);
                if(map.containsKey(c)&&i!=j&&map.get(c)!=i&&map.get(c)!=j){
                    return new int[]{c,arr[i],arr[j]};
                }
            }
        }

        return null;
    }
}
