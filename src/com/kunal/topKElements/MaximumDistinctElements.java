package com.kunal.topKElements;

import java.util.*;

/*
Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array
such that we are left with maximum distinct numbers.

Time: O(NlogN+KlogN)
Space: O(N)
 */
public class MaximumDistinctElements {

    public static int findMaximumDistinctElements(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                minHeap.add(entry);
            }
        }
        int temp = minHeap.size();
        while (!minHeap.isEmpty() && k > 0) {
            k--;
            Map.Entry<Integer, Integer> entry = minHeap.remove();
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() > 1) {
                minHeap.add(entry);
            }
        }
        return map.size() - temp - k + 1;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{7, 3, 5, 8, 5, 3, 3}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{3, 5, 12, 11, 12}, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}