package com.timeup.checkout.algoexpert;

//Implementing a Binary Tree
public class Node {
    public int data;
    public Node left;
    public Node right;


    public Node(int data){
        this.data = data;
    }

    public void insert(int value){
        //Value less than data insert to the left
        if(value <= data){
            if(left == null){
                left = new Node(value);
            }else{
                left.insert(value);
            }
        }else{ // value greater than data insert to the right
            if(right == null){
                right = new Node(value);
            }else{
                right.insert(value);
            }
        }
    }

    public boolean contains(int value){
        if(value == data){
            return true;
        }else if(value < data){ //Left
            if(left == null){
                return false;
            }else{
                return left.contains(value);
            }
        }else{ //Right
            if(right == null){
                return false;
            }else{
                return right.contains(value);
            }
        }
    }


    public void printInOrderTraversal(){
        if(left != null){
            left.printInOrderTraversal();
        }
        System.out.println(data);
        if(right != null){
            right.printInOrderTraversal();
        }
    }

    public static void main(String args[]){
             /*
                8
               / \
              6    15
             / \   / \
            2  7  12  20
            \
            5
         */
        Node root = new Node(8);
        root.insert(6);
        root.insert(15);
        root.insert(2);
        root.insert(7);
        root.insert(12);
        root.insert(20);
        //root.printInOrderTraversal();
        System.out.println("Result :"+root.contains(12));
    }
}
