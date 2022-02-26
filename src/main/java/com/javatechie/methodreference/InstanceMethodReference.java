package com.javatechie.methodreference;
//https://www.javatpoint.com/java-8-method-reference
import java.util.function.BiFunction;

interface Sayable1{
    void say();
}
public class InstanceMethodReference {
    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object
        // Referring non-static method using reference
        Sayable sayable = methodReference::saySomething;
        // Calling interface method
        sayable.say();
        // Referring non-static method using anonymous object
        Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also
        // Calling interface method
        sayable2.say();
    }
}


class InstanceMethodReference2 {
    public void printnMsg(){
        System.out.println("Hello, this is instance method");
    }
    public static void main(String[] args) {
        Thread t2=new Thread(new InstanceMethodReference2()::printnMsg);
        t2.start();
    }
}




class Arithmetic1{
    public int add(int a, int b){
        return a+b;
    }
}
class InstanceMethodReference3 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder = new Arithmetic1()::add;
        int result = adder.apply(10, 20);
        System.out.println(result);
    }
}