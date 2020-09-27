package com.kunal.slidingWindow;

import java.io.*;
import java.util.*;

public class StringAnagrams {
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
        Space Complexity: O(M)
        In the worst case, we also need O(N) space for the result list,
        this will happen when the pattern has only one character and the string contains only that character.
    */

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {

        }
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> list = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            for(char ch : p.toCharArray()){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int start = 0;
            int target = 0;
            for (int end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                if (map.containsKey(ch)){
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0){
                        target++;
                    }
                }
                if (target == map.size()){
                    list.add(start);
                }
                if (end >= p.length() - 1){
                    char first = s.charAt(start);
                    if (map.containsKey(first)){
                        if (map.get(first) == 0){
                            target--;
                        }
                        map.put(first, map.get(first) + 1);
                    }
                    start++;
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
