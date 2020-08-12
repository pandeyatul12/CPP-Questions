package com.kunal.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// https://leetcode.com/problems/non-overlapping-intervals/
public class NonOverlappingIntervals {
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
            int[][] arr = {};
            out.println(eraseOverlapIntervals(arr));
        }
        public int eraseOverlapIntervals(int[][] intervals) {
            int count = 0;
            if(intervals.length == 0){
                return count;
            }
            // Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            int checkE = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (start < checkE) {
                    // remove this
                    count++;
                }else{
                    checkE = end;
                }
            }
            return count;
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
