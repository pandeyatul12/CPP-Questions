package com.kunal.dp;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, 0);
    }

    private int minCostClimbingStairs(int[] cost, int index) {
        if (index >= cost.length - 1) {
            return 0;
        }
        int cost1 = cost[index] + minCostClimbingStairs(cost, index + 1);
        int cost2 = cost[index + 1] + minCostClimbingStairs(cost, index + 2);

        return Math.min(cost1, cost2);
    }

    public int minCostClimbingStairsDP(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        return minCostClimbingStairsDP(cost, 0, dp);
    }

    private int minCostClimbingStairsDP(int[] cost, int index, Integer[] dp) {
        if (index >= cost.length - 1) {
            return 0;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        int cost1 = cost[index] + minCostClimbingStairsDP(cost, index + 1, dp);
        int cost2 = cost[index + 1] + minCostClimbingStairsDP(cost, index + 2, dp);

        dp[index] = Math.min(cost1, cost2);
        return dp[index];
    }

    public int minCostClimbingStairsItr(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }

        return dp[cost.length];
    }
}
