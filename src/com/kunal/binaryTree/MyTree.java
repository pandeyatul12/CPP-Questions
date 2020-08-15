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
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            // main code here
            BinTree tree = new BinTree();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                tree.insert(in.nextInt());
            }
            tree.display();
        }

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
