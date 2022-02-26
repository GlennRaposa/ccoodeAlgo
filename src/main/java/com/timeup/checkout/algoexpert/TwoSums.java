package com.timeup.checkout.algoexpert;

import java.util.Arrays;

public class TwoSums {

    public static void main(String args[]) throws IllegalAccessException {

        int[] array = {5, 7, 1, 2, 8, 3, 4};
        int targetSum = 8;
        printIndexes(twoNumberSum(array, targetSum));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        if(array !=null && array.length >= 2){
            Arrays.sort(array);
            int startIdx = 0;
            int endIdx = array.length-1;
            while(startIdx < endIdx){
                if(array[startIdx] + array[endIdx] == targetSum){
                    return new int[]{array[startIdx], array[endIdx]};
                }else if(array[startIdx] + array[endIdx] < targetSum){
                    startIdx++;
                }else{ //array[startIdx] + array[endIdx] > targetSum
                    endIdx--;
                }
            }
        }
        return new int[0];
    }


    private static void printIndexes(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}
