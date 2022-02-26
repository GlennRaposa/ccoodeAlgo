package com.timeup.checkout.array;

//https://www.youtube.com/watch?v=En68ipRaFOU
public class FindLargetElementInArray {
    public static int maxElement(int[] array){
        int max = 0;
        for(int i=0; i<array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }

    public static void main(String args[]){
        int[] nums = {4,3,2,7,8,26,3,1};
        System.out.println("max Element"+maxElement(nums));
    }
}
