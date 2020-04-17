package com.codingblocks.numberTheory;

import java.io.*;
import java.util.StringTokenizer;

public class FermatsTheorem {
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
            String a = in.next();
            String b = in.next();
            long mod = 1000000007;
            long x = stringToInt(a, mod);
            long y = stringToInt(b, mod-1);

            long ans = power(x, y, mod);
            out.println(ans);
        }

        private long power(long x, long y, long m){
            if (y == 0){
                return 1;
            }
            // recursive x^(y/2)
            long smallPower = power(x, y/2, m);
            smallPower = smallPower % m;
            smallPower = (smallPower * smallPower) % m;

            // if y is odd
            if ((y&1) == 1){
                return (x * smallPower)%m;
            }
            return smallPower;
        }

        private long stringToInt(String str, long m) {
            long ans = 0;
            for (int i = 0; i < str.length(); i++) {
                ans = (ans * 10) % m + (str.charAt(i) - '0');
                ans %= m;
            }
            return ans;
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
