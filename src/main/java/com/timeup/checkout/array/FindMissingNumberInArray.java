package com.timeup.checkout.array;

//https://www.educative.io/blog/crack-amazon-coding-interview-questions#questions
//https://www.youtube.com/watch?v=6KHW7ZQwtCA

/*
    SUM FORMULA
    Sn = n*(n-1)/2
    Sa = arr[0] + arr[1] + arr[2] + .....arr[n]
    missing number = Sn - Sa
 */
public class FindMissingNumberInArray {

    public static void main(String args[]){
        int[] arr = {3,7,1,6,2,8,4};
        System.out.println("Missing value "+findMissingValue(arr));
    }

    public static int findMissingValue(int[] arr){
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        System.out.println("sum :"+sum);

        for(int i=0; i<arr.length; i++){
            sum = sum - arr[i];
            System.out.println("sum for loop :"+sum);
        }
        return sum;
    }
}
