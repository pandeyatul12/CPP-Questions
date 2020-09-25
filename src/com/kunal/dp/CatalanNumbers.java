package com.kunal.dp;
// C4 ​​= C​0 *​​ C3 ​​+ C1 ​​*​​ C2 ​​+ C2 *​​​​ C1 + C3 *​​​​ C​0

// The Catalan numbers readily appear in many interesting counting problems:
// 1. The number of ways to put parentheses around n numbers for multiplication.
// 2. The number of paths to climb up a 2n x 2n grid without going above the diagonal.
// 3. The number of possible binary trees with n leaf nodes.

public class CatalanNumbers {
    public static void main(String[] args) {
        System.out.println(catalan(4));
        System.out.println(catalanDP(4));
        System.out.println(catalanItr(4));
    }

    // Time Complexity : O(n!)
    private static int catalan(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += catalan(i) * catalan(n - 1 - i);
        }
        return count;
    }

    // Time Complexity : O(n^2)
    // Space : O(N)
    public static int catalanDP(int n) {
        Integer[] dp = new Integer[n + 1];
        return catalanDP(n, dp);
    }
    private static int catalanDP(int n, Integer[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += catalanDP(i, dp) * catalanDP(n - 1 - i, dp);
        }
        dp[n] = count;
        return count;
    }

    // Time Complexity : O(n^2)
    // Space : O(N)
    public static int catalanItr(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += dp[j] * dp[i-1-j];
            }
            dp[i] = count;
        }

        return dp[n];
    }
}

