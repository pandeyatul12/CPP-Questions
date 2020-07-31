package com.kunal.greedy;

import java.io.*;
import java.util.StringTokenizer;
// https://leetcode.com/problems/delete-columns-to-make-sorted/
public class DeleteColumns {
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
            int n = in.nextInt();
            String[] A = new String[n];
            for (int i = 0; i < n; i++) {
                A[i] = in.next();
            }
            int count = 0;
            for (int i = 0; i < A[0].length(); i++) {
                char ch = A[0].charAt(i);
                for (int j = 1; j < A.length; j++) {
                    char temp = A[j].charAt(i);
                    if (temp < ch){
                        count++;
                        break;
                    }
                    ch = temp;
                }
            }
            System.out.println(count);
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
