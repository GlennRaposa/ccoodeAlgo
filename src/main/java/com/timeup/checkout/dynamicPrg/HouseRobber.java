package com.timeup.checkout.dynamicPrg;

//https://www.youtube.com/watch?v=ge_Fv2ZQAaE&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=4
public class HouseRobber {

    public static void main(String args[]){
     int[] A = {1,2,3,1};
     //System.out.println("Robber_1:"+rob_m4(A));
        // System.out.println("Robber_2:"+rob_m3(A));
        System.out.println("Robber_2:"+rob_m2(A,3));
    }

    /*
   MOST Efficient solution
   * Painted House -
   * Find Maximum Sum in Array for non-adjacent elements
   * Find Maximum sum of a subsequence with no two adjacent
   */
    public static int rob_m4(int[] A){
        if(A == null || A.length ==0){
            return 0;
        }
        if(A.length ==1){
            return A[0];
        }
        int prev2 = A[0];
        int prev1 = Math.max(A[0], A[1]);

        for(int i=2; i<A.length; i++){
            int temp = prev1;
            prev1 = Math.max(prev2+A[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }

    /*
  Botton UP-Approach time & Space O(n)
  */
    public static int rob_m3(int[] A){
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }
        int[] cache= new int[A.length+1];
        cache[0] = A[0];
        cache[1] = Math.max(A[0], A[1]);

        for(int i=2; i<A.length; i++){
            int ith_house_is_selected = cache[i-2]+A[i];
            int ith_house_is_not_selected = cache[i-1];
            cache[i] = Math.max(ith_house_is_selected, ith_house_is_not_selected);
        }
        return cache[A.length-1];
    }

    /*
         Dynamic Programming - Recurssion + Memoization
     */
    public static int rob_m2(int[] A, int i) {
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }
        if(i<0) {
            return 0;
        }
        int ith_house_is_selected = rob_m2(A, i-2)+A[i];
        int ith_house_is_not_selected = rob_m2(A, i-1);

        return Math.max(ith_house_is_selected, ith_house_is_not_selected);
    }



}
