package com.codingblocks.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumCircles {
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
            int[][] circles = new int[n][2];
            for (int i = 0; i < n; i++) {
                circles[i][0] = in.nextInt();
                circles[i][1] = in.nextInt();
            }
            int count = 0;
            int prevC = circles[0][0];
            int prevR = circles[0][1];
            for (int i = 1; i < n; i++) {
                int c = circles[i][0];
                int r = circles[i][1];
                if (prevC+prevR > c-r) {
                    // overlaps with prev one so remove this
                    count++;
                }else{
                    prevC = c;
                    prevR = r;
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
