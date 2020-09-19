package com.kunal.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
    // O(N) TIME COMPLEXITY: O(N) + O(N-1)
    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            // check if num is at index num-1
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // OR
    public static void sort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i]-1]) {
                // swap nums[i] with index nums[i]-1
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
    }

    public static int findMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != nums[nums[i]]){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i]-1]){
                // swap
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i-1){
                missingNumbers.add(i+1);
            }
        }

        return missingNumbers;
    }
}
