package com.codingblocks.adhoc;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximalValue {
    // https://atcoder.jp/contests/abc140/tasks/abc140_c
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
            int[] b = new int[n-1];
            for (int i = 0; i < n - 1; i++) {
                b[i] = in.nextInt();
            }

            int[] a = new int[n];
            a[0] = b[0];
            a[1] = b[0];
            for (int i = 1; i < b.length; i++) {
                a[i+1] = b[i];
                if (a[i] > b[i]){
                    a[i] = b[i];
                }
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }
//            out.println(Arrays.toString(a));
            out.println(sum);
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
