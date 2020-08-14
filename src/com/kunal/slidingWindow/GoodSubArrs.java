package com.kunal.slidingWindow;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GoodSubArrs {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int t = in.nextInt();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            for (int t = 0; t < testNumber; t++) {
                int n = in.nextInt();
                String nums = in.next();
                int[] arr = new int[n];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = nums.charAt(i) - '0';
                }
                int i = 0;
                long count = 0;
                int sum = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for(int num : arr){
                    i++;
                    sum += num;
                    count += map.getOrDefault(sum-i, 0);
                    map.put(sum-i, map.getOrDefault(sum-i, 0) + 1);
                }
                out.println(count);
            }
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
