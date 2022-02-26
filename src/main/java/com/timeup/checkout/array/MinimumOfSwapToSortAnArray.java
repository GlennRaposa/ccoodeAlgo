package com.timeup.checkout.array;
//https://www.youtube.com/watch?v=zrWiBivUzLM
//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class MinimumOfSwapToSortAnArray {

    public static void main(String args[]) {
        System.out.println("SWAPS:::"+minimumSwaps(new int[]{4,3,2,1}));
    }
    static int minimumSwaps(int[] arr){
        int min_index=0;
        int min_value = arr[0];
        int swaps = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] < min_value){
                min_index= i;
                min_value = arr[i];
            }
        }
        if(min_index !=0){
            int temp = arr[0];
            arr[0] = arr[min_index];
            arr[min_index] = temp;
            swaps++;
        }

        for(int cur=1; cur<arr.length-1;cur++){
            int pos = arr[cur]-arr[0];
            while(arr[pos] != arr[cur]){
                int temp = arr[pos];
                arr[pos] = arr[cur];
                arr[cur] = temp;
                swaps++;
                pos = arr[cur]-arr[0];
            }
            cur= pos;
            System.out.println("CUR::"+cur);
        }
        return swaps;
    }
}
