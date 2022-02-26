package com.timeup.checkout.array;

public class FindMinAndMaxNum {

    public static void main(String args[]){
        int[] arr = {5,2,6,9,10,11};
        int min = arr[0];
        int max = 0;

        for(int i=0; i<arr.length; i++){
            if(min == 0){
                min= arr[i];
            }else if (arr[i] < min){
                min = arr[i];
            }else if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("min:"+min+"  max:"+max);
    }
}
