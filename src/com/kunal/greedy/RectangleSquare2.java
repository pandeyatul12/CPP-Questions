package com.kunal.greedy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RectangleSquare2 {
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
            int count = 0;
            for (Integer key : map.keySet()){
                count += map.get(key) / 2;
            }

            for (int i = 0; i < q; i++) {
                String op = in.nextLine();
                char ch = op.split(" ")[0].charAt(0);
                int len = Integer.parseInt(op.split(" ")[1]);
                count -= map.get(len) / 2;
                if (ch == '-') {
                    map.put(len, map.getOrDefault(len, 0) - 1);
                } else {
                    map.put(len, map.getOrDefault(len, 0) + 1);
                }
                out.println(map);
                count += map.get(len) / 2;

                int found = 0;
                for (Integer val : map.values()) {
                    if (val >= 4) {
                        found = 1;
                        break;
                    }
                }
                if (found == 0){
                    out.println("NO");
                    continue;
                }

                if ((count / 2) >= 2) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
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
