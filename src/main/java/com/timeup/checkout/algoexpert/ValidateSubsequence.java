package com.timeup.checkout.algoexpert;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {

    /*
     CR: validate if array two is subsequence of the Bigger array one
     Given two array
     array one : [5,1,22,25,-6,1,8,10]
     array two : [1,-6,1,10]
     */
    public static void main(String args[]){
        List<Integer> array = Arrays.asList(5,1,22,25,-6,1,8,10,11,12,13);
        List<Integer> sequence = Arrays.asList(1,-6,1,10);
        System.out.println(isValidSubsequence(array, sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;
        while(arrIdx<array.size() && seqIdx < sequence.size()){
            if(array.get(arrIdx) == sequence.get(seqIdx)){
                seqIdx +=1;
            }
            arrIdx+=1;
        }
        return seqIdx == sequence.size() ? true : false;
    }
}
