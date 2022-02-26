package com.timeup.checkout.array;

import java.util.Arrays;
import java.util.Collections;

//https://www.youtube.com/watch?v=SLauY6PpjW4
public class QuickSortArray {

    public static void main(String args[]){
        int[] array = {9,2,6,4,3,5,1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index-1);
        quickSort(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot){
        while(left <=right){
            while(array[left]< pivot){
                left++;
            }
            while(array[right]> pivot){
                right--;
            }
            if(left <=right){
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
}
