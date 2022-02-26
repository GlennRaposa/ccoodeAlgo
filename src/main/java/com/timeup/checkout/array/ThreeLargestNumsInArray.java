package com.timeup.checkout.array;

import java.util.Arrays;

//https://www.youtube.com/watch?v=aMsSF1Il3IY
public class ThreeLargestNumsInArray {

    public static void main(String args[]){
        int[] array = {0,121,4,5,90,7,6,81};
        int[] l = findThreeLargestNumbers(array);
        Arrays.stream(l).forEach(System.out::println);
    }

    public static int[] findThreeLargestNumbers(int[] array){
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int num : array){
            updateLargest(threeLargest, num);
        }
        return threeLargest;
    }

    public static void updateLargest(int[] threeLargest, int num){
        if(num > threeLargest[2]){
            shiftAndUpdate(threeLargest,  num, 2);
        }else if(num > threeLargest[1]){
            shiftAndUpdate(threeLargest,  num, 1);
        }else if(num > threeLargest[0]){
            shiftAndUpdate(threeLargest,  num, 0);
        }
    }


    public static void shiftAndUpdate(int[] threeLargest, int num, int idx){
        for(int i =0; i<=idx; i++){
            if(i == idx){
                threeLargest[i] = num;
            }else{
                threeLargest[i] = threeLargest[i+1];
            }
        }
    }
}
