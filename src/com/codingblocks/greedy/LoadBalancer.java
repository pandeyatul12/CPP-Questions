package com.codingblocks.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LoadBalancer {
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
            while (true) {
                int n = in.nextInt();
                if (n == -1) {
                    break;
                }
                long[] arr = new long[n];
                long load = 0;
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextLong();
                    load += arr[i];
                }
                if (load % n != 0) {
                    out.println(-1);
                    continue;
                }
                load = load / n;
                long max_load = 0;
                long diff = 0;
                for (int i = 0; i < n; i++) {
                    diff += (arr[i] - load);
                    long ans = Math.abs(diff);
                    max_load = Math.max(max_load, ans);
                }
                out.println(max_load);
            }
        }
        public static long sum(long[] arr){
            long sum = 0;
            for (long value : arr) {
                sum += value;
            }
            return sum;
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
