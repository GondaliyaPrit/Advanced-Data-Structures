package com.prit.Tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        Node root = gettree();
        System.out.println("Countof lraf ===>" + CountleafNode(root));

    }

    public static Node gettree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;

        return root;
    }


    

    public static  int CountleafNode(Node root)
    {
        if(root == null )
        {
            return  0;
        }
        if(root.left== null && root.right == null)
        {
            return 1;
        }
        return  CountleafNode(root.left)+CountleafNode(root.right);
    }
}

