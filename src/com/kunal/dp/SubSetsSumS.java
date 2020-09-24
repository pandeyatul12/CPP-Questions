package com.kunal.dp;
//Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
public class SubSetsSumS {
    public static void main(String[] args) {
        int[] num = {1, 1, 2, 3};
        System.out.println(countSubsetsItrSpace(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(countSubsetsItrSpace(num, 9));
    }

    public static int countSubsets(int[] nums, int s) {
        return countSubsets(nums, s, 0);
    }

    private static int countSubsets(int[] nums, int s, int index) {
        if (s == 0) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        int count = 0;
        if (nums[index] <= s) {
            count += countSubsets(nums, s - nums[index], index + 1);
        }
        count += countSubsets(nums, s, index + 1);
        return count;
    }

    public static int countSubsetsDP(int[] nums, int s) {
        Integer[][] dp = new Integer[nums.length][s + 1];
        return countSubsetsDP(nums, s, 0, dp);
    }

    private static int countSubsetsDP(int[] nums, int s, int index, Integer[][] dp) {
        if (s == 0) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index][s] != null) {
            return dp[index][s];
        }
        int count = 0;
        if (nums[index] <= s) {
            count += countSubsetsDP(nums, s - nums[index], index + 1, dp);
        }
        count += countSubsetsDP(nums, s, index + 1, dp);
        dp[index][s] = count;
        return count;
    }

    public static int countSubsetsItr(int[] nums, int sum) {
        int[][] dp = new int[nums.length][sum + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = (nums[0] == i ? 1 : 0);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] = dp[i - 1][s];
                if (nums[i] <= s) {
                    dp[i][s] += dp[i - 1][s - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }

    public static int countSubsetsItrSpace(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[s] = (nums[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for (int i = 1; i < nums.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if (nums[i] <= s) {
                    dp[s] += dp[s - nums[i]];
                }
            }
        }

        return dp[sum];
    }

}
