package com.timeup.checkout.algoexpert;

public class LinkedListRemoveDupNodes {

    public static void main(String args[]){
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(2);
        head.next.next.next = new LinkedNode(3);
        head.next.next.next.next = new LinkedNode(3);
        head.next.next.next.next.next = new LinkedNode(9);
        LinkedNode resultNode = deleteDuplicate(head);
        while (resultNode != null) {
            System.out.println("Current node value:" + resultNode.val);
            resultNode = resultNode.next;
        }

    }

    public static LinkedNode deleteDuplicate(LinkedNode head){
        LinkedNode current_node = head;
        while(current_node != null && current_node.next !=null){
            if(current_node.val == current_node.next.val){
                current_node.next = current_node.next.next;
            }else{
                current_node = current_node.next;
            }
        }
        return head;
    }
}
