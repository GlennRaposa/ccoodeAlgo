package com.timeup.checkout.algoexpert;

public class BinarySearchFor_A_ValueIterative {

    public static void main(String args[]){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println("Binary Search Results::"+binarySearchIterative(array, 26));
        System.out.println("GET INDEX binary Search results::"+binarySearch_GetIndex(array, 26));

        System.out.println("Binary Search Results::"+binarySearchIterative(array, 6));
        System.out.println("GET INDEX binary Search results::"+binarySearch_GetIndex(array, 6));
    }

    //GET INDEX OF VALUE
    public static int binarySearch_GetIndex(int[] array, int target) {
        int left = 0;
        int right = array.length-1;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(target == array[mid]){
                return mid;
            }else if(target < array[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    //True or false
    public static boolean binarySearchIterative(int[] array, int x){
        int left = 0;
        int right = array.length-1;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(x == array[mid]){
                return true;
            }else if(x < array[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }

}
