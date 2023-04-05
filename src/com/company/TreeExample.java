package com.company;

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

        Node findValue = root.find(7);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.find(13);
        System.out.println(findValue != null ? findValue.value : "null");

        findValue = root.find(300);
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

    public Node find(int value){
        if(this.value == value)
            return this;
        else if(this.value > value && this.left != null)
            return left.find(value);
        else if(this.value < value && this.right != null)
            return right.find(value);
        else
            return null;
    }
}
