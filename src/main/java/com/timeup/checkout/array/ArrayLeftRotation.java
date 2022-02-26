package com.timeup.checkout.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//https://www.youtube.com/watch?v=TurKRD6Ne6w
//https://www.hackerrank.com/challenges/ctci-array-left-rotation/forum?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class ArrayLeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] rotArray = new int[n];

        for (int oldIndex = 0; oldIndex < n; oldIndex++) {
            int newIndex = (oldIndex + n - d) % n;
            System.out.println("newIndex ::"+newIndex);
            rotArray[newIndex] = a[oldIndex];
        }
        return rotArray;
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int n =  a.size();
        Integer [] rotatedArray = new Integer[n];

        for(int oldindex=0; oldindex< n; oldindex++){
            int newIndex = (oldindex +(n-d))%n;
            rotatedArray[newIndex] = a.get(oldindex);
        }
        return Arrays.asList(rotatedArray);
    }

    public static void main(String[] args) {

        int d = 2;
        int a[] = {1,2,3,4,5};

        int res[] = rotLeft(a, d);

        Arrays.asList(res);
        System.out.println(Arrays.toString(res));
    } 

   /* public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        List<Integer> list  = new ArrayList<Integer>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);
        list.add(4,5);
        rotLeft(list, 4).stream().forEach(System.out::println);
    }

    public static List<Integer> rotLeft(List<Integer> currentList, int d) {
        int arrLength = currentList.size() -1;
        List<Integer> newList = new ArrayList<Integer>(arrLength);
        int rotation = d;
        for(int aIndex =0; aIndex<arrLength;aIndex++){
            int newIndex = (aIndex + arrLength-rotation) % arrLength;
            System.out.println("aIndex:"+aIndex+" newIndex:"+newIndex+" currentValue:"+currentList.get(aIndex));
            newList.add(newIndex, currentList.get(aIndex));
        }
        return newList;
    }*/
}
