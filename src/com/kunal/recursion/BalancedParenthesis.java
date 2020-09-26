package com.kunal.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BalancedParenthesis {
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
        int n;
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            n = in.nextInt();
            ans("",0,0);
            List<String> list = new ArrayList<>();
            ansList("", 0, 0, list);
            out.println(list);
        }

        private void ansList(String str, int open, int close, List<String> list) {
            if (close == n) {
                list.add(str);
                return;
            }
            if (open < n) {
                ansList(str+"(", open+1, close, list);
            }
            if (close < open) {
                ansList(str + ")", open, close+1, list);
            }
        }

        private void ans(String s, int open, int closed) {
           if (closed == n){
               System.out.println(s);
               return;
           }
           if (open < n){
               ans(s + "(",open + 1, closed);
           }
           if (closed < open){
               ans(s + ")",open, closed+1);
           }
        }

        public List<String> generateParenthesis(int n) {
            return generateParenthesis(n, 0, 0, "");
        }

        private List<String> generateParenthesis(int n, int open, int closed, String s) {
            if (closed == n) {
                List<String> list = new ArrayList<>();
                list.add(s);
                return list;
            }

            List<String> ans = new ArrayList<>();

            if (open < n) {
                ans.addAll(generateParenthesis(n, open+1, closed, s+"("));
            }
            if (closed < open) {
                ans.addAll(generateParenthesis(n, open, closed+1, s+")"));
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
