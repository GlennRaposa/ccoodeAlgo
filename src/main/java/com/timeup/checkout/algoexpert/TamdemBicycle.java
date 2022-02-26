package com.timeup.checkout.algoexpert;

import java.util.Arrays;
import java.util.Collections;
//https://www.algoexpert.io/questions/Tandem%20Bicycle
//Get Max or min Speed
public class TamdemBicycle {

    public static void main(String args[]){
        int[] redShritsspeeds = {5,5,3,9,2};
        int[] blueShirtsSpeecs = {3,6,7,2,1};
        /*
         1 Sort - Max speed
         2. i = {2,3,5,5,9}
         3. j = {1,2,3,6,7}

         Two pointer approach i=2 j=7  max(7)
                              i=3 j=6  max(6)
                              i=5,j=3  max(5)
         */
       // System.out.println("tandemBicycles MAX output ::"+tandemBicycles(redShritsspeeds, blueShirtsSpeecs, true));
        System.out.println("tandemBicycles MIN output ::"+tandemBicycles(redShritsspeeds, blueShirtsSpeecs, false));

    }

    //O(nLogn) time | O(1) - where n is the number of tandem biccyles
    public static int tandemBicycles(int[] redShritsspeeds, int[] blueShirtsSpeecs, boolean fastest){
        Arrays.sort(redShritsspeeds);
        Arrays.sort(blueShirtsSpeecs);

        if(!fastest){
           redShritsspeeds = reverseArrayInPlace(redShritsspeeds);
        }

        int totalSpeed = 0;
        for(int idx = 0; idx < redShritsspeeds.length; idx++){
           int rider1 = redShritsspeeds[idx];
           System.out.println("RedShirts_idx ::"+idx+" Rider1_value::"+rider1);

           int rider2 = blueShirtsSpeecs[blueShirtsSpeecs.length -idx -1];
            System.out.println("BlueShirtIdx::"+(blueShirtsSpeecs.length -idx -1)+" Rider2_value ::"+rider2);

           totalSpeed += Math.max(rider1, rider2);
        }
        return totalSpeed;
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
