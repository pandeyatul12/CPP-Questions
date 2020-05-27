package com.kunal.recursion;

import java.io.*;
import java.util.StringTokenizer;

public class SmartKeypadI {
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
        String[] table;
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            String num = in.next();
            table = new String[]{" ", ".+@$", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans("", num);
        }

        public void ans(String p, String u){
            if (u.isEmpty()){
                System.out.println(p);
                return;
            }
            int num = Integer.parseInt(u.charAt(0)+ "");
            String s = table[num];
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                ans(p+ch, u.substring(1));
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
