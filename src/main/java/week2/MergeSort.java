package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int listLength = Integer.parseInt(in.readLine());
        int[] nums;
        if(listLength>0) {
            nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        else{
            nums = new int[0];
            in.readLine();
        }
        mergeSort(nums);

        String output = Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
    }


    private static void mergeSort(int[] arr) {
        recMergeSort(arr, 0, arr.length - 1);
    }

    private static int[] recMergeSort(int[] arr, int left, int right) {
        if(left>=right)
            return arr;
        int mid = (left+right)/2;
        recMergeSort(arr,left,mid);
        recMergeSort(arr,mid+1,right);
        return merge(arr,left,mid,right);
    }


    private static int[] merge(int[] arr, int left, int mid, int right) {
        int leftLen = mid - left+1;
        int rightLen = right - mid;
        int[] leftArr = new int[leftLen], rightArr = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[left+i];
        }
        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = arr[mid+i+1];
        }
        int i = 0, j = 0, k = left;
        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
        return arr;
    }

}
