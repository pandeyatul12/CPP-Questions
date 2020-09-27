package com.kunal.slidingWindow;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NoRepeatSubstring {
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
        Time Complexity: O(N)
        Space Complexity: O(K)?? but K <= N and we can use an array of size 26 to represent all letters hence
        answer is O(1)
    */
    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            System.out.println("Length of the longest substring: " + findLength2("aabccbb"));

        }
        public static int findLength(String str) {
            int max = 0;
            int start = 0;
            Set<Character> set = new HashSet<>();
            for (int end = 0; end < str.length(); end++) {
                char ch = str.charAt(end);
                while(set.contains(ch)){
                    set.remove(str.charAt(start));
                    start++;
                }
                set.add(ch);
                max = Math.max(max, end-start+1);
            }
            return max;
        }
        public static int findLength2(String str) {
            int max = 0;
            int start = 0;
            int[] arr = new int[26];
            Arrays.fill(arr, -1);
            for (int end = 0; end < str.length(); end++) {
                int ch = str.charAt(end) - 'a';
                if(arr[ch] != -1){
                    start = Math.max(start, arr[ch] + 1);
                }
                arr[ch] = end;
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
