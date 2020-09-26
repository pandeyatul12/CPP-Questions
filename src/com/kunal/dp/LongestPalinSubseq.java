package com.kunal.dp;

import java.util.Arrays;

public class LongestPalinSubseq {
    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(subseq(s));
        System.out.println(subseqDP(s));
        System.out.println(subseqItr(s));

        s = "aaa";
        System.out.println(subseq(s));
        System.out.println(subseqDP(s));
        System.out.println(subseqItr(s));
    }

    public static int subseq(String s) {
        return subseq(0, s.length() - 1, s);
    }

    private static int subseq(int f, int l, String s) {
        if (s.isEmpty() || f > l) {
            return 0;
        }
        if (f == l) {
            return 1;
        }
        if (s.charAt(f) == s.charAt(l)) {
            return 2 + subseq(f + 1, l - 1, s);
        }
        return Math.max(subseq(f, l - 1, s), subseq(f + 1, l, s));
    }

    public static int subseqDP(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return subseqDP(0, s.length() - 1, s, dp);
    }

    private static int subseqDP(int f, int l, String s, Integer[][] dp) {
        if (s.isEmpty() || f > l) {
            return 0;
        }
        if (f == l) {
            return 1;
        }
        if (dp[f][l] != null) {
            return dp[f][l];
        }
        if (s.charAt(f) == s.charAt(l)) {
            dp[f][l] = 2 + subseqDP(f + 1, l - 1, s, dp);
        } else {
            dp[f][l] = Math.max(subseqDP(f, l - 1, s, dp), subseqDP(f + 1, l, s, dp));
        }
        return dp[f][l];
    }

    // dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
    // NOTE: In top down we were doing from 0,n-1 hence in bottom up we are doing n-1, 0.
    public static int subseqItr(String s) {
        int n = s.length();
        int[][] dp  = new int[n][n];
        for (int f = n - 1; f >= 0; f--) {
            dp[f][f] = 1;
            for (int l = f + 1; l < n; l++) {
                if (s.charAt(f) == s.charAt(l)) {
                    dp[f][l] = dp[f + 1][l - 1] + 2;
                } else {
                    dp[f][l] = Math.max(dp[f + 1][l], dp[f][l - 1]);
                }
            }
        }
        print(dp);
        return dp[0][n-1];
    }

    public static void print(int[][] mem) {
        for (int[] arr : mem) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
