package com.kunal.greedy;

import java.io.*;
import java.util.*;

// https://leetcode.com/problems/advantage-shuffle/
public class AdvanceShuffle {
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
            int[] A = {2,7,11,15};
            int[] B = {1,10,4,11};
            out.println(Arrays.toString(advantageCount(A, B)));
        }
        public int[] advantageCount(int[] A, int[] B) {
            int[] sortedA = A.clone();
            Arrays.sort(sortedA);
            int[] sortedB = B.clone();
            Arrays.sort(sortedB);

            // assigned[b] = list of a that are assigned to beat b
            Map<Integer, Deque<Integer>> assigned = new HashMap<>();
            for (int b: B) assigned.put(b, new LinkedList<>());

            // remaining = list of a that are not assigned to any b
            Deque<Integer> remaining = new LinkedList<>();

            // populate (assigned, remaining) appropriately
            // sortedB[j] is always the smallest unassigned element in B
            int j = 0;
            for (int a: sortedA) {
                if (a > sortedB[j]) {
                    assigned.get(sortedB[j++]).add(a);
                } else {
                    remaining.add(a);
                }
            }

            // Reconstruct the answer from annotations (assigned, remaining)
            int[] ans = new int[B.length];
            for (int i = 0; i < B.length; ++i) {
                // if there is some a assigned to b...
                if (assigned.get(B[i]).size() > 0)
                    ans[i] = assigned.get(B[i]).pop();
                else
                    ans[i] = remaining.pop();
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
