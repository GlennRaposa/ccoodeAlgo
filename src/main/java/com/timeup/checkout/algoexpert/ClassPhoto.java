package com.timeup.checkout.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Given Two arrays we need Sort
//
public class ClassPhoto {
    //Each Row contains the same numner of students
    // All Students wearing red shirts must be in the same row
    //Each student in the back row must be Taller than the ones in the front row.
    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>();
        redShirtHeights.add(5);
        redShirtHeights.add(8);
        redShirtHeights.add(1);
        redShirtHeights.add(3);
        redShirtHeights.add(4);

        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>();
        blueShirtHeights.add(6);
        blueShirtHeights.add(9);
        blueShirtHeights.add(2);
        blueShirtHeights.add(4);
        blueShirtHeights.add(6);


        System.out.println("Class Photo::"+classPhoto(redShirtHeights,blueShirtHeights));
    }

    //O(nlogn) time | o(1) space- where n is the number of students
    public static boolean classPhoto(ArrayList<Integer> redShirtHeights,ArrayList<Integer> blueShirtHeights){
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        String ShritColorInFirstRow =
                (redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE");

        for(int idx = 0; idx < redShirtHeights.size(); idx++){
            int redShirtHeight = redShirtHeights.get(idx);
            int blueShirtHeight = blueShirtHeights.get(idx);

            if(ShritColorInFirstRow == "RED"){
                if(redShirtHeight >= blueShirtHeight){
                    return false;
                }
            }else{
                if(blueShirtHeight >= redShirtHeight){
                    return false;
                }
            }
        }

        return true;
    }
}
