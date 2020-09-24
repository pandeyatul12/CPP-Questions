package com.kunal.dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProft = knapsackItr(profits, weights, 6);
    }

    public static int knapsack(int[] profits, int[] weights, int capacity) {
        return knapsack(profits, weights, capacity, 0);
    }

    public static int knapsack(int[] profits, int[] weights, int capacity, int index) {
        if (capacity <= 0 || index >= profits.length) {
            return 0;
        }

        int profit1 = 0;
        if (weights[index] <= capacity) {
            profit1 = profits[index] + knapsack(profits, weights, capacity - profits[index], index + 1);
        }

        int profit2 = knapsack(profits, weights, capacity, index + 1);
        return Math.max(profit1, profit2);
    }

    public static int knapsackDP(int[] profits, int[] weights, int capacity, int index, Integer[][] mem) {
        if (capacity <= 0 || index >= profits.length) {
            return 0;
        }
        if (mem[index][capacity] != null) {
            return mem[index][capacity];
        }
        int profit1 = 0;
        if (weights[index] <= capacity) {
            profit1 = profits[index] + knapsackDP(profits, weights, capacity - profits[index], index + 1, mem);
        }

        int profit2 = knapsackDP(profits, weights, capacity, index + 1, mem);
        mem[index][capacity] = Math.max(profit1, profit2);
        return mem[index][capacity];
    }

    // meme[i][j] means max profit to get when capacity is j with first i items
    public static int knapsackItr(int[] profits, int[] weights, int capacity) {
        // base checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                // exclude the item
                profit2 = dp[i - 1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);
        // maximum profit will be at the bottom-right corner.
        return dp[n - 1][capacity];
    }

    private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity) {
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }


    // We only need one previous row to find the optimal solution!
    static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        // we only need one previous row to find the optimal solution, overall we need '2' rows
        // the above solution is similar to the previous solution, the only difference is that
        // we use `i%2` instead if `i` and `(i-1)%2` instead if `i-1`
        int[][] dp = new int[2][capacity+1];

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = dp[1][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for(int i=1; i < n; i++) {
            for(int c=0; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[(i-1)%2][c-weights[i]];
                // exclude the item
                profit2 = dp[(i-1)%2][c];
                // take maximum
                dp[i%2][c] = Math.max(profit1, profit2);
            }
        }

        return dp[(n-1)%2][capacity];
    }

//    This space optimization solution can also be implemented using a single array.
//    It is a bit tricky, but the intuition is to use the same array for the previous and the next iteration!
    static int solveKnapsackItrSpaceBetter(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        // if we have only one weight, we will take it if it is not more than the capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[c] = profits[0];
            }
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0;

                // dp[c-weight[i]] might be overridden if “weight[i] > 0”. Therefore we can’t use this value for the current iteration.
                // Solution: We can change our inner loop to process in the reverse direction: c:capacity-->0.
                // This will ensure that whenever we change a value in dp[], we will not need it again in the current iteration.
                // include the item, if it is not more than the capacity
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[c - weights[i]];
                }
                // exclude the item
                int profit2 = dp[c];
                // take maximum
                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }
}
