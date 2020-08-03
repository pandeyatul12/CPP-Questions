package com.kunal.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// https://leetcode.com/problems/car-pooling/
public class CarPooling {
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
            int[][] trips = {
                    {7, 5, 6},
                    {6, 7, 8},
                    {10, 1, 6}
            };
            int capacity = 16;
            Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
            System.out.println(ans(trips, capacity));
        }

        private boolean ans(int[][] trips, int capacity) {
            PriorityQueue<Temp> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

            for(int[] li : trips){
                queue.add(new Temp(li[2], li[0]));
                capacity -= li[0];

                // remove all smaller than li[1]
                if (!queue.isEmpty()){
                    while (queue.peek().end <= li[1]){
                        capacity += queue.remove().capacity;
                    }
                }
                if (capacity < 0){
                    return false;
                }
            }
            return true;
        }
        static class Temp{
            int end;
            int capacity;

            public Temp(int end, int capacity) {
                this.end = end;
                this.capacity = capacity;
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
