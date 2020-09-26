package com.kunal.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 11;
        System.out.println(coinChangeDP(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int res = coinChange(coins, amount-coin);
                if (res >= 0 && res < count) {
                    count = 1 + res;
                }
            }
        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public static int coinChangeDP(int[] coins, int amount) {
        Integer[] dp = new Integer[amount+1];
        return coinChangeDP(coins, amount, dp);
    }
    private static int coinChangeDP(int[] coins, int amount, Integer[] dp) {
        if(amount == 0) {
            return 0;
        }
        if (dp[amount] != null) {
            return dp[amount];
        }
        int count = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int res = coinChangeDP(coins, amount-coin, dp);
                if (res >= 0 && res < count) {
                    count = 1 + res;
                }
            }
        }
        dp[amount] = count == Integer.MAX_VALUE ? -1 : count;
        return dp[amount];
    }

    public static int coinChangeItr(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int count = Integer.MAX_VALUE;
            for(int coin  : coins) {
                if (coin <= i) {
                    int res = dp[i-coin];
                    if (res >= 0 && res < count) {
                        count = 1 + res;
                    }
                }
            }
            dp[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return dp[amount];
    }
}
