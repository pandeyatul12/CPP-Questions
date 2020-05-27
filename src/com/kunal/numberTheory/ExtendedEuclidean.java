package com.kunal.numberTheory;

import java.io.*;
import java.util.StringTokenizer;

public class ExtendedEuclidean {
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
        int x, y, gcd;
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            int a = 18;
            int b = 30;
            // find solution for ax + by = gcd(a,b)
            extendedEuclidean(a, b);
            out.print(a + " * " + x + " + " + b + " * " + y + " = " + gcd);
        }
        public int gcd(int a, int b){
            if (b == 0){
                return a;
            }
            return gcd(b, a % b);
        }
        public void extendedEuclidean(int a, int b){
            if (b == 0){
                x = 1;
                y = 0;
                gcd = a;
                return;
            }
            extendedEuclidean(b, a % b);
            int cX = y;
            int cY = x - (a/b)*y;
            x = cX;
            y = cY;
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
