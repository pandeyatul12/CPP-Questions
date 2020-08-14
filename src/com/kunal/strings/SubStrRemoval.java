package com.kunal.strings;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
// https://codeforces.com/contest/1398/problem/B
public class SubStrRemoval {
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
            for (int t = 0; t < testNumber; t++) {
                String str = in.nextLine();
                String strPattern = "^0+(?!$)";
                str = str.replaceAll(strPattern, "");
                ArrayList<Integer> list = new ArrayList<>();
                int ones = 0;
                int check = 0;
                for (int i = 0; i < str.length(); i++) {
                    char num = str.charAt(i);
                    if (num == '0'){
                        if (check == 0){
                            list.add(ones);
                            ones = 0;
                            check = 1;
                        }
                    }else{
                        ones++;
                        check = 0;
                    }
                }
                if (ones > 0){
                    list.add(ones);
                }
                list.sort((o1, o2) -> o2 - o1);

                int sum = 0;
                for (int i = 0; i < list.size(); i+=2) {
                    sum += list.get(i);
                }
                out.println(sum);
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
