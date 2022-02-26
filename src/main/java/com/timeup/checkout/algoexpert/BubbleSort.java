package com.timeup.checkout.algoexpert;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String args[]) {
        int [] arr = {64, 34, 25, 12, 22, 11, 90};
        int [] r = bubbleSort(arr);
        Arrays.stream(r).forEach(System.out::println);
    }

    public static int[] bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i , int j){
        // swap arr[j+1] and arr[j]
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
}
