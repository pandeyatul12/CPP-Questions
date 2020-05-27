package com.kunal.divideNconquer;

import java.io.*;
import java.util.StringTokenizer;

public class PainterPartition {
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
            int p = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int s = findMax(arr);
            int e = findSum(arr);
            int t = 0;
            int ans = 0;
            while (s <= e) {
                t = (s + e) / 2;
                if (canDo(arr, t, p)) {
                    ans = t;
                    e = t - 1;
                }else{
                    s = t + 1;
                }
            }
            out.println(ans);
        }

        private boolean canDo(int[] arr, int time, int painters) {
            int currentPainters = 1;
            int painted = 0;
            for (int value : arr) {
                if (painted + value > time) {
                    painted = value;
                    currentPainters++;
                    if (currentPainters > painters) {
                        return false;
                    }
                } else {
                    painted += value;
                }
            }
            return true;
        }

        private int findSum(int[] boards) {
            int sum = 0;
            for (int board : boards) {
                sum += board;
            }
            return sum;
        }

        public static int findMax(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
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
