package com.kunal.arrays2D;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SkillUp {
    // https://atcoder.jp/contests/abc167/tasks/abc167_c
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
            int x = in.nextInt();
            int[][] arr = new int[n+1][m+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
            int count = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= m; i++) { // columns
                int sum = 0;
                int c = 0;
                for (int j = 1; j <= n; j++) { // row
                    if(sum < x){
                        sum += arr[j][0];
                        c++;
                    }
                    if (c > max){
                        count += arr[j][0];
                        max = c;
                    }
                    if (sum > x){
//                        if(sum - x >= arr[j-1][0]){
//                            count -= arr[j][0];
//                            max -= 1;
//                        }
                        break;
                    }
                }
            }
            System.out.println(count);

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
