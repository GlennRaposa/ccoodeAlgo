package com.timeup.checkout.array;

import java.util.Arrays;
import java.util.List;

public class JumpIngTheClouds {


    public static void main(String args[]){

        Integer[] ints = new Integer[] {0,0,1,0,0,1,0};
        List<Integer> list = Arrays.asList(ints);
        System.out.println("clouds::"+jumpingOnClouds(list));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int jumps=-1;
        for(int i=0; i<c.size();){

            if(i+2 < c.size() && c.get(i+2) == 0){
                i = i+2;
            }else {
                i = i+1;
            }
            jumps++;
        }
        return jumps;
    }
}
