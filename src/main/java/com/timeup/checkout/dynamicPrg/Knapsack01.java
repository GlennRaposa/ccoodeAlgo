package com.timeup.checkout.dynamicPrg;
//https://www.youtube.com/watch?v=aL6cU5dWmWM&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=5
/*
   case1: Choose the current items
   if current ith item is selection, so maximum profit value you can make

   Value of current item + maximum profile with remaining capacity
   ith_item_is_selected = val[i-1]+maxV(i-1, C-wt[i-1])

   Case2: : DO not choose the current item
   if current ith item is NOT selection, so maximum profit value you can make

   maximum value from the remaining items except current item
   ith_item_is_not_selected = maxV(i-1, C)

   MaxC(i,C) = Math.max(ith_item_is_selected, ith_item_is_not_selected)
   maxV(i,C) = Math.max((V[i-1]+maxV(i-1),C-wt[j-1])), maxV(i-1, C))
 */
public class Knapsack01 {
   //Similar problem : Subset Sums
   //Given a Set S of 1<=n<=20 integers and prositive integer x, is there a subset of S the sums to X
   //S = {17,5,7,15,3,8} x=16

    public static void main(String args[]){
        int[] n = {1,2,3,1};

    }


    static int cache[][];
    static int val[];
    static int wt[];

    public int solveKnapsack_m1(int i, int c){
        //basecase
        if(i == 0 || c == 0){ return 0; }
        //if weight of ith items is more than capacity then this item cannot be included
        if(wt[i-1] > c){
            return solveKnapsack_m1(i-1, c);
        }
        //(1) ith item included/selected
        int ith_item_is_Selected = val[i-1]+ solveKnapsack_m1(i-1, c-wt[i-1]);
        //(2) not included
        int ith_item_is_not_Selected = solveKnapsack_m1(i-1, c);
        //Return max of two cases
        return Math.max(ith_item_is_Selected, ith_item_is_not_Selected);
    }

    /*
    BEST solution
     */
    //Using local Cache
    public int solveKnapsack_m4(int n, int c){
        int i, w;
        int cache[][] = new int[n+1][c+1];

        for(i=0; i<=n; i++) {
            for(w= 0; w<=c; w++) {
                if (i == 0 || c == 0) {
                    return cache[i][w] = 0;
                }else if(wt[i-1] > w){
                    cache[i][w] = cache[i-1][w];
                }else{
                    //(1) ith item included/selected
                    int ith_item_is_Selected = val[i-1]+cache[i-1][w-wt[i-1]];
                    //(2) not included
                    int ith_item_is_not_Selected = cache[i-1][w];
                    cache[i][w] = Math.max(ith_item_is_Selected, ith_item_is_not_Selected);
                }
            }
        }
        return cache[n][c];
    }



   //Using global Cache
    public int solveKnapsack_m2(int i, int c){
        //basecase
        if(i == 0 || c == 0){ return 0; }

        if(cache[i][c] !=0){
            return cache[i][c];
        }

        //if weight of ith items is more than capacity then this item cannot be included
        if(wt[i-1] > c){
            return cache[i][c] = solveKnapsack_m2(i-1, c);
        }
        //(1) ith item included/selected
        int ith_item_is_Selected = val[i-1]+ solveKnapsack_m2(i-1, c-wt[i-1]);
        //(2) not included
        int ith_item_is_not_Selected = solveKnapsack_m2(i-1, c);
        //Return max of two cases
        return cache[i][c] = Math.max(ith_item_is_Selected, ith_item_is_not_Selected);
    }


    //Using local Cache
    public int solveKnapsack_m3(int i, int c, int cache[][]){
        //basecase
        if(i == 0 || c == 0){ return 0; }

        if(cache[i][c] !=0){
            return cache[i][c];
        }

        //if weight of ith items is more than capacity then this item cannot be included
        if(wt[i-1] > c){
            return cache[i][c] = solveKnapsack_m3(i-1, c, cache);
        }
        //(1) ith item included/selected
        int ith_item_is_Selected = val[i-1]+ solveKnapsack_m3(i-1, c-wt[i-1], cache);
        //(2) not included
        int ith_item_is_not_Selected = solveKnapsack_m3(i-1, c, cache);
        //Return max of two cases
        return cache[i][c] = Math.max(ith_item_is_Selected, ith_item_is_not_Selected);
    }

}
