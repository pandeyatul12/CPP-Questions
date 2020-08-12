package com.kunal.slidingWindow;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AverageOfWindows {
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
            int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
            int k = 5;
            out.println(Arrays.toString(avgSubarrays(arr, k)));;
        }
        public float[] avgSubarrays(int[] arr, int k) {
            float[] ans = new float[arr.length - k + 1];
            float sum = 0.0f;
            int start = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (i >= k-1) {
                    ans[start] = sum / k;
                    sum -= arr[start];
                    start++;
                }
            }
            return ans;
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
