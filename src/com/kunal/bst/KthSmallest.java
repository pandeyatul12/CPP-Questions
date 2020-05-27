package com.kunal.bst;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

public class KthSmallest {

    static int count = 0;

    public static Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    // Function to find k'th largest element in BST
    // Here count denotes the number
    // of nodes processed so far
    public static Node kthSmallest(Node root, int k) {
        if (root == null)
            return null;

        // search in left subtree
        Node left = kthSmallest(root.left, k);

        // if k'th smallest is found in left subtree, return it
        if (left != null)
            return left;

        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;

        // else search in right subtree
        return kthSmallest(root.right, k);
    }

    public static void printKthSmallest(Node root, int k) {
        count = 0;
        Node res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less "
                    + "than k nodes in the BST");
        else
            System.out.println("K-th Smallest"
                    + " Element is " + res.data);
    }

    public static void main(String[] args) {
        Node root = null;
        int[] keys = {20, 8, 22, 4, 12, 10, 14};

        for (int x : keys)
            root = insert(root, x);

        int k = 3;
        printKthSmallest(root, k);
    }
}