package com.timeup.checkout.algoexpert;

public class BinarySearchFor_A_ValueRecurssive {

    public static void main(String args[]){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println("Binary Search Results::"+binarySearchRecursive(array, 6));
    }

    public static boolean binarySearchRecursive(int[] array, int x, int left, int right){
        if(left > right){
            return false;
        }
        //int mid = (left+right) / 2;  [could lead to integer overflow issues ]
        int mid = left + ((right - left) / 2);
        if(x == array[mid]){
            return true;
        }else if(x < array[mid]){
            return binarySearchRecursive(array, x, left, mid-1);
        }else{
            return binarySearchRecursive(array, x, mid+1, right);
        }

    }

    public static boolean binarySearchRecursive(int[] array, int x){
        return binarySearchRecursive(array, x, 0, array.length-1);
    }
}
