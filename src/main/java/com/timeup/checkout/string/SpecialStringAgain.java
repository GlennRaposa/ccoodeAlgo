package com.timeup.checkout.string;

//https://www.youtube.com/watch?v=SJ_C9mclZJo&t=612s
public class SpecialStringAgain {

    public static void main(String args[]){
        //int n = 4;
        //String s = "aaaa";

        int n = 5;
        String s = "asasd";

        System.out.println("Long value ::"+substrCount(n, s));
    }

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long ans = s.length();
        for(int i=0; i<s.length(); i++){
            int repeat = 0;
            //IF String has same characters aaaa
            //Scenario 1 :
            // 4 character = 1
            // 3 character = 2
            // 2 character = 3
            // 4 character = 4  (Total 10)
            while(i+1< s.length() && s.charAt(i) == s.charAt(i+1)){
                repeat++;
                i++;
            }
            ans += (repeat * (repeat+1))/2;

            //IF String has same characters asasd
            int pointer = 1;
            while(i-pointer >=0 && i+pointer<s.length()
              && s.charAt(i+pointer) == s.charAt(i-1)
             && s.charAt(i-pointer) == s.charAt(i-1)){
                ans++;
                pointer++;
            }
        }
        return ans;
    }
}
