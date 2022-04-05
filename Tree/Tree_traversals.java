
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
        System.out.print("PreOreder ====> ");
        preorder(root);
        System.out.println("");
        System.out.print("InOrder ====>");
        inorder(root);
        System.out.println("");
        System.out.print("postorder ====>");
        postorder(root);
        System.out.println("");
        System.out.print("Levelorder ====>");
        Levelorder(root);

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


    public static void preorder(Node root) {
        if (root == null) {

            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void Levelorder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}

