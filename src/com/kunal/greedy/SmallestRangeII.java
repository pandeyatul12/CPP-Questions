package com.kunal.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// https://leetcode.com/problems/smallest-range-ii/
public class SmallestRangeII {
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
        public int smallestRangeII(int[] A, int K) {
            Arrays.sort(A);
            int ans = A[A.length - 1] - A[0];
            for (int i = 0; i < A.length - 1; i++) {
                int max = Math.max(A[A.length-1] - K, A[i] + K);
                int min = Math.min(A[0] + K, A[i+1] - K);
                if ((max - min) < ans) {
                    ans = max - min;
                }
            }
            return ans;
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
