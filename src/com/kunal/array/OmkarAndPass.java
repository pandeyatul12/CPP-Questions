package com.kunal.array;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// http://codeforces.com/contest/1392/problem/A
public class OmkarAndPass {
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
                int n = in.nextInt();
                ArrayList<Long> list = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    list.add(in.nextLong());
                }
                int start = 0;
                if (list.size() == 1){
                    out.print(1);
                    continue;
                }
                if (list.size() == 2){
                    if (list.get(0).equals(list.get(1))){
                        out.println(2);
                    }else{
                        out.println(1);
                    }
                    continue;
                }
                for (int end = start+1; end < list.size(); end++) {
                    long first = list.get(start);
                    long second = list.get(end);
                    if (end < list.size()-1 && first+second == list.get(end+1)){
                        start++;
                    }else{
                        first = list.remove(start);
                        second = list.remove(end-1);
                        long join = first + second;
                        list.add(start, join);
                    }
                }
                if (list.size() == 1){
                    out.print(1);
                    continue;
                }
                if (same(list)){
                    out.println(list.size());
                }else{
                    out.println(1);
                }
            }
        }
        public boolean same(ArrayList<Long> list){
            long first = list.get(0);
            for (int i = 1; i < list.get(i); i++) {
                if (first != list.get(i)){
                    return false;
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
