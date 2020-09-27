package com.kunal.slidingWindow;

import java.io.*;
import java.util.*;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
public class WordConcatHard {
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
        Time Complexity: O(N * M * Len), when Len is the lend of the words, M is total number of words
        Space Complexity: O(M) for Hashmap & O(N) for result hence it will be O(N+M)
    */

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {

        }
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> list = new ArrayList<>();
            if(s.length() == 0){
                return list;
            }
            if(words.length == 0){
                return list;
            }
            Map<String, Integer> map = new HashMap<>();
            int wordCount = words.length;
            int wordLength = words[0].length();
            for (String str : words){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            for (int i = 0; i <= s.length() - wordCount * wordLength; i++) {
                Map<String, Integer> seen = new HashMap<>();
                for (int j = 0; j < wordCount; j++) {
                    int start = i + j * wordLength;
                    String check = s.substring(start, start + wordLength);
                    if (!map.containsKey(check)){
                        break;
                    }
                    seen.put(check, seen.getOrDefault(check, 0) + 1);
                    if (seen.get(check) > map.get(check)){
                        break;
                    }
                    if (j+1 == wordCount){
                        list.add(i);
                    }
                }
            }
            return list;
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
