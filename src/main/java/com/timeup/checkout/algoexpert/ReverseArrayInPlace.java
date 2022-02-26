package com.timeup.checkout.algoexpert;

import java.util.Arrays;

public class ReverseArrayInPlace {

    public static void main(String args[]){
        int[] array = {1,2,3,4,5};
        Arrays.stream(reverseArrayInPlace(array)).forEach(System.out::println);
    }
    //Two pointer technique
    public static int[] reverseArrayInPlace(int[] array){
        int start = 0;
        int end = array.length-1;
        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start +=1;
            end -=1;
        }
        return array;
    }
}
