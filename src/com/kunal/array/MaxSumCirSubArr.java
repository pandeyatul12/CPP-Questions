package com.kunal.array;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MaxSumCirSubArr {
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
            out.println(kadanes(new int[]{-2,-3,-1}));
            out.println(kadanesMin(new int[]{-2,-3,-1}));
        }
        public int maxSubarraySumCircular(int[] A) {
            int maxSum = kadanes(A);
            if (maxSum < 0){
                return maxSum;
            }
            int min = kadanesMin(A);
            int sum = 0;
            for(int a : A){
                sum += a;
            }
            int case2 = sum - min;
            return Math.max(maxSum, case2);
        }
        public int kadanes(int[] arr){
            int curr = 0;
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                curr = arr[i] + Math.max(curr, 0);
                ans = Math.max(ans, curr);
            }
            return ans;
        }
        public int kadanesMin(int[] arr){
            int curr = 0;
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                curr = arr[i] + Math.min(curr, 0);
                ans = Math.min(ans, curr);
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
