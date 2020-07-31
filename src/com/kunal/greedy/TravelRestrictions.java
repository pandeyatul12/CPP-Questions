package com.kunal.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TravelRestrictions {
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
                char[][] arr = new char[2][n];
                arr[0] = in.next().toCharArray();
                arr[1] = in.next().toCharArray();

                char[][] ans = new char[n][n];

                for (int j = 0; j < n; j++) {
                    Arrays.fill(ans[j], '_');
                }

                for (int j = 0; j < n; j++) {
                    char ch = arr[1][j];
                    if(ch == 'N'){
                        for (int k = 0; k < n; k++) {
                            ans[j][k] = 'N';
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    char ch = arr[0][j];
                    if(ch == 'N'){
                        for (int k = 0; k < n; k++) {
                            ans[k][j] = 'N';
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if(j == k){
                            ans[j][k] = 'Y';
                        }
                    }
                }

                for (int row = 0; row < n-1; row++) {
                    char down = arr[1][row];
                    if (down == 'Y'){
                        int col = row + 1;
                        char up = arr[0][col];
                        for (int j = 0; j < 1; j++) {
                            if (up == 'Y'){
                                ans[row][col] = 'Y';
                                col += 1;
                                if (col >= n){
                                    break;
                                }
                                up = arr[0][col];
                            }else{
                                break;
                            }
                        }
                    }
                }

                for (int row = n-1; row > 0; row--) {
                    char down = arr[1][row];
                    if (down == 'Y'){
                        int col = row - 1;
                        char up = arr[0][col];
                        for (int j = 0; j < 1; j++) {
                            if (up == 'Y'){
                                ans[row][col] = 'Y';
                                col -= 1;
                                if (col < 0){
                                    break;
                                }
                                up = arr[0][col];
                            }else{
                                break;
                            }
                        }
                    }
                }

                for (int row = 0; row < n - 2; row++) {
                    char down = arr[1][row];
                    if (down == 'Y'){
                        int col = row + 2;
                        char up = arr[0][col];
                        while (up == 'Y' && arr[0][col-1] != 'N'){
                            if (arr[1][row+1] == 'Y'){
                                ans[row][col] = 'Y';
                                col += 1;
                                row += 1;
                                if (col >= n){
                                    break;
                                }
                                up = arr[0][col];
                            }else{
                                break;
                            }
                        }
                    }
                }

                for (int row = n-1; row > 1; row--) {
                    char down = arr[1][row];
                    if (down == 'Y'){
                        int col = row - 2;
                        char up = arr[0][col];
                        while (up == 'Y' && arr[0][col+1] != 'N'){
                            if (arr[1][row-1] == 'Y'){
                                ans[row][col] = 'Y';
                                col -= 1;
                                row -= 1;
                                if (col < 0){
                                    break;
                                }
                                up = arr[0][col];
                            }else{
                                break;
                            }
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (ans[j][k] == '_'){
                            ans[j][k] = 'N';
                        }
                    }
                }

                out.println("Case #" + (i+1) + ": ");
                for (char[] a : ans) {
                    for (char ch : a) {
                        out.print(ch);
                    }
                    out.println();
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
