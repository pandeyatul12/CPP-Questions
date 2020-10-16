package com.kunal.dp;

//Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
public class PartitionSet {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(partitionSetDP(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(partitionSetDP(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(partitionSetDP(num));

    }

    /*
        Time: O(2^n)
        Space: O(n)
    */
    public static boolean partitionSet(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return partitionSet(arr, sum / 2, 0);
    }

    private static boolean partitionSet(int[] arr, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (index >= arr.length) {
            return false;
        }
        if (arr[index] <= sum) {
            if (partitionSet(arr, sum - arr[index], index + 1)) {
                return true;
            }
        }
        return partitionSet(arr, sum, index + 1);
    }

    /*
    Time: O(n*s)
    Space: O(n*s)
*/
    // dp[i][s] will be ‘true’ if we can make the sum ‘s’ from the first ‘i’ numbers.
    public static boolean partitionSetDP(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        Boolean[][] dp = new Boolean[arr.length][(sum / 2) + 1];
        return partitionSetDP(arr, sum / 2, 0, dp);
    }

    private static boolean partitionSetDP(int[] arr, int sum, int index, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (index >= arr.length) {
            return false;
        }
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }
        if (arr[index] <= sum) {
            if (partitionSetDP(arr, sum - arr[index], index + 1, dp)) {
                dp[index][sum] = true;
                return true;
            }
        }
        dp[index][sum] = partitionSetDP(arr, sum, index + 1, dp);
        return dp[index][sum];
    }

    /*
        Time: O(n*s)
        Space: O(n*s)
    */
    public static boolean partitionSetItr(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        boolean[][] dp = new boolean[arr.length][(sum / 2) + 1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= sum / 2; i++) {
            if (arr[i] == i) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (arr[i] <= j) {
                        dp[i][j] = dp[i - 1][j - arr[i]];
                    }
                }
            }
        }
        return dp[arr.length - 1][sum / 2];
    }

}
