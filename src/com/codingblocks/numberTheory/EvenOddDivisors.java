package com.codingblocks.numberTheory;

import java.io.*;
import java.util.StringTokenizer;

public class EvenOddDivisors {
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
                int n = in.nextInt();
                int[] sum = new int[100001];
                for (int j = 1; j <= 100000; j++) {
                    // k is multiple of j, j is divisor of i
                    for (int k = j; k <= 100000; k+=j) {
                        if (j % 2 == 0){
                            sum[k] += j;
                        }else {
                            sum[k] -= j;
                        }
                    }
                }
                out.println(sum[n]);
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
