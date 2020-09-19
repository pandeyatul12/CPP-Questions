package com.kunal.twoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class RemoveDuplicates {
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

        }

        public static int remove(int[] arr) {
            int nextNonDup = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[nextNonDup-1] != arr[i]){
                    arr[nextNonDup] = arr[i];
                    nextNonDup++;
                }
            }
            return nextNonDup;
        }

        public static int remove(int[] arr, int key) {
            int placeHere = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != key){
                    arr[placeHere] = arr[i];
                    placeHere++;
                }
            }
            return placeHere;
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
