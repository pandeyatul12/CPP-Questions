package com.kunal.stacksNqueues;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class DoubleParenMinAdd {
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
            out.println(minInsertions(s));
        }

        private int minInsertions(String s) {
            Stack<Character> stack = new Stack<>();
            int i = 0;
            int o = 0;
            int c = 0;
            int ans = 0;
            while (i < s.length()){
                char ch = s.charAt(i);
                if (ch == '('){
                    stack.push(ch);
                    o++;
                    i++;
                }else if (ch == ')'){
                    // check if next is also ')'
                    if (i < s.length()-1 && s.charAt(i+1) == ')'){
                        // check if '(' is at top of stack
                        if (!stack.isEmpty() && stack.peek() == '('){
                            o--;
                            stack.pop();
                        }else{
                            stack.push(')');
                            stack.push(')');
                            c += 2;
                        }
                        i += 2;
                    }else{
                        if (!stack.isEmpty() && stack.peek() == '('){
                            o--;
                            stack.pop();
                            ans += 1;
                        }else{
                            stack.add(')');
                            stack.add(')');
                            c+=2;
                            ans += 1;
                        }
                        i++;
                    }
                }
            }
//            System.out.println(stack);
            return ans + 2*o + c/2;
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
