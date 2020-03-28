package com.codingblocks.mathematics;


import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class RandomQuery {
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
            int[] arr = new int[n+1];
            for(int i=1; i<=n; i++) {
                arr[i] = in.nextInt();
            }
            double ans = 0.0d;
            ArrayList<Integer> counts = getCounts(arr);
            for (int i = 0; i < counts.size(); i++) {
                ans += counts.get(i);
            }
            // 10 9 6 8 5 5 2 8 9 2 2
            // 20 49 33 9 8 50 21 12 44 23 39 24 10 17 4 17 40 24 19 27 21

            ans = 2 * ans; // for l > r we will swap but here if l==r then this is counted twice!
            ans = ans - n; // all subarray of size 1 (i.e. l==r) have been counted twice
            ans = ans / (n * n);

            DecimalFormat df = new DecimalFormat("0.000000");
            out.println(df.format(ans));
        }
    }
    public static ArrayList<Integer> getCounts(int[] arr) {
        HashMap<Integer, Integer> last = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < arr.length; i++) {
            if (!last.containsKey(arr[i])) {
                list.add(list.get(i-1)+i);
            }else {
                list.add(list.get(i-1) + i - last.get(arr[i]));
            }
            last.put(arr[i], i);
        }
        return list;
    }
    public static float expected(int[] arr, int l, int r) {
        float ans = 0.0f;
        ans += 1.0 * unique(arr, l, r)/ (arr.length * arr.length);
        return ans;
    }
    public static int unique(int[] arr, int l, int r) {
        Set<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            set.add(arr[i]);
        }
        return set.size();
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
