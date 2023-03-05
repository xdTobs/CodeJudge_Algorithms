package week2;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10,9,8,7,6,5,4,3,2,1,0};
        insertSort(arr);
        System.out.println(arr);
        System.out.println("hi");

    }

    private static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(nums[j]<nums[i]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
}
