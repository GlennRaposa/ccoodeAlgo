package com.timeup.checkout;

final class Parent {
    protected int age;

   /* @Override
    void finalize() throws Throwable{
        System.out.println("finalized() was executed in parent calss");
    }*/
}
/*
class Child extends Parent{

    @Override
    void finalize() throws Throwable{
        System.out.println("finalized() was executed in child calss");
    }

    int compare(Parent parent)throws IllegalArgumentException{
        try{
            if(age >= parent.age){
                throw new IllegalArgumentException("child cant be older than parent");
            }
            return age-parent.age;
        }finally{
            System.out.println("child age"+age);
        }
    }
    final int gender(){
        return 0;
    }
}

class Son extends Child{
    @Override
    void finalize() throws Throwable{
        System.out.println("finalized() was executed in son calss");
    }

    @Override
    final int gender(){
        return -1;
    }
}

class Daughter extends Child{
    @Override
    int gender(){
        return -1;
    }
}
*/