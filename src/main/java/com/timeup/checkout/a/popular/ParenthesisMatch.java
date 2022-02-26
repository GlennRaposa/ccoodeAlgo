package com.timeup.checkout.a.popular;

import java.util.Stack;
//http://www.algorithmsandme.com/matching-parenthesis-problem/
public class ParenthesisMatch {

    public static boolean isMatchingParenthesis(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s == null || s.length() == 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ('('):
                    stack.push(s.charAt(i));
                    break;
                case (')'):
                    if (stack.empty()) return false;
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }
        return stack.empty();
    }

    //------------ RIGHT WAY TO SOLVE PROBLEM -------------
    //https://www.youtube.com/watch?v=IhJGJG-9Dx8&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX
    public static char[][] TOKENS = {{'{','}'}, {'[',']'}, {'(',')'}};

    public static boolean isOpenTerm(char c){
        for(char[] array : TOKENS){
            if(array[0] == c){
                return true;
            }
        }
        return false;
    }

    public static boolean matches(char openTerm, char closeTerm){
        for(char[] array : TOKENS){
            if(array[0] == openTerm){
                return array[1] == closeTerm;
            }
        }
        return false;
    }


    public static boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<Character>();
        for(char c : expression.toCharArray()){
            if(isOpenTerm(c)){
                stack.push(c);
            }else{
                if(stack.empty() || !matches(stack.pop(), c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {
        //String s = ")(()))";
        //System.out.println(isMatchingParenthesis(s));

        String s = "{[()]}";
        System.out.println(isBalanced(s));
    }
}
