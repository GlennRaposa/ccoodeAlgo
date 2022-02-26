package com.timeup.checkout.string;

public class IsWordPalindrome {
    //we could use a string buffer
    public static boolean isPalidrome(String str){
        String reverseString = "";
        for(int i = str.length()-1; i>= 0; i--){
            reverseString += str.charAt(i);
        }
        return str.equals(reverseString);
    }
}
