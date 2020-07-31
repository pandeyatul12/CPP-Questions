package com.kunal.greedy;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

// https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
public class MinSubSeqNonDec {
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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            // code
            List<Integer> list = ans(arr);
            System.out.println(list);
        }

        private List<Integer> ans(int[] nums) {
            Integer[] li = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(li, Collections.reverseOrder());
            int sum = 0;
            for (Integer num : li) {
                sum += num;
            }
            int temp = 0;
            List<Integer> list = new ArrayList<>();
            for (Integer num : li) {
                if (temp > sum) {
                    return list;
                }
                sum -= num;
                temp += num;
                list.add(num);
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
