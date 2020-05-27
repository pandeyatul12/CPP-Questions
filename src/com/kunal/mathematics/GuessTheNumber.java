package com.kunal.mathematics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GuessTheNumber {
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
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int key = in.nextInt();
                int value =  in.nextInt();
                if (key == 1 && value == 0 && n > 1){
                    out.println(-1);
                    return;
                }
                if (map.containsKey(key) && map.get(key) != value){
                    out.println(-1);
                    return;
                }
                if (key > n){
                    out.println(-1);
                    return;
                }
                map.put(key, value);
            }
            StringBuilder ans = new StringBuilder();
            if (n == 1) {
                if (map.containsKey(1)){
                    ans.append(map.get(1));
                }else{
                    ans.append(0);
                }
            }else {
                for (int i = 1; i <= n; i++) {
                    if (map.containsKey(i)){
                        ans.append(map.get(i));
                    }else{
                        if (i == 1){
                            ans.append(1);
                        }else{
                            ans.append(0);
                        }
                    }
                }
            }
            out.println(ans);
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
