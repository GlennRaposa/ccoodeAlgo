package com.timeup.checkout.string;

import java.util.Arrays;
//https://www.youtube.com/watch?v=IRN1VcA8CGc
public class CheckIfStringIsAnagram {

    public static void main(String args[]){
        //System.out.println(isAnagramSort("abcd", "cdba"));
        //System.out.println(isAnagramSort("abcd", "cdbae"));
        System.out.println(isAnagramCounting_v1("abcde", "cdba"));

    }

    //O(nlogn) -> As sorting is nlongn
    static boolean isAnagramSort(String string1, String string2) {

     if(string1 != null && string1.length() > 0 &&
             string2 != null && string2.length() > 0)
     {
         char[] a1 = string1.toCharArray();
         char[] a2 = string2.toCharArray();
         Arrays.sort(a1);
         Arrays.sort(a2);
         return Arrays.equals(a1,a2);
     }
     return false;
    }

    private static int CHARACTER_RANGE= 256;
    // O(n) time ->
    public boolean isAnagramCounting(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    //NIck White
    public static boolean isAnagramCounting_v1(String string1, String string2){
        if(string1.length() != string2.length()){
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for(int i =0; i<string1.length(); i++){
            count[string1.charAt(i)]++;
            count[string1.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;

    }

}
