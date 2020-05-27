package com.kunal.divideNconquer;

import java.io.*;
import java.util.StringTokenizer;

public class BookAllocation {
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
            int m = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int s = findMax(arr);
            int e = findSum(arr);
            int finalans = 0;
            int p = 0;      // pages
            while (s <= e) {
                p = (s + e) / 2;
                if (canDo(arr, p, m)) {
                    finalans = p;
                    e = p - 1;
                }else{
                    s = p + 1;
                }
            }
            out.println(finalans);
        }
        private boolean canDo(int[] arr, int p, int students) {
            int s = 1;
            int count = 0;
            for (int value : arr) {
                if (count + value > p) {
                    count = value;
                    s++;
                    if (s > students) {
                        return false;
                    }
                } else {
                    count += value;
                }
            }
            return true;
        }

        private static int findSum(int[] boards) {
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
