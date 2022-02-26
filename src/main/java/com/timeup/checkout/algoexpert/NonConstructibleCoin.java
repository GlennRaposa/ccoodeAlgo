package com.timeup.checkout.algoexpert;

import java.util.Arrays;
//https://www.algoexpert.io/questions/Non-Constructible%20Change
/*
 coins = [1,2,5]
 Non Constructible Coin = 4  as [1] [2] [1+2] [But Cant Make 4]
 */
public class NonConstructibleCoin {

    public static void main(String args[]){
        int[] array = {5,7,1,1,2,3,22};
        System.out.println("Number::"+NonConstructibleCoin(array));
    }
    public static int NonConstructibleCoin(int[] coins){
        Arrays.sort(coins);
        printIndexes(coins);
        int currentChangCreated = 0;
        for(int coin : coins){
            if(coin > currentChangCreated+1){
                System.out.println("coin-IF ::"+coin);
                return currentChangCreated+1;
            }
            System.out.println("coin ::"+coin);
            currentChangCreated += coin;
        }
        return currentChangCreated+1;
    }

    private static void printIndexes(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
    }
}
