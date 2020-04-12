package com.codingblocks.divideNconquer;

import java.io.*;
import java.util.StringTokenizer;

public class SimpleEnough {
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
        int l, r;
        int count = 0;
        int ones = 0;

        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            int n = in.nextInt();
            l = in.nextInt();
            r = in.nextInt();
            ans(n);
            out.println(ones);
        }

        public void ans(int n) {
            if (n == 1 || n == 0) {
                count++;
                if (n == 1) {
                    if (count >= l && count <= r) {
                        ones++;
                    }
                }
                return;
            }
            // check how much will be in this subtree
            double val;
            int digits = (int) ((Math.log(n) / Math.log(2))+ 1);
            if(isPowerof2(n)){
                val = Math.pow(2, digits-1) - 1;
            } else{
                val = Math.pow(2, digits) - 1;
            }

            if (count > r) {
                return;
            }

            if (count+val >= 0 && count+val < l) {
                count += val;
                return;
            }
            ans(n/2);
            ans(n%2);
            ans(n/2);
        }

        private boolean isPowerof2(int n) {
            return (n & (n-1)) == 1;
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
