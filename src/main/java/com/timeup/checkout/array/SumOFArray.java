package com.timeup.checkout.array;

public class SumOFArray {

    public static void main(String args[]){
        int nums[] = {1,2,3};
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        System.out.println("SUM --------"+sum);
    }
}
