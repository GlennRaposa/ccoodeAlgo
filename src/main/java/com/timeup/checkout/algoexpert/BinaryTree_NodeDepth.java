package com.timeup.checkout.algoexpert;

public class BinaryTree_NodeDepth {

    public static int maxDepth(Node root){

        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) +1;
    }

    public static void main(String[] args) {
        /*
                3
               / \
              9    20
                   / \
                  15  7


         */

        Node root = null;
        NodeUtil a = new NodeUtil();

        root = a.insert(root, 3);
        root = a.insert(root, 20);
        root = a.insert(root, 9);
        root = a.insert(root, 15);
        root = a.insert(root, 7);

        int maxDepth = maxDepth(root);
        System.out.println("maxDepth ::"+maxDepth);
    }
}
