package com.timeup.checkout.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String args[]){
        System.out.print("First NON REP CHAR ::"+getFirstNonRepeatingCharacter("abcdeabe"));
    }

    public static char getFirstNonRepeatingCharacter(String str){
        Map<Character, Integer> counts = new LinkedHashMap<Character, Integer>();

        for(char c : str.toCharArray()){
            counts.put(c, counts.containsKey(c) ? counts.get(c)+1 : 1);
        }

        for(Map.Entry<Character, Integer> entry : counts.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        throw new RuntimeException("NO CHAR IS REPEATED");

    }

}
