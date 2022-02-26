package com.javatechie.methodreference;
//https://www.javatpoint.com/java-8-method-reference
import java.util.function.BiFunction;

@FunctionalInterface
interface Sayable{
    void say();
}
//ContainingClass::staticMethodName
//we have defined a functional interface and referring a static method to it's functional method say().
public class StaticMethodReference {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }
    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = StaticMethodReference::saySomething;
        // Calling interface method
        sayable.say();
    }
}

//----------- SECOND EXAMPLE --------
//we are using predefined functional interface Runnable to refer static method.
class StaticMethodReference2 {
    public static void ThreadStatus(){
        System.out.println("Thread is running...");
    }
    public static void main(String[] args) {
        Thread t2=new Thread(StaticMethodReference2::ThreadStatus);
        t2.start();
    }
}



//----------- THIRD EXAMPLE --------
class Arithmetic{
    public static int add(int a, int b){
        return a+b;
    }
    public static float add(int a, float b){
        return a+b;
    }
    public static float add(float a, float b){
        return a+b;
    }
}
// In the following example, we have defined and overloaded three add methods.
class StaticMethodReference4 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer>adder1 = Arithmetic::add;
        BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float>adder3 = Arithmetic::add;
        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}