package com.timeup.checkout.string;

public class MakingAnagram {
    public static int NUMBER_LETTERS = 26;

    public static void main(String args[]){
        System.out.println("Number Count : "+numberNeeded("cde", "abc"));
    }

    public static int getDelta(int[] array1, int[] array2){
        if(array1.length != array2.length){
            return -1; //todo : better error handling
        }
        int delta = 0;
        for (int i=0; i< array1.length; i++){
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

    public static int[] getCharCount(String str){
        int[] charsCounts = new int[NUMBER_LETTERS];
        for(int i=0; i< str.length(); i++){
            char current_char = str.charAt(i);
            int char_to_int = (int) current_char;
            int offset = (int) 'a';
            int code = current_char - offset;
            //System
            charsCounts[code]++;
        }
        return charsCounts;
    }

    public static int numberNeeded(String first, String second){
        int[] charCount1 = getCharCount(first);
        int[] charCount2 = getCharCount(second);
        return getDelta(charCount1 , charCount2);
    }
}
