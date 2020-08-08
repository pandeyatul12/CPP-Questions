package com.kunal.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RectangleSquare {
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
            int[] planks = new int[n];
            for (int i = 0; i < n; i++) {
                planks[i] = in.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int len = planks[i];
                map.put(len, map.getOrDefault(len, 0) + 1);
            }

            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                String op = in.nextLine();
                char ch = op.split(" ")[0].charAt(0);
                int len = Integer.parseInt(op.split(" ")[1]);

                if (ch == '-') {
                    map.put(len, map.getOrDefault(len, 0) - 1);
                } else {
                    map.put(len, map.getOrDefault(len, 0) + 1);
                }

                if (canMake(map)) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
        }

        private boolean canMake(Map<Integer, Integer> map) {
            int count = 0;
            for (Integer key : map.keySet()){
                count += map.get(key) / 2;
            }
            return (count / 2) >= 2;
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
