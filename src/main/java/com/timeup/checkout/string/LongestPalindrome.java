package com.timeup.checkout.string;
//https://www.youtube.com/watch?v=DK5OKKbF6GI&list=PLqq-6Pq4lTTZgXnsBNQwCWdKR6O6Cgk1Z&index=8
public class LongestPalindrome {

    int resultStart;
    int resultLength;

    public static void main(String args[]){
        LongestPalindrome l = new LongestPalindrome();
        //l.longestPalindrome("forgeeksskeegfor");
        System.out.println("------------"+l.longestPalindrome("foreeeeefor"));
    }

    public String longestPalindrome(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    // foggogged
    private void expandRange(String str, int begin, int end) {
        while (begin >= 0 && end < str.length() &&
                str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
