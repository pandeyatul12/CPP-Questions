package com.kunal.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class GridSearch {
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

    /*
3
MOM
SON
RAT
4
MNT RAH MSR OOB
     */
    static class Task {
        static boolean find(char[][] matrix, String pat, int x, int y, int row, int col, int level) {
            int l = pat.length();

            if (level == l)
                return true;

            if (x < 0 || y < 0 || x >= row || y >= col)
                return false;

            if (matrix[x][y] == pat.charAt(level)) {
                char temp = matrix[x][y];
                matrix[x][y] = '#';

                boolean result = find(matrix, pat, x - 1, y, row, col, level + 1) |
                        find(matrix, pat, x + 1, y, row, col, level + 1) |
                        find(matrix, pat, x, y - 1, row, col, level + 1) |
                        find(matrix, pat, x, y + 1, row, col, level + 1);

                matrix[x][y] = temp;
                return result;
            } else
                return false;
        }

        static boolean check(char[][] matrix, String pattern, int row, int col) {
            int l = pattern.length();

            if (l > row * col)
                return false;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == pattern.charAt(0))
                        if (find(matrix, pattern, i, j, row, col, 0))
                            return true;
                }
            }
            return false;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) throws IOException {
            int n = in.nextInt();
            char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = in.nextLine().toCharArray();
            }
            int q = in.nextInt();
            for (int i = 0; i < q; i++) {
                String word = in.next();
                if (check(grid, word, n, n))
                    out.print("Yes ");
                else
                    out.print("No ");
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
