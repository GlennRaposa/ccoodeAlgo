package com.timeup.checkout;

public  class Animal {
    public void move() {
        System .out.println("Animal can move");
    }
}

class Cat extends Animal{
    @Override
    public void move(){
        System .out.println("Cat can walk and run Animal can move");
    }
}
