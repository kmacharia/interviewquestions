package com;

import java.util.HashSet;

/**
 * Remove duplicates from an unsorted linked list
 * https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class RemoveDuplicatesList {
    
    static class Node {
        int data;
        Node next;
        
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    
    static Node head;
    
    public static void main (String args[]){
        //The constructed linked list is: 10->12->11->11->12->11->10
        RemoveDuplicatesList list = new RemoveDuplicatesList();
        list.head = new Node(10);
        list.head.next =new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next= new Node(11);
        list.head.next.next.next.next.next.next=new Node(10);
        
        System.out.print("Linked list with duplicates: ");
        list.printList(head);
        
//        list.remove_duplicates();
        list.remove_duplicates(head);
        System.out.println(""); 
        System.out.print("Linked List after removing duplicates: "); 
        list.printList(head); 
    }
    
    void printList(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    void remove_duplicates(Node head){
//    void remove_duplicates(){
//        Node ptr1 = head, ptr2 = null, dup =null;        
//        while(ptr1!=null && ptr1.next!=null){
//            ptr2 = ptr1;
//            while (ptr2.next!=null) {                
//                if(ptr1.data == ptr2.next.data){
//                    dup =ptr2.next;
//                    ptr2.next = ptr2.next.next;
//                    System.gc();
//                } else {
//                    ptr2 = ptr2.next;
//                }
//            }
//            ptr1 = ptr1.next;
//        }
//    Time Complexity of above is O(n^2)

        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while(current!=null){
            int currentData =current.data;
            if(hs.contains(currentData)){
                prev.next = current.next;
            } else {
                hs.add(currentData);
                prev = current;
            }
            current = current.next;
        }
    }
}
