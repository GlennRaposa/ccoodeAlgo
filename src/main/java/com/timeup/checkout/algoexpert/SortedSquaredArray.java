package com.timeup.checkout.algoexpert;

import java.util.Arrays;

/*
 CR: we get an array and give back a squared sorted array
   input  : [1,2,3,5,6,8,9]
   output : [1,2,9,25,36,69,81]
 */
public class SortedSquaredArray {

    public static void main(String args[]){
        int[] array = {1,2,3,5,6,8,9};
        printIndexes(sortedSquaredArray(array));
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] squaredArray = new int[array.length];
        int left=0;
        int right= array.length-1;
        for(int i =array.length-1; i>=0; i--){
            if(Math.abs(array[left]) > array[right]){
                squaredArray[i] = array[left] * array[left];
                left++;
            }else{
                squaredArray[i] = array[right] * array[right];
                right--;
            }
        }
        return squaredArray;
    }


    /*public static int[] nLogN_sortedSquaredArray(int[] array){
        int[] squared_nums = new int[array.length];
        for(int i=0; i<array.length; i++){
            squared_nums[i] = array[i] * array[i];
        }
        Arrays.sort(squared_nums);
        return squared_nums;
    }*/

    private static void printIndexes(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }

}
