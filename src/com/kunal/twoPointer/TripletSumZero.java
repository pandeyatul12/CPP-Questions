package com.kunal.twoPointer;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TripletSumZero {
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

        }
        public static List<List<Integer>> searchTriplets(int[] arr) {
            List<List<Integer>> triplets = new ArrayList<>();
            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                if (i > 0 && arr[i] == arr[i-1]){
                    continue;
                }
                search(arr, -arr[i], i+1, triplets);
            }
            return triplets;
        }

        private static void search(int[] arr, int target, int start, List<List<Integer>> triplets) {
            int end = arr.length-1;
            while (start < end){
                int sum = arr[start] + arr[end];
                if (sum == target){
                    triplets.add(Arrays.asList(-target, arr[start], arr[end]));
                    start++;
                    end--;
                    while (start < end && arr[start] == arr[start-1]){
                        start++;
                    }
                    while (start < end && arr[end] == arr[end+1]){
                        end--;
                    }
                }else if (target > sum){
                    start++;
                }else{
                    end--;
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
