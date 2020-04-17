package com.codingblocks.adhoc;

import java.io.*;
import java.util.StringTokenizer;

public class CitySavers {
    // https://atcoder.jp/contests/abc135/tasks/abc135_c
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
            long[] towns = new long[n+1];
            long[] heroes = new long[n];
            for (int i = 0; i < n+1; i++) {
                towns[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                heroes[i] = in.nextLong();
            }
            long count = 0;
            for (int i = n-1; i >= 0; i--) {
                if (towns[i+1] < heroes[i]){
                    count += towns[i+1];
                    heroes[i] -= towns[i+1];
                    long min = Math.min(towns[i], heroes[i]);
                    count += min;
                    towns[i] -= min;
                }else{
                    count+= heroes[i];
                    towns[i+1] -= heroes[i];
                }
            }
            out.println(count);
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
