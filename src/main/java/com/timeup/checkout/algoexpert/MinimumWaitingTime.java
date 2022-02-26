package com.timeup.checkout.algoexpert;

import java.util.Arrays;

//what is the Minimum waiting time
// if we run it as is
public class MinimumWaitingTime {

    public static void main(String args[]){
        int[] arr = {3,2,1,2,6};
        //First - idx1 -> 3
        //secdons - idx2 will have to wait for idx1 to completed -> 2 (+3)
        //third -. idx3 will have to wait for idx1 and idx2 to complated
        System.out.println(minTime(arr));
    }
    //O(nlogn) time | o(n) space - where n is the number of queries
    public static int minTime(int[] arr){
        Arrays.sort(arr); //nlogn
        int minwaitingTime = 0;
        for(int idx =0; idx<arr.length; idx++){
            int duration = arr[idx];
            int queriesLeft = arr.length - (idx+1);
            System.out.println("duration:"+duration+"  queriesLeft ::"+queriesLeft);
            minwaitingTime +=  duration * queriesLeft;
            System.out.println("minwaitingTime:"+minwaitingTime);
        }
        return minwaitingTime;
    }
}
