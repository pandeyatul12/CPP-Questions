package com.kunal.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubSetZeroSum {
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
                int[] arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = in.nextInt();
                }
                ArrayList<Integer> list = new ArrayList<>();
                if(ans(list, arr)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }

        private boolean ans(ArrayList<Integer> list, int[] arr) {
            if (sum(list) == 0 && !list.isEmpty()){
                return true;
            }
            if (arr.length == 0){
                return false;
            }
            ArrayList<Integer> l = new ArrayList<>(list);
            l.add(arr[0]);
            return ans(l, Arrays.copyOfRange(arr, 1, arr.length)) || ans(list, Arrays.copyOfRange(arr, 1, arr.length));
        }

        private int sum(ArrayList<Integer> list){
            int s = 0;
            for (Integer integer : list) {
                s += integer;
            }
            return s;
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
