package com;

import java.util.Stack;

/**
 * Demo of Stack data structure
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
public class StackDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Stack: "+stack);
        showPush(stack, 42);
        showPush(stack, 66);
        showPush(stack, 99);
        showPop(stack);
        showPop(stack);
        showPop(stack);
        try {
            showPop(stack);
        } catch (Exception e){
            System.out.println("empty stack");
        }
        
    }
    
    static void showPush(Stack stack, int a){
        stack.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("Stack: "+stack);
    }
    
    static void showPop(Stack stack){
        System.out.print("pop -> ");
        Integer a = (Integer) stack.pop();
        System.out.println(a);
        System.out.println("Stack: "+stack);
    }
}
