package com.kunal.greedy;

import java.io.*;
import java.util.StringTokenizer;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGameHard {
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
            int[] nums = {2, 3, 1, 1, 4};
            System.out.println(jump(nums));
        }

        public int jump(int[] nums) {

            int n = nums.length;
            int jumps = 1;

            if (n == 1 || nums[0] == 0) {
                return 0;
            }

            int farthest = nums[0];
            int curr_end = nums[0];

            for (int i = 1; i < n; i++) {
                if (i == n - 1) {
                    return jumps;
                }
                farthest = Math.max(farthest, nums[i] + i);
                if (i == curr_end) {
                    jumps++;
                    curr_end = farthest;
                }
            }

            return jumps;
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
