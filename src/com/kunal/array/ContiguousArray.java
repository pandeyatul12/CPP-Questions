package com.kunal.array;

import java.util.HashMap;

public class ContiguousArray {
    // https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(findMaxLength(nums));
    }

    private static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hM = new HashMap<>();
        int sum = 0;
        int n = nums.length;
        int max_len = 0;
        int ending_index = -1;

        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == 0) ? -1 : 1;
        }

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            } else {
                hM.put(sum + n, i);
            }
        }

        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

    // Better
    public int findMaxLength2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int count = 0;

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {
                result = Math.max(result, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return result;
    }

}
