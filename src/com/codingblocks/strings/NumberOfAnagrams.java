package com.codingblocks.strings;

import java.io.*;
import java.util.*;

public class NumberOfAnagrams {
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
            int n = in.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String str = in.next();
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String s = String.valueOf(ch);
                if(map.containsKey(s)){
                    map.put(s, map.get(s) + 1);
                }else{
                    map.put(s, 1);
                }
            }
            int count = 0;
            for (Map.Entry<String, Integer> entry: map.entrySet()){
                count += nCr(entry.getValue());
            }
            out.println(count);
        }
        public static int nCr(int n){
            return n * (n - 1) / 2;
        }
        public static int xor(String a){
            int ans = 0;
            for (int i = 0; i < a.length(); i++) {
                ans ^= a.charAt(i);
            }
            return ans;
        }
        public static boolean check(String a, String b){
            int ans = 0;
            for (int i = 0; i < a.length(); i++) {
                ans ^= a.charAt(i) ^ b.charAt(i);
            }
            return ans == 0;
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
