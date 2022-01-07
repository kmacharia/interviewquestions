package com;

/**
 *
 * Check whether Binary tree or not
 * 
 * @author Ken Macharia <https://github.com/kmacharia>
 */
class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {

    Node root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(4);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.left = new Node(1);
        binaryTree.root.left.right = new Node(3);

        if (binaryTree.isBST()) {
            System.out.println("Is binary tree");
        } else {
            System.out.println("Not binary tree");
        }
    }

    boolean isBST() {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBstUtil(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBstUtil(node.left, min, node.data - 1) && isBstUtil(node.right, node.data + 1, max));
    }
}
