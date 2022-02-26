package com.timeup.checkout.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FillAllDuplicatesInArray {

    public static void main(String args[]){
        int[] nums = {4,3,2,7,8,2,3,1};
        /*
         {4,3,2,-7,8,2,3,1}; -> F
         {4,3,-2,-7,8,2,3,1}; -> S
         {4,-3,-2,-7,8,2,-3,-1}; ->T
         */
        find_ALL_Duplicate(nums).stream().forEach(System.out::println);

        int[] num1 = {2,1,3,5,3,2};
        //System.out.println("First DUP- O(N2):"+find_FIRST_Duplicate(num1));

        //System.out.println("First DUP- O(N):"+find_FIRST_DUP_HashSet_Solution(num1));

    }



    // FIND_ALL_DUPS ----- O(n) Solution - //https://www.youtube.com/watch?v=aMsSF1Il3IY
    public static List<Integer> find_ALL_Duplicate(int[] nums){
        List<Integer> output_arr = new ArrayList();
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]<0){
                output_arr.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return output_arr;
    }


    //FIND FIRST DUP  O(n2) Solution - https://www.youtube.com/watch?v=XSdr_O-XVRQ
    //TWO POINTER SOLUTION
    public static int find_FIRST_Duplicate(int[] a){
        int min_second_index = a.length;
        for(int i=0; i<a.length; i++){
            for(int j=i+1; j<a.length; j++){
                if(a[i] == a[j]){
                    min_second_index = Math.min(min_second_index, j);
                }
            }
        }
        if(min_second_index == a.length) return -1;
        else return a[min_second_index];
    }

    //FIND FIRST DUP
    // O(n) - time  O(n)-space
    public static int find_FIRST_DUP_HashSet_Solution(int[] a){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<a.length; i++){
             if(set.contains(a[i])){
                return a[i];
            }else{
                set.add(a[i]);
            }
        }
        return -1;
    }



}
