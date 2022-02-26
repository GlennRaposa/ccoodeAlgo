package com.timeup.checkout.algoexpert;

import java.util.ArrayList;
import java.util.List;

//Summing Branches in a BST
public class BinaryTree_BranchSums {

    public static List<Integer> branchSums(Node root) {
        List<Integer> sumsList =  new ArrayList<Integer>();
        return branchSums(root, 0, sumsList);
    }

    public static List<Integer> branchSums(Node root, int sum, List<Integer> sumsList) {
        if(root == null){
            return sumsList;
        }
        //sum = sum+root.value
        sum = sum + root.data;
        if(root.left == null && root.right == null){
            //Leaf node
            sumsList.add(sum);
        }
        if(root.left !=null){
            branchSums(root.left, sum, sumsList);
        }
        if(root.right !=null){
            branchSums(root.right, sum, sumsList);
        }
        return sumsList;
    }


    public static void main(String[] args) {
        /*
                8
               / \
              6    15
             / \   / \
            2  7  12  20
            \
            5
         */

        Node root = null;
        NodeUtil a = new NodeUtil();

        root = a.insert(root, 8);
        root = a.insert(root, 15);
        root = a.insert(root, 6);
        root = a.insert(root, 2);
        root = a.insert(root, 7);
        root = a.insert(root, 20);
        root = a.insert(root, 5);
        root = a.insert(root, 12);

        List<Integer> sumslist = branchSums(root);
        sumslist.stream().forEach(System.out::println);
    }
}
