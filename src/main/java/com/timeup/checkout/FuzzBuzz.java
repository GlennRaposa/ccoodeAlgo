package com.timeup.checkout;

public class FuzzBuzz {
    private static final String FUZZBUZZ = "FUZZBUZZ";
    private static final String FUZZ ="FUZZ";
    private static final String BUZZ = "BUZZ";

    public static void main(String args[]){
        FuzzBuzz fuzzBuzz = new FuzzBuzz();
        int num = 100;
        fuzzBuzz.printFuzzBuzz(num);
    }

    private void printFuzzBuzz(int num){
        //IF divided by 3 = FUZZ   IF divided by 5=BUZZ if with both then FUZZBUZZ
        for(int i = 0; i<=num; i++){
            if(i%3 ==0 && i%5==0){
                System.out.println("FUZZBUZZ");
            }else if(i%5 == 0){
                System.out.println("BUZZ");
            }else if(i%3 == 0){
                System.out.println("FUZZ");
            }else{

            }
        }
    }
}
