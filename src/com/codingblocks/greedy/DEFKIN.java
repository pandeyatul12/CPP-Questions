package com.codingblocks.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DEFKIN {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int t = in.nextInt();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            for (int i = 0; i < testNumber; i++) {
                int w = in.nextInt();
                int h = in.nextInt();
                int n = in.nextInt();
                if (n == 0){
                    continue;
                }
                int[] x = new int[n+1];
                int[] y = new int[n+1];
                for (int j = 0; j < n; j++) {
                    x[j] = in.nextInt();
                    y[j] = in.nextInt();
                }
                Arrays.sort(x);
                Arrays.sort(y);
                x[0] = x[1] - 1;
                y[0] = y[1] - 1;
                for (int j = 1; j < n; j++) {
                    x[j] = x[j+1] - x[j] - 1;
                    y[j] = y[j+1] - y[j] - 1;
                }
                x[n] = w - x[n];
                y[n] = h - y[n];
                int ans = findMax(x) * findMax(y);
                out.println(ans);
            }
        }
        public static int findMax(int[] arr){

            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max){
                    max = arr[i];
                }
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
