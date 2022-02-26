package com.timeup.checkout;

public class Stack {

   private int arr[];
   private int top;
   private int capacity;

   Stack(int capacity){
       this.arr = new int[capacity];
       this.capacity = capacity;
       this.top = -1;
   }

   public void push(int item){
       if(isFull()){
           throw new RuntimeException("Stack is Full");
       }
       arr[++top] = item;
   }

   public int pop(){
       if(isEmpty()){
           throw new RuntimeException("Stack is Empty");
       }
       return arr[top--];
   }

   public int peek(){
       return top;
   }

   public boolean isFull(){
       return top == capacity-1 ? true : false;
   }

    public boolean isEmpty(){
        return top == -1 ? true : false;
    }

    public static void main(String args[]){
        Stack stack = new Stack(5);
        stack.push(9);
        stack.push(6);
        stack.push(5);
        stack.push(8);
        System.out.println("Peek:"+stack.peek());
        System.out.println("Stack full:"+stack.isFull());
    }
}
