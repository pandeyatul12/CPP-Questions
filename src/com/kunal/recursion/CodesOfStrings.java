package com.kunal.recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CodesOfStrings {
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
            String num = in.next();
            ans2("", num);
//            ArrayList<Character> list = new ArrayList<>();
//            ans(list, num);
        }

        public static void ans2(String processed, String unprocessed){
            if (unprocessed.isEmpty()){
                System.out.println(processed);
                return;
            }
            int f = Integer.parseInt(unprocessed.charAt(0)+"");
            ans2(processed+((char)('a' + f - 1)), unprocessed.substring(1));
            if (unprocessed.length() >= 2){
                int s = Integer.parseInt(unprocessed.substring(0, 2));
                if (s > 0 && s < 27) {
                    ans2(processed+((char)('a' + s - 1)), unprocessed.substring(2));
                }
            }
        }
        public static void ans(ArrayList<Character> list, String num){

            if(num.isEmpty()){
                for (Character character : list) {
                    System.out.print(character);
                }
                System.out.println();
                return;
            }

            for (int i = 1; i <= num.length() ; i++) {
                int n = Integer.parseInt(num.substring(0,i));
                ArrayList<Character> temp = new ArrayList<>(list);
                if (n > 0 && n < 27) {
                    temp.add((char)('a' + n - 1));
                }else{
                    continue;
                }
                ans(temp, num.substring(i));
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
