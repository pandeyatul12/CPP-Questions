package com.kunal.slidingWindow;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class LongestSubstringKDistinct {
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

        }
        public static int findLength(String str, int k) {
            int start = 0;
            int max = -1;
            Map<Character, Integer> freq = new HashMap<>();
            for (int end = 0; end < str.length(); end++) {
                char ch = str.charAt(end);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                while (freq.keySet().size() == k+1){
                    freq.put(str.charAt(start), freq.get(str.charAt(start)) - 1);
                    if (freq.get(str.charAt(start)) == 0){
                        // remove
                        freq.remove(str.charAt(start));
                    }
                    start++;
                }
                max = Math.max(max, end-start+1);
            }
            return max;
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
