package com.kunal.dp;

public class RodCutting {
    public static void main(String[] args) {
        int[] arr = {2,3,7,8};
        int n = 4;
        System.out.println(rodCutting(arr, n));
        System.out.println(rodCuttingDP(arr, n));
        System.out.println(rodCuttingItr(arr, n));
    }
    public static int rodCutting(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 0; i+1 <= n; i++) {
            profit = Math.max(profit,  arr[i] + rodCutting(arr, n-i-1));
        }
        return profit;
    }
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
            profit = Math.max(profit,  arr[i] + rodCuttingDP(arr, n-i-1, dp));
        }
        dp[n] = profit;
        return profit;
    }
    public static int rodCuttingItr(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int profit = 0;
            for (int j = 0; j < i; j++) {
                profit = Math.max(profit, arr[j] + dp[i-j-1]);
            }
            dp[i] = profit;
        }
        return dp[n];
    }
}
