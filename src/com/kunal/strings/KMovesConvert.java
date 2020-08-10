package com.kunal.strings;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class KMovesConvert {
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
            String s = in.next();
            String t = in.next();
            int k = in.nextInt();

            out.println(canConvertString(s, t, k));
        }

        private boolean canConvertString(String s, String t, int k) {

            if (s.length() != t.length()){
                return false;
            }

            int[] ss = new int[s.length()];
            int[] tt = new int[t.length()];

            for (int i = 0; i < s.length(); i++) {
                // ss[i] is numeric val of that alphabet
                ss[i] = s.charAt(i) - 'a';
            }
            for (int i = 0; i < t.length(); i++) {
                // ss[i] is numeric val of that alphabet
                tt[i] = t.charAt(i) - 'a';
            }

            System.out.println(Arrays.toString(ss));
            System.out.println(Arrays.toString(tt));
            Set<Integer> checked = new HashSet<>();
            int check = 0;
            for (int i = 0; i < ss.length; i++) {
                int num1 = ss[i];
                int num2 = tt[i];
                if (num1 != num2){
                    int minRequired = Math.abs(num1 - num2);
                    if (minRequired > k){
                        return false;
                    }
                    if (!checked.contains(minRequired)){
                        checked.add(minRequired);
                    }else{
                        // check +26
                        int newReq = minRequired;
                        while (true){
                            newReq = newReq + 25;
                            // check if this is already taken
                            if (newReq > k){
                                return false;
                            }
                            if (!checked.contains(newReq)){
                                checked.add(newReq);
                                break;
                            }
                        }
                    }
                }
            }
            return true;
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
