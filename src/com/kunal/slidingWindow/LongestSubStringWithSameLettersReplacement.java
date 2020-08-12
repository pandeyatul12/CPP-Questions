package com.kunal.slidingWindow;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestSubStringWithSameLettersReplacement {
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
        public int characterReplacement(String s, int k) {
            int start = 0;
            int max = 0;
            int maxLen = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                maxLen = Math.max(maxLen, map.get(ch));

                // condition violated
                if (end-start+1 - maxLen > k){
                    char first = s.charAt(start);
                    map.put(first, map.get(first) - 1);
                    start++;
                }
                // NOTE: this works because, the subarray size all the time will be = max so far if the condition is
                // violated (as we are doing start++)
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
