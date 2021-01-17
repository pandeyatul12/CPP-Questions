package com.kunal.sorting;

public class Sorting {
    // Bubble Sort
    /*
        Time: N^2
        Space: 1
     */
    public static void bubble(int[] nums) {
        // run the loop n-1 times
        for (int i = 0; i < nums.length; i++) {
            // reduce items from last
            for (int j = 1; j < nums.length - i; j++) {
                // swap if next item is smaller then previous
                if (nums[j] < nums[j - 1])
                    swap(nums, j, j - 1);
            }
        }
    }

    // Selection Sort
    /*
        Time: N^2
        Space: 1
     */
    public static void selection(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int last = nums.length - i - 1;
            int max = max_limit(nums, 0, last);
            swap(nums, max, last);
        }
    }

    // Insertion sort
    /*
        Time: n & n^2
        Space: 1
     */
    public static void insertion(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1])
                    swap(nums, j - 1, j);
                else
                    break;
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static int max_limit(int[] nums, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max])
                max = i;
        }
        return max;
    }
}
