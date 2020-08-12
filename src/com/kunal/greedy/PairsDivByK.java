package com.kunal.greedy;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
public class PairsDivByK {
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
        public boolean canArrange(int[] arr, int k) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] %= k;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                int toFind = k - num;
                // search toFind or -num

                if (map.containsKey(-num)) {
                    map.put(-num, map.get(-num) - 1);
                    if (map.get(-num) == 0){
                        map.remove(-num);
                    }
                }
                else if (map.containsKey(toFind)) {
                    map.put(toFind, map.get(toFind) - 1);
                    if (map.get(toFind) == 0){
                        map.remove(toFind);
                    }
                }
                else {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }

            for(int value : map.values()){
                if (value != 0) {
                    return false;
                }
            }
            return true;
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
