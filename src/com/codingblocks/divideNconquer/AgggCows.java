package com.codingblocks.divideNconquer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgggCows {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int t = in.nextInt();
        solver.solve(t, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            for (int i = 0; i < testNumber; i++) {
                int n = in.nextInt();
                int c = in.nextInt();
                int[] loc = new int[n];
                for (int j = 0; j < n; j++) {
                    loc[j] = in.nextInt();
                }
                Arrays.sort(loc);
                out.println(ans(n, loc, c));
            }
        }
        private static int ans(int n, int[] loc, int c) {
            int s = 0;
            int e = loc[loc.length-1];
            int mid = (s + e) / 2;
            while (s <= e) {
                if (canPlace(loc, n, mid, c)) {
                    s = mid+1;
                }else{
                    e = mid - 1;
                }
                mid = (s + e) / 2;
            }
            return mid;
        }

        private static boolean canPlace(int[] loc, int n, int dis, int c) {
            int cows = 1; // already placed at index 0

            for (int i = 1, j=0; i < n; i++) {
                if (cows == c) {
                    return true;
                }
                if (loc[i] - loc[j] >= dis) {
                    // place the cow
                    cows++;
                    j = i;
                }
            }
            return cows==c;
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
