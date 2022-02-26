package com.timeup.checkout.algoexpert;

//Check if tree is a validate binary search tree
public class BinarySearchTreeIsValidBST {

    static boolean checkBST(Node root){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


   // O(n) Time Complexity | Space complixity LogN
    static boolean checkBST(Node root, int min, int max){
        //Base Case
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return true;
        }
        return checkBST(root.left, min, root.data -1) && checkBST(root.right, root.data +1, max);
    }


    /* Inorder traversal of a binary tree*/
    //InOrder - Left -> Root -> Right
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
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

        inorder(root);
        System.out.println(checkBST(root));
    }
}
