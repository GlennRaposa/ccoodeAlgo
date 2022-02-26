package com.timeup.checkout.algoexpert;

/*
 Class to Append, PrePend, Delete from Linked list
 */
public class LinkedListImpl {
    LinkedNode head;

    public void append(int data){
        if(head == null){
            head = new LinkedNode(data);
        }
        LinkedNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new LinkedNode(data);
    }

    public void prepend(int data){
        LinkedNode newHead = new LinkedNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data){
        if(head == null)return;
        if(head.val == data){
            head = head.next;
            return;
        }
        LinkedNode current = head;
        while(current.next != null){
            if(current.next.val == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String args[]){
        //Append Values
        LinkedListImpl linkedListImpl = new LinkedListImpl();
        linkedListImpl.append(2);
        linkedListImpl.append(3);
        linkedListImpl.append(4);
        linkedListImpl.append(5);

        //Print Values of Linked list
       /* while(linkedListImpl.head.next != null)
        {
            System.out.println("PRINT LINKED LIST VALUE"+linkedListImpl.head.next.val);
            linkedListImpl.head = linkedListImpl.head.next;
        } */

        //PREPEND TEST
        linkedListImpl.deleteWithValue(5);
        //Print Values of Linked list
        while(linkedListImpl.head.next != null)
        {
            System.out.println("PREPEND VALUE"+linkedListImpl.head.next.val);
            linkedListImpl.head = linkedListImpl.head.next;
        }
    }




}
