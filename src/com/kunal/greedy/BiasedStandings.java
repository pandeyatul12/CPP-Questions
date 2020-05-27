package com.kunal.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BiasedStandings {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        long t = in.nextLong();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(long testNumber, InputReader in, PrintWriter out) throws IOException {
            for (long i = 0; i < testNumber; i++) {
                int n = in.nextInt();
                long[] arr = new long[n];
                for (int j = 0; j < n; j++) {
                    String name = in.next();
                    arr[j] = in.nextLong();
                }
                long[] ranks = new long[n+1];
                for (int j = 0; j < n; j++) {
                   ranks[(int) arr[j]] ++;
                }
                long s=1, c=1;
                long counts = 0;
                while (s <= n){
                    if (ranks[(int) s] > 0) {
                        counts += Math.abs(s - c);
                        ranks[(int) s]-=1;
                        c += 1;
                    }else {
                        s += 1 ;
                    }
                }
                out.println(counts);
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
