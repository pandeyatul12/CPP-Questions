package com.kunal.greedy;

import java.io.*;
import java.util.*;

public class EXPEDI {
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
                int n = in.nextInt(); // number of stops
                int[][] dis = new int[n][2]; // stop location from town with fuel
                for (int j = 0; j < n; j++) {
                    dis[j][0] = in.nextInt();
                    dis[j][1] = in.nextInt();
                }
                int l = in.nextInt(); // distance of truck from town
                int p = in.nextInt(); // initial petrol in truck

                for (int j = 0; j < n; j++) {
                    dis[j][0] = l - dis[j][0];
                }
                // dis contains distance of stop from truck
                Arrays.sort(dis, Comparator.comparingInt(o -> o[0])); // sort on the basis of distance in asc order
                Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

                int ans = 0;
                int prev = 0; // prev city we have visited
                int x = 0;   // current city
                int flag = 0;
                while (x < n){
                    // if we have enough fuel to go to next city
                    if (p >= dis[x][0] - prev){
                        p = p - (dis[x][0] - prev);
                        queue.add(dis[x][1]);
                        prev = dis[x][0];
                    }else{
                        // check if you have some previously visited station in queue
                        if (queue.isEmpty()){
                            flag = 1;
                            break;
                        }
                        // refuel truck
                        p += queue.peek();
                        queue.remove();
                        ans += 1;
                        continue;
                    }
                    x++;
                }
                // after while loop, you have actually travelled through n fuel stations
                // you have to reach the town from last fuel station
                if (flag == 1){
                    out.println(-1);
                    continue;
                }
                // check distance of town
                l = l - dis[n-1][0];

                // you have enough fuel
                if (p >= l){
                    out.println(ans);
                    continue;
                }

                // check if queue has enough fuel to make you reach the town
                while (p < l){
                    if (queue.isEmpty()){
                        flag = 1;
                        break;
                    }
                    p += queue.peek();
                    queue.remove();
                    ans += 1;
                }

                // not enough fuel
                if (flag == 1){
                    out.println(-1);
                    continue;
                }
                out.println(ans);
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
    }
}
