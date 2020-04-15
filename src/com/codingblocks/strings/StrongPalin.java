package com.codingblocks.strings;

import java.io.*;
import java.util.StringTokenizer;

public class StrongPalin {
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
            String s = in.next();
            String l = s.substring(0, (s.length() - 1)/2);
            String r = s.substring((s.length() + 3) / 2 - 1);
            if (isPalin(s) && isPalin(l) && isPalin(r)){
                out.println("Yes");
            }else{
                out.println("No");
            }
        }
        public static boolean isPalin(String s){
            int start = 0;
            int end = s.length() - 1;
            return isPalin(s, start, end);
        }

        private static boolean isPalin(String s, int start, int end) {
            if (start > end){
                return true;
            }
            return (s.charAt(start) == s.charAt(end)) && isPalin(s, start+1, end-1);
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
