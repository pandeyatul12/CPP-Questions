package com.kunal.numberTheory;

import java.io.*;
import java.util.StringTokenizer;
// https://www.spoj.com/problems/DCEPC11B/
public class NFactModP {
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
                long n = in.nextLong();
                long p = in.nextLong();
                if (n >= p){
                    out.println(0);
                }else{
                    out.println(ans(n, p));
                }
            }
        }

        private long ans(long n, long p) {
            long ans = -1;
            for (long i = n+1; i <= p-1; i++) {
                long temp = fastModuleExp(i, p-2, p);
                ans = (ans * temp) % p;
            }
            return (ans+p); // to return a positive answer
        }

        public static long fastModuleExp(long a, long b, long m){
            long res = 1;
            while (b > 0){
                if ((b & 1) == 1){
                    res = (res*a)%m;
                }
                b = b >> 1;
                a = (a*a)%m;
            }
            return res;
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
