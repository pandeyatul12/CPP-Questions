package com.kunal.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] dims = {3, 3, 2, 1, 2};
        System.out.println(minMulti(dims));        // 21
        System.out.println(minMultiRec(dims));     // 21
        System.out.println(minMultiRecDP(dims));     // 21
        System.out.println(minMultiItr(dims));     // 21
    }

    // Time: O(N^2 * 2^N)
    public static int minMulti(int[] dims) {
        if (dims.length <= 2) {
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        for (int i = 1; i < dims.length - 1; i++) {
            cost = Math.min(
                    cost,
                    minMulti(Arrays.copyOfRange(dims, 0, i + 1))
                            + minMulti(Arrays.copyOfRange(dims, i, dims.length))
                            + dims[0] * dims[dims.length - 1] * dims[i] // this is because in the end after the recursion has done calculations, there will only be a single matrix of dimensions (dims[i] x dims[dims.length - 1])
            );
        }
        return cost;
    }

    // same as above but using indexing
    // Time: O(N * 2^N)
    public static int minMultiRec(int[] dims) {
        return minMultiRec(dims, 0, dims.length);
    }

    private static int minMultiRec(int[] dims, int i, int j) {
        if (j - i <= 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j - 1; k++) {
            min = Math.min(
                    min,
                    minMultiRec(dims, i, k + 1) + minMultiRec(dims, k, j) + (dims[i] * dims[j - 1] * dims[k])
            );
        }
        return min;
    }

    //    Time Complexity : O(N^3), Space: O(N^2)
    // Every recursive call loops over the list of dims which is O(n)
    // and the number of i - j pairs would be bound by O(N^2), hence time is O(N^3)
    public static int minMultiRecDP(int[] dims) {
        Integer[][] dp = new Integer[dims.length + 1][dims.length + 1];
        return minMultiRecDP(dims, 0, dims.length, dp);
    }

    private static int minMultiRecDP(int[] dims, int i, int j, Integer[][] dp) {
        if (j - i <= 2) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j - 1; k++) {
            min = Math.min(
                    min,
                    minMultiRecDP(dims, i, k + 1, dp) + minMultiRecDP(dims, k, j, dp) + (dims[i] * dims[j - 1] * dims[k])
            );
        }
        dp[i][j] = min;
        return min;
    }

    //    Time Complexity : O(N^3), Space: O(N^2)
    public static int minMultiItr(int[] arr) {
        int n = arr.length;
        /* For simplicity of the program, one extra row and one
        extra column are allocated in dp[][].  0th row and 0th
        column of dp[][] are not used */

        int[][] dp = new int[n][n];
        /* dp[i, j] = Minimum number of scalar multiplications needed
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is arr[i-1] x arr[i] */

        // cost is zero when multiplying one matrix.
        for (int i = 1; i < n; i++)
            dp[i][i] = 0;

        // L is chain length.
        // we need to handle the cases for multiplications of the chains of size 2,
        // since these will be used by all the bigger problems.
        // After 2, we will need to fill for chains of size 3, and so on
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                //  The nested for loops are simply calculating the optimal answer in the same way as the previous
                //  solutions, i.e., by finding the minimum cumulative value from all the subproblems
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
                }
            }
        }
        return dp[1][n - 1];
    }
}
