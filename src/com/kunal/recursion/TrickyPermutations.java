package com.kunal.recursion;

import java.io.*;
import java.util.*;

public class TrickyPermutations {
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
        Set<String> set = new HashSet<>();
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            String s = in.next();
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = String.valueOf(ch);
            permu("", s);
        }

        private void permu(String p, String u) {
            if (u.isEmpty()){
                if (!set.contains(p)){
                    System.out.println(p);
                    set.add(p);
                }
                return;
            }
            for (int i = 0; i < u.length(); i++) {
                char ch = u.charAt(i);
                String f = u.substring(0, i);
                String l = u.substring(i+1);
                permu(p+ch, f+l);
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
