package com;

/**
 * Add two numbers represented by linked lists
 * Based on https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class LinkedListSum {
    class Node {
        int val;
        Node next;
        
        public Node(int val){
            this.val =val;
        }
    }
    
    Node head1, head2, result, subhead1;
    int carry;
    
    public static void main(String[] args){
        LinkedListSum list = new LinkedListSum();
        list.head1 = null;
        list.head2 = null;
        list.result =null;
        list.carry = 0;        
        
        int arr1[] = {9,9,9};
        int arr2[] = {1,8};
        
        for(int i = arr1.length-1; i>=0; i--){
            list.push(arr1[i], 1);
        }
        
        for(int i=arr2.length-1; i>=0; i--){
            list.push(arr2[i], 2);
        }
        
        list.addLists();
        list.printList(list.result);
    }
    
    void push(int val, int list){
        //vals comming in reverse order. Node eventually in original order
        Node newnode = new Node(val);
        switch (list) {
            case 1:
                newnode.next = head1;
                head1 = newnode;
                break;
            case 2:
                newnode.next = head2;
                head2 = newnode;
                break;
            default:
                newnode.next = result;
                result = newnode;
                break;
        }
    }
    
    void addLists(){
        if(head1==null){
            result = head2;
            return;
        }
        if(head2==null){
            result = head1;
            return;
        }
        
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        
        if(size1 == size2){
            addSameSizeLists(head1, head2);
        } else {
            //First list to be larger than second list
            //If not, swap pointers
            if(size1<size2){
                Node temp = head1;
                head1 = head2;
                head2 = temp;
                //no need to swap sizes
            }
            int diff = Math.abs(size1-size2);
            
            //move diff number of nodes to have node sublist being equal in size to head2
            Node temp = head1;            
            while(diff-- >=0){
                subhead1 = temp;
                temp = temp.next;
            }
            addSameSizeLists(subhead1, head2);
            
            //get addition of remaining first list and carry
            propagateCarry(head1);
        }
        
        //if some carry is still there, add a new node to the front of result list
        // e.g in adding 999 and 87
        if(carry > 0){
            push(carry, 3);
        }
    }
    
    int getSize(Node node){
        int count = 0;
        while (node!=null) {
            count++;
            node = node.next;            
        }
        return count;
    }
    
    void addSameSizeLists(Node node1, Node node2){
        if(node1==null){//or node2
            return;
        }
        addSameSizeLists(node1.next, node2.next);
        int sum = node1.val + node2.val + carry;
        carry = sum/10;
        sum = sum%10;
        
        push(sum, 3);
    }
    
    void propagateCarry(Node head1){
        if(head1!=subhead1){
            propagateCarry(head1.next);
            int sum = carry + head1.val;
            carry = sum/10;
            sum%=10;
            
            push(sum, 3);
        }
    }
    
    void printList(Node list){
        while(list!=null){
            System.out.print(list.val+ " ");
            list = list.next;
        }
    }
}
