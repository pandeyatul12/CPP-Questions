package com.kunal.dp;

import java.util.Arrays;

public class LongestIncreasingSubseq {
    public static void main(String[] args) {

    }

    public static int lis(int[] arr) {
        return lis(arr, Integer.MIN_VALUE, 0);
    }

    private static int lis(int[] arr, int prev, int index) {
        if (index == arr.length) {
            return 0;
        }
        int taken = 0;
        if (arr[index] > prev) {
            taken = 1 + lis(arr, arr[index], index + 1);
        }
        int notTaken = lis(arr, arr[index], index + 1);
        return Math.max(taken, notTaken);
    }

    public static int lisDP(int[] arr) {
        Integer[][] dp = new Integer[arr.length + 1][arr.length];
        return lisDP(arr, -1, 0, dp);
    }

    private static int lisDP(int[] arr, int prevIndex, int index, Integer[][] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[prevIndex + 1][index] != null) {
            return dp[prevIndex + 1][index];
        }
        int taken = 0;
        if (prevIndex < 0 || arr[index] > arr[prevIndex]) {
            taken = 1 + lisDP(arr, index, index + 1, dp);
        }
        int notTaken = lisDP(arr, prevIndex, index + 1, dp);
        dp[prevIndex + 1][index] = Math.max(taken, notTaken);
        return dp[prevIndex + 1][index];
    }

    // O(N^2)
    // dp[i] contains length of lis ending with arr[i]
    public static int lisItr(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // Math.max(notTaken, taken)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    // O(NLogN)
    public int lisBinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
