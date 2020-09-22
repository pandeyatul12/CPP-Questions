package com.kunal.greedy;

import java.io.*;
import java.util.StringTokenizer;
// https://leetcode.com/problems/gas-station/
public class GasStation {
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
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = 0;
            int currPos = 0;
            int currCap = 0;
            int n = gas.length;
            while (start < n) {
                currCap += gas[currPos % n];
                if (currCap < cost[currPos % n]) {
                    start++;
                    currCap = 0;
                    currPos = start;
                } else {
                    currCap -= cost[currPos % n];
                    currPos++;
                    if (start == currPos%n) {
                        return start;
                    }
                }
            }
            return -1;
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
