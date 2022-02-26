package com.javatechie.lambda;

@FunctionalInterface
interface Calculator{
    //void switchOn();
    //void sum(int input);
    int substract(int i1, int i2);
    default void one(){
        System.out.println("one");
    }

    static void two(){
        System.out.println("two");
    }
}

public class CalculatorImpl {

    public static void main(String args[]){
        /*Calculator cal = (input) -> {
            int sum = 3+input;
            System.out.println("Sum Adding ::"+sum);
        };
        cal.sum(3);*/

        Calculator cal = (i1,i2) -> {
            if(i2 < i1){
                throw new RuntimeException("------- Value less that 1i -------");
            }
            return i2 -i1;
        };
        System.out.println(cal.substract(12,2));
    }
}
