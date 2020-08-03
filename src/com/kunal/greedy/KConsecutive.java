package com.kunal.greedy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class KConsecutive {
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
            int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
            int k = 4;
            out.println(isPossibleDivide(nums, k));
        }
        public boolean isPossibleDivide(int[] nums, int k) {
            if (nums == null || nums.length == 0 || nums.length % k != 0) {
                return false;
            }

            Map<Integer, Integer> map = new TreeMap<>();
            for (int i : nums){
                map.merge(i, 1, Integer::sum);
            }
            for (Integer key : map.keySet()){
                if (map.get(key) <= 0) continue;
                for(int i=k-1; i>=0; i--){
                    if (map.getOrDefault(key+i, 0) < map.get(key)){
                        return false;
                    }
                    map.put(key+i, map.getOrDefault(key+i,0)-map.get(key));
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
