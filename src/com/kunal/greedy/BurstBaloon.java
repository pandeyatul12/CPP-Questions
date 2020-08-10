package com.kunal.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class BurstBaloon {
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
            int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
            int[][] points2 = {{1,2}, {3,4}, {5,6}, {7,8}};

            out.println(findMinArrowShots(points));
            out.println(findMinArrowShots(points2));
        }

        private int betterWay(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
            System.out.println(Arrays.deepToString(points));
            int currEnd = points[0][1];
            int cnt = 0;
            for (int[] point : points) {
                if (point[0] > currEnd) {
                    cnt++;
                    currEnd = point[1];
                }
            }
            cnt++;
            return cnt;
        }

        private int findMinArrowShots(int[][] points) {
            int count = 0;
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
            Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
            int i = 0;
            while (i < points.length) {
                int start = points[i][0];
                int end = points[i][1];
                count++;
                // remove all in front of this that have start less that equal to end
                int index = i+1;
                while (true){
                    if (index >= points.length){
                        return count;
                    }
                    int checkStart = points[index][0];
                    int checkEnd = points[index][1];
                    if (checkStart > end) {
                        break;
                    }
                    if (checkStart > start) {
                        start = checkStart;
                    }
                    if (checkEnd < end){
                        end = checkEnd;
                    }
                    index++;
                }
                i = index;
            }
            return count;
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
