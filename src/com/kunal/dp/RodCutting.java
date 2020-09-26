package com.kunal.dp;

public class RodCutting {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8};
        int n = 4;
        System.out.println(rodCutting(arr, n));
        System.out.println(rodCuttingDP(arr, n));
        System.out.println(rodCuttingItr(arr, n));
    }

    // Time Complexity: O(2^n)
    public static int rodCutting(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i + 1 <= n; i++) {
            profit = Math.max(profit, arr[i] + rodCutting(arr, n - i - 1));
        }
        return profit;
    }

    //    Time: O(n^2) Space: O(n)
    public static int rodCuttingDP(int[] arr, int n) {
        Integer[] dp = new Integer[n + 1];
        return rodCuttingDP(arr, n, dp);
    }

    private static int rodCuttingDP(int[] arr, int n, Integer[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, arr[i] + rodCuttingDP(arr, n - i - 1, dp));
        }
        dp[n] = profit;
        return profit;
    }

    //    Time: O(n^2) Space: O(n)
    public static int rodCuttingItr(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int profit = 0;
            for (int j = 0; j < i; j++) {
                profit = Math.max(profit, arr[j] + dp[i - j - 1]);
            }
            dp[i] = profit;
        }
        return dp[n];
    }

    // Given a rope of length n meters, cut the rope in different parts of
    // integer lengths in a way that maximizes product of lengths of all parts.
    public static int maxProd(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        // Make a cut at different places
        // and take the maximum of all
        int max_val = 0;
        for (int i = 1; i < n; i++) {
            max_val = Math.max(max_val, Math.max(i * (n - i), maxProd(n - i) * i));
        }

        return max_val;
    }
}
