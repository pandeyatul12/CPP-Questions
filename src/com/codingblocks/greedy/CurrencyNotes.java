package com.codingblocks.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CurrencyNotes {
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
            long n = in.nextLong();
            int count = 0;
            while (n > 0){
                while (n >= 100) {
                    n-=100;
                    count++;
                }
                while (n >= 20) {
                    n-=20;
                    count++;
                }
                while (n >= 10) {
                    n-=10;
                    count++;
                }
                while (n >= 5) {
                    n-=5;
                    count++;
                }
                while (n >= 1) {
                    n-=1;
                    count++;
                }
            }
            System.out.println(count);
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

    public static class TaskCodeJam {
        public static void main(String[] args) {
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
            public void solve(int testNumber, InputReader in, PrintWriter out) {
                for (int t = 1; t <= testNumber ; t++) {
                    int n = in.nextInt();
                    if(n >= 2) {
                        int[][] time = new int[n][2];
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < 2; j++) {
                                time[i][j] = in.nextInt();
                            }
                        }
                        ArrayList<Integer> c = new ArrayList<>();
                        ArrayList<Integer> j = new ArrayList<>();
                        c.add(0);
                        StringBuilder builder = new StringBuilder();
                        builder.append("C");
                        for (int i = 1; i < n; i++) {
                            int currentS = time[i][0];
                            int currentE = time[i][1];
                            if (check(c, currentS, currentE, time)) {
                                builder.append("C");
                                c.add(i);
                            } else if(check(j, currentS, currentE, time)) {
                                builder.append("J");
                                j.add(i);
                            }
                        }
                        String ans = builder.toString();
                        if (ans.length() != n) {
                            ans = "IMPOSSIBLE";
                        }
                        out.println("Case #" + t + ": " + ans);
                    }
                }
            }
            public static boolean check(ArrayList<Integer> a, int s, int e, int[][] orignal) {
                for (Integer integer : a) {
                    int startA = orignal[integer][0];
                    int endA = orignal[integer][1];
                    if (startA >= s) {
                        if (!(e <= startA)) {
                            return false;
                        }
                    } else {
                        if (!(endA <= s)) {
                            return false;
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
                reader = new BufferedReader(new InputStreamReader(stream));
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

            public int nextInt() {
                return Integer.parseInt(next());
            }
        }
    }

    // Vishesh's Solution : Passed
    public static class TaskCodeJam2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for (int j = 1; j <= t; j++) {
                int n = in.nextInt();
                int[] s = new int[n];
                int[] e = new int[n];
                for (int i = 0; i < n; i++) {
                    s[i] = in.nextInt();
                    e[i] = in.nextInt();
                }
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=i;
                }
                for (int x = 0; x < n; x++) {
                    for (int z = 0; z < n - x - 1; z++) {
                        if (s[z] > s[z + 1]) {
                            int temp = s[z];
                            s[z] = s[z + 1];
                            s[z + 1] = temp;
                            int temp2 = e[z];
                            e[z] = e[z + 1];
                            e[z + 1] = temp2;
                            temp=arr[z];
                            arr[z]=arr[z+1];
                            arr[z+1]=temp;
                        }
                    }
                }
                int cam = 0;
                int jam = 0;
                int tc = 0;
                int tj = 0;
                int flag = 0;
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (s[i] >= tc)
                        cam = 0;
                    if (s[i] >= tj)
                        jam = 0;
                    if (cam == 0) {
                        cam = 1;
                        tc = e[i];
                        ans.append("C");
                    } else if (jam == 0) {
                        jam = 1;
                        tj = e[i];
                        ans.append("J");
                    } else {
                        flag = 1;
                        break;
                    }

                }

                if (flag == 1) {
                    System.out.println("Case #" + j + ": IMPOSSIBLE");
                } else{
                    StringBuilder finalans=new StringBuilder();
                    char[] b=new char[n];
                    for(int i=0;i<n;i++){
                        b[arr[i]]=ans.charAt(i);
                    }

                    for(int i=0;i<n;i++){
                        finalans.append(b[i]);
                    }
                    System.out.println("Case #" + j + ": " + finalans);
                }
            }
        }
    }
}
