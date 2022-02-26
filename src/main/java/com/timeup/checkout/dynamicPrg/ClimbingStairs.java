package com.timeup.checkout.dynamicPrg;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=ftpbBbtyxdE&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=3
public class ClimbingStairs {

    static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public static void main(String[] args) {

        //System.out.println("Num of ways:  "+noOfWaysToClimb(10));
        //System.out.println("DP Num of ways:  "+climbStairs(10));
        System.out.println("DP Num of ways:  "+climbStairs(10, cache));

    }

    /*
     BETTER SOLUTION
     Time complexity - O(n)
     Space - O(1)
    */
    public static int noOfWaysToClimb(int n){
        int first =1, second=1, sum=0;
        if(n < 2){
            return n;
        }

        for(int i=2; i<=n; i++){
            sum=first + second;
            first = second;
            second = sum;
        }
        return sum;

    }

    /*
     BETTER SOLUTION
    Time complexity - O(n)
    Space - O(1)
    */
    public static int climbStairs(int n){
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        if(n < 0) {
            return 0;
        }else if(n == 0) return 1;
        if(resultMap.containsKey(n)){
            return resultMap.get(n);
        }
        int result = (climbStairs(n-1)+climbStairs(n-2));
        resultMap.put(n, result);
        return result;

    }

    public static int climbStairs(int n, Map<Integer, Integer> cache){

        if(n < 0) {
            return 0;
        }else if(n == 0) return 1;
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int result = (climbStairs(n-1, cache)+climbStairs(n-2, cache));
        cache.put(n, result);
        return result;

    }


}
