package com.timeup.checkout;

/*
 Number that i divided by One and itself(2,3,5,7,11 ...etc)
 */
public class PrimeNumber {

    public static void main(String args[]){
        System.out.println(isPrime(13));
    }

    private static boolean isPrime(int num){
        boolean isPrime = true;
        //You could use Math.Sqrt as well to reduce the number of Looping
        for(int i=2; i<num/2; i++){
            if(num%i == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }
}
