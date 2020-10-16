package com.kunal.dp;

// Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.
    /*
        Time: O(2^n)
        Space: O(n)
    */
public class MinimumSubsetSum {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(partitionSetDP(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(partitionSetDP(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(partitionSetDP(num));
    }

    public int partitionSet(int[] num) {
        return this.partitionSet(num, 0, 0, 0);
    }

    private int partitionSet(int[] num, int currentIndex, int sum1, int sum2) {
        // base check
        if (currentIndex == num.length)
            return Math.abs(sum1 - sum2);

        // recursive call after including the number at the currentIndex in the first set
        int diff1 = partitionSet(num, currentIndex + 1, sum1 + num[currentIndex], sum2);

        // recursive call after including the number at the currentIndex in the second set
        int diff2 = partitionSet(num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

        return Math.min(diff1, diff2);
    }

    /*
    Time: O(ns)
    Space: O(ns)
*/
    // dp[i][s] will be ‘true’ if we can make the sum ‘s’ from the first ‘i’ numbers.
    public static int partitionSetDP(int[] num) {
        int sum = 0;
        for (int value : num) sum += value;

        Integer[][] dp = new Integer[num.length][sum + 1];
        return partitionSetDP(dp, num, 0, 0, 0);
    }

    private static int partitionSetDP(Integer[][] dp, int[] num, int currentIndex, int sum1, int sum2) {
        // base check
        if (currentIndex == num.length)
            return Math.abs(sum1 - sum2);

        // check if we have not already processed similar problem
        if (dp[currentIndex][sum1] == null) {
            // recursive call after including the number at the currentIndex in the first set
            int diff1 = partitionSetDP(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);

            // recursive call after including the number at the currentIndex in the second set
            int diff2 = partitionSetDP(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

            dp[currentIndex][sum1] = Math.min(diff1, diff2);
        }

        return dp[currentIndex][sum1];
    }
    /*
        Time: O(ns)
        Space: O(ns)
    */
    public static int partitionSetItr(int[] num) {
        int sum = 0;
        for (int value : num) sum += value;

        int n = num.length;
        boolean[][] dp = new boolean[n][sum / 2 + 1];

        // populate the sum=0 columns, as we can always form '0' sum with an empty set
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to that number
        for (int s = 1; s <= sum / 2; s++) {
            dp[0][s] = (num[0] == s);
        }

        // process all subsets for all sums
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum / 2; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {
                    // else include the number and see if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }

        int sum1 = 0;
        // Find the largest index in the last row which is true
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n - 1][i]) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }

}
