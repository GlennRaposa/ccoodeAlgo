package com.timeup.checkout.array;

public class CountingValley {

    public static void main(String args[]){

        System.out.println("Valleys::"+countingValleys(8, "UDDDUDUU"));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int valley = 0;
        int altitude = 0;
        for (int i = 0; i < path.length(); i++) {
            if('U' == path.charAt(i)){
                altitude++;
                if(altitude == 0){
                    valley++;
                }
            }else{
                altitude--;
            }
        }
        return valley;

    }
}
