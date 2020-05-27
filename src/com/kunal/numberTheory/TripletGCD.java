package com.kunal.numberTheory;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TripletGCD {
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
            int k = in.nextInt();
            long ans = 0;
            for (int i = 1; i <=k; i++) {
                for (int j = 1; j <= i; j++) {
                    for (int l = j; l <= i ; l++) {
                        long g = gcdMultiple(i,j,l);
                        if (findUnique(i,j,l) == 1) {
                            ans += g;
                        }
                        if (findUnique(i,j,l) == 2) {
                            ans += g*3;
                        }
                        if (findUnique(i,j,l) == 3) {
                            ans += g*6;
                        }
                    }
                }
            }
            out.println(ans);
        }
        private static int findUnique(int a, int b, int c) {
            Set<Integer> set = new HashSet<>();
            set.add(a);
            set.add(b);
            set.add(c);
            return set.size();
        }
        private static int gcd(int a, int b) {
            if (b == 0){
                return a;
            }
            return gcd(b, a % b);
        }

        static int gcdMultiple(int a, int b, int c) {
            return gcd(gcd(a,b), c);
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
