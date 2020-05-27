package com.kunal.numberTheory;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeFactorsTillN {
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
            int[] arr = new int[n+1];
            Arrays.fill(arr, -1);
            arr[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = i; j <= n; j+=i) {
                    if (arr[j] == -1){
                        arr[j] = i;
                    }
                }
            }
//            out.println(Arrays.toString(arr));
            int num = 12; // find prime factors of this
            while (num != 1){
                out.print(arr[num] + " ");
                num = num / arr[num];
            }
            out.println();
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
