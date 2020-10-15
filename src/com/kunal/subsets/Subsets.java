package com.kunal.subsets;

import java.util.*;

public class Subsets {

    /*
      Time Complexity: O(N * 2^N)
      Space Complexity: O(2 ^ N)
    */

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>(subsets.get(i));
                list.add(num);
                subsets.add(list);
            }
        }
        return subsets;
    }

    public static List<List<Integer>> findNonDupSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int endIndex = 0;
        int startIndex = 0;
        for(int i=0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size()-1;
            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> list = new ArrayList<>(subsets.get(j));
                list.add(nums[i]);
                subsets.add(list);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
