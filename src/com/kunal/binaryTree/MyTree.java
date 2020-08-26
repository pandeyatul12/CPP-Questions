package com.kunal.binaryTree;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MyTree {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
//        int t = in.nextInt();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {

        // tree code here
        public class BinTree{
            private class Node{
                int value;
                Node left;
                Node right;
                public Node(int value) {
                    this.value = value;
                }
            }
            private Node root;

            public void display(){
                display(root, "");
            }
            private void display(Node node, String spacing){
                if (node == null){
                    return;
                }
                System.out.println(spacing + node.value);
                display(node.left, spacing + "\t");
                display(node.right, spacing + "\t");
            }

            public void insert(int val){
                this.root = insert(val, root);
            }
            Queue<Node> queue = new LinkedList<>();
            private Node insert(int val, Node root){
                Node newNode = new Node(val);
                Node temp = null;
                if (!queue.isEmpty()){
                    temp = queue.peek();
                }
                if (root == null){
                    root = newNode;
                }else if(temp != null && temp.left == null){
                    temp.left = newNode;
                }else if (temp != null && temp.right == null) {
                    temp.right = newNode;
                    queue.remove();
                }
                queue.add(newNode);
                return root;
            }

            public void levelOrderTraversal(){
                Queue<Node> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()){
                    int len = queue.size();
                    for (int i = 0; i < len; i++) {
                        Node removed = queue.remove();
                        System.out.print(removed.value + " ");
                        if (removed.left != null) queue.add(removed.left);
                        if (removed.right != null) queue.add(removed.right);
                    }
                    System.out.println();
                }
            }

            public int size(){
                return size(root);
            }
            private int size(Node node){
                if (node == null){
                    return 0;
                }
                return 1 + size(node.left) + size(node.right);
            }
            public int largest(){
                return largest(root);
            }
            private int largest(Node node){
                if (node == null){
                    return Integer.MIN_VALUE;
                }
                int left = largest(node.left);
                int right = largest(node.right);
                return Math.max(node.value, Math.max(left, right));
            }

            public void printLevel(int depth){
                printLevel(root, depth);
            }
            private void printLevel(Node node, int depth) {
                if(node == null){
                    return;
                }
                if(depth >= 0){
                    printLevel(node.left, depth - 1);
                    if(depth == 0){
                        System.out.println(node.value);
                    }
                    printLevel(node.right, depth - 1);
                }
            }

            public int height(){
                return height(root);
            }
            private int height(Node node) {
                if(node == null){
                    return -1;
                }
                return 1 + Math.max(height(node.left), height(node.right));

            }

            public int diameter(){
                if(root == null){
                    return 0;
                }
                return 1 + height(root.left) + height(root.right);
            }

            public boolean find(int value){
                return find(root, value);
            }
            private boolean find(Node node, int value) {
                if(node == null){
                    return false;
                }
                if(node.value == value){
                    return true;
                }
                return find(node.left, value) || find(node.right, value);
            }

        }

        // main code here
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            BinTree tree = new BinTree();
            // 7 4 2 7 1 3 6 9
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                tree.insert(in.nextInt());
            }
//            tree.display();
            tree.levelOrderTraversal();
//            out.println(tree.size());
//            out.println(tree.largest());
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() throws IOException {
            return reader.readLine().trim();
        }
    }
}
