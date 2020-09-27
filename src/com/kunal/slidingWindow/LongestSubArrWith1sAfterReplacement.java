package com.kunal.slidingWindow;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LongestSubArrWith1sAfterReplacement {
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

    /*
        Time Complexity: O(N)
        Space Complexity: O(1)
    */

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {

        }
        public static int findLength(int[] arr, int k) {
            int start = 0;
            int max = 0;
            int ones = 0;
            for (int end = 0; end < arr.length; end++) {
                if (arr[end] == 1){
                    ones++;
                }
                if (end-start+1 - ones > k){
                    if (arr[start] == 1){
                        ones--;
                    }
                    start++;
                }
                max = Math.max(max, end-start+1);
            }
            return max;
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
