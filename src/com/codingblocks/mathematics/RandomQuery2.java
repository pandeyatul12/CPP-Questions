package com.codingblocks.mathematics;


import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class RandomQuery2 {
    public static void main(String[] args) {
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n+1];
            for(int i=1; i<=n; i++) {
                arr[i] = in.nextInt();
            }
            BigDecimal ans = getCounts2(arr);
            // 10 9 6 8 5 5 2 8 9 2 2
            // 20 49 33 9 8 50 21 12 44 23 39 24 10 17 4 17 40 24 19 27 21
            ans = ans.multiply(new BigDecimal(2));
            ans = ans.subtract(new BigDecimal(n));
            ans = ans.divide(new BigDecimal(n*n));
            DecimalFormat df = new DecimalFormat("0.000000");
            System.out.println(df.format(ans));
        }
    }
    public static BigDecimal getCounts2(int[] arr) {
        HashMap<Integer, Integer> last = new HashMap<>();
        double ans;
        double prev = 0;
        BigDecimal bd = new BigDecimal("0.0");
        for (int i = 1; i < arr.length; i++) {
            if (!last.containsKey(arr[i])) {
                ans = prev + i;
            }else {
                ans = prev +  i - last.get(arr[i]);
            }
            prev = ans;
            bd = bd.add(new BigDecimal(prev));
            last.put(arr[i], i);
        }
        return bd;
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
    }
}
