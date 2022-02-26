package com.timeup.checkout.algoexpert;

//https://www.youtube.com/watch?v=uYWxgNFJDPg
//https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
public class ClosestElementInBST {

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

        int closestElementNode = findClosestvalueInBst(root, 14);
        System.out.println("closestElementNode ::"+closestElementNode);
    }




    public static int findClosestvalueInBst(Node tree, int target){
        return findClosestValueInBst(tree, target, tree.data);
    }

    public static int findClosestValueInBst(Node tree, int target, int closest){
        if(Math.abs(target - closest) > Math.abs(target - tree.data)){
            closest = tree.data;
        }

        if(target < tree.data && tree.left != null){
            return findClosestValueInBst(tree.left, target, closest);
        }else if (target > tree.data && tree.right != null){
            return findClosestValueInBst(tree.right, target, closest);
        }else{
            return closest;
        }
    }

}
