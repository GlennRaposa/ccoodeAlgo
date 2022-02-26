package com.timeup.checkout.array;

import java.util.Arrays;

public class PrefixSumArray {

    public static void main(String args[]){

        int[] arr= {6,9,-2,3,4};

        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i]+arr[i-1];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println("");
        }
    }
}
