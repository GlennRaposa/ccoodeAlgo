package com.timeup.checkout.array;

import java.util.Arrays;

public class LeetCode_TwoSums {

    public static void main(String args[]){
        //int []nums = {2,7,11,15};
        //int target = 9;

        //int[] nums = {3,2,4};
        //int target = 6;

        //int []nums = {3,3};
        //int target = 6;

        int[] nums = {2,7,11,15};
        int target = 9;

        printIndexes(twoSum(nums, target));
    }

    /*
    public static int[] twoSum(int[] nums, int target) {
        precondition(nums);
        Arrays.sort(nums);
        printIndexes(nums);
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            if(nums[start]+nums[end] == target){
                return new int[]{start, end};
            }else if (nums[start]+nums[end] < target){
                start++;
            }else if (nums[start]+nums[end] > target){
                end--;
            }
        }
        return new int[]{-1, -1};
    }*/


    public static int[] twoSum(int[] nums, int target) {
        precondition(nums);
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            if(nums[start]+nums[end] == target){
                return new int[]{start, end};
            }else if (nums[start]+nums[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    private static void printIndexes(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void precondition(int[] arrOfNumbers){
        if(arrOfNumbers == null || arrOfNumbers.length < 2 ){
            throw new IllegalArgumentException("Input array is Empty or Less than 2");
        }

    }

}
