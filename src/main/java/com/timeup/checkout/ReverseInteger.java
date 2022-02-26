package com.timeup.checkout;

public class ReverseInteger {
    /*
    TODO
    Input - 54321
    Expected result - 12345
    Approach :
    use mod to divide and get remainder
    First Iteration
    remainder = num % 10
    1 = 54321 % 10

    input = num/10
    5432 = 54321/10

    Second Iteration
    remainder = num % 10
    2 = 5432 % 10

    input = num/10
    543 = 5432/10

    while(input != 0){
     remainder = remainder*10+input % 10
     input = input/10
    }
    First Iteration
    1 = 0*10+54321%10
    5432=54321/10
    Second Iteration
     12 = 1*10+5432%10
     543 = 5432/10
     Third Iteration
      123 = 12*10+543%10

     */

    public static void main(String args[]){
        int num = 54321;
        System.out.println(reverseNumber(num));
    }


    private static int reverseNumber(int input){
        int remainder = 0;
        while(input != 0){
            System.out.println("remainder Start"+remainder);
            remainder = (remainder*10)+ (input%10);
            input = input/10;
            System.out.println("remainder end"+remainder+"   input:"+input);
        }
        return remainder;
    }

    //private
}
