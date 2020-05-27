package com.kunal.recursion;
import java.io.*;
import java.util.StringTokenizer;

public class Permutations {
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
            permu("", s);
        }

        // lexographic order
        public void permu(String p, String u){
            if (u.isEmpty()){
                System.out.println(p);
                return;
            }
            for (int i = 0; i < u.length(); i++) {
                char ch = u.charAt(i);
                String f = u.substring(0, i);
                String l = u.substring(i+1);
                permu(p+ch, f+l);
            }

        }

//        public void permu(String p, String u) {
//            if (u.isEmpty()){
//                System.out.println(p);
//                return;
//            }
//            char ch = u.charAt(0);
//            for (int i = 0; i <= p.length(); i++) {
//                String f = p.substring(0, i);
//                String l = p.substring(i);
//                permu(f + ch + l, u.substring(1));
//            }
//        }
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
