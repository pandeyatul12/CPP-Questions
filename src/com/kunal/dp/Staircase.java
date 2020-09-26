package com.kunal.dp;

public class Staircase {
    public static void main(String[] args) {
        System.out.println(staircase(4, 2));
    }

//     Normal Recursion time complexity: O(m^n)
    public static int staircase(int n, int m) {
        Integer[] dp = new Integer[n+1];
        return staircase(n, m, dp);
    }
    // O(nm)
    public static int staircase(int n, int m, Integer[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        int count = 0;
        for (int i = 1; i <= m && i <= n; i++) {
            count += staircase(n-i, m, dp);
        }
        dp[n] = count;
        return dp[n];
    }
}
