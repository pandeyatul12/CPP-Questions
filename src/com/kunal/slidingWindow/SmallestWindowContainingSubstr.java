package com.kunal.slidingWindow;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
// https://leetcode.com/problems/minimum-window-substring/
public class SmallestWindowContainingSubstr {
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

    /*
        Time Complexity: O(N + M)
        Space Complexity: O(M) and O(N) to store result when the input string is a permutation of the pattern.
    */

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {

        }
        public String minWindow(String str, String pattern) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : pattern.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int windowStart = 0;
            int subStrStart = 0;
            int matched = 0;
            int minLength = str.length() + 1;
            for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
                char ch = str.charAt(windowEnd);
                if (map.containsKey(ch)){
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) >= 0){
                        matched++;
                    }
                }

                while (matched == pattern.length()){
                    if (minLength > windowEnd-windowStart+1){
                        minLength = windowEnd-windowStart+1;
                        subStrStart = windowStart;
                    }
                    // remove
                    char first = str.charAt(windowStart);
                    if (map.containsKey(first)){
                        if (map.get(first) == 0){
                            matched--;
                        }
                        map.put(first, map.get(first) + 1);
                    }
                    windowStart++;
                }
            }
            return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);

        }

        public String minWindow2(String s, String t){
            Map<Character, Integer> map = new HashMap<>();
            for(char ch : t.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int windowStart = 0;
            int subArrStart = 0;
            int min = s.length()+1;
            int found = 0;
            for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
                char ch = s.charAt(windowEnd);
                // check if this is in the pattern
                if (map.containsKey(ch)){
                    // reduce by one
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0){
                        found++;
                    }
                }
                while (found == map.size()){
                    // check the min size
                    if (min > windowEnd - windowStart + 1){
                        min = windowEnd - windowStart + 1;
                        subArrStart = windowStart;
                    }
                    // slide the window while this is true
                    char first = s.charAt(windowStart);
                    if (map.containsKey(first)){
                        if (map.get(first) == 0){
                            found--;
                        }
                        map.put(first, map.get(first) + 1);
                    }
                    windowStart++;
                }
            }
            return min > s.length() ? "" : s.substring(subArrStart, subArrStart + min);
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
