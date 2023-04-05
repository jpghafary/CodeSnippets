package com.codinggame;

public class TreeExample {

    public static void main(String args[]){
        Node root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.right.right = new Node(14);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right.right.left = new Node(13);

        root.print("", root, false);

        Node findValue = root.findRecursive(7);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.findRecursive(13);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.findRecursive(300);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.findIterative(7);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.findIterative(13);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.findIterative(300);
        System.out.println(findValue != null ? findValue.value : "null");

    }
}

class Node{
    Node left;
    Node right;
    int value;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println (prefix + ("|-- ") + n.value);
            print(prefix + "     ", n.left, true);
        }
    }

    public Node findRecursive(int value){
        if(this.value == value)
            return this;
        else if(this.value > value && this.left != null)
            return left.findRecursive(value);
        else if(this.value < value && this.right != null)
            return right.findRecursive(value);
        else
            return null;
    }

    public Node findIterative(int value){
        Node n = this;
        while(n != null){
            if(value > n.value)
                n = n.right;
            else if(value < n.value)
                n = n.left;
            else
                return n;
            }
        return null;
    }
}
