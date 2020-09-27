package com.kunal.dp;

public class WiggleSubsequence {
    public static void main(String[] args) {

    }
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 2) {
            return 2;
        }
        return Math.max(wiggleMaxLength(nums, 0, true), wiggleMaxLength(nums, 0, false));
    }

    private int wiggleMaxLength(int[] nums, int prev, boolean isUp) {
        int maxCount = 0;

        for (int i = prev+1; i < nums.length; i++) {
            if ((isUp && nums[prev] < nums[i]) || (!isUp && nums[prev] > nums[i])) {
                maxCount = Math.max(maxCount, 1 + wiggleMaxLength(nums, i , !isUp));
            }
        }

        return maxCount;
    }
}
